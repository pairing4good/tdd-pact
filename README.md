# tdd-pact
## Overview
This tutorial demonstrates how to set up a contract test between multiple [React](https://reactjs.org/) applications (consumers)and a single [Spring Boot](https://spring.io/projects/spring-boot) service (provider).  This tutorial will use [Pact](https://pact.io/) to [test drive](https://en.wikipedia.org/wiki/Test-driven_development) each consumer call to the provider.

> **Consumer**: An application that makes use of the functionality or data from another application to do its job. For applications that use HTTP, the consumer is always the application that initiates the HTTP request (eg. the web front end), regardless of the direction of data flow. For applications that use queues, the consumer is the application that reads the message from the queue. https://docs.pact.io/getting_started/how_pact_works

> **Provider**: An application (often called a service) that provides functionality or data for other applications to use, often via an API. For applications that use HTTP, the provider is the application that returns the response. For applications that use queues, the provider (also called producer) is the application that writes the messages to the queue. https://docs.pact.io/getting_started/how_pact_works

## Tutorial Approach
This project has 4 consumers:
- consumer-todo-all
- consumer-todo-due
- consumer-todo-owner
- consumer-todo-top

Each consumer is a separate React app that calls the same provider [endpoint](https://swagger.io/docs/specification/paths-and-operations).

http://localhost:3000/todo  

```
[
  {
    "id": 1,
    "description": "Take out the garbage",
    "dueDate": "2022-02-23T13:10:21.125+00:00",
    "priority": 5,
    "status": "TODO",
    "owner": "bsmith",
    "created": "2022-02-18T13:10:21.125+00:00",
    "lastModified": "2022-02-18T13:10:21.125+00:00"
  },
  {
    "id": 2,
    "description": "Wash the dishes",
    "dueDate": "2022-02-28T13:10:21.125+00:00",
    ...
  }
]
```
However, however each consumer uses the response in different ways.  The consumer-todo-all app simply lists all of the todo descriptions in a list.  While consumer-todo-all only cares about the description field, the consumer-todo-due app also uses the dueDate field and sorts the list of todo's by due date.  Each of the 4 consumer apps use the provider's response slightly differently.  These different consumer expectations are called contracts or pacts.  As a provider gains more consumers it's important for the provider to understand how each consumer is using thier service.  [Contract tests](https://docs.pact.io/) solve this problem.  

> **Contract tests** assert that inter-application messages conform to a shared understanding that is documented in a contract. https://docs.pact.io/

In this tutorial we will test drive each consumer interaction with the provider.  Tests will start in each consumer and the resulting contract will drive the creation of the provider's endpoint.  This is called [consumer driven contract testing](https://docs.pact.io/#consumer-driven-contracts).

##Running Applications Together
### Prerequisites
- [Node](https://nodejs.org/) 14 or higher
- [Java](https://aws.amazon.com/corretto) 8 or higher

### Steps
1. Open a separate terminal window for each application.
1. Within each terminal window `cd` into the application that that window will run (example: `cd {your-path-to-this-project}/tdd-pact/consumer-todo-all`)
1. Start the application
    1. For the consumer applications run `npm start` within each terminal window.
    1. For the provider-todo application run `./mvnw spring-boot:run`. Open http://localhost:3000/todo


