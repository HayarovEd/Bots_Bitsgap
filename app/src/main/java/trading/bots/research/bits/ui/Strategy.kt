package trading.bots.research.bits.ui

import trading.bots.research.bits.R

data class Strategy(
    val imagePath: Int,
    val name: Int
)

val strategysGridTrading = listOf(
    Strategy(
        imagePath = R.drawable.stop_loss_1,
        name = R.string.stop_loss
    ),
    Strategy(
        imagePath = R.drawable.tralling_down_1,
        name = R.string.trailing_down
    ),
    Strategy(
        imagePath = R.drawable.take_profit_1,
        name = R.string.take_profit
    ),
    Strategy(
        imagePath = R.drawable.pump_dump_protection_1,
        name = R.string.pump_dump_protection
    ),
    Strategy(
        imagePath = R.drawable.trailing_up_1,
        name = R.string.trailing_up
    ),
    Strategy(
        imagePath = R.drawable.backtest_1,
        name = R.string.backtest
    ),
)

val strategysDcaTrading = listOf(
    Strategy(
        imagePath = R.drawable.pump_dump_protection_2,
        name = R.string.pump_dump_protection
    ),
    Strategy(
        imagePath = R.drawable.multiplier_2,
        name = R.string.multiplier
    ),
    Strategy(
        imagePath = R.drawable.trailing_up_2,
        name = R.string.trailing_up
    ),
    Strategy(
        imagePath = R.drawable.trailing_down_2,
        name = R.string.trailing_down
    ),
    Strategy(
        imagePath = R.drawable.backtest_2,
        name = R.string.backtest
    ),
    Strategy(
        imagePath = R.drawable.max_min_price_2,
        name = R.string.max_min_price
    ),
    Strategy(
        imagePath = R.drawable.average_orders_limit_2,
        name = R.string.average_orders_limit
    ),
    Strategy(
        imagePath = R.drawable.technical_indicators_2,
        name = R.string.technical_indicators
    ),
    Strategy(
        imagePath = R.drawable.manual_averaging_2,
        name = R.string.manual_averaging
    ),
)

val strategysBtdTrading = listOf(
    Strategy(
        imagePath = R.drawable.stop_loss_3,
        name = R.string.stop_loss
    ),
    Strategy(
        imagePath = R.drawable.take_profit_3,
        name = R.string.take_profit
    ),
    Strategy(
        imagePath = R.drawable.trailing_down_3,
        name = R.string.trailing_down
    ),
    Strategy(
        imagePath = R.drawable.low_high_price_3,
        name = R.string.low_high_price
    ),
    Strategy(
        imagePath = R.drawable.demo_mode_3,
        name = R.string.demo_mode
    ),
    Strategy(
        imagePath = R.drawable.backtest_3,
        name = R.string.backtest
    ),
)

val strategysDcaFutureTrading = listOf(
    Strategy(
        imagePath = R.drawable.trailing_up_down_4,
        name = R.string.trailing_up_down
    ),
    Strategy(
        imagePath = R.drawable.pump_dump_protection_4,
        name = R.string.pump_dump_protection
    ),
    Strategy(
        imagePath = R.drawable.trailing_up_4,
        name = R.string.trailing_up
    ),
    Strategy(
        imagePath = R.drawable.trailing_up_down_4,
        name = R.string.trailing_down
    ),
    Strategy(
        imagePath = R.drawable.backtest_4,
        name = R.string.backtest
    ),
    Strategy(
        imagePath = R.drawable.max_min_price_4,
        name = R.string.max_min_price
    ),
    Strategy(
        imagePath = R.drawable.average_orders_limit_4,
        name = R.string.average_orders_limit
    ),
    Strategy(
        imagePath = R.drawable.technical_indicators_4,
        name = R.string.technical_indicators
    ),
    Strategy(
        imagePath = R.drawable.manual_averaging_4,
        name = R.string.manual_averaging
    ),
)

val strategysComboTrading = listOf(
    Strategy(
        imagePath = R.drawable.stop_loss_5,
        name = R.string.stop_loss
    ),
    Strategy(
        imagePath = R.drawable.take_profit_5,
        name = R.string.take_profit
    ),
    Strategy(
        imagePath = R.drawable.trailing_down_5,
        name = R.string.trailing_down
    ),
    Strategy(
        imagePath = R.drawable.leverage_x10_5,
        name = R.string.leverage_x10
    ),
    Strategy(
        imagePath = R.drawable.manual_averaging_5,
        name = R.string.manual_averaging
    ),
    Strategy(
        imagePath = R.drawable.backtest_5,
        name = R.string.backtest
    ),
)