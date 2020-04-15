package sean.graphics.shapes;

import java.awt.Graphics;

import sean.graphics.Shape;

public class Shapes extends Shape{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static Line createLine(int x1, int y1, int x2, int y2) {
        return new Shapes().new Line(x1, y1,x2,y2);
    }
    public class Line implements ShapeBase {
        public double scalar = 1;
        public int translateX = 0, translateY = 0;
        public int x1,y1,x2,y2;
        public Line(int x1i, int y1i, int x2i, int y2i){
            x1 = x1i;
            x2 = x2i;
            y2 = y2i;
            y1 = y1i;
        }
        @Override
        public void paint(Graphics g) {
            System.out.println("drawing line to: " + (int)(x1*scalar) + translateX + " " + (int)(y1*scalar) + translateY + " " +  (int)(x2*scalar) + translateX + " " + (int)(y2*scalar) + translateY);
            g.drawLine((int)(x1*scalar) + translateX, (int)(y1*scalar) + translateY, (int)(x2*scalar) + translateX, (int)(y2*scalar) + translateY);
        }

        @Override
        public void fill(Graphics g) {
            System.out.println("drawing line to: " + (int)(x1*scalar) + translateX + " " + (int)(y1*scalar) + translateY + " " +  (int)(x2*scalar) + translateX + " " + (int)(y2*scalar) + translateY);
            g.drawLine((int)(x1*scalar) + translateX, (int)(y1*scalar) + translateY, (int)(x2*scalar) + translateX, (int)(y2*scalar) + translateY);
        }

        @Override
        public void setST(double s, int tX, int tY) {
            scalar = s;
            translateX = tX;
            translateY = tY;
        }
    }


    public static Arc createArc(int x, int y, int w, int h, int start, int stop){
        return new Shapes().new Arc(x, y,w,h,start, stop);
    }
    public class Arc implements ShapeBase {
        public double scalar;
        public int translateX, translateY;
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
            g.drawArc((int)(x*scalar) + translateX, (int)(y*scalar) + translateY, (int)(w*scalar), (int)(h*scalar), start, stop);
        }
        @Override
        public void fill(Graphics g) {
            g.fillArc((int)(x*scalar) + translateX, (int)(y*scalar) + translateY, (int)(w*scalar), (int)(h*scalar), start, stop);
        }
        @Override
        public void setST(double s, int tX, int tY) {
            scalar = s;
            translateX = tX;
            translateY = tY;
        }
    }


    public static Circle createCircle(int x, int y, int d){
        return new Shapes().new Circle(x,y,d);
    }
    public class Circle implements ShapeBase{
        public double scalar;
        public int translateX, translateY;
        public int x,y,d;
        public Circle(int xi, int yi, int di){
            x = xi;
            y = yi;
            d = di;
        }
        @Override
        public void paint(Graphics g) {
            g.drawOval((int)(x*scalar) + translateX,(int)(y*scalar) + translateY,(int)(d*scalar),(int)(d*scalar));
        }
        @Override
        public void fill(Graphics g) {
            g.fillOval((int)(x*scalar) + translateX,(int)(y*scalar) + translateY,(int)(d*scalar),(int)(d*scalar));
        }
        @Override
        public void setST(double s, int tX, int tY) {
            scalar = s;
            translateX = tX;
            translateY = tY;
        }
    }

    public static Ellipse createEllipse(int x, int y, int w, int h){
        return new Shapes().new Ellipse(x,y,w,h);
    }
    public class Ellipse implements ShapeBase{
        int x,y,w,h;
        public double scalar;
        public int translateX, translateY;
        public Ellipse(int xi, int yi, int wi, int hi){
            x = xi;
            y = yi;
            w = wi;
            h = hi;
        }
        @Override
        public void paint(Graphics g) {
            g.drawOval((int)(x * scalar) + translateX, (int)(y * scalar) + translateY, (int)(w * scalar), (int)(h * scalar));
        }
        @Override
        public void fill(Graphics g) {
            g.fillOval((int)(x * scalar) + translateX, (int)(y * scalar) + translateY, (int)(w * scalar), (int)(h * scalar));
        }
        @Override
        public void setST(double s, int tX, int tY) {
            scalar = s;
            translateX = tX;
            translateY = tY;
        }
    }
    public static Point createPoint(int x, int y){
        return new Shapes().new Point(x,y);
    }
    public class Point implements ShapeBase{
        public int translateX, translateY;
        public double scalar;
        int x, y;
        public Point(int ix, int iy){
            x = ix;
            y = iy;
        }

        @Override
        public void paint(Graphics g) {
            g.fillOval((int)(x*scalar) + translateX,(int)(y*scalar) + translateY,pointWidth,pointWidth);
        }

        @Override
        public void fill(Graphics g) {
            g.fillOval((int)(x*scalar) + translateX,(int)(y*scalar) + translateY,pointWidth,pointWidth);
        }
        @Override
        public void setST(double s, int tX, int tY) {
            translateX = tX;
            translateY = tY;
            scalar = s;
        }
    }

    public static Rectangle createRect(int x, int y, int w){
        return new Shapes().new Rectangle(x, y, w);
    }
    public static Rectangle createRect(int x, int y, int w, int h){
        return new Shapes().new Rectangle(x, y, w, h);
    }
    public static Rectangle createRect(int x, int y, int w, int h, int arcWidth, int arcHeight){
        return new Shapes().new Rectangle(x, y, w, h, arcWidth, arcHeight);
    }
    public class Rectangle implements ShapeBase{
        public double scalar;
        public int translateX, translateY;
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
            g.drawRoundRect((int)(mX * scalar) + translateX, (int)(mY * scalar) + translateY, (int)(mW * scalar), (int)(mH * scalar), (int)(mAw * scalar), (int)(mAh * scalar));
        }

        @Override
        public void fill(Graphics g) {
            g.fillRoundRect((int)(mX * scalar) + translateX, (int)(mY * scalar) + translateY, (int)(mW * scalar), (int)(mH * scalar), (int)(mAw * scalar), (int)(mAh * scalar));
        }
        @Override
        public void setST(double s, int tX, int tY) {
            scalar = s;
            translateX = tX;
            translateY = tY;
        }
    }
}