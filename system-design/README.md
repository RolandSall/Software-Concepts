# Object Oriented Design



## Aim

Object oriented design aims to demonstrate your understanding how to model and a maintain an oop code.



## Tips

*Step 1*: **Handle ambiguity**

Often such question are vague intentionally to see how to the developer will make use of the given and try to extract use cases by asking the right questions. Good three questions to ask yourself

* Who is going to use it?
* How they are going to use it?

other question could be that what? where and when? the *6Ws*

*Step 2*: **Define the Core Objects**

Suppose we are asked to do the object oriented design of a system for a restaurant. What are the core things?:

Table, Guest, Party, Order, Meal, Employee, Server, Host

*Step 3*: **Analyze Relationship**

* Server and Host are types of Employee

* There is one Host per restaurant
* Party is an array of Guests
* Each table has one Party, but each Party may have multiple tables

*Step 4:* **Investigate Actions**

At this point, you should have the basic outline of your object-oriented design. What remains is to consider key actions that the objects must perform. Example

A `Party` walks into a `Restaurant`, and a `Guest`  request a ` Table` from the `Host` . The Host looks up up the `Reservation` 	and, if exists assign a `Party` to a `Table` . Otherwise, the `Party` is added at the end of the list. When a `Party` leaves, `Table` is freed and assigned to a new Party in the List.

*Step5:* **Design Patterns**

Normally patterns are outside of this scope. However two important patterns to know `Singleton` and `Factory Method` are widely used. In this document I will not discuss these pattern since I already cover them in this repository under the `Design Patterns` Directory.





 































References:

* Cracking the code interview
