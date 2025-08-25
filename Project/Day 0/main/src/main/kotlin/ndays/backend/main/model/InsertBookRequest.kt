package ndays.backend.main.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class InsertBookRequest(
    @field:NotBlank
    @Size(max = 100)
    var title: String
)
