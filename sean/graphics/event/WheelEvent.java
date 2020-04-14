package sean.graphics.event;

public class WheelEvent {
    public double deltaX, deltaY;
    public WheelEvent(double dX, double dY){
        deltaX = dX;
        deltaY = dY;
    }
}