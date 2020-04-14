package sean.graphics;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class ScrollableCanvas extends Canvas implements MouseWheelListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private double zoom = 1d;
    public static ScrollableCanvas instance;
    public static ScrollableCanvas getInstance() {
        if (instance == null) {
            instance = new ScrollableCanvas();
        }
        return instance;
    }

    public static ScrollableCanvas getInstance(int h, int w) {
        if (instance == null) {
            instance = new ScrollableCanvas();
        }
        return instance;
    }
    public ScrollableCanvas(){
        this.addMouseWheelListener(this);
    }
    public static void initCanvas(){
        getInstance().addMouseWheelListener(getInstance());
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        double width = getWidth();
        double height = getHeight();

        double zoomWidth = width * zoom;
        double zoomHeight = height * zoom;

        double anchorx = (width - zoomWidth) / 2;
        double anchory = (height - zoomHeight) / 2;

        AffineTransform at = new AffineTransform();
        at.translate(anchorx, anchory);
        at.scale(zoom, zoom);
        at.translate(-100, -100);

        g2d.setTransform(at);
        paint(g);

        g2d.dispose();
    }
    public void zoomTransform(MouseWheelEvent e){
        zoom += e.getPreciseWheelRotation();
        repaint();
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("you scrolled and stuff");
        zoomTransform(e);
    }
}