package sean.graphics.graphs;

import java.awt.Color;
import java.util.ArrayList;

import sean.graphics.P5Color;
import sean.graphics.p5;
import sean.graphics.event.WheelEvent;

public class SimpleGraph extends p5 {
    public ZoomableHelper z;
    public ArrayList<Trace> traces;
    public static void main(String args[]){
        new SimpleGraph();
    }
    public SimpleGraph(){
        this.run();
    }
    public void updateValues(Trace trace){
        traces.add(trace);
    }
    public void udpateValues(Trace trace, int i){
        traces.add(i,trace);
    }
    public void setup(){
        traces = new ArrayList<Trace>();
        createCanvas(500,500);
        z = new ZoomableHelper();
        Trace t = new Trace();
        //t.values.add(100.0);
        //t.values.add(50.0);
        //t.values.add(220.0);
        //t.color = new P5Color(0,255,0);
        traces.add(t);
        background(0);
    }
    int posX = 0, posY = getInstance().getHeight()/2;
    public void draw(){
        int pointdistance;
        z.updateZoom(movedX, movedY);
        if(traces.get(0) != null){
            if(traces.get(0).values.get(0) != null){
        pointdistance = getInstance().getWidth()/traces.get(0).values.size()-1;
        for(int i = 0; i < traces.size(); i++){
            posX = 0; posY = 250;
            for(int j = 0; j < traces.get(0).values.size(); j++){
                stroke(traces.get(i).color);
                strokeWeight(3);
                line(posX, posY, posX + pointdistance, (Integer)traces.get(i).values.get(j).intValue() + getInstance().getHeight()/4);
                posX += pointdistance;
                posY = (Integer)traces.get(i).values.get(j).intValue() + getInstance().getHeight()/4;
            }
        }
    }
        }
    }
	public void mouseWheel(WheelEvent e){
        z.mouseWheelMoved(e);
    }
    /**
     *
     */
    private static final long serialVersionUID = 1L;

}