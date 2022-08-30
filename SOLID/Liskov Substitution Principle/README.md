## Liskov Substitution Principle (LSP)

> Let **Φ(x)** be a property provable about objects *x*  of type *T* . Then *Φ(y)* should be true for objects *y* of type *S* where *S* is a subtype of T.

The Liskov substitution principle simply implies that when an instance of a class is passed/extended to another class, the inheriting class should have a use case for all the properties and behavior of the inherited class.

Hence, if a Class A is a subtype of class B, then we should be able to replace B with A without interrupting the program behavior. 



Assume the following example

``` java
public abstract Student{

    public abstract void registerCourse();
    public abstract void registerClub();

}

```

```json
public class SeniorStudent extends Student {
    
    public void registerCourse(){
        // logic
    }
    
       
    public void registerClub(){
        // logic
    }
    
    
}
```

However, assume that a `JuniorStudent` cannot register in a club in his junior period. Therefore it cannot extend the Student class. Hence, when you extend a class, if some of the properties of the initial class are not useful for the new class, the *Liskov substitution principle has been violated.*

**The solution to this is simple: create interfaces that match the needs of the inheriting class.**