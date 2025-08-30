package ndays.backend.main.model

data class GetRentResponse (
    val id: String,
    val firstName: String,
    val lastName: String,
    val listBook: List<BookResponse>
)
