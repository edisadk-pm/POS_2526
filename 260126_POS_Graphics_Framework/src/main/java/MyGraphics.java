import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class MyGraphics {
    protected List<GenericGraphic> figures = new ArrayList<>();

    public void addFigure(GenericGraphic figure){
        figures.add(figure);
    }

    public void update(int width, int height){
        figures.stream()
                .forEach(e -> e.update(width, height));
    }

    public void draw(Graphics2D g2d){
        figures.stream()
                .forEach(e -> e.draw(g2d));
    }

    abstract public void handleMouseClickEvent(MouseEvent event);
}
