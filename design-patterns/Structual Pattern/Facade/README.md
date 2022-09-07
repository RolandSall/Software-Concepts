# Facade Design Pattern



Facade Implementation is a pattern that can be used to abstract different methods that are used by a system into a simple interface that hides the complexity of these methods. However, it sill includes the features that the client cares about.



Referring to the following [example](https://refactoring.guru/design-patterns/facade):

* Assume the application functionality is to convert videos to a certain format.
* Such feature relies on multiple other functionalities such as compression, CODEC format, BufferReaders ..



Instead having your application to deal directly with theses classes (some of the classes could be used from a specific library). You can create a facade class which encapsulates all of these functionalities and hides it from the rest of code and only provided the needed feature which is `convertVideo`  



 ``` java
 // These are some of the classes of a complex 3rd-party video
 // conversion framework. We don't control that code, therefore
 // can't simplify it.
 
 class VideoFile
 // ...
 
 class OggCompressionCodec
 // ...
 
 class MPEG4CompressionCodec
 // ...
 
 class CodecFactory
 // ...
 
 class BitrateReader
 // ...
 
 class AudioMixer
 // ...
 ```



``` jade
// We create a facade class to hide the framework's complexity
// behind a simple interface. It's a trade-off between
// functionality and simplicity.
class VideoConverter is
    method convert(filename, format):File is
        file = new VideoFile(filename)
        sourceCodec = new CodecFactory.extract(file)
        if (format == "mp4")
            destinationCodec = new MPEG4CompressionCodec()
        else
            destinationCodec = new OggCompressionCodec()
        buffer = BitrateReader.read(filename, sourceCodec)
        result = BitrateReader.convert(buffer, destinationCodec)
        result = (new AudioMixer()).fix(result)
        return new File(result)
```



Notice how the main application only instantiate a `VideoConverter` Application and call one method: `convert`. In the Facade class, notice how we tend to use the classes from the first snippet to reach the desired goal. However, from a main application perspective this hidden. 

``` java
class Application is
    method main() is
        convertor = new VideoConverter()
        mp4 = convertor.convert("funny-cats-video.ogg", "mp4")
        mp4.save()
```

*Note this pattern can be used to apply the Single Responsibility Principle (SOLID) How you might ask? Lets take another example*



lets say you have the following class

```java
public class Teacher {

    // properties
    // get and setters
    // constructor
    
    public void reportHours(){
        // logic
    }
    
    public Teacher save(){
        // logic
    }
    
    public double calculatePay(){
        // logic
    }
    
}
```



Notice how this class violates the Single Responsibility Principles: **It has one more than one reason to change**

One solution is to implement a Facade class and extract each method to its own class.

```java
public class PayCalculator () {
    
    public double calculatePay(){
        // logic
    }
}


public class HourReporter () {
    
    public double reportHours(){
        // logic
    }
}


public class TeacherSaver () {
    
    public double saveTeacher(){
        // logic
    }
}

public class Teacher(){
    // data
}


public class TeacherFacade() {
    
    private PayCalculator payCalculator;
    private HourReporter hourRepoter;
    private TeacherSaver teacherSaver;
    private Teacher teacher;
    
    public TeacherFacade(Teacher teacher){
        payCalculator = new PayCalcualtor();
        hourRepoter = new HourRepoter();
        teacherSaver = new TeacherSaver();
        this.teacher = teacher;
    }
    
    public double calculatePay(){
        payCalculator.calculatePay();
    }
    
    ...
    // Notice how the facade implementation is minimal in this case, and only call the method we abstracted
    // Hence we ensure the SRP principle in each of these functionalities.
}
```



> Declare and implement this interface in a new facade class. The facade should redirect the calls from the client code to appropriate objects of the subsystem. The facade should be responsible for initializing the subsystem and managing its further life cycle unless the client code already does this. Now your system only contact the facade



Pros:

* Isolate complex subsystem code
* A facade become `god object` coupled to all classes of an application