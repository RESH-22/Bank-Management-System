# 🏦 Bank Management System (Java)

---

## 📌 Project Overview

The **Bank Management System** is a console-based Java application developed using **Core Java and File Handling**.

This project allows users to perform basic banking operations without using SQL or any external database.

All account information is stored securely in a text file (`accounts.txt`).

---

## 🚀 Features

- ✅ Create New Account  
- ✅ Deposit Money  
- ✅ Withdraw Money  
- ✅ Check Account Balance  
- ✅ Prevent Duplicate Accounts  
- ✅ Validate Balance Before Withdrawal  
- ✅ Automatic File Creation  
- ✅ Exception Handling  

---

## 🛠 Technologies Used

- Java (Core Java)
- OOP Concepts
- File Handling (FileWriter, FileReader, BufferedReader, BufferedWriter)
- IntelliJ IDEA

---

## 💾 Data Storage Method

This project uses **File Handling** instead of MySQL.

All account data is stored in:

```
accounts.txt
```

### 📄 Data Format:

```
accountNumber,name,balance
```

### Example:

```
101,Reshmitha,5000.0
102,Rahul,3000.0
```

---

## 📂 Project Structure

```
BankManagementSystem/
│
├── src/
│   └── BankSystem.java
│
├── accounts.txt  (Auto-created)
│
└── README.md
```

---

## ▶️ How to Run the Project

### 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/BankManagementSystem.git
```

### 2️⃣ Open in IntelliJ IDEA

- Open IntelliJ
- Click **Open**
- Select the project folder

### 3️⃣ Run the Program

- Open `BankSystem.java`
- Click **Run**

---

## 🖥 Application Menu

```
====== BANK MANAGEMENT SYSTEM ======
1. Create Account
2. Deposit
3. Withdraw
4. Check Balance
5. Exit
```

---

## 🧠 OOP Concepts Used

- Classes and Objects  
- Methods  
- Encapsulation (Basic Level)  
- Exception Handling  
- Loops  
- Conditional Statements  

---

## 🔍 How It Works

- User selects an operation from the menu
- Program reads/writes account data to `accounts.txt`
- For deposit/withdraw:
  - Temporary file is created
  - Balance is updated
  - Old file is replaced

---

## 📈 Future Enhancements

- 🔐 Admin Login System  
- 🧾 Transaction History  
- 💻 GUI Version using Java Swing  
- 📊 Interest Calculation Feature  
- 📁 Separate Transaction Log File  
- 🌐 Convert to Web-Based Application  

---

## 🎓 Learning Outcomes

This project helps understand:

- Real-time file handling
- Data persistence without database
- Java console application structure
- Banking logic implementation
- Error handling in Java

---

## 👩‍💻 Author

**Reshmitha R**  
B.Tech / B.E Electronics and Communication Student Student  

---

## 📜 License

This project is created for educational purposes only.

---

⭐ If you like this project, consider giving it a star!
