package sean.graphics;

import java.util.ArrayList;

import sean.graphics.shapes.ShapeBase;
import sean.graphics.shapes.Shapes;
import sean.graphics.shapes.Shapes.Arc;
import sean.graphics.shapes.Shapes.Circle;
import sean.graphics.shapes.Shapes.Ellipse;
import sean.graphics.shapes.Shapes.Line;
import sean.graphics.shapes.Shapes.Rectangle;

import java.awt.*;

public class Shape extends Typography{
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
    public static Typography.Text text(String s, int x, int y){
        Typography.Text txt = new Typography().new Text(s,x,y, Typography.cFont);
        shapes.add(txt);
        addFS();
        return txt;
    }
    public static Line line(int x1,int y1, int x2, int y2){
        Line ln = Shapes.createLine(x1,y1,x2,y2);
        shapes.add(ln);
        addFS();
        return ln;
    }
    public static Shapes.Point point(int x, int y){
        Shapes.Point pt = Shapes.createPoint(x,y);
        shapes.add(pt);
        addFS();
        return pt;
    }

    public static Arc arc(int x, int y, int w, int h, int start, int stop){
        Arc ac = Shapes.createArc(x, y, w, h, start, stop);
        shapes.add(ac);
        addFS();
        return ac;
    }

    public static Ellipse ellipse(int x, int y, int h, int w){
        Ellipse ep = Shapes.createEllipse(x, y, w, h);
        shapes.add(ep);
        addFS();
        return ep;
    }

    public static Circle circle(int x, int y, int d){
        Circle cl = Shapes.createCircle(x, y, d);
        shapes.add(cl);
        addFS();
        return cl;
    }
    public static Rectangle rect(int x, int y, int w){
        Rectangle rt = Shapes.createRect(x, y, w);
        shapes.add(rt);
        addFS();
        return rt;
    }
    public static Rectangle rect(int x, int y, int w, int h){
        Rectangle rt = Shapes.createRect(x, y, w,h);
        shapes.add(rt);
        addFS();
        return rt;
    }
    public static Rectangle rect(int x, int y, int w, int h, int arcWidth, int arcHeight){
        Rectangle rt = Shapes.createRect(x, y, w,h, arcWidth, arcHeight);
        shapes.add(rt);
        addFS();
        return rt;
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