package controller;

import lombok.extern.java.Log;
import model.Lander;
import model.LandingZone;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

@Log
public class Game extends BaseGame {
    private Lander lander;
    private LandingZone landingZone;
    Random rand = new Random();

    private boolean gameOver = false;
    private boolean won = false;

    public Game()  {
        super();

        //create the lander at the center top of the screen
        lander = new Lander(200, 50, 20, 40);
        landingZone = new LandingZone(60, 10, rand.nextInt(340) - 50,  300);

    }

    private void resetGame() {
        lander = new Lander(200, 50, 20, 40);
        gameOver = false;
        won = false;
    }

    private void createNewLandingZone() {
        landingZone = new LandingZone(60, 10, rand.nextInt(340) - 50, 300);
    }

    @Override
    public void update() {
        log.info("--> game update called");

        if (gameOver || won) {
            return; // no updates if game over oder won
        }

        lander.update(view.getWidth(), view.getHeight());

        // LANDING ZONE COLLISION DETECTION
        if (lander.getY() + lander.getHeight() >= landingZone.getY()) {
            if (lander.getX() + lander.getWidth() >= landingZone.getX() && lander.getX() <= landingZone.getX() + landingZone.getWidth()) {
                won = true;
                log.info("YOU WON - Landed Successfully!");
                return;
            } else {
                gameOver = true;
                log.info("GAME OVER - Hit ground outside landing zone!");
                return;
            }
        }

        // hit walls
        if (lander.getX() + lander.getWidth() >= view.getWidth() || lander.getX() <= 0) {
            gameOver = true;
            log.info("GAME OVER - Hit wall!");
            return;
        }

        // hit ceiling
        if (lander.getY() <= 0) {
            gameOver = true;
            log.info("GAME OVER - Hit ceiling!");
        }
    }

    @Override
    public void draw(java.awt.Graphics2D g2d) {
        log.info("--> game draw called");
        g2d.fillRect(1,1, view.getWidth()-2, view.getHeight()-2);
        lander.draw(g2d);
        landingZone.draw(g2d);

        if (gameOver) {
            g2d.setColor(Color.RED);
            String text = "GAME OVER";
            int textWidth = g2d.getFontMetrics().stringWidth(text);
            g2d.drawString(text, (view.getWidth() - textWidth) / 2, view.getHeight() / 2);

            String restart = "Press SPACE to start again";
            int restartWidth = g2d.getFontMetrics().stringWidth(restart);
            g2d.drawString(restart, (view.getWidth() - restartWidth) / 2, view.getHeight() / 2 + 40);
        } else if (won) {
            g2d.setColor(Color.GREEN);
            String text = "YOU WON!";
            int textWidth = g2d.getFontMetrics().stringWidth(text);
            g2d.drawString(text, (view.getWidth() - textWidth) / 2, view.getHeight() / 2);

            String restart = "Press SPACE for new landing zone";
            int restartWidth = g2d.getFontMetrics().stringWidth(restart);
            g2d.drawString(restart, (view.getWidth() - restartWidth) / 2, view.getHeight() / 2 + 40);
        }
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

        if (e.getKeyChar() == ' ') {
            if (gameOver) {
                resetGame();
                log.info("Game restarted!");
            } else if (won) {
                createNewLandingZone();
                resetGame();
                log.info("New landing zone created!");
            }
            return;
        }

        // Movement control
        if (!gameOver && !won) {
            switch (e.getKeyChar()) {
                case 'w' -> lander.thrustUp();
                case 'a' -> lander.thrustLeft();
              X  case 'd' -> lander.thrustRight();
                case 's' -> lander.thrustDown();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

