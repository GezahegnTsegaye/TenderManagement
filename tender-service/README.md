# E-Government Tendering System

## Tender Service

This document provides a comprehensive overview of the Tender Service module within the E-Government Tendering System, a microservice-based application for managing the public procurement process.

## Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Setup and Configuration](#setup-and-configuration)
- [API Documentation](#api-documentation)
- [Event System](#event-system)
- [Data Models](#data-models)
- [Service Implementation](#service-implementation)
- [Database Schema](#database-schema)
- [Testing](#testing)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)
- [Future Enhancements](#future-enhancements)

## Overview

The Tender Service is a core component of the E-Government Tendering System, responsible for managing tender lifecycle from creation to closure. It facilitates the creation, publishing, and management of tenders, along with their associated criteria and items.

This service follows a microservice architecture pattern and communicates with other system components through RESTful APIs and asynchronous event-based communication using Kafka.

## Architecture

The Tender Service is designed with a clean, layered architecture:

1. **Controller Layer** - Handles HTTP requests and responses
2. **Service Layer** - Contains business logic and transaction management
3. **Data Access Layer** - Interacts with the database
4. **Event Layer** - Publishes events to Kafka for inter-service communication

The service is designed to be stateless and horizontally scalable, relying on a shared database for persistence and Kafka for messaging.

## Features

- **Tender Management**
    - Create and manage tenders with detailed descriptions
    - Define tender criteria and evaluation weights
    - Specify items required in the tender
    - Track tender status through its lifecycle

- **Tender Status Workflow**
    - DRAFT: Initial creation state
    - PUBLISHED: Open for bids
    - CLOSED: No longer accepting bids
    - AWARDED: Contract assigned
    - CANCELLED: Tender process terminated

- **Allocation Strategies**
    - SINGLE_WINNER: Award entire tender to one bidder
    - MULTIPLE_WINNERS_BY_SCORE: Select multiple winners based on score thresholds
    - PROPORTIONAL_ALLOCATION: Distribute work proportionally to scores
    - CUSTOM: Implement specialized allocation logic

- **Automated Processing**
    - Automatic closing of expired tenders
    - Event notifications for status changes

## Technology Stack

- **Java 17** - Core programming language
- **Spring Boot 3.2.2** - Application framework
- **Spring Cloud** - Microservice infrastructure
- **Spring Data JPA** - ORM and data access
- **MySQL** - Relational database
- **Kafka** - Event messaging system
- **Maven** - Dependency management and build tool
- **Lombok** - Boilerplate reduction
- **MapStruct** - Object mapping
- **JUnit & Mockito** - Testing frameworks

## Setup and Configuration

### Prerequisites

- JDK 17
- Maven 3.8+
- MySQL 8.0+
- Kafka 3.5+
- Docker (optional, for containerization)

### Configuration

The application's configuration is managed via Spring Cloud Config. The main properties are defined in `application.yml`:

```yaml
server:
  port: 8081
  servlet:
    context-path: /tender-service

spring:
  application:
    name: tender-service
  datasource:
    url: jdbc:mysql://localhost:3306/tender_service_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: ${MYSQL_USER:root}
    password: ${MYSQL_PASSWORD:password}
  jpa:
    hibernate:
      ddl-auto: update
  kafka:
    bootstrap-servers: ${KAFKA_SERVERS:localhost:9092}

app:
  kafka:
    topics:
      tender-events: tender-events
```

### Building and Running

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/egov-tendering-system.git
   cd egov-tendering-system
   ```

2. Build the project
   ```bash
   mvn clean install
   ```

3. Run the Tender Service
   ```bash
   cd tender-service
   mvn spring-boot:run
   ```

4. Docker Alternative
   ```bash
   docker-compose up tender-service
   ```

## API Documentation

### Tender Management APIs

#### Create Tender
```
POST /api/tenders
```
Creates a new tender in DRAFT status.

#### Get Tender Details
```
GET /api/tenders/{tenderId}
```
Retrieves detailed information about a specific tender.

#### Search Tenders
```
GET /api/tenders?title={title}&status={status}&type={type}
```
Searches for tenders matching the provided criteria.

#### Get Tenderee's Tenders
```
GET /api/tenders/tenderee
```
Retrieves all tenders created by the authenticated tenderee.

#### Update Tender Status
```
PATCH /api/tenders/{tenderId}/status
```
Updates the status of a tender.

#### Publish Tender
```
POST /api/tenders/{tenderId}/publish
```
Changes tender status from DRAFT to PUBLISHED.

#### Close Tender
```
POST /api/tenders/{tenderId}/close
```
Changes tender status from PUBLISHED to CLOSED.

### Tender Category Management APIs

#### Create Category
```
POST /api/tenderCategory
```
Creates a new tender category.

#### Get Category Details
```
GET /api/tenderCategory/{id}
```
Retrieves details of a specific category.

#### Get All Categories
```
GET /api/tenderCategory
```
Lists all tender categories.

#### Update Category
```
PUT /api/tenderCategory/{id}
```
Updates an existing category.

#### Delete Category
```
DELETE /api/tenderCategory/{id}
```
Deletes a category.

#### Get Active Categories
```
GET /api/tenderCategory/active
```
Lists all active categories.

## Event System

The Tender Service implements an event-driven architecture using Kafka for asynchronous communication with other microservices. This design provides loose coupling and system resilience.

### Published Events

1. **TENDER_CREATED** - Emitted when a new tender is created
2. **TENDER_PUBLISHED** - Emitted when a tender is published and open for bids
3. **TENDER_CLOSED** - Emitted when a tender is closed for bidding
4. **TENDER_STATUS_CHANGED** - Emitted when a tender's status changes

### Event Implementation

The service uses a dedicated `TenderEventPublisher` class that handles:

- Event creation with proper structure and metadata
- Sending events to Kafka
- Error handling and monitoring
- Idempotency through unique event IDs

Example event structure:
```json
{
  "eventId": 123,
  "eventType": "TENDER_PUBLISHED",
  "timestamp": "2023-02-15T10:30:45.123Z",
  "tenderId": 456,
  "tenderTitle": "Office Supplies Procurement 2023",
  "submissionDeadline": "2023-03-15T23:59:59Z"
}
```

## Data Models

### Core Entities

#### Tender
```java
@Entity
@Table(name = "tenders")
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long tendereeId;
    private TenderType type;
    private TenderStatus status;
    private LocalDateTime submissionDeadline;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private AllocationStrategy allocationStrategy;
    private Integer minWinners;
    private Integer maxWinners;
    private Double cutoffScore;
    private Boolean isAverageAllocation;
    
    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private List<TenderCriteria> criteria;
    
    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
    private List<TenderItem> items;
}
```

#### TenderCriteria
```java
@Entity
@Table(name = "tender_criteria")
public class TenderCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;
    
    private String name;
    private String description;
    private CriteriaType type;
    private Double weight;
    private Boolean preferHigher;
}
```

#### TenderItem
```java
@Entity
@Table(name = "tender_items")
public class TenderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;
    
    @ManyToOne
    @JoinColumn(name = "criteria_id")
    private TenderCriteria criteria;
    
    private String name;
    private String description;
    private Integer quantity;
    private String unit;
    private BigDecimal estimatedPrice;
}
```

### Enumerations

- **TenderStatus**: DRAFT, PUBLISHED, CLOSED, AWARDED, CANCELLED
- **TenderType**: PUBLIC, PRIVATE, RESTRICTED, NEGOTIATED
- **AllocationStrategy**: SINGLE_WINNER, MULTIPLE_WINNERS_BY_SCORE, PROPORTIONAL_ALLOCATION, CUSTOM
- **CriteriaType**: PRICE, QUALITY, DELIVERY_TIME, TECHNICAL_SPEC, EXPERIENCE, CUSTOM

## Service Implementation

### TenderService

The `TenderService` interface defines the core operations for tender management:

```java
public interface TenderService {
    TenderDTO createTender(CreateTenderRequest request, Long tendereeId);
    TenderDTO getTenderById(Long tenderId);
    Page<TenderDTO> searchTenders(String title, TenderStatus status, TenderType type, Pageable pageable);
    Page<TenderDTO> getTendersByTenderee(Long tendereeId, Pageable pageable);
    TenderDTO updateTenderStatus(Long tenderId, UpdateTenderStatusRequest request);
    TenderDTO publishTender(Long tenderId);
    TenderDTO closeTender(Long tenderId);
    void checkForExpiredTenders();
}
```

The implementation in `TenderServiceImpl` contains business logic for:
- Creating tenders with criteria and items
- Validating state transitions
- Publishing events on state changes
- Automatically handling expired tenders

### TenderCategoryService

Manages tender categories that can be reused across multiple tenders:

```java
public interface TenderCategoryService {
    TenderCriteriaDTO createCategory(TenderCriteriaDTO categoryDTO);
    TenderCriteriaDTO getCategoryById(Long id);
    List<TenderCriteriaDTO> getAllCategories();
    TenderCriteriaDTO updateCategory(Long id, TenderCriteriaDTO categoryDTO);
    void deleteCategory(Long id);
    List<TenderCriteriaDTO> findActiveCategories();
}
```

## Database Schema

The Tender Service uses the following database structure:

### tenders Table
| Column               | Type             | Description                         |
|----------------------|------------------|-------------------------------------|
| id                   | BIGINT           | Primary key                         |
| title                | VARCHAR(255)     | Tender title                        |
| description          | TEXT             | Detailed description                |
| tenderee_id          | BIGINT           | ID of the tenderee                  |
| type                 | VARCHAR(50)      | Tender type (enum)                  |
| status               | VARCHAR(50)      | Current status (enum)               |
| submission_deadline  | DATETIME         | Deadline for bid submissions        |
| created_at           | DATETIME         | Creation timestamp                  |
| updated_at           | DATETIME         | Last update timestamp               |
| allocation_strategy  | VARCHAR(50)      | Winner selection strategy (enum)    |
| min_winners          | INT              | Minimum number of winners           |
| max_winners          | INT              | Maximum number of winners           |
| cutoff_score         | DOUBLE           | Minimum score for consideration     |
| is_average_allocation| BOOLEAN          | Use average allocation              |

### tender_criteria Table
| Column       | Type         | Description                         |
|--------------|--------------|-------------------------------------|
| id           | BIGINT       | Primary key                         |
| tender_id    | BIGINT       | Foreign key to tenders              |
| name         | VARCHAR(255) | Criterion name                      |
| description  | TEXT         | Detailed description                |
| type         | VARCHAR(50)  | Criterion type (enum)               |
| weight       | DOUBLE       | Weight for scoring                  |
| prefer_higher| BOOLEAN      | True if higher values are better    |

### tender_items Table
| Column        | Type         | Description                         |
|---------------|--------------|-------------------------------------|
| id            | BIGINT       | Primary key                         |
| tender_id     | BIGINT       | Foreign key to tenders              |
| criteria_id   | BIGINT       | Foreign key to tender_criteria      |
| name          | VARCHAR(255) | Item name                           |
| description   | TEXT         | Detailed description                |
| quantity      | INT          | Required quantity                   |
| unit          | VARCHAR(50)  | Unit of measurement                 |
| estimated_price| DECIMAL     | Estimated price                     |

### tender_categories Table
| Column       | Type         | Description                         |
|--------------|--------------|-------------------------------------|
| id           | BIGINT       | Primary key                         |
| name         | VARCHAR(255) | Category name                       |
| description  | TEXT         | Detailed description                |
| active       | BOOLEAN      | Whether category is active          |

## Testing

### Unit Tests

Unit tests focus on individual components, particularly the service layer. Example test for the tender service:

```java
@ExtendWith(MockitoExtension.class)
public class TenderServiceImplTest {

    @Mock
    private TenderRepository tenderRepository;
    
    @Mock
    private TenderEventPublisher eventPublisher;
    
    @InjectMocks
    private TenderServiceImpl tenderService;
    
    @Test
    void shouldCreateTender() {
        // Test implementation
    }
    
    @Test
    void shouldThrowExceptionWhenPublishingNonDraftTender() {
        // Test implementation
    }
}
```

### Integration Tests

Integration tests verify interactions between components:

```java
@SpringBootTest
@AutoConfigureMockMvc
public class TenderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private TenderRepository tenderRepository;
    
    @Test
    void shouldCreateAndRetrieveTender() {
        // Test implementation
    }
}
```

### End-to-End Tests

E2E tests verify entire flows across multiple services using TestContainers for real instances of MySQL and Kafka.

## Deployment

### Container Deployment

The service is containerized using Docker:

```dockerfile
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/tender-service-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Kubernetes Deployment

The service can be deployed to Kubernetes:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: tender-service
spec:
  replicas: 2
  selector:
    matchLabels:
      app: tender-service
  template:
    metadata:
      labels:
        app: tender-service
    spec:
      containers:
      - name: tender-service
        image: egov-tendering/tender-service:latest
        ports:
        - containerPort: 8081
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "prod"
        - name: MYSQL_USER
          valueFrom:
            secretKeyRef:
              name: mysql-credentials
              key: username
        - name: MYSQL_PASSWORD
          valueFrom:
            secretKeyRef:
              name: mysql-credentials
              key: password
```

## Troubleshooting

### Common Issues

1. **Database Connection Issues**
    - Check database credentials and connectivity
    - Verify MySQL service is running and accessible

2. **Kafka Connection Issues**
    - Check Kafka broker is running
    - Verify topic configuration

3. **Service Discovery Problems**
    - Ensure Eureka server is running
    - Check service registration in Eureka dashboard

### Logging

The service uses SLF4J with Logback for logging. Log levels are configurable in `application.yml`:

```yaml
logging:
  level:
    com.egov.tendering: INFO
    org.springframework: WARN
```

### Health Checks

Spring Boot Actuator endpoints provide health information:
```
GET /tender-service/actuator/health
```

## Future Enhancements

1. **Advanced Evaluation Algorithms**
    - Implement machine learning for bid evaluation
    - Add support for complex multi-criteria decision analysis

2. **Enhanced Security**
    - OAuth2 with resource server configuration
    - Role-based access control per tender

3. **Internationalization**
    - Multi-language support for tender documents
    - Localized tender creation and viewing

4. **Reporting and Analytics**
    - Tender performance metrics
    - Supplier performance tracking

5. **Integration Improvements**
    - Integration with payment gateways
    - Blockchain integration for immutable tender records

---

For further information, please contact the development team or refer to the project documentation repository.