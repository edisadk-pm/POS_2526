package Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector {
    private float x;
    private float y;

    public void scale(float factor){
        this.x *= factor;
        this.y *= factor;
    }

    public void add(Vector other){
        this.x += other.x;
        this.y += other.y;
    }

    public double magnitude(){
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public String toString() {
        return String.format("%.2f", magnitude());
    }
}
