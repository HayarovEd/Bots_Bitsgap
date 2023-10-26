package trading.bots.research.bits.ui

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import trading.bots.research.bits.R
import trading.bots.research.bits.R.font
import trading.bots.research.bits.ui.theme.background
import trading.bots.research.bits.ui.theme.border
import trading.bots.research.bits.ui.theme.darkGrey
import trading.bots.research.bits.ui.theme.darkText
import trading.bots.research.bits.ui.theme.grey
import trading.bots.research.bits.ui.theme.subText2

@Composable
fun Short(
    modifier: Modifier = Modifier,
    strategies: List<Strategy>,
    isThreeRow: Boolean,
    addTextColor: Color
) {
    val cardColor = Brush.verticalGradient(colors = listOf(grey, darkGrey), startY = 0.9f)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = background)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(28.dp))
                .background(brush = cardColor)
                .padding(vertical = 14.dp, horizontal = if (isThreeRow) 32.dp else 12.dp)
        ) {
            Text(
                modifier = modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.strategies),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(font.inter)),
                    fontWeight = FontWeight(700),
                    color = darkText
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(19.dp))
            LazyVerticalGrid(
                modifier = modifier
                    .fillMaxWidth(),
                columns = GridCells.Fixed(if (isThreeRow) 3 else 5),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                items(strategies) { strategy ->
                    ItemStrategy(
                        strategy = strategy
                    )
                }
                if (!isThreeRow) {
                    item {
                        AddStrategy(
                            addTextColor = addTextColor
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun ItemStrategy(
    modifier: Modifier = Modifier,
    strategy: Strategy
) {
    Column(
        modifier = modifier.height(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier.size(31.dp),
            painter = painterResource(id = strategy.imagePath),
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            modifier = modifier
                .fillMaxWidth(),
            text = stringResource(id = strategy.name),
            style = TextStyle(
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(font.inter)),
                fontWeight = FontWeight(700),
                color = darkText
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AddStrategy(
    modifier: Modifier = Modifier,
    addTextColor: Color
) {
    Box (
        modifier = modifier
            .height(50.dp)
            .border(
                width = 1.dp,
                color = border,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier
                .align(alignment = Alignment.Center),
            text = stringResource(id = R.string.add_strategies),
            style = TextStyle(
                fontSize = 8.sp,
                fontFamily = FontFamily(Font(font.inter)),
                fontWeight = FontWeight(700),
                color = addTextColor
            ),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun SampleItemStrategy() {
    ItemStrategy(
        strategy = Strategy(
            imagePath = R.drawable.stop_loss_1,
            name = R.string.stop_loss
        )
    )
}



@Preview
@Composable
fun SampleShort() {
    Short(
        addTextColor = subText2,
        strategies = strategysDcaTrading,
        isThreeRow = false)
}


