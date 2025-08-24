package ndays.backend.main.repository

import ndays.backend.main.entity.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author, String> {
}