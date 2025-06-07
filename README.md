# 🏨 Hotel Management System (Java Console Application)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Principles-blueviolet?style=for-the-badge)
![ConsoleApp](https://img.shields.io/badge/Console%20App-Text%20UI-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

> 🔐 A menu-driven, multi-role Java application for managing hotel rooms, bookings, and users via the command-line interface.

---

## 📌 Description

The **Hotel Management System** is a Java-based console application that allows three different user roles:

- 👨‍💼 **Admin**
- 🧑‍🔧 **Resource Manager**
- 👤 **Regular User**

Each role has specific capabilities like adding/editing rooms, managing users, booking/canceling rooms, and viewing bookings. The application demonstrates core Java principles including:

- Object-Oriented Programming (OOP)
- Collections (ArrayList, Iterator)
- Menu-driven design
- Modular service layers
- Input validation and exception handling

---

## 🧱 Project Structure
HotelManagementSystem/
├── DataBase/
│ ├── DatabaseClass.java
├── EntityPackage/
│ ├── Admin.java
│ ├── Booking.java
│ ├── RegularUser.java
│ ├── Resource.java
│ ├── ResourceManager.java
│ ├── User.java
├── Service/
│ ├── AdminServices.java
│ ├── BookingService.java
│ ├── ResourceManagerService.java
│ ├── ResourceService.java
│ ├── UserService.java
├── Driver/
│ ├── Driverclass.java (or your main launcher class)
└── README.md


---

## 🧑‍💼 Roles & Functionalities

### 🔒 Admin
- View all registered users
- Remove users
- View all bookings
- Authenticate with ID and password

### 🛠️ Resource Manager
- Add, edit, or delete rooms
- View all available rooms
- Authenticate with ID and password

### 🙋 Regular User
- View available rooms
- Book a room
- Cancel a room booking
- View personal booking history

---

## ✨ Key Features

- 🧠 **OOP Principles** – Proper use of classes, inheritance, and encapsulation.
- 🔁 **Service-Oriented Architecture** – All operations are modularized into specific service classes.
- 🔐 **Role-Based Access Control** – Different menus and options based on the user role.
- 📦 **In-Memory Database** – Uses static collections for runtime storage.
- 📊 **Dynamic Room Management** – Rooms can be added, edited, and deleted with availability checks.

---

## 🧪 Sample Console Output
![image](https://github.com/user-attachments/assets/46039e2c-f0e6-4ac7-8ddb-1576ab746c3b)


---

## ⚙️ Technologies Used

- 💻 Java 8+
- ☕ Java Collections Framework
- 🧪 Scanner for Input Handling
- 🧹 Iterator for Safe Data Manipulation

---

## 🚀 Getting Started

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/HotelManagementSystem.git
2. **Compile the project**
   javac *.java
3. Run the main class
   Driverclass

---

📈 Future Enhancements
1. Add file/database persistence

2. Implement a GUI using JavaFX or Swing

3. Add unit testing using JUnit

4. Export booking reports to CSV (currently commented in AdminServices)

---

🏷️ License
This project is open-source and free to use for educational purposes.

🙋‍♂️ Author
Ayush-Gola ayushgola851@gmail.com

