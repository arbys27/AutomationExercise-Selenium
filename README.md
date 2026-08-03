# STAAutomationDemo

## Project Title

**Automation Exercise Web Testing using Selenium WebDriver with Java, TestNG, and Page Object Model (POM)**

---

## Group Members

- Arby M. Barnuevo (Group Leader)
- John Raphael A. Bautista
- Wendelyn E. Salazar

---

## Brief Project Description

This project is an automated web testing framework developed for the **Automation Exercise** website using **Selenium WebDriver**. The framework automates multiple user scenarios based on the provided test cases, including user registration, login, contact form submission, product review, checkout process, invoice download, and other website functionalities.

The project follows the **Page Object Model (POM)** design pattern to improve code organization, reusability, and maintainability. Test execution is managed using **TestNG**, while **Maven** handles project dependencies and build management.

### Implemented Test Cases

- ✅ TC01 – Register User
- ✅ TC02 – Login User with Correct Email and Password
- ✅ TC03 – Login User with Incorrect Email and Password
- ✅ TC04 – Logout User
- ✅ TC05 – Register User with Existing Email
- ✅ TC06 – Contact Us Form
- ✅ TC07 – Verify Test Cases Page
- ✅ TC10 – Verify Subscription in Home Page
- ✅ TC11 – Verify Subscription in Cart Page
- ✅ TC14 – Place Order: Register while Checkout
- ✅ TC15 – Place Order: Register before Checkout
- ✅ TC16 – Place Order: Login before Checkout
- ✅ TC21 – Add Review on Product
- ✅ TC23 – Verify Address Details in Checkout Page
- ✅ TC24 – Download Invoice after Purchase Order
- ✅ TC25 – Verify Scroll Up using Arrow Button
- ✅ TC26 – Verify Scroll Up without Arrow Button

---

## Technologies Used

- Java 17
- Selenium WebDriver 4
- TestNG
- Apache Maven
- Page Object Model (POM)
- Google Chrome
- ChromeDriver
- Visual Studio Code
- Git & GitHub
- Extent Reports

---

## Project Structure

```
STAAutomationDemo
│
├── src
│   ├── main
│   │   ├── base
│   │   ├── pageElements
│   │   ├── pageEvents
│   │   └── utils
│   │
│   └── test
│       ├── java
│       │   └── regression
│       └── resources
│
├── pom.xml
├── testng.xml
├── README.md
└── .gitignore
```

---

## Instructions to Set Up and Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/STAAutomationDemo.git
```

Replace `<your-username>` with your GitHub username.

---

### 2. Open the Project

Open the project using:

- Visual Studio Code
- Eclipse IDE
- IntelliJ IDEA

---

### 3. Install Prerequisites

Ensure the following software is installed:

- Java JDK 17
- Apache Maven
- Git
- Google Chrome
- Visual Studio Code (or any Java IDE)

Verify the installation:

```bash
java -version
mvn -version
git --version
```

---

### 4. Install Maven Dependencies

Open the project terminal and execute:

```bash
mvn clean install
```

---

### 5. Run the Test Cases

Run all automated test cases using:

```bash
mvn test
```

or execute the **testng.xml** file directly from your IDE.

---

### 6. View Test Results

After execution, generated reports can be found in the project's report/output directory, depending on your TestNG and reporting configuration.

---

## Design Pattern Used

This project follows the **Page Object Model (POM)** design pattern.

- **BaseTest** – Browser setup, teardown, and common methods
- **Page Elements** – Stores all web element locators
- **Page Events** – Contains reusable page actions and business logic
- **Regression Tests** – Contains automated test cases

---

## Developed For

**System Testing and Automation**

Bachelor of Science in Information Technology (BSIT)

Polytechnic University of the Philippines

---