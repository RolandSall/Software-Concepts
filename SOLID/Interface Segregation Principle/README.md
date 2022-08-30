# Interface Segregation Principle (ISP)

The interface segregation principle states that the interface of a program should be split in a way that the user/client would only have access to the necessary methods related to their needs.

``` java
public interface Teacher {

    void English();

    void Biology();

    void Chemistry();
    
    void Mathematics();

}

```

``` java
public class Jane implements Teacher {

    @Override
    public void English() {
        System.out.println("Jane is teaching the students English language.");
    }

    @Override
    public void Biology() {
    }

    @Override
    public void Chemistry() {
    }

    @Override
    public void Mathematics() {
    }
}
```

You can see from the code above that the other methods should not be implemented by the Class `Jane`.

*NOTE: Do not confuse the Liskov substitution principle and the interface segregation principle. They may seem similar but they are not entirely the same.*

* Liskov Substitution Principle is based on a new class has the need to inherit existing class because it has a need for the methods existing in the parent class.
* Interface segregation is based on understanding that is not reasonable to create an interface with a lot of methods because as seen above it might be irrelevant.

To fix the following:

    ``` java
    public interface Teacher {
    
        void Teach();
    
    }
    ```

``` java
public interface EnglishTeacher extends Teacher {

    void English();

}
```

``` java
public class Jane implements EnglishTeacher {
    
    @Override
    public void Teach() {
        System.out.println("Jane has started teaching.");
    }

    @Override
    public void English() {
        System.out.println("Jane is teaching the students English language.");
    }

}
```

