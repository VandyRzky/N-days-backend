package ndays.backend.main.service

import ndays.backend.main.entity.Address
import ndays.backend.main.entity.Book
import ndays.backend.main.model.AddressResponse
import ndays.backend.main.model.BookResponse
import ndays.backend.main.model.GetBookByAuthorResponse
import ndays.backend.main.model.InsertBookRequest
import ndays.backend.main.repository.AuthorRepository
import ndays.backend.main.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Date
import java.util.UUID

@Service
class BookService (
    @Autowired
    val authorRepository: AuthorRepository,
    @Autowired
    val bookRepository: BookRepository
){

    fun insertBook(id:String, request: InsertBookRequest):BookResponse{
        val author = authorRepository.findById(id).orElseThrow{RuntimeException("User not found")}

        val book = Book(
            id = "book-" + UUID.randomUUID().toString(),
            title = request.title,
            addedDate = Date().toString(),
            author = author
        )

        bookRepository.save(book)

        return createBookResponse(book)
    }

    fun getBookByAuthor(id: String):GetBookByAuthorResponse{
        val author = authorRepository.findById(id).orElseThrow{RuntimeException("User not found")}
        val listBooks = bookRepository.findByAuthorId(id).map { value ->
            createBookResponse(value)
        }

        return GetBookByAuthorResponse(
            id = author.id,
            firstName = author.firstName,
            lastName = author.lastName,
            addressResponse = createAddressResponse(author.address),
            books = listBooks

        )

    }

    fun deleteBook(id:String){
        if (!bookRepository.existsById(id)){
            throw RuntimeException("Book not found")
        }
        bookRepository.deleteById(id)
    }

    fun getBookByTitle(title: String): BookResponse{
        val book = bookRepository.findByTitle(title)
        return createBookResponse(book)
    }

    fun createAddressResponse(address: Address): AddressResponse {
        return AddressResponse(
            id = address.id,
            city = address.city,
            postCode = address.postCode
        )
    }

    fun createBookResponse(book: Book): BookResponse{
        return BookResponse(
            id = book.id,
            title = book.title,
            addedDate = book.addedDate
        )
    }
}