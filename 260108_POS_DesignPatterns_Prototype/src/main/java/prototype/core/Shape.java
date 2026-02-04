package prototype.core;

import java.awt.Color;

public abstract class Shape {
    private int x;
    private int y;
    private Color color;

    // Getters and setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    // Copy constructor for deep copying
    public Shape(Shape source) {
        if (source != null) {
            this.x = source.x;
            this.y = source.y;
            this.color = source.color;
        }
    }

    // Default constructor
    public Shape() {}

    // Abstract clone method - each subclass implements
    public abstract Shape clone();

    // Abstract print method
    public abstract void print();
}