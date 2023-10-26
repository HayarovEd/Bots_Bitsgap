package trading.bots.research.bits.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import trading.bots.research.bits.R
import trading.bots.research.bits.ui.theme.background
import trading.bots.research.bits.ui.theme.white

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    when (val result = state.value.status) {
        ApplicationStatus.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = background)
            ) {
                CircularProgressIndicator(
                    modifier = modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    color = white
                )
            }
        }

        ApplicationStatus.Mock -> {
            MockScreen()
        }
        ApplicationStatus.PreLoading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = background)
            ) {
                Image(
                    modifier = modifier
                        .size(100.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.icon2),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "logo"
                )
            }
        }

        is ApplicationStatus.Succsess -> {
            WebScreen(
                url = result.url
            )
        }
    }
}