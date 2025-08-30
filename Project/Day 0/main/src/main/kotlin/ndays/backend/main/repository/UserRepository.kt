package ndays.backend.main.repository

import ndays.backend.main.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {
}