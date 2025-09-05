# Migration with Flyway

## Setup Flyway on Project
Menambahkan dependencies flyway untuk mysql pada [build.gradle.kts](/Project/Day%200/main/build.gradle.kts)
```kotlin
dependencies {
	implementation("org.flywaydb:flyway-mysql:11.11.2")
}
```
## Setup Directory Migration
Membuat directori untuk file migration pada [resource/db](/Project/Day%200/main/src/main/resources/db/migration)

## Konfigurasi Flyway
Melakukan konfigurasi flyway pada [application.yml](/Project/Day%200/main/src/main/resources/application.yml)
```yaml
spring:
  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
```
- `enabled: true` berfungsi untuk mengaktifkan Flyway di aplikasi Spring Boot.
- `locations: classpath:db/migration` untuk menentukan lokasi folder tempat file SQL migration berada.
- `baseline-on-migrate: true` digunakan saat database sudah ada (bukan fresh) tapi belum ada riwayat migrasi Flyway.

menambahkan code berikut pada [application.properties](/Project/Day%200/main/src/main/resources/application.properties):
```properties
spring.jpa.hibernate.ddl-auto=validate
```
code tersebut digunakan untuk memvalidasi antara entity pada api sesuai dengan tabel yang ada di database

## Membuat File Migration
Membuat file migration dengan format berikut version__namaMigration.sql contohnya [V1__initial_schema.sql](/Project/Day%200/main/src/main/resources/db/migration/V1__initial_schema.sql)



