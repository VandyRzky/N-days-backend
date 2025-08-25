package ndays.backend.main.model

import java.awt.print.Book

data class GetBookByAuthorResponse(
    var id: String,
    var firstName: String,
    var lastName: String,

    var addressResponse: AddressResponse,

    val books: List<BookResponse>
)
