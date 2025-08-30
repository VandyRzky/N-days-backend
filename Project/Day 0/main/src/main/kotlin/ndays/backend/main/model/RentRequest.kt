package ndays.backend.main.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RentRequest(
    @field:NotBlank
    @Size(max = 100)
    var idUser: String,

    @field:NotBlank
    @Size(max = 100)
    var idBook: String
)
