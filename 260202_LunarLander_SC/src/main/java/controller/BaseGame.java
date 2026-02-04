package controller;

import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Log
public abstract class BaseGame {
    protected JPanel view;
    private Timer timer; // tick, tick, tick

    public BaseGame(){
        log.info("--> basegame ctor called ");
        timer = new Timer(20, e -> tick()); // tick all 20ms, call methode
    }

    public void start(JPanel view){
        this.view = view; // paint area
        init(); // init after I get a View
        log.info("--> basegame timer started");
        timer.start();
    }

    private void tick(){
        // update the game
        update();
        // repaint
        view.repaint();
    }

    abstract public void init();
    abstract public void update();
    abstract public void draw(Graphics2D g2d);

    abstract public void mouseClicked(MouseEvent e);
    abstract public void mouseDown(MouseEvent e);
    abstract public void mouseRelease(MouseEvent e);

    abstract public void keyPressed(KeyEvent e);
    abstract public void keyReleased(KeyEvent e);

}
