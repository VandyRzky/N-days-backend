package ndays.backend.main.model

import jakarta.validation.constraints.Size

data class UpdateAddressRequest(
    @Size(max = 100)
    var city: String?,
    @Size(max = 100)
    var postCode: String?
)
