package controller;

import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Log
public abstract class BaseGame {
    protected JPanel view;
    private final Timer timer; // tick, tick, tick

    public BaseGame(){
        log.info("--> basegame called ");
        timer = new Timer(1000/60, e -> tick()); // 1000 / (the fps you want)
    }

    public void start(JPanel view){
        this.view = view; // paint area
        log.info("--> basegame timer started");
        timer.start();
    }

    private void tick(){
        update();
        view.repaint();
    }

    abstract public void update();
    abstract public void draw(Graphics2D g2d);

    abstract public void mouseClicked(MouseEvent e);
    abstract public void mouseDown(MouseEvent e);
    abstract public void mouseRelease(MouseEvent e);

    abstract public void keyPressed(KeyEvent e);
    abstract public void keyReleased(KeyEvent e);
}
