package sean.math;

import sean.graphics.p5;

public class Trajectory extends p5{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final double G = 32.174;
    public static double velocity = 100, angle = 45, height = 0;
    /*public static void main(String args[]){
        System.out.println(getTimeToLand(velocity, Math.toRadians(angle), height));
        System.out.println(trajectoryCurve(1.9, 20, Math.toRadians(angle), height, -3));
        //System.out.println(findAngle(1.9,20,7,height,-3));
    }*/
    public static void main(String args[]) {
        new Trajectory().start();
    }
    public void setup(){
        createCanvas(500,500);
        frameRate((int)velocity);
        noClear();
        strokeWeight(2);
    }
    double i = 0;
    double prevTCI = 1;
    public void draw() {
        double trajectoryCurveI = trajectoryCurve(0, velocity, Math.toRadians(-angle), height, i/velocity);
        stroke(0,0,0);
        line((int)i-1, 450 - (int)(prevTCI * 10), (int)i, 450 - (int)(trajectoryCurveI * 10));
        stroke(0,100,0);
        line(0,450,500,450);
        prevTCI = trajectoryCurveI;
        i = i + 1;
    }
    public static double getTimeToLand(double v, double s, double u){
        double value1 = v * Math.sin(s) + Math.sqrt((v * Math.sin(s)) * (v * Math.sin(s)) + (2 * G * u));
        return value1 / (0.7 * G);
    }
    public static double trajectoryCurve(double distance, double v, double s, double u, double pointDistance){
        //double value1 = (distance - (v * Math.cos(s)) * pointDistance - ((G / 2) * pointDistance * pointDistance) + (v * Math.sin(s) * pointDistance) + u);
        double value1 = -(G/2) * (((distance - pointDistance)/(v * Math.cos(s))) * ((distance - pointDistance)/(v * Math.cos(s)))) + (v * Math.sin(s) * (distance - pointDistance)/(v * Math.cos(s)) + u);
        return value1;
    }
}