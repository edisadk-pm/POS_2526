import lombok.extern.java.Log;

import javax.swing.*;
import java.awt.*;

@Log
public class ShowTheFrame {
    public static void main(String[] args) {
        log.info("Lets start ...");
        System.setProperty("sun.java2d.opengl", "true");

        MyGraphics game = new Game();
        PaintArea paintArea = new PaintArea(game);

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new Frame(paintArea).setVisible(true);
                    }
                } // thread -> see next semester
        );

        log.info(" ... received the End");
    }
}

// 250107: Your turn: Create a Circle similar to Rectangle. Implement the wall-bouncing.
// 250107: your turn: change color if mouse click is within a moveable object.
