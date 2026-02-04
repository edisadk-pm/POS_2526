package graphics;

import java.awt.*;

public interface GenericGraphic {
    void update(int width, int height);

    void draw(Graphics2D g2d); // repaint
}
