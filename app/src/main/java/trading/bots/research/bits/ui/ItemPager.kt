package trading.bots.research.bits.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun ItemPager(
    modifier: Modifier = Modifier,

) {
    val isShowFull = remember {
        mutableStateOf(false)
    }
    if (isShowFull.value) {

    }  else {

    }
}