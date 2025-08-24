package ndays.backend.main.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateAuthorRequest(

    @Size(max = 100)
    var firstName:String?,

    @Size(max = 100)
    var lastName:String?
)
