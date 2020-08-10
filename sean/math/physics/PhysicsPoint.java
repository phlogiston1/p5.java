package sean.math.physics;
import sean.math.geometry.Point2d;
public class PhysicsPoint {
    public double mass = 1;
    private double x = 0;
    private double y = 0;
    public double xAccel = 0;
    public double yAccel = 0;
    public double xVel = 0;
    public double yVel = 0;
    public double time = 0;
    public double friction = 1;
    public void addForce(double xForce, double yForce){
        xAccel += xForce / mass;
        yAccel += yForce / mass;
    }
    public void update(){
        time++;
        xVel += xAccel;
        yVel += yAccel;
        xVel /= friction;
        yVel /= friction;
        x += xVel;
        y += yVel;
        xAccel = 0;
        yAccel = 0;
    }
    public Point2d getPosition(){
        return new Point2d(x,y);
    }
}