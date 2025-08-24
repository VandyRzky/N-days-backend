package ndays.backend.main.service

import ndays.backend.main.entity.Author
import ndays.backend.main.model.AuthorResponse
import ndays.backend.main.model.CreateAuthorRequest
import ndays.backend.main.model.UpdateAuthorRequest
import ndays.backend.main.model.WebResponse
import ndays.backend.main.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuthorService (
    @Autowired
    val authorRepository: AuthorRepository
){
    fun addAuthor(create: CreateAuthorRequest):AuthorResponse{
        val author = Author(
            id = UUID.randomUUID().toString(),
            lastName = create.lastName,
            firstName = create.firstName
        )

        authorRepository.save(author)

        return toAuthorResponse(author)
    }

    fun getAllAuthor():List<AuthorResponse>{
        return authorRepository.findAll().map { value ->
            toAuthorResponse(value)
        }
    }

    fun updateAuthor(id:String, request: UpdateAuthorRequest):AuthorResponse{
        val author = findAuthor(id)
        var isUpdate: Boolean = false

        if (!request.firstName.isNullOrBlank()){
            author.firstName = request.firstName!!
            isUpdate = true
        }
        if (!request.lastName.isNullOrBlank()){
            author.lastName = request.lastName!!
            isUpdate = true
        }

        if (isUpdate){
            authorRepository.save(author)
        }

        return toAuthorResponse(author)

    }

    fun deleteAuthor(id:String){
        val author = findAuthor(id)
        authorRepository.delete(author)
    }

    fun findAuthor(id:String):Author{
        return authorRepository.findByIdOrNull(id)!!
    }

    fun toAuthorResponse(author: Author): AuthorResponse{
        return AuthorResponse(
            id = author.id,
            firstName = author.firstName,
            lastName = author.lastName
        )
    }
}