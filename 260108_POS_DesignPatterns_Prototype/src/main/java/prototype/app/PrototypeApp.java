package prototype.app;
import prototype.core.Shape;
import prototype.shapes.Circle;
import prototype.shapes.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
public class PrototypeApp {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle c1 = new Circle();
        c1.setX(10);
        c1.setY(20);
        c1.setColor(Color.RED);
        c1.setRadius(15);
        shapes.add(c1);
        
// Clone the first circle
        Circle c2 = (Circle) c1.clone();
        c2.setColor(Color.BLUE);
        shapes.add(c2);
        
// Display all shapes
        for (Shape s : shapes) {
            s.print();
        }
    }
}