package sean.math;

import sean.graphics.p5;

public class Trajectory extends p5{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final double G = 32.174;
    public static double velocity = 20, angle = 67, height = 3.2;
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
    }
    int i = 1;
    double prevTCI = 1;
    public void draw() {
        double trajectoryCurveI = trajectoryCurve(10, 20, Math.toRadians(angle), height, i);
        line(i-1, 250 + (int)prevTCI, i, 250 + (int)trajectoryCurveI);
        prevTCI = trajectoryCurveI;
        i++;
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
    public static double findAngle(double distance, double v, double goalHeight, double u, double pointDistance){
        double guessAngle = angle;
        double guess = trajectoryCurve(distance, v, Math.toRadians(guessAngle), u, pointDistance);
        double guessTrajectory;
        guessTrajectory = trajectoryCurve(distance, v, Math.toRadians(guess), u, pointDistance);
        while(guessTrajectory > goalHeight - 0.1 || guessTrajectory < goalHeight + 0.1){
            if(guessTrajectory > goalHeight){
                guessAngle -= 0.1;
            }
            if(guessTrajectory < goalHeight){
                guessAngle += 0.1;
            }
            System.out.println(guessTrajectory);
            System.out.println(guessAngle);
        }
        return guessAngle;
    }
}