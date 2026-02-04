package model;

import graphics.GenericGraphic;
import graphics.Moveable;
import lombok.extern.java.Log;
import utils.Vector;

import java.awt.*;

@Log
public class Lander extends Moveable implements GenericGraphic {
    //des is des gleiche wie rect lol

    private int width;
    private int height;

    public Lander(int x, int y, int width, int height) {
        this.location = new Vector(x, y);
        this.velocity = new Vector(1.f, 0.f);
        this.acceleration = new Vector(0.f, 0.05f);
        this.width = width;
        this.height = height;
    }

    public void thrustUp(){
        this.velocity.y -= 0.8f;
    }

    public void thrustLeft(){
        this.velocity.x -= 0.8f;
    }

    public void thrustRight(){
        this.velocity.x += 0.5f;
    }

    public void thrustDown(){
        this.velocity.y += 0.5f;
    }



    @Override
    public void update(int width, int height) {
        log.info(String.format("Lander: Update Called %d/%d", width, height));
        velocity.add(acceleration);
        location.add(velocity); // s = s_0 + v * 1

    }

    @Override
    public void draw(Graphics2D g2d) {
        log.info(System.currentTimeMillis() + " Lander: Draw Called");
        g2d.setColor(Color.GRAY);
        g2d.drawRect((int)location.x, (int)location.y, width, height);
        g2d.setColor(Color.GRAY);

        g2d.drawString(String.format("%.2f", velocity.magnitude()),
                (int)location.x,
                (int)location.y - 5);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return (int) location.x;
    }

    public int getY() {
        return (int) location.y;
    }

    public double getVelocity() {
        return velocity.magnitude();
    }
}
