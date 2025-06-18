# 🚖 Cab Booking System

A robust **Cab Booking System** backend application built using **Java**, **Spring Boot**, **Hibernate**, **JPA**, and **MySQL**. This project manages user registrations, cab bookings, ride history, and driver assignments, providing a modular and scalable backend solution for a cab service platform.

---

## 🛠️ Technologies Used

- **Java** – Core language for backend development  
- **Spring Boot** – Framework for rapid API development  
- **Hibernate** – ORM for mapping Java objects to database tables  
- **JPA (Java Persistence API)** – Simplifies database operations  
- **MySQL** – Relational database to store all records  
- **Maven** – Build and dependency management  
- **Postman** – API testing  
- **Spring Security** *(optional)* – For authentication and authorization

---

## 📌 Key Features

- 👥 User & Driver Registration/Login  
- 🚕 Book a Cab (with pickup and drop location)  
- 📖 View Booking History  
- 🧾 Admin: View all users, drivers, and bookings  
- 🚗 Driver: Accept/Reject bookings  
- 🗓️ Schedule rides for future dates  
- 🔒 Role-based access (User, Driver, Admin)

---

## 🗃️ Project Structure

cab-booking-system/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/cabbooking/
│ │ │ ├── controller/
│ │ │ ├── entity/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── CabBookingApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql (optional)
├── pom.xml
└── README.md

