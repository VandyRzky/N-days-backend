package ndays.backend.main.model

data class AuthorResponse(
    var id: String,
    var firstName: String,
    var lastName: String,
    var addressResponse: AddressResponse
)
