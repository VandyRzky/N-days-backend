package ndays.backend.main.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AddressRequest(
    @field:NotBlank
    @Size(max = 100)
    val city: String,
    @field:NotBlank
    @Size(max = 100)
    val postCode: String
)
