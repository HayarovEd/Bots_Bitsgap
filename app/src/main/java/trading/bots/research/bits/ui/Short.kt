package trading.bots.research.bits.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import trading.bots.research.bits.ui.theme.background

@Composable
fun Short(
    modifier: Modifier = Modifier,
) {
    Column (
        modifier
            .fillMaxWidth()
            .background(color = background)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {

    }
}

