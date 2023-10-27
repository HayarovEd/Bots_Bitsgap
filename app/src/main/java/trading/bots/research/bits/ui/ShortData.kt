package trading.bots.research.bits.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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
import trading.bots.research.bits.ui.theme.darkGreySub
import trading.bots.research.bits.ui.theme.darkText
import trading.bots.research.bits.ui.theme.grey
import trading.bots.research.bits.ui.theme.greySub
import trading.bots.research.bits.ui.theme.subText1
import trading.bots.research.bits.ui.theme.subText2
import trading.bots.research.bits.ui.theme.text1
import trading.bots.research.bits.ui.theme.white

@Composable
fun ShortData(
    modifier: Modifier = Modifier,
    strategies: List<Strategy>,
    isThreeRow: Boolean,
    name: String,
    subName: String,
    content: String,
    baseTextColor: Color,
    subTextColor: Color,
    chip: Chip,
    backgroundImagePath: Int,
    onClick: () -> Unit
) {
    val cardColor = Brush.verticalGradient(colors = listOf(grey, darkGrey), startY = 0.9f)
    val secondCardColor =
        Brush.verticalGradient(colors = listOf(greySub, darkGreySub), startY = 0.1f)
    Column(
        modifier = modifier
            .fillMaxWidth()
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
                            addTextColor = subTextColor
                        )
                    }
                }
            }
        }
        Spacer(modifier = modifier.height(24.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(28.dp))
                .background(brush = secondCardColor)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 14.dp, horizontal = 22.dp)
            ) {
                TextByChip(
                    chip = chip,
                    addTextColor = subTextColor
                )
                Spacer(modifier = modifier.height(24.dp))
                Text(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = subName,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(font.inter)),
                        fontWeight = FontWeight(700),
                        color = baseTextColor
                    ),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(font.inter)),
                        fontWeight = FontWeight(700),
                        color = subTextColor
                    ),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = modifier.height(24.dp))
                Text(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = content,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(font.inter)),
                        fontWeight = FontWeight(400),
                        color = darkText
                    ),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = modifier.height(32.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = subTextColor
                    ),
                    onClick = onClick
                ) {
                    Text(
                        text = stringResource(id = R.string.learn_more),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(font.inter)),
                            fontWeight = FontWeight(400),
                            color = white
                        )
                    )
                    Spacer(modifier = modifier.width(10.dp))
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_forward_16),
                        contentDescription = "",
                        tint = white
                    )
                }
            }
            Image(
                modifier = modifier
                    .size(200.dp)
                    .align(alignment = Alignment.TopEnd),
                painter = painterResource(id = backgroundImagePath),
                contentDescription = ""
            )
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


@Composable
private fun TextByChip(
    modifier: Modifier = Modifier,
    chip: Chip,
    addTextColor: Color,
) {
    when (chip) {
        is Chip.ChipOne -> {
            Text(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(color = white)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                text = stringResource(id = R.string.sideways),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(font.inter)),
                    fontWeight = FontWeight(400),
                    color = addTextColor
                ),
                textAlign = TextAlign.Center
            )
        }

        is Chip.ChipTwo -> {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(30.dp))
                        .background(color = white)
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = stringResource(id = R.string.long_),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(font.inter)),
                        fontWeight = FontWeight(400),
                        color = addTextColor
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(30.dp))
                        .background(color = white)
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = stringResource(id = R.string.short_),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(font.inter)),
                        fontWeight = FontWeight(400),
                        color = addTextColor
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

        is Chip.ChipThree -> {
            Text(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(color = white)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                text = stringResource(id = R.string.short_),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(font.inter)),
                    fontWeight = FontWeight(400),
                    color = addTextColor
                ),
                textAlign = TextAlign.Center
            )
        }
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
fun SampleShortData() {
    ShortData(
        name = stringResource(id = R.string.grid_trading_bot),
        subName = stringResource(id = R.string.grid_trading_bot_sub),
        content = stringResource(id = R.string.grid_trading_bot_short),
        baseTextColor = text1,
        subTextColor = subText1,
        strategies = strategysGridTrading,
        isThreeRow = true,
        chip = Chip.ChipOne,
        backgroundImagePath = R.drawable.bots_1,
        onClick = {}
    )
}

@Preview
@Composable
fun SampleTextByChip() {
    TextByChip(
        chip = Chip.ChipTwo,
        addTextColor = subText2
    )
}


