package sean.graphics.shapes;

import java.awt.Graphics;

public interface ShapeBase {
    public void paint(Graphics g);
    public void fill(Graphics g);
    public void setST(double s, int tX, int tY);
}