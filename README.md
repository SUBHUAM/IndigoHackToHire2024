#Odoo-x-CGC-QuickDesk (QuickDesk)
Problem Statement
QuickDesk is designed to provide a simple, easy-to-use help desk solution where users can raise support tickets, and support staff can manage and resolve them efficiently. The system aims to streamline communication between users and support teams without unnecessary complexity.

Demo Video
[Add your demo video here]

Technologies Used
Frontend
Next.js

Tailwind CSS

React Components

Form Validation

Real-time Notifications

Backend
Spring Boot

Spring Security

Spring Data JPA

SLF4J Logging

Mail Service

OWASP HTML Sanitizer

Database
PostgreSQL

JPA/Hibernate

📋 Team
The Watcher - Project Oversight

Subhum Tangar - Team Lead

Ayush Agarwal - Developer

Core Dependencies (Maven)
xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-test</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>com.googlecode.owasp-java-html-sanitizer</groupId>
  <artifactId>owasp-java-html-sanitizer</artifactId>
  <version>20220608.1</version>
</dependency>
✨ Key Features & Achievements
1. Full-Stack Authentication & Authorization
User Login & Registration: Secure signup, login, password hashing and reset flows

Role-Based Access Control: Users are assigned roles (USER, AGENT, ADMIN) with appropriate permissions

XSRF/CSRF Protection: Automatic CSRF token generation and validation in every form submission

CORS Handling: Configured CORS policy to allow frontend origin and restrict unwanted requests

Security Hardening: Spring Security configurations for session management, password policies, and endpoint protection

2. Ticket Management
Create & Track Tickets: Users can open new tickets by specifying subject, category, and description

Agent Dashboard: Support staff can view assigned tickets, update status (OPEN, IN_PROGRESS, RESOLVED), and add comments

Email Notifications: Automated email alerts to ticket creator and assigned agents on status changes and new comments

Persistence Layer: JPA entities for Users, Tickets, Comments with PostgreSQL as the data store

Dashboard with filters, search, pagination, sorting.


Category management 

3. UI/UX & Frontend
Modern Interface: Built with Next.js & Tailwind CSS for responsive and intuitive layouts

Component Library: Reusable form components, modals, and navigation elements

Form Validation: Client-side validation matching backend rules ensures data integrity

Real-Time Feedback: Loading spinners and toast notifications for in-app actions

4. Logging & Monitoring
SLF4J Logging: Structured logs at INFO and DEBUG levels for user actions, errors, and system events

Error Handling: Global exception handlers return standardized API responses and log stack traces

🚀 Getting Started
Prerequisites
Java 17+

Node.js 18+

PostgreSQL 12+

Maven 3.6+

Installation
Clone the repository:

bash
git clone https://github.com/your-org/Odoo-x-CGC-QuickDesk.git
cd Odoo-x-CGC-QuickDesk
Configure the Database:
Create a PostgreSQL database (e.g., quickdesk_db) and update application.properties:

text
spring.datasource.url=jdbc:postgresql://localhost:5432/quickdesk_db
spring.datasource.username=your_username
spring.datasource.password=your_password
Run the Backend:

bash
./mvnw spring-boot:run
Run the Frontend:

bash
cd frontend
npm install
npm run dev
Access the App
Frontend: http://localhost:3000

Backend API: http://localhost:8080


Contributing
Fork the repository

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

License
This project is licensed under the MIT License - see the LICENSE file for details.

🙏 Acknowledgements
Thanks to the entire QuickDesk team—The Watcher, Subhum Tangar, and Ayush Agarwal—for the collaborative effort in building a secure, user-friendly helpdesk solution.

Made with ❤️ by Team QuickDesk
