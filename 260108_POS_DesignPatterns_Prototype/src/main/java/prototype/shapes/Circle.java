package prototype.shapes;

import prototype.core.Shape;

public class Circle extends Shape {
    private int radius;

    // Default constructor
    public Circle() {

    }

    // Copy constructor
    public Circle(Circle source) {
        super(source);  // Copy parent fields
        if (source != null) {
            this.radius = source.radius;
        }
    }


    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public void print() {
        System.out.println("Circle at (" + getX() + "," + getY() +
                "), color=" + getColor());
    }
}