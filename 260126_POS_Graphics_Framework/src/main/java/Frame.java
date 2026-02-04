import javax.swing.*;

public class Frame extends JFrame {
    private int width = 400; // pixel
    private int height = 500; // pixel
    private String title = "HTL Kaindorf IS SIMPLY THE BEST";

    private PaintArea paintArea;

    public Frame(PaintArea paintArea){

        this.paintArea = paintArea;

        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(paintArea);

        Timer timer = new Timer(
            20, (e) -> paintArea.repaint()
        );
        timer.start(); // start another thread
    }
}
