package ndays.backend.main.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
@Table(name = "book")
class Book(
    @Id
    val id: String,

    @Column(name = "title")
    var title: String,

    @Column(name = "added_date")
    var addedDate: String,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    val author: Author? = null,


    @ManyToMany(mappedBy = "book")
    @JsonManagedReference
    val user: MutableSet<User> = mutableSetOf()
)
