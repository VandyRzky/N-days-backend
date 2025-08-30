package ndays.backend.main.service

import ndays.backend.main.entity.Book
import ndays.backend.main.model.*
import ndays.backend.main.repository.BookRepository
import ndays.backend.main.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RentService (
    @Autowired
    val bookRepository: BookRepository,

    @Autowired
    val userRepository: UserRepository
){

    @Transactional
    fun makeRent(request: RentRequest): RentResponse{
        val user = userRepository.findById(request.idUser).orElseThrow()
        val book = bookRepository.findById(request.idBook).orElseThrow()

        user.book.add(book)
        book.user.add(user) // manual sync

        userRepository.save(user)

        return RentResponse(
            user = UserResponse(user.id, user.firstName, user.lastName),
            book = BookResponse(book.id, book.title, book.addedDate)
        )
    }

    @Transactional
    fun returnBook(request: RentRequest){
        val user = userRepository.findById(request.idUser).orElseThrow()
        val book = bookRepository.findById(request.idBook).orElseThrow()

        user.book.remove(book)

        userRepository.save(user)
    }

    fun getAllRent(): List<GetRentResponse>{
        val response = userRepository.findAll().map{
            GetRentResponse(
                id = it.id,
                firstName = it.firstName,
                lastName = it.lastName,
                listBook = it.book.map{
                    createBookResponse(it)
                }
            )
        }

        return response

    }

    fun createBookResponse(book: Book): BookResponse{
        return BookResponse(
            id = book.id,
            title = book.title,
            addedDate = book.addedDate
        )
    }

}