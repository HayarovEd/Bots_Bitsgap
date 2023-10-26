package trading.bots.research.bits.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        getFromLocal()
    }

    private fun getFromLocal() {
        viewModelScope.launch {
            delay(2000)
            _state
                .value
                .copy(ApplicationStatus.Loading)
                .updateStateUI()
            val remoteConfig = FirebaseRemoteConfig.getInstance()
            val configSettings = FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build()
            remoteConfig.setConfigSettingsAsync(configSettings)
            remoteConfig.fetchAndActivate()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val resultUrl = remoteConfig.getString("link")
                        if (resultUrl.isNotBlank()) {
                            _state
                                .value
                                .copy(ApplicationStatus.Succsess(url = resultUrl))
                                .updateStateUI()
                        } else {
                            _state
                                .value
                                .copy(ApplicationStatus.Mock)
                                .updateStateUI()
                        }
                    } else {
                        _state
                            .value
                            .copy(ApplicationStatus.Mock)
                            .updateStateUI()
                    }
                }

        }
    }

    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }
}