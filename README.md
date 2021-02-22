# spring-boot-openapi3-rest-documentation
This Project Demonstrates A Simple Way To Document Spring Boot Microservices.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

Always clean the project before running it by executing below command
```bash
mvn clean install
```

### Prerequisites

* Java 1.8
* Maven 

### How to run Unit Tests or API Tests
```bash
mvn clean test
```

### Running the application
You can run the application by executing below command.
```bash
mvn spring-boot:run
```
2. Run the *.jar file from the `target` directory using:
```bash
java -jar target/Application.jar
```

#### Maven Spring Boot Plugin
1. Build and deploy the process application using:
```bash
mvn clean install spring-boot:run
```

#### Your Java IDE
1. Run the project as a Java application in your IDE using Application as the main class.

## OpenAPI 3.0 was used to document Spring Boot Micro service.
Please Use medium [Github](http://github.com/) for more detailed information.

### How to download yaml file?
* Default
```
http://localhost:8080/v3/api-docs.yaml
```
* Custom
```
http://localhost:8080/microservice-docs.yaml
```

### How to view the Swagger UI Page?
* Default
```
http://localhost:8080/swagger-ui.html
```
* Custom
```
http://localhost:8080/swagger-ui.html
```

### How to view the yaml information?

* Default
```
http://host:port/api-docs.yaml
```

## Built With

* [OpenApi](https://swagger.io/specification/)

## Versioning

We use [Github](http://github.com/) for versioning.

## Authors

* **Tebatso Mokgokolo** - *Initial work*

## Acknowledgments

* Tebatso Mokgokolo

https://springdoc.org/#properties