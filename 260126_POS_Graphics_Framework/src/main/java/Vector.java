public class Vector {
    public float x;
    public float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector other){
        this.x += other.x;
        this.y += other.y;
    }

    public double magnitude(){
        return Math.sqrt(x*x + y*y);
    }

}
