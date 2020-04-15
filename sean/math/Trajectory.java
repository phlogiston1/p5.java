package sean.math;

import sean.graphics.P5Color;
import sean.graphics.p5;
import sean.graphics.graphs.SimpleGraph;
import sean.graphics.graphs.Trace;

public class Trajectory{
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
        SimpleGraph g = new SimpleGraph();
        g.run();
        Trace trace = new Trace();
        for(int i = 0; i < 2000; i++){
            trace.values.add(trajectoryCurve(1.9,20,Math.toRadians(angle), height, i));
        }
        trace.color = new P5Color(0,200,0);
        g.updateValues(trace);
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