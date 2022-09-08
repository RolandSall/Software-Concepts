import Factory.AbstractFactory;
import Factory.FactoryProducer;
import Shapes.IShape;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        IShape shape1 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape1.draw();
        //get an object of Shape Square
        IShape shape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape2.draw();
        //get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
        //get an object of Shape Rectangle
        IShape shape3 = shapeFactory1.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape3.draw();
        //get an object of Shape Square
        IShape shape4 = shapeFactory1.getShape("SQUARE");
        //call draw method of Shape Square
        shape4.draw();
    }
}
