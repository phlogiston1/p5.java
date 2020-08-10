import sean.graphics.p5;
import sean.graphics.graphs.ZoomableHelper;
import sean.math.geometry.Point2d;
import sean.math.geometry.PolarPoint2d;

public class whatever extends p5{
    double a1 = 0,a2 = 90;
    double f1 = 4, f2 = 3;
    PolarPoint2d v1 = new PolarPoint2d(f1,a1);
    PolarPoint2d v2 = new PolarPoint2d(f2,a2);
    ZoomableHelper z;
    public static void main(String args[]){
        new whatever().run();

    }
    public void setup(){
        createCanvas(500,500);
        z = new ZoomableHelper();
    }
    public void draw(){
        z.updateZoom(movedX, movedY);
        v1 = new PolarPoint2d(f1,a1);
        v2 = new PolarPoint2d(f2,a2);
        line(0,0,(int)PolarPoint2d.getCartesianPoint(v1).getX(), (int)PolarPoint2d.getCartesianPoint(v1).getY());
        PolarPoint2d v3 = Point2d.getPolarPoint(new Point2d(PolarPoint2d.getCartesianPoint(v1).getX()+ PolarPoint2d.getCartesianPoint(v2).getX(),PolarPoint2d.getCartesianPoint(v1).getY()+ PolarPoint2d.getCartesianPoint(v2).getY()));
        line(0,0,(int)PolarPoint2d.getCartesianPoint(v3).getX(), (int)PolarPoint2d.getCartesianPoint(v3).getY());
        line((int)PolarPoint2d.getCartesianPoint(v1).getX(), (int)PolarPoint2d.getCartesianPoint(v1).getY(), (int)PolarPoint2d.getCartesianPoint(v3).getX(), (int)PolarPoint2d.getCartesianPoint(v3).getY());
    }
}