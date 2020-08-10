package sean.math.physics;

import sean.graphics.*;
import sean.math.geometry.Point2d;
import sean.math.geometry.PolarPoint2d;
import sean.math.geometry.Vector3;
import sean.math.physics.ballistics.*;

public class Test extends p5{
    private static final long serialVersionUID = 1L;
    Canvas c;
    double gravity;
    PhysicsPoint physics;
    int targetX = 0, targetY = 20;
    public static void main(String args[]){
        new Test().start();
    }
    public void setup(){
        gravity = 1;
        physics = new PhysicsPoint();
        physics.mass = 1;
        targetX = 126;
        targetY = 550;
        //physics.friction = 1.01;
        c = createCanvas(800,800);
        background(color(0,0,0));
        BallisticsOut solve = BallisticsSolver.solve_ballistic_arc(new Vector3(0,0,0), 80, new Vector3(targetX,targetY,0), (int)gravity);
        Point2d solvePoint = new Point2d(solve.s0.getX(), solve.s0.getY());
        PolarPoint2d forAngle = Point2d.getPolarPoint(solvePoint);
        System.out.println("shooter angle: " + Math.toDegrees(forAngle.getP()));
        System.out.println(forAngle.getR());
        physics.addForce(solve.s0.getX(), solve.s0.getY());
        strokeWeight(5);
    }
    int px = 0, py = 0;
    public void draw(){
        physics.addForce(0,-gravity);
        //System.out.println(physics.yVel + ", " + physics.xVel);
        physics.update();
        Point2d pointLocation = physics.getPosition();
        strokeWeight(2);
        stroke(235, 210, 52);
        line(px + 20,py + 700,(int)pointLocation.getX() + 20, -(int)pointLocation.getY() + 700);
        px = (int)pointLocation.getX();
        py = -(int)pointLocation.getY();
        strokeWeight(20);
        stroke(0,255,0);
        point(targetX + 20,-targetY + 700);
        strokeWeight(1);
        stroke(255,255,255);
        line(0,702,800,702);
        noClear();
    }
}