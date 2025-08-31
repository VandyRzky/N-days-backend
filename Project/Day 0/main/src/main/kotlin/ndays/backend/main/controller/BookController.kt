package ndays.backend.main.controller

import ndays.backend.main.model.BookResponse
import ndays.backend.main.model.GetBookByAuthorResponse
import ndays.backend.main.model.InsertBookRequest
import ndays.backend.main.model.WebResponse
import ndays.backend.main.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
data class BookController(
    @Autowired
    val bookService: BookService
){
    @PostMapping("/api/{id_author}/book")
    fun insertBook(@PathVariable("id_author") id: String, @RequestBody request: InsertBookRequest): WebResponse<BookResponse>{
        val response = bookService.insertBook(id, request)

        return WebResponse(
            data = response,
            error = null
        )
    }

    @GetMapping("/api/{id_author}/book")
    fun findBookByAuthor(@PathVariable("id_author") id: String):WebResponse<GetBookByAuthorResponse>{
        val response = bookService.getBookByAuthor(id)

        return WebResponse(
            data = response,
            error = null
        )
    }

    @GetMapping("/api/book")
    fun findBookByTitle(@RequestParam title:String): WebResponse<BookResponse>{
        val response = bookService.getBookByTitle(title)

        return WebResponse(
            data = response,
            error = null
        )
    }



    @DeleteMapping("/api/book/{id_book}")
    fun deleteBook(@PathVariable("id_book") id:String):WebResponse<String>{
        bookService.deleteBook(id)

        return WebResponse(
            data = "Delete success",
            error = null
        )
    }
}
