package ndays.backend.main.model

data class WebResponse<T>(
    var data: T,
    var error: String?
)
