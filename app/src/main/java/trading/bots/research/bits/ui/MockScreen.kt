package trading.bots.research.bits.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import trading.bots.research.bits.ui.theme.background

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MockScreen (
    modifier: Modifier = Modifier,
){
    val pages = listOf(
        MockState.Grid, MockState.DcaTrading, MockState.Btd, MockState.DcaFuture, MockState.Combo
    )
    val pagerState = rememberPagerState(initialPage = 0)
    HorizontalPager(
        modifier = modifier
            .fillMaxSize(),
        pageCount = pages.size,
        state = pagerState
    ) { pageIndex ->
        when (pages[pageIndex]) {
            MockState.Btd -> TODO()
            MockState.Combo -> TODO()
            MockState.DcaFuture -> TODO()
            MockState.DcaTrading -> TODO()
            MockState.Grid -> TODO()
        }
    }
}