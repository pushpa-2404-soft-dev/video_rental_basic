# 🎬 RentVideo - Video Rental System ( Basic )

A simple RESTful API built using **Spring Boot**, **Gradle**, **Spring Security (Basic Auth)** and **MySQL**.

This project demonstrates authentication, role-based authorization, and CRUD operations for managing videos in a video rental system.

---

##  Tech Stack

* Java 21
* Spring Boot 
* Spring Security (Basic Authentication)
* Spring Data JPA (Hibernate)
* MySQL
* Gradle
* BCrypt Password Encoder

---

##  Security Features

* Basic Authentication
* Passwords stored using BCrypt hashing
* Role-based Authorization
* Two Roles:

  * `ADMIN`
  * `CUSTOMER`

---

##  User Roles & Access

| Endpoint                | Access           |
| ----------------------- | ---------------- |
| POST /api/auth/register | Public           |
| GET /api/videos         | CUSTOMER & ADMIN |
| POST /api/videos        | ADMIN only       |
| PUT /api/videos/{id}    | ADMIN only       |
| DELETE /api/videos/{id} | ADMIN only       |

---

##  API Endpoints

### 1 Register User (Public)

**POST** `/api/auth/register`

Request Body:

```json
{
  "email": "admin@gmail.com",
  "password": "123456",
  "firstName": "Admin",
  "lastName": "User",
  "role": "ADMIN"
}
```

If role is not provided → defaults to `CUSTOMER`.

---

### 2 Login

Uses **Basic Authentication Header**

Example:

```
Authorization: Basic base64(email:password)
```

Example:

```
admin@gmail.com:123456
```

---

### 3 Get All Videos

**GET** `/api/videos`

Accessible by:

* CUSTOMER
* ADMIN

---

### 4 Create Video (ADMIN Only)

**POST** `/api/videos`

```json
{
  "title": "Inception",
  "director": "Christopher Nolan",
  "genre": "Sci-Fi"
}
```

---

### 5 Update Video (ADMIN Only)

**PUT** `/api/videos/{id}`

---

### 6 Delete Video (ADMIN Only)

**DELETE** `/api/videos/{id}`

---

## Database Configuration

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/rentvideobasic
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

Create database manually:

```sql
CREATE DATABASE rentvideobasic;
```

---

## How To Run The Project

### 1 Clone Repository

```
git clone https://github.com/pushpa-2404-soft-dev/video_rental_basic.git
cd video_rental_basic
```

### 2 Run Application

```
./gradlew bootRun
```

Windows:

```
gradlew.bat bootRun
```

---

##  Build JAR File

```
./gradlew build
```

Run jar:

```
java -jar build/libs/video_rental_basic-0.0.1-SNAPSHOT.jar
```

---

##  Testing Using Postman

1. Register user
2. Use Basic Auth in Authorization tab
3. Access private endpoints

---

##  Project Structure

```
com.crio.video_rental_basic
 ├── config
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 └── exception
```

---

##  Features Implemented

✔ User Registration
✔ BCrypt Password Hashing
✔ Basic Authentication
✔ Role-based Authorization
✔ Video CRUD Operations
✔ Global Exception Handling
✔ MySQL Persistence
✔ Clean Layered Architecture

---

## Author

Pushparaj B

---

## 📎 GitHub Repository Link

(Add your GitHub repository link here before submission)

Example:

```
https://github.com/pushpa-2404-soft-dev/video_rental_basic
```

---

# Assignment Completed Successfully
