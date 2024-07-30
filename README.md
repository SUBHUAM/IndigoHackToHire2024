# IndigoHackToHire2024
 Hack to Hire 2024 Indigo
Flight Status and Notifications
Problem Statement
Flight Status and Notifications: Develop a system to provide real-time flight status updates and notifications to passengers.

Demo Video
Watch the demo video

Technologies Used
Frontend
HTML
CSS
React.js
Tailwind CSS
Chakra UI
WebSocket
Backend
Java
Spring Boot
Spring WebSocket
Database
PostgreSQL
Notifications
Kafka
Note: All coding standards and conventions have been followed to maintain high readability and refactorability.

Solution Description
We have developed a robust notification service that allows an admin to update flight statuses in real-time. Here's how it works:

Admin Panel: The admin can search for a flight by entering the flight number in the search bar. All relevant details related to that flight will be displayed.
Update Flight Data: The admin can update flight information such as gate number, departure time, or cancellation status.
Notifications: After updating, concerned passengers receive immediate notifications about the changes to their flight. Only passengers with the specific flight number will receive these notifications.
Data Storage: All data is stored in the database for tracking and other purposes, ensuring a robust notification system.
Internal Working
Backend
The backend is powered by Spring Boot, divided into two main services: AdminProvider and UserConsumer.

AdminProvider Service
Kafka Integration: Handles the creation of topics in the Kafka server, configuring topics with partition and replication factors, and sending notification messages.
APIs: Includes three APIs for fetching booking details, flight details, and all booking IDs. It uses Spring JDBC and PostgreSQL for data retrieval and storage.
UserConsumer Service
Message Handling: Receives notification messages from the provider, deserializes them, and listens to specific notification topics using the @KafkaListener annotation.
WebSocket Communication: Sends messages to the WebSocket controller to establish continuous communication between the server and users.
Frontend
Single Page Application: Developed using React.js, HTML, CSS, Tailwind CSS, and Chakra UI.
Admin Panel: Allows the admin to search for flights by flight number and update flight details (e.g., gate number, departure time). When updates are made, an API call is sent to the AdminProvider service, which then notifies the UserConsumer service.
User Interface: Includes three dummy users to demonstrate real-time notifications. When changes are made, users receive notifications about updates related to their flights, such as gate changes or delays.
Continuous WebSocket Connection: Ensures users receive real-time notifications.
Database
PostgreSQL: Used to store flight data. The database setup mimics a production environment to achieve accurate results.
Error Handling
Critical statements are wrapped in try-catch blocks in both frontend and backend code to prevent service interruptions.

Achieved Features
Real-time Updates: Displays current flight status (delays, cancellations, gate changes).
Push Notifications: Sends notifications for flight status changes via app notifications.
Admin Console: Provides real-time updates quickly to users about flight status.
Smooth and Interactive UI: Ensures a user-friendly experience.
