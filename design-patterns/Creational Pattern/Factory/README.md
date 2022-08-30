# Factory Pattern

First we will start by defining some keys words 

## Factory

Factory is a word that stands for a function, method or class that is supposed to produce a certain output. An example could be a class that creates a car.

## Creation Method

It is the method that creates objects. Hence, a factory pattern is part of the creational patterns. However, not evert creational pattern is a factory pattern. In fact creation method are wrapper around a constructor call.

## Static Creation Method

> **Static creation method** is a creation method declared as `static`. In other words, it can be called on a class and doesn’t require an object to be created

``` java
public class Coordinate {
    private double x_coord;
    private double y_coord;
    
    private Coordinate(double x, double y){
        x_coord = x;
        y_coord = y;
    }
    
    public static final Coordinate fromXY(double x, double y){
        return new Coordinate(x,y);
    }
    
    public static final Coordinate fromPolar(double dist, double angle){
        return new Coordinate(dist* Math.cos(angle), dist * Matg.sin(angle));
    }    
    
}
```

The only way to use the constructor is to make the two function as static. What this help us is now we can create a coordinate in two different ways. 

## Simple Factory Pattern

A simple factory is normally represented by a single method in a single class.

``` java
class VehicleInstantiator {
    
    public static Vehicle instantiate(String type, int year) throws Exception {
        return switch(type){
                case "Electric" -> new ElectricVehicle(type,year);
                case "Diesel" -> new DieselVehicle(type,year);
                default -> throw new Exception ("Type not Found")
        }
    }
    
}
```

Over time, this method might become too big, so you may decide to extract parts of the method to subclasses. Once you do it several times, you might discover that the whole thing turned into the classic *factory method* pattern.



## Factory Method Pattern

The **Factory Method** is a creational design pattern that provides an interface for creating objects but allows subclasses to alter the type of an object that will be created.

``` java
abstract class Department {
    public abstract function createEmployee($id);

    public function fire($id) {
        $employee = $this->createEmployee($id);
        $employee->paySalary();
        $employee->dismiss();
    }
}

class ITDepartment extends Department {
    public function createEmployee($id) {
        return new Programmer($id);
    }
}

class AccountingDepartment extends Department {
    public function createEmployee($id) {
        return new Accountant($id);
    }
}
```

* The class is chosen at *Run Time*



## When To Choose?

*  When you do not know ahead of time which object you need
* When all potential classes are in the same subclass hierarchy 
* To centralize class code selection
* When you do not want the user to have to know every subclass
* To encapsulate object creation



