package ndays.backend.main.controller

import jakarta.validation.Valid
import ndays.backend.main.model.GetRentResponse
import ndays.backend.main.model.RentRequest
import ndays.backend.main.model.RentResponse
import ndays.backend.main.model.WebResponse
import ndays.backend.main.service.RentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RentController(
    @Autowired
    val rentService: RentService
) {

    @PostMapping("/api/book/rent")
    fun makeRent(@RequestBody @Valid request: RentRequest):WebResponse<RentResponse>{
        val response = rentService.makeRent(request)

        return WebResponse(
            data = response,
            error = null
        )
    }

    @PostMapping("/api/book/return")
    fun returnRent(@RequestBody @Valid request: RentRequest): WebResponse<String>{
        rentService.returnBook(request)

        return WebResponse(
            data = "Success",
            error = null
        )
    }

    @GetMapping("api/book/rent")
    fun getAllRent():WebResponse<List<GetRentResponse>>{
        val response = rentService.getAllRent()

        return WebResponse(
            data = response,
            error = null
        )
    }

}