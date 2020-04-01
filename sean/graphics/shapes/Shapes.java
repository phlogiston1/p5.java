package sean.graphics.shapes;

import java.awt.Graphics;

import sean.graphics.Shape;

public class Shapes extends Shape{
    public static Line createLine(int x1, int y1, int x2, int y2){
        return new Shapes().new Line(x1, y1,x2,y2);
    }
    public class Line implements ShapeBase {
        public int x1,y1,x2,y2;
        public Line(int x1i, int y1i, int x2i, int y2i){
            x1 = x1i;
            x2 = x2i;
            y2 = y2i;
            y1 = y1i;
        }
        @Override
        public void paint(Graphics g) {
            g.drawLine(x1, y1, x2, y2);
        }

        @Override
        public void fill(Graphics g) {
            g.drawLine(x1, y1, x2, y2);
        }
    }


    public static Arc createArc(int x, int y, int w, int h, int start, int stop){
        return new Shapes().new Arc(x, y,w,h,start, stop);
    }
    public class Arc implements ShapeBase {
        public int x,y,w,h,start,stop;
        public Arc(int xi, int yi, int wi, int hi, int starti, int stopi){
            x = xi;
            y = yi;
            w = wi;
            h = hi;
            start = starti;
            stop = stopi;
        }
        @Override
        public void paint(Graphics g) {
            g.drawArc(x, y, w, h, start, stop);
        }
        @Override
        public void fill(Graphics g) {
            g.fillArc(x, y, w, h, start, stop);
        }
    }


    public static Circle createCircle(int x, int y, int d){
        return new Shapes().new Circle(x,y,d);
    }
    public class Circle implements ShapeBase{
        public int x,y,d;
        public Circle(int xi, int yi, int di){
            x = xi;
            y = yi;
            d = di;
        }
        @Override
        public void paint(Graphics g) {
            g.drawOval(x,y,d,d);
        }
        @Override
        public void fill(Graphics g) {
            g.fillOval(x,y,d,d);
        }
    }

    public static Ellipse createEllipse(int x, int y, int w, int h){
        return new Shapes().new Ellipse(x,y,w,h);
    }
    public class Ellipse implements ShapeBase{
        int x,y,w,h;
        public Ellipse(int xi, int yi, int wi, int hi){
            x = xi;
            y = yi;
            w = wi;
            h = hi;
        }
        @Override
        public void paint(Graphics g) {
            g.drawOval(x, y, w, h);
        }
        @Override
        public void fill(Graphics g) {
            g.fillOval(x, y, w, h);
        }
    }
    public static Point createPoint(int x, int y){
        return new Shapes().new Point(x,y);
    }
    public class Point implements ShapeBase{
        int x, y;
        public Point(int ix, int iy){
            x = ix;
            y = iy;
        }

        @Override
        public void paint(Graphics g) {
            g.fillOval(x,y,pointWidth,pointWidth);
        }

        @Override
        public void fill(Graphics g) {
            g.fillOval(x,y,pointWidth,pointWidth);
        }
    }
    public class Rectangle implements ShapeBase{
        public Rectangle(int x, int y, int w){
            mX = x;
            mY = y;
            mW = w;
            mH = w;
        }
        public Rectangle(int x, int y, int w, int h){
            mX = x;
            mY = y;
            mW = w;
            mH = h;
        }
        public Rectangle(int x, int y, int w, int h, int aW, int aH){
            mX = x;
            mY = y;
            mW = w;
            mH = h;
            mAw = aW;
            mAh = aH;
        }
        public int mX,mY,mW,mH,mAw = 0,mAh = 0;
        @Override
        public void paint(Graphics g) {
            g.drawRoundRect(mX, mY, mW, mH, mAw, mAh);
        }

        @Override
        public void fill(Graphics g) {
            g.fillRoundRect(mX, mY, mW, mH, mAw, mAh);
        }
    }
}