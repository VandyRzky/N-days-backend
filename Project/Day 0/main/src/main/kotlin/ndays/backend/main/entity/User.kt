package ndays.backend.main.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table


@Entity
@Table(name = "users")
class User(
    @Id
    val id: String,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName:String,

    @ManyToMany
    @JoinTable(name = "users_book",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")])
    @JsonManagedReference
    val book: MutableSet<Book> = mutableSetOf()
)
