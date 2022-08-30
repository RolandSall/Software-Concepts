## Dependency Inversion Principle (DIP)

The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details. 

Assume having the following example: An `ElectricPowerSwtich` and `LightBulb`

``` java
public class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
    }
}
```

```java
public class ElectricPowerSwitch {
    public LightBulb lightBulb;
    public boolean on;
    public ElectricPowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.on = false;
    }
    public boolean isOn() {
        return this.on;
    }
    public void press(){
        boolean checkOn = isOn();
        if (checkOn) {
            lightBulb.turnOff();
            this.on = false;
        } else {
            lightBulb.turnOn();
            this.on = true;
        }
    }
}
```

The obvious mistake that we did is that we made a High Level Class which is a switch to be dependent on a LightBulb... An electric switch could be used to turn on and off any electrical device.



## Solution

Create a`switch.java` interface

```java
public interface Switch {
    boolean isOn();
    void press();
}
```

The above interface will allow us to implement different plug types.

`switchable.java`

```java
public interface Switchable {
    void turnOn();
    void turnOff();
}
```

`ElectricalPowerSwitch.java`

```java
public class ElectricPowerSwitch implements Switch {
    public Switchable client;
    public boolean on;
    public ElectricPowerSwitch(Switchable client) {
        this.client = client;
        this.on = false;
    }
    public boolean isOn() {
        return this.on;
    }
   public void press(){
       boolean checkOn = isOn();
       if (checkOn) {
           client.turnOff();
           this.on = false;
       } else {
             client.turnOn();
             this.on = true;
       }
   }
}
```

In the `ElectricPowerSwitch` class we implemented the `Switch` interface and referred the `Switchable` interface instead of any concrete class in a field.

We then called the `turnOn()` and `turnoff()` methods on the interface, which at run time will get invoked on the object passed to the constructor. 

Going back to our low level classes

`LightBulb.java`

```java
public class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }
    @Override
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
    }
}
```

```java
public class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan: Fan turned on...");
    }
    @Override
    public void turnOff() {
        System.out.println("Fan: Fan turned off...");
    }
}
```

 

We want the low-level classes to depend (inversely) on our abstraction. This will also help us if we later decide to release the high-level package as a public API that other applications can use for their devices.