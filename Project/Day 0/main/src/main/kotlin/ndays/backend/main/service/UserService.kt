package ndays.backend.main.service

import ndays.backend.main.entity.Book
import ndays.backend.main.entity.User
import ndays.backend.main.model.AddUserRequest
import ndays.backend.main.model.BookResponse
import ndays.backend.main.model.GetRentResponse
import ndays.backend.main.model.UserResponse
import ndays.backend.main.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    @Autowired
    val userRepository: UserRepository
) {

    fun addUser(request: AddUserRequest): UserResponse {
        val user = User(
            id = "user-"+ UUID.randomUUID().toString(),
            firstName = request.firstName,
            lastName = request.lastName
        )

        userRepository.save(user)

        return createUserResponse(user)
    }

    fun getUser():List<UserResponse>{
        val response = userRepository.findAll().map { value ->
            createUserResponse(value)
        }

        return response
    }

    fun deleteUser(id: String){
        userRepository.deleteById(id)
    }

    fun getBook(id:String): GetRentResponse{
        val user = userRepository.findById(id).orElseThrow()

        return GetRentResponse(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            listBook = user.book.map { createBookResponse(it) }
        )
    }

    fun createUserResponse(user: User): UserResponse{
        return UserResponse(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName
        )
    }

    fun createBookResponse(book: Book): BookResponse {
        return BookResponse(
            id = book.id,
            title = book.title,
            addedDate = book.addedDate
        )
    }
}