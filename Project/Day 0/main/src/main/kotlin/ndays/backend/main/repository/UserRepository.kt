package ndays.backend.main.repository

import ndays.backend.main.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository: JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    fun findByFirstName(firstName: String): User?


    @Query("SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true)
    fun findByLastName(lastName: String): User?
}