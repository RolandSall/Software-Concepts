# Singleton

> **Singleton** is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.



## How to implement

- Make the default constructor private, to prevent other objects from using the `new` operator with the Singleton class.
- Create a static creation method that acts as a constructor. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.



## Pros and Cons

:heavy_check_mark: You can be sure that this class has only one instance

:heavy_check_mark: You gain global access to this instance

:x: Special treatment in a Multi-Thread environment

:x: May be difficult to unit test the client. 

