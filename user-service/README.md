# e-Government Tendering System - User Service
comprehensive user management, authentication, and organization management functionalities for your e-Government Tendering System. The service follows a clean architecture with separation of concerns and implements the event-driven approach using Kafka for inter-service communication.
The key features of this user-service include:

- User registration and authentication with JWT token-based security
- Role-based access control (TENDEREE, TENDERER, EVALUATOR, COMMITTEE)
- Organization management for tenderers
- User-Organization relationship management
- Event publishing for all significant state changes
- Comprehensive exception handling
- Restful API endpoints