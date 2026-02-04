    import lombok.extern.java.Log;

    import java.awt.*;

    @Log
    public class Rectangle extends Moveable implements GenericGraphic {

        private int width;
        private int height;

        public Rectangle(int x, int y, int width, int height) {
            this.location = new Vector(x, y);
            this.velocity = new Vector(1.f, 0.f);
            this.acceleration = new Vector(0.f, 0.05f);
            this.width = width;
            this.height = height;
        }

        @Override
        public void update(int width, int height) {
            log.info(String.format("Rectangle: Update Called %d/%d", width, height));
            velocity.add(acceleration);
            location.add(velocity); // s = s_0 + v * 1s

            if(location.y + this.height > height){
                this.velocity.y *= -1;
                this.location.y = height - this.height;
                this.velocity.y *= 0.8;
            }

            if(location.x + this.width > width || location.x <= 0){
                this.velocity.x *= -1;
            }
        }

        @Override
        public void draw(Graphics2D g2d) {
            log.info(System.currentTimeMillis() + " Rectangle: Draw Called");
            g2d.drawRect((int)location.x, (int)location.y, width, height);

            g2d.drawString(String.format("%.2f", velocity.magnitude()),
                    location.x,
                    location.y);
        }
    }
