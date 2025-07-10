# ✈️ Travel Management System

A Spring Boot-based RESTful application for managing users, travel packages, hotels, and hotel categories. Built with clean architecture using DTOs, services, repositories, and PostgreSQL.

---

## 🚀 Features

* 👤 User registration with profile (name, email, phone, address)
* 👳 Add and view travel packages (destination, duration, price)
* 🏨 Manage hotels and assign categories (Budget, Deluxe, etc.)
* 🔍 Search packages by destination or fetch user by email
* ↺ Inter-service communication supported (Feign Client)
* 🌐 CORS enabled for frontend integration

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3.x
* Spring Data JPA
* PostgreSQL
* Lombok
* OpenFeign (optional)
* Postman (for API testing)

---

## 🗃️ Database Configuration

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/travel_management_system
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

---

## 📦 Run the Project

```bash
# Build and run
mvn clean install
mvn spring-boot:run

# OR run the jar
java -jar target/travel-management-system-0.0.1-SNAPSHOT.jar
```

---

## 📢 API Endpoints

| Action                     | Method | Endpoint                                      |
| -------------------------- | ------ | --------------------------------------------- |
| Add User                   | POST   | `/tms/add-new-user`                           |
| Fetch User by Email        | GET    | `/tms/fetch-user/{email}`                     |
| Update User Name           | PUT    | `/tms/update-userName/{email}/{updatedName}`  |
| Delete User                | DELETE | `/tms/delete-user/{email}`                    |
| Add Travel Package         | POST   | `/tms/add-travel-packing`                     |
| Get Package by Destination | GET    | `/tms/fetch-available-packages/{destination}` |
| Add Hotel Category         | POST   | `/tms/add-hotel-categories/{HotelName}`       |
| Fetch Hotel Categories     | GET    | `/tms/fetch-hotel-categories/{HotelName}`     |

---

## 🔪 Testing

Use **Postman** or Swagger UI to test all endpoints under:

```
http://localhost:8080/tms
```

---

## 📁 Project Structure

```
com.gl.tms
🔗 controller
🔗 dto
🔗 entity
🔗 repository
🔗 service
     └️ impl
🔗 exception
```

---

## 👨‍💻 Author

**Vadlamudi Haaswitha**
Open to collaboration and feedback!

---

## 📄 License

This project is open-source under the MIT License.
