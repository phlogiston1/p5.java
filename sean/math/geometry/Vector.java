package sean.math.geometry;

public class Vector {
    public Point2d m_location;
    public PolarPoint2d m_vector;
    public Vector(Point2d location, PolarPoint2d vector){
        m_location = location;
        m_vector = vector;
    }
    public Point2d getLocation(){
        return m_location;
    }
    public PolarPoint2d getVector(){
        return m_vector;
    }
    public Point2d getTotalLocation(){
        return PolarPoint2d.getCartesianPoint(getVector()).transformBy(getLocation().getX(), getLocation().getY());
    }
}