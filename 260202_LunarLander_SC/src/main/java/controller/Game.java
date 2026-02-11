package controller;

import Utils.Vector;
import lombok.extern.java.Log;
import model.LandingZone;
import model.MoonLander;
import model.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Log
public class Game extends BaseGame {

    private final List<MoonLander> models = new ArrayList<>();
    Random random = new Random();
    LandingZone landingZone;
    World world;
    private final Vector GRAVITY = new Vector(0.0f, 0.0001f);
    private float ACC_IMPULSE = 0.1f;
    private float FUEL_CONSUMPTION_RATE = 0.3f;

    int gamestate = 0; // 0 = playing, 1 = game over, 2 = won

    @Override
    public void init() {
        // Initialize world with view dimensions
        world = new World(view.getWidth(), view.getHeight());

        // Initialize landing zone here after view is available
        landingZone = new LandingZone(40, 10, random.nextInt(view.getWidth() - 100) + 50, view.getHeight() - 30);

        int moonLanderWidth = 30;
        int moonLanderHeight = 50;
        int startX = view.getWidth() / 2 - moonLanderWidth/2;
        int startY = view.getHeight() / 2 - moonLanderHeight/2;
        models.add(new MoonLander(new Vector(startX, startY), moonLanderWidth, moonLanderHeight,500.0f));
    }


    @Override
    public void update() {
        for(MoonLander model : models) {
            model.update(GRAVITY);

            // Use World's collision detection
            int collisionResult = world.checkCollision(model, models, landingZone);
            if (collisionResult == 1) {
                ACC_IMPULSE = 0.0f;
                gamestate = 1; // game over
            } else if (collisionResult == 2) {
                ACC_IMPULSE = 0.0f;
                gamestate = 2; // won
            }

            model.setFuel(model.getFuel() - FUEL_CONSUMPTION_RATE);

            if (model.getFuel() < 0.0f) {
                model.setFuel(0.0f);
                model.setAcceleration(new Vector(0.0f, 0.0f));
            }

        }
    }

    @Override
    public void draw(Graphics2D g2d) {

        // Draw fuel bar on the left side
        if (!models.isEmpty()) {
            drawFuelBar(g2d, models.getFirst());
        }

        landingZone.draw(g2d);
        for(MoonLander model : models) {
            model.draw(g2d);
        }

        if (gamestate == 1) {
            gameOver(g2d);
        } else if (gamestate == 2) {
            won(g2d);
        }
    }

    private void drawFuelBar(Graphics2D g2d, MoonLander lander) {
        int barX = 20;
        int barY = 80;
        int barWidth = 30;
        int maxBarHeight = 200;
        float maxFuel = 500.0f;

        float currentFuel = lander.getFuel();
        float fuelPercentage = currentFuel / maxFuel;
        int currentBarHeight = (int)(maxBarHeight * fuelPercentage);

        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(barX, barY, barWidth, maxBarHeight);

        //farben
        if (fuelPercentage > 0.5f) {
            g2d.setColor(Color.GREEN);
        } else if (fuelPercentage > 0.2f) {
            g2d.setColor(Color.ORANGE);
        } else {
            g2d.setColor(Color.RED);
        }
        g2d.fillRect(barX, barY + (maxBarHeight - currentBarHeight), barWidth, currentBarHeight);

        // border
        g2d.setColor(Color.BLACK);
        g2d.drawRect(barX, barY, barWidth, maxBarHeight);

        //when fuel 0 then gravitation to bottom
        if (currentFuel <= 0.0f) {
            GRAVITY.setY(0.01f);
        }

        g2d.drawString("FUEL", barX - 5, barY - 5);
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        g2d.drawString(String.format("%.0f", currentFuel), barX, barY + maxBarHeight + 15);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        log.info("--> game mouseClicked called");

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
        switch (e.getKeyChar()) {
            case 'w':
                models.getFirst().accelerate(new Vector(0.0f, -ACC_IMPULSE));
                models.getFirst().setFuel(models.getFirst().getFuel() - FUEL_CONSUMPTION_RATE);

                break;
            case 's':
                models.getFirst().accelerate(new Vector(0.0f, ACC_IMPULSE));
                models.getFirst().setFuel(models.getFirst().getFuel() - FUEL_CONSUMPTION_RATE);
                break;
            case 'a':
                models.getFirst().accelerate(new Vector(-ACC_IMPULSE, 0.0f));
                models.getFirst().setFuel(models.getFirst().getFuel() - FUEL_CONSUMPTION_RATE);
                break;
            case 'd':
                models.getFirst().accelerate(new Vector(ACC_IMPULSE, 0.0f));
                models.getFirst().setFuel(models.getFirst().getFuel() - FUEL_CONSUMPTION_RATE);
                break;

            case ' ':
                // activate debug mode
                models.getFirst().setDebugMode(!models.getFirst().isDebugMode());
                break;

            case 'r':
                resetGame();
                log.info("Game restarted!");
                break;

            default:
                log.info("--> game keyPressed called: UNHANDLED KEY" + e.getKeyChar());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        log.info("--> game keyReleased called " + e.getKeyChar());
        for(MoonLander model : models) {
            model.accelerate(new Vector(0.0f, 0.0f));
        }
    }


    private void resetGame() {
        models.clear();
        world = new World(view.getWidth(), view.getHeight());
        int moonLanderWidth = 30;
        int moonLanderHeight = 50;
        int startX = view.getWidth() / 2 - moonLanderWidth/2;
        int startY = view.getHeight() / 2 - moonLanderHeight/2;
        models.add(new MoonLander(new Vector(startX, startY), moonLanderWidth, moonLanderHeight,500f));
        ACC_IMPULSE = 0.1f;
        gamestate = 0;
        landingZone = new LandingZone(40, 10, random.nextInt(view.getWidth() - 100) + 50, view.getHeight() - 30);
        FUEL_CONSUMPTION_RATE = 0.3f;
    }

    private void gameOver(Graphics2D g2d) {
        models.clear();
        //how to draw game over text -> handled in draw method
        gamestate = 1;
        ACC_IMPULSE = 0.0f;
        FUEL_CONSUMPTION_RATE = 0.0f;

        //draw fire emoji at the position of the lander
        g2d.setFont(new Font("Arial", Font.PLAIN, 50));
        g2d.drawString("\uD83D\uDCA5", (int)models.getFirst().getLocation().getX(), (int)models.getFirst().getLocation().getY() + models.getFirst().getHeight());

        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("YOU LOST!" , view.getWidth() / 2 - 80, view.getHeight() / 2);
    }

    public void won(Graphics2D g2d) {
        models.clear();
        gamestate = 2;
        ACC_IMPULSE = 0.0f;
        FUEL_CONSUMPTION_RATE = 0.0f;
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("YOU WON!" , view.getWidth() / 2 - 85, view.getHeight() / 2);
    }
}
