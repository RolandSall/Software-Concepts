package Factory;

import Shapes.IShape;

public abstract class AbstractFactory {

    public abstract IShape getShape(String shapeType);
}
