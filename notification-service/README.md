# Notification Service for E-Government Tendering System

The Notification Service is a microservice component of the E-Government Tendering System, designed to manage and deliver notifications to various stakeholders in the tendering process.

## Features

- **Multi-channel notifications**: Supports email, SMS, push notifications, and in-app notifications
- **Event-driven architecture**: Consumes events from Kafka to generate notifications automatically
- **Templated notifications**: Uses Thymeleaf templates for consistent notification formatting
- **User preferences**: Allows users to manage their notification preferences
- **Read/unread tracking**: Tracks notification status for better user experience
- **Scheduled notifications**: Supports scheduling of notifications for future delivery
- **Retry mechanism**: Automatically retries failed notification deliveries

## Architecture

The notification service follows a modern microservice architecture:

- **API Layer**: REST endpoints for managing notifications
- **Service Layer**: Core business logic for processing and sending notifications
- **Repository Layer**: Data access for persisting notification records
- **Event Processing**: Kafka consumers for processing events from other services
- **External Services**: Integration with email, SMS, and push notification providers

## Technical Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.2.2
- **Database**: MySQL 8.0
- **Messaging**: Apache Kafka
- **Service Discovery**: Eureka (Spring Cloud Netflix)
- **Configuration**: Spring Cloud Config
- **API Documentation**: Swagger/OpenAPI 3
- **Testing**: JUnit 5, Mockito
- **Templating**: Thymeleaf
- **Authentication**: JWT with Spring Security
- **Database Migration**: Flyway

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven 3.8.x or higher
- MySQL 8.0
- Kafka (for event processing)
- Docker and Docker Compose (optional)

### Local Development Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/e-gov-tendering.git
   cd e-gov-tendering
   ```

2. Build the project:
   ```bash
   mvn clean install -DskipTests
   ```

3. Create the MySQL database:
   ```sql
   CREATE DATABASE notification_service CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

4. Update application.yml with your database credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/notification_service?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
       username: yourUsername
       password: yourPassword
   ```

5. Run the application:
   ```bash
   cd notification-service
   mvn spring-boot:run
   ```

### Running with Docker

1. Build the Docker images:
   ```bash
   docker-compose build
   ```

2. Start the services:
   ```bash
   docker-compose up -d
   ```

3. Check the logs:
   ```bash
   docker-compose logs -f notification-service
   ```

## API Documentation

When the service is running, you can access the OpenAPI documentation at:
```
http://localhost:8086/swagger-ui.html
```

## Available Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | /api/v1/notifications | Send a new notification |
| GET    | /api/v1/notifications/user/{userId} | Get notifications for a user |
| GET    | /api/v1/notifications/{id} | Get notification details |
| PUT    | /api/v1/notifications/{id}/read | Mark a notification as read |
| GET    | /api/v1/notifications/count/unread/{userId} | Count unread notifications |

## Event Listeners

The service listens to the following Kafka topics:

- `tender-created`: When a new tender is created
- `tender-updated`: When a tender is updated
- `bid-submitted`: When a new bid is submitted
- `bid-evaluation-completed`: When bid evaluation is completed
- `contract-awarded`: When a contract is awarded

## Configuration Options

The service can be configured through the following properties:

- `spring.mail.*`: Email server configuration
- `kafka.topics.*`: Kafka topic names for different events
- `notification.templates.*`: Template file locations

## Monitoring

The service exposes several endpoints for monitoring and management:

- `/actuator/health`: Health information
- `/actuator/info`: Application information
- `/actuator/prometheus`: Metrics for Prometheus

## Troubleshooting

### Common Issues:

1. **Connection to Kafka fails**: Ensure Kafka is running and `spring.kafka.bootstrap-servers` is set correctly.

2. **Email sending fails**: Verify SMTP settings in `application.yml`.

3. **Database migration issues**: Check Flyway migration scripts for errors.

4. **Template not found**: Ensure templates are in the correct location.

## Contributing

Please see the [CONTRIBUTING.md](../CONTRIBUTING.md) file for details on contributing to this project.

## License

This project is licensed under the MIT License - see the [LICENSE](../LICENSE) file for details.