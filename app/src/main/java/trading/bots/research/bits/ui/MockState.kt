package trading.bots.research.bits.ui

sealed interface MockState {
    object Grid:MockState
    object DcaTrading:MockState
    object Btd:MockState
    object DcaFuture:MockState
    object Combo:MockState
}