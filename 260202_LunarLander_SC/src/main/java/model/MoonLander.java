package model;

import Utils.Vector;

import java.awt.*;

public class MoonLander {

    private Vector location;
    private Vector velocity;
    private Vector acceleration;
    private int width;
    private int height;
    private boolean isCollided;

    private float fuel;



    private boolean debugMode = false;

    public MoonLander(Vector upperLeftCorner, int width, int height, float fuel) {
        location = upperLeftCorner;
        velocity = new Vector(0.0f, 0.0f);
        acceleration = new Vector(0.0f, 0.0f);
        this.width = width;
        this.height = height;
        this.fuel = fuel;
    }



    public void update(Vector gravity){
        acceleration.add(gravity);
        velocity.add(acceleration);
        location.add(velocity);
    }

    public void draw(Graphics2D g2d){
        // legs: triangle
        int xA = (int)location.getX();
        int yA = (int)location.getY() + height;
        int xB = (int)location.getX() + width;
        int yB = (int)location.getY() + height;
        int xC = (int)location.getX() + width / 2;
        int yC = (int)location.getY() + height / 2;

        g2d.drawLine(xA, yA, xB, yB);
        g2d.drawLine(xA, yA, xC, yC);
        g2d.drawLine(xB, yB, xC, yC);

        // wings: triangle
        xA = (int)location.getX();
        yA = (int)location.getY() + height / 2;
        xB = (int)location.getX() + width;
        yB = (int)location.getY() + height / 2;
        xC = (int)location.getX() + width / 2;
        yC = (int)location.getY();

        g2d.drawLine(xA, yA, xB, yB);
        g2d.drawLine(xA, yA, xC, yC);
        g2d.drawLine(xB, yB, xC, yC);

        // ellipse: body
        xA = (int)location.getX() + width / 4;
        yA = (int)location.getY();
        int ellipseWidth = width - width / 2;
        int ellipseHeight = height * 3 / 4;
        g2d.fillOval(xA, yA, ellipseWidth, ellipseHeight);

        if(debugMode) {
            drawDebug(g2d);
        }

        //gamestate:
//        if ()
    }

    private void drawDebug(Graphics2D g2d){
        g2d.drawRect((int)location.getX(), (int)location.getY(), width, height);
        g2d.drawString(velocity.toString(), 10, 10);
        g2d.drawString(acceleration.toString(), 10, 25);
        g2d.drawString(fuel + "l of fuel", 10, 40);
    }

    public void accelerate(Vector a){
        acceleration = a;
    }

    public Vector getLocation() {
        return location;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isCollided() {
        return isCollided;
    }

    public void setCollided(boolean collided) {
        isCollided = collided;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
