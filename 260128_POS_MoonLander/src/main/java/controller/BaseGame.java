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
        log.info("--> basegame ctor called ");
        timer = new Timer(20, e -> tick()); // new frame every 20ms
    }

    public void start(JPanel view){
        this.view = view; // paint area
        log.info("--> basegame timer started");
        timer.start();
    }

    private void tick(){
        // update the game
        update();
        // repaint
        view.repaint();
    }

    abstract public void update();
    abstract public void draw(Graphics2D g2d);

    abstract public void mouseClicked(MouseEvent e);
    abstract public void mouseDown(MouseEvent e);
    abstract public void mouseRelease(MouseEvent e);

    abstract public void keyPressed(KeyEvent e);

}
