package prototype.shapes;

import prototype.core.Shape;

public class Rectangle extends Shape {
    private int width;
    private int height;

    // Default constructor
    public Rectangle() {}

    // Copy constructor
    public Rectangle(Rectangle source) {
        super(source);  // Copy parent fields
        if (source != null) {
            this.width = source.width;
            this.height = source.height;
        }
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void print() {
        System.out.println("Rectangle at (" + getX() + "," + getY() +
                "), color=" + getColor());
    }
}