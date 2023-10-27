package trading.bots.research.bits.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ItemPager(
    modifier: Modifier = Modifier,
    strategies: List<Strategy>,
    isThreeRow: Boolean,
    name: String,
    subName: String,
    content: String,
    fullContent: String,
    baseTextColor: Color,
    subTextColor: Color,
    chip: Chip,
    backgroundImagePath: Int,
) {
    val isShowFull = remember {
        mutableStateOf(false)
    }
    if (isShowFull.value) {
        FullData(
            name = name,
            subName =subName,
            content =fullContent,
            baseTextColor = baseTextColor,
            subTextColor = subTextColor,
            chip = chip,
            backgroundImagePath = backgroundImagePath,
            onClick = {
                isShowFull.value = false
            }
        )
    }  else {
        ShortData(
            strategies = strategies,
            isThreeRow = isThreeRow,
            name = name,
            subName = subName,
            content = content,
            baseTextColor = baseTextColor,
            subTextColor = subTextColor,
            chip = chip,
            backgroundImagePath = backgroundImagePath,
            onClick = {
                isShowFull.value = true
            })
    }
}