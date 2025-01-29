# StudentTracker

Husk å lage configurer fil : Der skal du kunne konfiguere Task manger filen slik at automatiske kjører indeks samtidig. 



StudentTracker is a project designed to help manage and organize student data efficiently. This system enables tracking student progress, managing course enrollments, and maintaining academic records.

---

## 🚀 Features
- **Student Management:** Add, edit, and remove student details.
- **Course Tracking:** Assign students to courses and monitor their progress.
- **Search Functionality:** Quickly find student records by name or ID.
- **Customizable Reports:** Generate and export academic performance reports.

---

## 📊 Technologies Used
- **Programming Language:** Java (or your specific language used in the project)
- **Database:** SQLite/MySQL (if applicable)
- **Frameworks/Tools:** IntelliJ, Git

---

## 🗓 How to Use
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Filimon-Coding/StudentTracker.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd StudentTracker
   ```
3. **Run the Application:**
   Follow the instructions in the `GettingStarted.md` file (if available) or run the main program file.

---

## 🔧 Setup and Installation
1. **Requirements:**
   - Java Development Kit (JDK)
   - IDE (IntelliJ recommended)
   - Database setup (if required, refer to the database setup instructions in the project)

2. **Steps:**
   - Import the project into your IDE.
   - Configure the database connection (if applicable).
   - Run the application and explore the features.

---

## 🔧 Contributing
Contributions are welcome! To contribute:
1. Fork this repository.
2. Create a new branch for your feature or bug fix.
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push the branch.
   ```bash
   git push origin feature-name
   ```
4. Open a pull request on this repository.

---

## 🔗 License
This project is licensed under the [MIT License](LICENSE).

---

## 📧 Contact
For questions or suggestions, feel free to reach out:
- **GitHub:** [Filimon-Coding](https://github.com/Filimon-Coding)
- **Email:** filimon.nuguse20@gmail.com


/* 
Database task : from terminal testing ground 
~/Documents/MinCodingLin/UtviklingAreaLin/StudentTracker$ sqlite3 tasks.db
SQLite version 3.45.1 2024-01-30 16:01:20
Enter ".help" for usage hints.
sqlite> .tables
tasks
sqlite> .schema tasks 
CREATE TABLE tasks (id INTEGER PRIMARY KEY, name TEXT, deadline TEXT);
sqlite> select * from tasks; 
1|bil|2025-01-21
2|Jeg har ekamen 15000 |2025-01-30
3|vcxvxcv|2025-01-29
4|cvcvvcxvxcv|2025-01-29
5|cvcvvcxvxcv|2025-01-29
6|cvcvvcxvxcv|2025-01-29
7|cvcvvcxvxcv|2025-01-29
8|cvcvvcxvxcv|2025-01-29
9|cvcvvcxvxcv|2025-01-29
10|cvcvvcxvxcv|2025-01-29
11|sdsad|2025-01-30
sqlite> 


*/
