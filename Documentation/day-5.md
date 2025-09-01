# JPQL vs Native Query

## JPQL 
JPQL = Java Persistence Query Language
- Bagian dari JPA (Java Persistence API).
- Mirip dengan SQL, tapi bukan query langsung ke tabel database.
- Operasi dilakukan pada Entity dan field di class

### Penerapan pada program
```kotlin
interface UserRepository: JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    fun findByFirstName(firstName: String): User?
}
```
- `User` pada query menunjukan entity user 
- `u` merupakan alias yang diberikan kepada entity
- `:firstName` merupakan named parameter nilainya akan digantikan dengan parameter yang terdapat pada function

### Query Utama dalam JPQL
- `SELECT`
- `UPDATE` -> membutuhkan `@Modifying`
- `DELETE` -> membutuhkan `@Modifying`
- Fitur tambahan: `JOIN`, `GROUP BY`, `HAVING`, `ORDER BY`, `AGGREGATE`, `Named Parameter`, `Constructor Expressions`

## Native Query
Query yang langsung ditulis dalam SQL murni, sesuai dengan dialek database
- Bekerja langsing ke tabel dalam kolom database

### Penerapan pada Program
```kotlin
interface UserRepository: JpaRepository<User, String> {
    @Query("SELECT * FROM users WHERE last_name = :lastName", nativeQuery = true)
    fun findByLastName(lastName: String): User?
}
```
- `users` merupakan tabel dalam database
- `last_name` merupakan kolom dalam tabel yang ada di databse

## Kapan harus digunakan?
- JPQL -> untuk query standar (select, where, join antar entity)
- Native Query -> untuk query kompleks, butuh performa tinggi, atau fungsi khusus database

