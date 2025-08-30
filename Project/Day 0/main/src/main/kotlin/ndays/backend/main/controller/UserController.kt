package ndays.backend.main.controller

import jakarta.validation.Valid
import ndays.backend.main.model.AddUserRequest
import ndays.backend.main.model.GetRentResponse
import ndays.backend.main.model.UserResponse
import ndays.backend.main.model.WebResponse
import ndays.backend.main.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    @Autowired
    val userService: UserService
) {

    @PostMapping("/api/user")
    fun addUser(@RequestBody @Valid request: AddUserRequest): WebResponse<UserResponse>{
        val response = userService.addUser(request)

        return WebResponse(
            data = response,
            error = null
        )
    }

    @GetMapping("/api/user")
    fun getUser():WebResponse<List<UserResponse>>{
        val response = userService.getUser()

        return WebResponse(
            data = response,
            error = null
        )
    }

    @DeleteMapping("/api/user/{id}")
    fun deleteUser(@PathVariable("id") id:String): WebResponse<String>{
        userService.deleteUser(id)

        return WebResponse(
            data = "Delete berhasil",
            error = null
        )
    }

    @GetMapping("/api/{id}/rent")
    fun getBookByUser(@PathVariable("id") id:String):WebResponse<GetRentResponse>{
        val response = userService.getBook(id)

        return WebResponse(
            data = response,
            error = null
        )
    }
}