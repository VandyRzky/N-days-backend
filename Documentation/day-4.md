# Query Method JPA (findByXxx)

Di Spring Data JPA, kita bisa membuat query secara otomatis hanya dengan menuliskan method di dalam Repository Interface.
Spring Data JPA akan menganalisis nama method lalu menghasilkan query SQL/HQL sesuai pola penamaan tersebut.

## Penerapan pada Repository
[Book Repository](/Project/Day%200/main/src/main/kotlin/ndays/backend/main/repository/BookRepository.kt)
```kotlin
interface BookRepository: JpaRepository<Book, String> {
    fun findByAuthorId(authorId: String): List<Book>

    fun findByTitle(title: String): Book
}
```
`fun findByTitle(title: String): Book` akan membuat query:
```SQL
SELECT * FROM book WHERE title = ?;
```
## Penerapan pada Controller
[Book Controller](/Project/Day%200/main/src/main/kotlin/ndays/backend/main/controller/BookController.kt)
```kotlin
    @GetMapping("/api/book")
    fun findBookByTitle(@RequestParam title:String): WebResponse<BookResponse>{
        val response = bookService.getBookByTitle(title)

        return WebResponse(
            data = response,
            error = null
        )
    }
```
Dengan controller tersebut akan membuat rute seperti `/api/book?title={title}`

