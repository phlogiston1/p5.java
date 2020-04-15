package sean.graphics.graphs;

import sean.graphics.Shape;
import sean.graphics.p5;
import sean.graphics.event.WheelEvent;

public class ZoomableHelper {
    int x = 0, y = 0, zoom = 1;
    int cWidth, cHeight;

    public void updateZoom(double movedX, double movedY) {
        if (p5.mouseIsPressed) {
            System.out.println("mouse pressed:)" + movedX);
            x -= (int) movedX;
            y -= (int) movedY;
        }
        Shape.scale(zoom);
        Shape.translate(x, y);
    }
    public void mouseWheelMoved(WheelEvent e){
        zoom += e.deltaY;
        x -= (p5.mouseX * e.deltaY) - p5.mouseX / zoom;
        y -= (p5.mouseY * e.deltaY) - p5.mouseY / zoom;
    }
    public void reset(){
        x = 0; y = 0; zoom = 1;
    }
}