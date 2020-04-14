package sean.math.kinematics;

import java.util.ArrayList;

import sean.graphics.p5;
import sean.math.geometry.*;

public class InverseKinematics{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public ArrayList<PolarPoint2d> m_vectors = new ArrayList<PolarPoint2d>();
    public InverseKinematics(){

    }
    public InverseKinematics(ArrayList<PolarPoint2d> vectors){
        m_vectors = vectors;
    }
    public Point2d addTo(int i){
        int prevX = 0, prevY = 0;
        int x = 0,y = 0;
        for(int j = m_vectors.size()-1; j > 0; j--){
            x = prevX + (int)PolarPoint2d.getCartesianPoint(m_vectors.get(j)).getX();//(int)ik.addTo(i - 1).getX();
            y = prevY + (int)PolarPoint2d.getCartesianPoint(m_vectors.get(j)).getY();//(int)ik.addTo(i - 1).getY();
            prevX = x;
            prevY = y;
        }
        return new Point2d(x,y);
    }
    public ArrayList<PolarPoint2d> getVectors(){
        return m_vectors;
    }
    public double finalLocationX = 0, finalLocationY = 0;
    public void kinemat(double x, double y, int i){
        Point2d cPosition = addTo(i);
        x -= cPosition.getX();
        y -= cPosition.getY();
        PolarPoint2d v = m_vectors.get(i);
        PolarPoint2d cKinematCoords = Point2d.getPolarPoint(new Point2d(x,y));
        v.updateValues(v.getR(), cKinematCoords.getP());
        if(i > 0) {
            kinemat(PolarPoint2d.getCartesianPoint(cKinematCoords).getX() - PolarPoint2d.getCartesianPoint(v).getX(), PolarPoint2d.getCartesianPoint(cKinematCoords).getY() - PolarPoint2d.getCartesianPoint(v).getY(), i-1);
        }else{
            finalLocationX = PolarPoint2d.getCartesianPoint(cKinematCoords).getX() - PolarPoint2d.getCartesianPoint(v).getX();
            finalLocationY = PolarPoint2d.getCartesianPoint(cKinematCoords).getY() - PolarPoint2d.getCartesianPoint(v).getY();
        }
    }
}