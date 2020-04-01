package sean.graphics;

import java.util.ArrayList;

import sean.graphics.shapes.Shapes;
import sean.graphics.shapes.Shapes.*;
import sean.graphics.shapes.Shapes.Point;

import java.awt.*;

public class Shape extends P5Color{
    /*public Shape(int height, int width) {
        super(height, width);
        // TODO Auto-generated constructor stub
    }*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static ArrayList<Line> lines = new ArrayList<Line>();
    static ArrayList<Fill> lineFill = new ArrayList<Fill>();
    static ArrayList<Stroke> lineStroke = new ArrayList<Stroke>();

    static ArrayList<Arc> arcs = new ArrayList<Arc>();
    static ArrayList<Fill> arcFill = new ArrayList<Fill>();
    static ArrayList<Stroke> arcStroke = new ArrayList<Stroke>();

    static ArrayList<Ellipse> ellipses = new ArrayList<Ellipse>();
    static ArrayList<Fill> ellipseFill = new ArrayList<Fill>();
    static ArrayList<Stroke> ellipseStroke = new ArrayList<Stroke>();

    static ArrayList<Circle> circles = new ArrayList<Circle>();
    static ArrayList<Fill> circleFill = new ArrayList<Fill>();
    static ArrayList<Stroke> circleStroke = new ArrayList<Stroke>();

    public static int pointWidth = 1;
    static ArrayList<Point> points = new ArrayList<Point>();
    static ArrayList<Fill> pointFill = new ArrayList<Fill>();
    static ArrayList<Stroke> pointStroke = new ArrayList<Stroke>();


    public static void drawLines(Graphics g){
        for(int i = 0; i < lines.size(); i++){
            setWeight(g,lineStroke.get(i));
            g.setColor(lineStroke.get(i).getColor());
            lines.get(i).paint(g);
            /*
            g.drawLine(linesX1.get(i),
                        linesY1.get(i),
                        linesX2.get(i),
                        linesY2.get(i));*/
        }
    }
    public static void drawPoints(Graphics g){
        for(int i = 0; i < points.size(); i++){
            boolean fill = pointFill.get(i).fill;
            boolean stroke = pointStroke.get(i).stroke;
            setWeight(g,pointStroke.get(i));
            pointWidth = pointStroke.get(i).weight;
            if(fill){
                g.setColor(pointFill.get(i).getColor());
                points.get(i).fill(g);
            }
            if(stroke){
                g.setColor(pointStroke.get(i).getColor());
                points.get(i).paint(g);
            }
        }
    }
    public static void drawArcs(Graphics g){
        for(int i = 0; i < arcs.size(); i++){
            boolean fill = arcFill.get(i).fill;
            boolean stroke = arcStroke.get(i).stroke;
            setWeight(g,arcStroke.get(i));
            if(fill){
                g.setColor(arcFill.get(i).getColor());
                arcs.get(i).fill(g);
            }
            if(stroke){
                g.setColor(arcStroke.get(i).getColor());
                arcs.get(i).paint(g);
                /*g.drawArc(  arcX.get(i),
                            arcY.get(i),
                            arcW.get(i),
                            arcH.get(i),
                            arcStart.get(i),
                            arcStop.get(i));*/
            }
        }
    }
    public static void drawEllipses(Graphics g){
        for(int i = 0; i < ellipses.size();i++){
            boolean fill = ellipseFill.get(i).fill;
            boolean stroke = ellipseStroke.get(i).stroke;
            setWeight(g,ellipseStroke.get(i));
            if(fill){
                g.setColor(ellipseFill.get(i).getColor());
                ellipses.get(i).fill(g);
            }
            if(stroke){
                g.setColor(ellipseStroke.get(i).getColor());
                ellipses.get(i).paint(g);            }
        }
    }
    public static void drawCircles(Graphics g){
        for(int i = 0; i < circles.size();i++){
            boolean fill = circleFill.get(i).fill;
            boolean stroke = circleStroke.get(i).stroke;
            setWeight(g,circleStroke.get(i));
            if(fill) {
                g.setColor(circleFill.get(i).getColor());
                circles.get(i).fill(g);
            }
            if(stroke){
                g.setColor(circleFill.get(i).getColor());
                circles.get(i).paint(g);
            }
        }
    }
    public static void draw(Graphics g) {
        drawLines(g);
        drawArcs(g);
        drawEllipses(g);
        drawCircles(g);
        drawPoints(g);
    }
    public static void setWeight(Graphics g, Stroke s){
        System.out.println(s.weight);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(s.weight));
    }

    public static void clearLines(){
        lines = new ArrayList<Line>();
        /*linesX1 = new ArrayList<Integer>();
        linesX2 = new ArrayList<Integer>();
        linesY1 = new ArrayList<Integer>();
        linesY2 = new ArrayList<Integer>();*/
        lineFill = new ArrayList<Fill>();
        lineStroke = new ArrayList<Stroke>();
    }
    public static void clearArcs(){
        arcs = new ArrayList<Arc>();
        /*arcX = new ArrayList<Integer>();
        arcY = new ArrayList<Integer>();
        arcW = new ArrayList<Integer>();
        arcH = new ArrayList<Integer>();
        arcStart = new ArrayList<Integer>();
        arcStop = new ArrayList<Integer>();*/
        arcFill = new ArrayList<Fill>();
        arcStroke = new ArrayList<Stroke>();
    }
    public static void clearEllipses(){
        ellipses = new ArrayList<Ellipse>();
        ellipseFill = new ArrayList<Fill>();
        ellipseStroke = new ArrayList<Stroke>();
    }
    public static void clearCircles(){
        circles = new ArrayList<Circle>();
        circleFill = new ArrayList<Fill>();
        circleStroke = new ArrayList<Stroke>();
    }
    public static void clearPoints(){
        points = new ArrayList<Point>();
        pointFill = new ArrayList<Fill>();
        pointStroke = new ArrayList<Stroke>();
    }


    public static void line(int x1,int y1, int x2, int y2){
        lines.add(Shapes.createLine(x1,y1,x2,y2));
        /*linesX1.add(x1);
        linesX2.add(x2);
        linesY1.add(y1);
        linesY2.add(y2);*/
        lineFill.add(P5Color.fillFrom(P5Color.getFill()));
        lineStroke.add(P5Color.strokeFrom(P5Color.getStroke()));
    }
    public static void point(int x, int y){
        points.add(Shapes.createPoint(x,y));
        pointFill.add(P5Color.fillFrom(P5Color.getFill()));
        pointStroke.add(P5Color.strokeFrom(P5Color.getStroke()));
    }

    public static void arc(int x, int y, int w, int h, int start, int stop){
        arcs.add(Shapes.createArc(x, y, w, h, start, stop));
        /*arcX.add(x);
        arcY.add(y);
        arcW.add(w);
        arcH.add(h);
        arcStart.add(start);
        arcStop.add(stop);*/
        arcFill.add(P5Color.fillFrom(P5Color.getFill()));
        arcStroke.add(P5Color.strokeFrom(P5Color.getStroke()));
    }

    public static void ellipse(int x, int y, int h, int w){
        ellipses.add(Shapes.createEllipse(x, y, w, h));
        ellipseFill.add(P5Color.fillFrom(P5Color.getFill()));
        ellipseStroke.add(P5Color.strokeFrom(P5Color.getStroke()));
    }

    public static void circle(int x, int y, int d){
        circles.add(Shapes.createCircle(x, y, d));
        circleFill.add(P5Color.fillFrom(P5Color.getFill()));
        circleStroke.add(P5Color.strokeFrom(P5Color.getStroke()));
    }
}