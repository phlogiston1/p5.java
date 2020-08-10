package sean.graphics.shapes;

import java.awt.Graphics;

/**
 * interface that defines various shapes
 */
public interface ShapeBase {
    public void paint(Graphics g);
    public void fill(Graphics g);
    public void setST(double s, int tX, int tY);
}