# Domain Driven Design Concepts

Main Book [here](https://www.amazon.com/Domain-Driven-Design-Tackling-Complexity-Software/dp/0321125215)

In this README.md file we will discuss in a brief manner the main concepts in Domain Driven Design. More detailed references will be added below.

## Domain Model

### Domain

The Domain Model is considered the heart of your application. A domain can be defined by the following:

> A Sphere of knowledge and activity around which the application logic revolves

### Model

The model represents an abstraction the illustrate elements of the domain that are normally used to solve issues in a specific domain.

Hence, a domain model will always contain business/concepts that the client cares about.



## Entity & Value Objects

## Entities

> Objects that are not fundamentally defined by their attributes, but rather by a thread of continuity and identity.

> Entity objects are classes that encapsulate the business model, including rules, data, relationships, and persistence behavior, for items that are used in your business application

## Value Objects

Values objects heavily differs from the entity object:

* Defined by its attributes
* Does not have an identity (unique identifier)
* Value Objects are [Immutable](https://stackoverflow.com/questions/279507/what-is-meant-by-immutable)

For each problem, you defines your entities and value object. 

#### Example

A bill i.e, a 10USD bill can be considered as a value object in one problem object because this specific problem does not care about which bill we use. However, in other problems the identity of each bill might be crucial for system. Hence each bill has a unique identifier.

##### Entity Example

```java
Bucket literOfRed = new Bucket(1L, Color.Red);
Bucket literOfWhite = new Bucket(1L, Color.WHITE);

literOfRed.add(literOfWhite);

// new literOfRed contains 2 liters ... of pink...
// literOfwhite is it empty??

// The logic is hidden by the .add method 
// the literOfRed variable is now not well representitive 
```

##### Value Objects Example

```java
Bucket literOfRed = new Bucket(1L, Color.Red);
Bucket literOfWhite = new Bucket(1L, Color.WHITE);

// Values objects are immutable
// We can modifies the existent objects
// We can only create a new bucket with a combination of the other buckts contents
Bucket lotsOfPink = literOfRed.mixedWith(literOfWhite);

// noticed the past tense method naming 
// value objects can be used to create any time of mathematical/operations
```

[Example Reference](https://academy.axoniq.io/)

## Repository

> A  repository is **an object that participates in the domain but really abstracts away storage and infrastructure details**.

it is up to the domain to define the repository.

## Aggregates

An aggregate is a result of multiple related entitles (value objects might be involved), that are considered as one unit with regard to data changes.

> Each aggregate has a single root entity, referred to as the aggregate root.

External references are restricted to one member of the aggregated named the `Root`. The root is responsible for controlling access to all members and rules within the aggregate boundaries.

## Events

A notification that illustrate relevant actions that occurred inside of a domain.

## Bounding Context

A bounding context represents a a set of functional features within a domain.





