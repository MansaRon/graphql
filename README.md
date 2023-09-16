# Graphql CRUD project
# Task Management GraphQL API

This is a task management application with a GraphQL API built using Spring Boot and PostgreSQL. It allows users to create, read, update, delete, and mark tasks as completed. Additionally, users can filter tasks based on their status.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before running the project, make sure you have the following prerequisites installed:

- Java 11 or higher
- Apache Maven
- PostgreSQL database

## Getting Started

1. Clone the repository:

   ```shell
   git clone https://github.com/yourusername/task-management-graphql.git
   cd task-management-graphql

2. Configure the PostgreSQL database connection in src/main/resources/application.properties:
      spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
      spring.datasource.username=your_database_user
      spring.datasource.password=your_database_password
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

3. Build the project:
      mvn clean install

Project Structure

The project follows a standard Spring Boot project structure:

    src/main/java/com/yourcompany/taskmanagement: Contains the main Java source code.
        controller: GraphQL controller and resolvers.
        model: Data models and entities.
        repository: Database repositories.
        service: Business logic services.
    src/main/resources: Contains application properties and GraphQL schema files.
 
API Endpoints:
The GraphQL API allows you to interact with tasks. You can access the GraphQL playground at http://localhost:8080/graphql when the application is running.
Here are some sample GraphQL queries and mutations:

* Fetch all tasks
 {
  getAllTasks {
    id
    title
    description
    completed
  }
}

* Create tasks
  mutation {
  createTask(title: "Sample Task", description: "A task description") {
    id
    title
    description
    completed
  }
}

* Update task
  mutation {
  updateTask(id: 1, title: "Updated Task") {
    id
    title
    description
    completed
  }
}

* Delete task 
  mutation {
  deleteTask(id: 1)
}

* Mark a task as complete
  mutation {
  markTaskAsCompleted(id: 1) {
    id
    completed
  }
}

Running the application:
  mvn spring-boot:run
  The GraphQL API will be available at http://localhost:8080/graphql.

Testing
  You can write unit tests for the application using testing frameworks like JUnit and Mockito. To run the tests:
  mvn test

Contributing

  If you'd like to contribute to this project, please fork the repository and create a pull request. We welcome contributions!
  License

  This project is licensed under the MIT License - see the LICENSE file for details.







