import lombok.extern.java.Log;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@Log
public class PaintArea extends JPanel {
    private MyGraphics myGraphics;

    public PaintArea(MyGraphics myGraphics) {
        super(); // for the mouse events
        this.myGraphics = myGraphics;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                myGraphics.handleMouseClickEvent(e); // call my own methode
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        log.info("called paintComponent");

        Graphics2D g2d = (Graphics2D) g;
        int height = getHeight();
        int width = getWidth();
        myGraphics.update(width, height);
        myGraphics.draw(g2d);
    }
}
