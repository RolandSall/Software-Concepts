# Mediator & CQRS Patterns In .NET





## Mediator 

#### Problem Statement

Consider having an application that aims to create and update certain profiles (products, customers...).  In this application you have four services (A,B,C,D) that are coupled and communicate to achieve certain goals. Instead of having direct communication among them, in a mediator pattern an entity will exist between these services and somehow `orchestrate` the communication.

For more details on the mediator pattern: [refactoring.guru](https://refactoring.guru/design-patterns/mediator) 



##### MediatR

In .NET core, `MediatorR` is a nugget package that helps implementing the Mediator pattern. Check the source code for an hand-on example.



## CQRS

* CQRS stands for **Command and Query Responsibility Segregation**

  * ​	 Basically this pattern separates read and update operations for a database.

  Extra References: [RolandSall24-Java-Es-CQRS](https://github.com/RolandSall/Microservices-Concepts/blob/main/event-driven-microservices/java/README.md), [Medium article](https://medium.com/design-microservices-architecture-with-patterns/cqrs-design-pattern-in-microservices-architectures-5d41e359768c)





