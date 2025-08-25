package ndays.backend.main.repository

import ndays.backend.main.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, String> {
    fun findByAuthorId(authorId: String): List<Book>
}