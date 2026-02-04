package model;

import java.awt.*;

public class LandingZone {
    private int x; //random x position (in game)
    private int y; //random y position
    private int width;
    private int height;

    public LandingZone(int width, int height, int x, int y) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        // Landing zone does not need to update its state
    }

    public void draw(java.awt.Graphics2D g2d) {

        g2d.fillRect(x, y, width, height);
        int fontSize = 12;
        g2d.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, fontSize));
        g2d.setColor(java.awt.Color.BLACK);
        g2d.drawString("LAND", x - height + 15, y - width);
        g2d.drawString("HERE", x - height + 15, y - width + fontSize);
        g2d.setColor(Color.BLACK);
        // fuel bar:


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
