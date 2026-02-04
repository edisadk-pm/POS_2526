package controller;

import Utils.Vector;
import lombok.extern.java.Log;
import model.LandingZone;
import model.MoonLander;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Log
public class Game extends BaseGame {

    private List<MoonLander> models = new ArrayList<>();
    Random random = new Random();
    LandingZone landingZone;
    private final Vector GRAVITY = new Vector(0.0f, 0.0001f);
    private float ACC_IMPULSE = 0.1f;
    private float FUEL_CONSUMPTION_RATE = 0.3f;

    int gamestate = 0; // 0 = playing, 1 = game over, 2 = won

    @Override
    public void init() {
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
            collision(model);
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
            drawFuelBar(g2d, models.get(0));
        }

        landingZone.draw(g2d);
        for(MoonLander model : models) {
            model.draw(g2d);
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
                models.get(0).accelerate(new Vector(0.0f, -ACC_IMPULSE));
                models.get(0).setFuel(models.get(0).getFuel() - FUEL_CONSUMPTION_RATE);

                break;
            case 's':
                models.get(0).accelerate(new Vector(0.0f, ACC_IMPULSE));
                models.get(0).setFuel(models.get(0).getFuel() - FUEL_CONSUMPTION_RATE);
                break;
            case 'a':
                models.get(0).accelerate(new Vector(-ACC_IMPULSE, 0.0f));
                models.get(0).setFuel(models.get(0).getFuel() - FUEL_CONSUMPTION_RATE);
                break;
            case 'd':
                models.get(0).accelerate(new Vector(ACC_IMPULSE, 0.0f));
                models.get(0).setFuel(models.get(0).getFuel() - FUEL_CONSUMPTION_RATE);
                break;
            case 'i':
                models.get(1).accelerate(new Vector(0.0f, -ACC_IMPULSE));
                break;
            case 'k':
                models.get(1).accelerate(new Vector(0.0f, ACC_IMPULSE));
                break;
            case 'j':
                models.get(1).accelerate(new Vector(-ACC_IMPULSE, 0.0f));
                break;
            case 'l':
                models.get(1).accelerate(new Vector(ACC_IMPULSE, 0.0f));
                break;

            case ' ':
                // activate debug mode
                models.get(0).setDebugMode(!models.get(0).isDebugMode());
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

    private void collision(MoonLander model) {
        int modelX1 = (int) model.getLocation().getX();
        int modelY1 = (int) model.getLocation().getY();


        //collion with floor
        if (modelY1 + model.getHeight() >= view.getHeight()) {
            model.setLocation(new Vector(modelX1, view.getHeight() - model.getHeight()));
            model.setVelocity(new Vector(0.0f, 0.0f));
            ACC_IMPULSE = 0.0f;
        }

        //collision with ceiling
        if (modelY1 <= 0) {
            model.setLocation(new Vector(modelX1, 0));
            model.setVelocity(new Vector(0.0f, 0.0f));
            ACC_IMPULSE = 0.0f;
        }

        //collion with walls
        if (modelX1 <= 0) {
            model.setLocation(new Vector(0, modelY1));
            model.setVelocity(new Vector(0.0f, 0.0f));
            ACC_IMPULSE = 0.0f;
        } else if (modelX1 + model.getWidth() >= view.getWidth()) {
            model.setLocation(new Vector(view.getWidth() - model.getWidth(), modelY1));
            model.setVelocity(new Vector(0.0f, 0.0f));
            ACC_IMPULSE = 0.0f;
        }

        //collion with each other
        for (MoonLander otherModel : models) {
            if (otherModel != model) {
                int otherX1 = (int) otherModel.getLocation().getX();
                int otherY1 = (int) otherModel.getLocation().getY();

                if (modelX1 < otherX1 + otherModel.getWidth() &&
                        modelX1 + model.getWidth() > otherX1 &&
                        modelY1 < otherY1 + otherModel.getHeight() &&
                        modelY1 + model.getHeight() > otherY1) {
                    // Simple collision response: stop both models
                    model.setVelocity(new Vector(0.0f, 0.0f));
                    ACC_IMPULSE = 0.0f;
                    otherModel.setVelocity(new Vector(0.0f, 0.0f));
                }
            }
        }

        //collision with landing zone
        int lzX1 = landingZone.getX();
        int lzY1 = landingZone.getY();
        if (modelX1 < lzX1 + landingZone.getWidth() &&
                modelX1 + model.getWidth() > lzX1 &&
                modelY1 < lzY1 + landingZone.getHeight() &&
                modelY1 + model.getHeight() > lzY1) {
            model.setVelocity(new Vector(0.0f, 0.0f));
            ACC_IMPULSE = 0.0f;
            model.setLocation(new Vector(modelX1, lzY1 - model.getHeight()));
        }
    }

    private void resetGame() {
        models.clear();
        int moonLanderWidth = 30;
        int moonLanderHeight = 50;
        int startX = view.getWidth() / 2 - moonLanderWidth/2;
        int startY = view.getHeight() / 2 - moonLanderHeight/2;
        models.add(new MoonLander(new Vector(startX, startY), moonLanderWidth, moonLanderHeight,500f));
        ACC_IMPULSE = 0.1f;
        gamestate = 0;
    }

    private void gameOver() {
        models.clear();
        //how to draw game over text -> handled in draw method
        gamestate = 1;
        ACC_IMPULSE = 0.0f;
        FUEL_CONSUMPTION_RATE = 0.0f;
    }

    public void won() {
        models.clear();
        gamestate = 2;
        ACC_IMPULSE = 0.0f;
        resetGame();
    }
}
