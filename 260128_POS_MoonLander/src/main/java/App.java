import controller.BaseGame;
import controller.Game;
import view.PaintArea;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");


        // model: The 2d-Logic (the game)
        BaseGame model = new Game();

        // view: the paint-area
        PaintArea view = new PaintArea(model);
        view.setFocusable(true);

        JFrame frame = new JFrame();
        frame.setTitle("2d-Game Template");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add paint-area to frame
        frame.add(view);

        // make them visible
        frame.setVisible(true);

        // start the game thread -> tick, tick, tick
        model.start(view);
    }
}
