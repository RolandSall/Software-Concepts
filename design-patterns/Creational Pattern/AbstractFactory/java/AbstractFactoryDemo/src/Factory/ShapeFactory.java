package Factory;

import Shapes.IShape;
import Shapes.Rectangle;
import Shapes.Square;

public class ShapeFactory extends AbstractFactory{

    @Override
    public IShape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
