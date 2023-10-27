package trading.bots.research.bits.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.util.lerp
import trading.bots.research.bits.R
import trading.bots.research.bits.ui.theme.background
import trading.bots.research.bits.ui.theme.subText1
import trading.bots.research.bits.ui.theme.subText2
import trading.bots.research.bits.ui.theme.subText3
import trading.bots.research.bits.ui.theme.subText4
import trading.bots.research.bits.ui.theme.subText5
import trading.bots.research.bits.ui.theme.text1
import trading.bots.research.bits.ui.theme.text2
import trading.bots.research.bits.ui.theme.text3
import trading.bots.research.bits.ui.theme.text4
import trading.bots.research.bits.ui.theme.text5
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MockScreen (
    modifier: Modifier = Modifier,
) {
    val pages = listOf(
        MockState.Grid, MockState.DcaTrading, MockState.Btd, MockState.DcaFuture, MockState.Combo
    )
    val pagerState = rememberPagerState(pageCount = {
        pages.size
    })
    HorizontalPager(
        modifier = modifier
            .fillMaxSize()
            .background(color = background),
        state = pagerState
    ) { pageIndex ->
        when (pages[pageIndex]) {
            MockState.Grid -> {
                ItemPager(
                    modifier = modifier
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - pageIndex) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    strategies = strategysGridTrading,
                    isThreeRow = true,
                    name = stringResource(id = R.string.grid_trading_bot),
                    subName = stringResource(id = R.string.grid_trading_bot_sub),
                    content = stringResource(id = R.string.grid_trading_bot_short),
                    fullContent = stringResource(id = R.string.grid_trading_bot_full),
                    baseTextColor = text1,
                    subTextColor = subText1,
                    chip = Chip.ChipOne,
                    backgroundImagePath = R.drawable.bots_1
                )
            }
            MockState.DcaTrading -> {
                ItemPager(
                    modifier = modifier
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - pageIndex) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    strategies = strategysDcaTrading,
                    isThreeRow = false,
                    name = stringResource(id = R.string.dca_trading_bot),
                    subName = stringResource(id = R.string.dca_trading_bot_sub),
                    content = stringResource(id = R.string.dca_trading_bot_short),
                    fullContent = stringResource(id = R.string.dca_trading_bot_full),
                    baseTextColor = text2,
                    subTextColor = subText2,
                    chip = Chip.ChipTwo,
                    backgroundImagePath = R.drawable.bots_2
                )
            }
            MockState.Btd -> {
                ItemPager(
                    modifier = modifier
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - pageIndex) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    strategies = strategysBtdTrading,
                    isThreeRow = true,
                    name = stringResource(id = R.string.btd_trading_bot),
                    subName = stringResource(id = R.string.btd_trading_bot_sub),
                    content = stringResource(id = R.string.btd_trading_bot_short),
                    fullContent = stringResource(id = R.string.btd_trading_bot_full),
                    baseTextColor = text3,
                    subTextColor = subText3,
                    chip = Chip.ChipThree,
                    backgroundImagePath = R.drawable.bots_3
                )
            }
            MockState.DcaFuture -> {
                ItemPager(
                    modifier = modifier
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - pageIndex) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    strategies = strategysDcaFutureTrading,
                    isThreeRow = false,
                    name = stringResource(id = R.string.dca_futures_trading_bot),
                    subName = stringResource(id = R.string.dca_futures_trading_bot_sub),
                    content = stringResource(id = R.string.dca_futures_trading_bot_short),
                    fullContent = stringResource(id = R.string.dca_futures_trading_bot_full),
                    baseTextColor = text4,
                    subTextColor = subText4,
                    chip = Chip.ChipTwo,
                    backgroundImagePath = R.drawable.bots_4
                )
            }
            MockState.Combo -> {
                ItemPager(
                    modifier = modifier
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - pageIndex) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    strategies = strategysComboTrading,
                    isThreeRow = true,
                    name = stringResource(id = R.string.combo_trading_bot),
                    subName = stringResource(id = R.string.combo_trading_bot_sub),
                    content = stringResource(id = R.string.combo_trading_bot_short),
                    fullContent = stringResource(id = R.string.combo_trading_bot_full),
                    baseTextColor = text5,
                    subTextColor = subText5,
                    chip = Chip.ChipTwo,
                    backgroundImagePath = R.drawable.bots_5
                )
            }
        }
    }
}