package model;

import graphics.GenericGraphic;
import graphics.Moveable;
import lombok.extern.java.Log;
import utils.Vector;

import java.awt.*;

@Log
public class Lander extends Moveable implements GenericGraphic {
    //des is des gleiche wie rect lol

    private final int width;
    private final int height;

    public Lander(int x, int y, int width, int height) {
        this.location = new Vector(x, y);
        this.velocity = new Vector(1.f, 0.f);
        this.acceleration = new Vector(0.f, 0.05f);
        this.width = width;
        this.height = height;
    }

    public void thrustUp(){
        this.velocity.y -= 1.0f;
    }

    public void thrustLeft(){
        this.velocity.x -= 0.5f;
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
        location.add(velocity); // s = s_0 + v * 1s


        //
        //collision detection
        //

        if(location.y + this.height > height){
            this.velocity.y *= -1;
            this.location.y = height - this.height;
        }

        if(location.x + this.width > width || location.x <= 0){
            this.velocity.x *= -1;
        }

        if (location.y < 0) {
            this.velocity.y *= -1;
            this.location.y = this.height;
        }


    }

    @Override
    public void draw(Graphics2D g2d) {
        log.info(System.currentTimeMillis() + " Lander: Draw Called");
        g2d.drawRect((int)location.x, (int)location.y, width, height);

        g2d.drawString(String.format("%.2f", velocity.magnitude()),
                location.x,
                location.y);
    }
}
