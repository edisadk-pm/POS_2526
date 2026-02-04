import lombok.extern.java.Log;

import java.awt.event.MouseEvent;

@Log
public class Game extends MyGraphics{

    public Game(){

    }

    @Override
    public void handleMouseClickEvent(MouseEvent event) {
        figures.add(new Rectangle(
                event.getX(),
                event.getY(),
                20, 20));
    }
}
