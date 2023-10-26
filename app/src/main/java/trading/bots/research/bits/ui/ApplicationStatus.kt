package trading.bots.research.bits.ui

sealed class ApplicationStatus {

    object PreLoading: ApplicationStatus()
    object Loading: ApplicationStatus()
    class Succsess(val url:String): ApplicationStatus()
    object Mock: ApplicationStatus()
}
