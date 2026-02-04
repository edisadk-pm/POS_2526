package controller;

import lombok.extern.java.Log;
import model.Lander;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Log
public class Game extends BaseGame {
    private final Lander lander;

    public Game() {
        super();
        lander = new Lander((400 / 2) - 20, (400/ 2) - 30, 20, 30);
    }

    @Override
    public void update() {
        log.info("--> game update called");
        lander.update(view.getWidth(), view.getHeight());
    }

    @Override
    public void draw(java.awt.Graphics2D g2d) {
        log.info("--> game draw called");
        lander.draw(g2d);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse click if needed
    }

    @Override
    public void mouseDown(MouseEvent e) {
        log.info("--> game mouseDown called");

    }

    @Override
    public void mouseRelease(MouseEvent e) {
        log.info("--> game mouseRelease called");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        log.info("--> game keyPressed called " + e.getKeyChar());
        switch (
                e.getKeyChar()) {
            case 'w' -> lander.thrustUp();
            case 'a' -> lander.thrustLeft();
            case 'd' -> lander.thrustRight();
            case 's' -> lander.thrustDown();
        }
    }

}
