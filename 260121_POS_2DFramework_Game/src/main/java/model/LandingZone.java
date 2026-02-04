package model;

import graphics.GenericGraphic;
import lombok.extern.java.Log;

import java.awt.*;

@Log
public class LandingZone implements GenericGraphic {

    private final int width;
    private final int height;
    private final int x;
    private final int y;


    public LandingZone(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int width, int height) {
        log.info(System.currentTimeMillis() + "LandingZone: Update Called.");
        // Landing zone does not need to update its stat
    }

    @Override
    public void draw(Graphics2D g2d) {
        log.info(System.currentTimeMillis() + "LandingZone: Draw Called.");

        g2d.fillRect(x,y,width,height);

        g2d.drawString("LAND HERE", x - height, y - width);

        g2d.setColor(Color.GREEN);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
