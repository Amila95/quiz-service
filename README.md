# quiz-service
Welcome to the **Quiz Service** repository! This project is designed to create quizzes using calls to the Question Service. It allows you to create a quiz, fetch questions for the quiz, and submit the quiz for evaluation. This README will guide you through the setup, configuration, and usage of the Quiz Service.

## Prerequisites

Before you begin, ensure you have the following:

- Java Development Kit (JDK) 17 installed
- Apache Maven build tool
- MySQL database server
- Git to clone the repository

 ## Getting Started

Follow these steps to set up and run the Quiz Service:

### Database Configuration

1. Create a MySQL database named `quiz` to store quiz-related data.

### Configuration

1. Clone the repository to your local machine:

   git clone `https://github.com/Amila95/quiz-service.git` <br>
   `cd quiz-service` <br>
   Open the `src/main/resources/application.yml` file and configure the MySQL database connection settings, including URL, username, and password.

### Running the Application
To run the Quiz Service, use the following command: `mvn spring-boot:run`

### Usage
Creating a Quiz
To create a quiz, make a POST request to the /create endpoint with a JSON body containing the quiz details. Example using curl:<br>
`curl -X POST -H "Content-Type: application/json" -d '{
    "category": "Math",
    "noOfQuestion": 5,
    "title": "Algebra Quiz"
}' http://localhost:8080/create`

### Fetching Quiz Questions
To retrieve questions for a quiz, make a GET request to the /get/{id} endpoint, where {id} is the ID of the quiz. Example using curl:
`curl http://localhost:8080/get/1`

### Submitting a Quiz
To submit a quiz, make a POST request to the /submit/{id} endpoint with a JSON body containing the user's responses. Example using curl:

`curl -X POST -H "Content-Type: application/json" -d '[
    {
        "questionId": 1,
        "selectedOption": "B"
    },
    {
        "questionId": 2,
        "selectedOption": "A"
    },
    {
        "questionId": 3,
        "selectedOption": "C"
    }
]' http://localhost:8080/submit/1`



