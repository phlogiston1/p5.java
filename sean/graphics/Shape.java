package sean.graphics;

import java.util.ArrayList;

import sean.graphics.shapes.ShapeBase;
import sean.graphics.shapes.Shapes;

import java.awt.*;

public class Shape extends P5Color{
    private static final long serialVersionUID = 1L;

    static ArrayList<ShapeBase> shapes = new ArrayList<ShapeBase>();
    static ArrayList<Fill> fills = new ArrayList<Fill>();
    static ArrayList<Stroke> strokes = new ArrayList<Stroke>();
    public static int pointWidth = 1;
    public static void draw(Graphics g) {
        for(int i = 0; i < shapes.size(); i++){
            boolean fill = fills.get(i).fill;
            boolean stroke = strokes.get(i).stroke;
            setWeight(g,strokes.get(i));
            pointWidth = strokes.get(i).weight;
            if(fill) {
                g.setColor(fills.get(i).getColor());
                shapes.get(i).fill(g);
            }
            if(stroke){
                g.setColor(strokes.get(i).getColor());
                shapes.get(i).paint(g);
            }
        }
    }

    public static void line(int x1,int y1, int x2, int y2){
        shapes.add(Shapes.createLine(x1,y1,x2,y2));
        addFS();
    }
    public static void point(int x, int y){
        shapes.add(Shapes.createPoint(x,y));
        addFS();
    }

    public static void arc(int x, int y, int w, int h, int start, int stop){
        shapes.add(Shapes.createArc(x, y, w, h, start, stop));
        addFS();
    }

    public static void ellipse(int x, int y, int h, int w){
        shapes.add(Shapes.createEllipse(x, y, w, h));
        addFS();
    }

    public static void circle(int x, int y, int d){
        shapes.add(Shapes.createCircle(x, y, d));
        addFS();
    }

    private static void addFS(){
        fills.add(P5Color.fillFrom(P5Color.getFill()));
        strokes.add(P5Color.strokeFrom(P5Color.getStroke()));
    }

    public static void setWeight(Graphics g, Stroke s){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(s.weight));
    }

    public static void clearEverything(){
        shapes = new ArrayList<ShapeBase>();
        strokes = new ArrayList<Stroke>();
        fills = new ArrayList<Fill>();
    }
}