package ndays.backend.main.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateAuthorRequest(
    @field:NotBlank
    @Size(max = 100)
    var firstName:String,

    @field:NotBlank
    @Size(max = 100)
    var lastName:String
)
