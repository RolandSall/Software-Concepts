# Strategy

> **Strategy** is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

It is about using composition rather than inheritance 



## When To Use

Use the strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another on runtime.

Things to keep in mind:

* Identify the aspects of your application that vary and separate them from what stays the same
* Program to an interface, not an implementation.



Consider the following example taken from Head First Design Book

* Consider you have superclass Duck that contains the following methods:
  * display()
  * eat()
* Two other subclasses CityDuck and MountainDuck extends the Duck Class

Later on a new requirements  came up: a `fly` requirement. So you go up to your superclass and add the latter method. However, it turns out that a `CityDuck` is able to fly but a `MountainDuck`is not able to fly. Now consider you have 10 other types of ducks each have their own`fly` technique and `eat` technique. In some cases, you would be implementing a `fly` method that does nothing, since the `MountainDuck` does not fly, in some cases you might be replicating the same fly method. Lets say `DuckTypeX` and `DuckTypeY` fly the same way. How can you achieve that without having to duplicate the behaviour?

### First Thoughts

Add an interface? Yes lets do that. Introduce `FlyInterface` and make only the subclasses that fly implement the latter. Great! now a `MountainDuck` does not have a redundant `fly` method since this class will not implement the `FlyInterface`. But wait a second! This solved my first problem. But what having different classes that have the same `fly` method, am still duplicating the code. How would you even maintain such numerous `fly` behaviors :thinking: 

### Solution

To solve the problem is to introduce a `FlyBehavior` and let these multiple fly behavior implements from the `FlyBehavior` . But how would this solve the problem?

Well If you think about it we decoupled our system. By taking the part that changes based on a certain strategy to an outside entity. Now, we can inject these strategies based on the our need depending on duck type. (see figures below)



![image-20220910081230541](https://github.com/RolandSall/Microservices-Concepts/blob/main/design-patterns/Behavioral%20Pattern/Strategy/images/img1.PNG)

The key is that a duck will now ***delegate*** its flying and quacking behavior, instead of using quacking and flying methods defined in the Duck class or subclass 



![image-20220910081651190](https://github.com/RolandSall/Microservices-Concepts/blob/main/design-patterns/Behavioral%20Pattern/Strategy/images/img2.PNG)



![image-20220910081459380](https://github.com/RolandSall/Microservices-Concepts/blob/main/design-patterns/Behavioral%20Pattern/Strategy/images/img3.PNG)





