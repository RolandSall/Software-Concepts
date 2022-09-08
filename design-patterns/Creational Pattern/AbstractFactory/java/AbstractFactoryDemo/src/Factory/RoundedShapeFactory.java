package Factory;

import Shapes.IShape;
import Shapes.RoundedRectangle;
import Shapes.RoundedSquare;

public class RoundedShapeFactory extends AbstractFactory{

    @Override
    public IShape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new  RoundedRectangle();
            }else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new RoundedSquare();
            }
            return null;
    }
}
