package sean.math.kinematics;

import java.util.ArrayList;

import sean.graphics.p5;
import sean.math.geometry.PolarPoint2d;

public class test extends p5 {
    public static void main(String args[]) {
        new test().run();
    }
    public void setup(){
        createCanvas(500,500);
        frameRate(100);
    }
    int i = 0;
    public void draw(){
        ArrayList<PolarPoint2d> vectors = new ArrayList<PolarPoint2d>();
        vectors.add(new PolarPoint2d(100,0));
        vectors.add(new PolarPoint2d(100,0));
        vectors.add(new PolarPoint2d(100,0));
        vectors.add(new PolarPoint2d(100,0));
        InverseKinematics ik = new InverseKinematics(vectors);
        ik.kinemat((mouseX())*1,(mouseY())*1, vectors.size()-1);
        vectors = ik.getVectors();
        int prevX = 0, prevY = 0;
        for(int j = vectors.size()-1; j > 0; j--){
            int x,y;
            x = prevX + (int)PolarPoint2d.getCartesianPoint(vectors.get(j)).getX();//(int)ik.addTo(i - 1).getX();
            y = prevY + (int)PolarPoint2d.getCartesianPoint(vectors.get(j)).getY();//(int)ik.addTo(i - 1).getY();
            if(j == vectors.size() - 1){
                x += ik.finalLocationX;
                prevX += ik.finalLocationX;
                y += ik.finalLocationY;
                prevY += ik.finalLocationY;
            }
            stroke(0,0,0);
            strokeWeight(2);
            line(prevX + 250, prevY + 250, x + 250, y + 250);
            strokeWeight(10);
            stroke(0,0,j * 20);
            point(x+245,y+245);
            prevX = x;
            prevY = y;
        }
        strokeWeight(10);
        stroke(0,255,0);
        point((int)mouseX(),(int)mouseY());//i+180);
        i++;
    }
}