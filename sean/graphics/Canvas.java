package sean.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final double PI = 3.14;
    public static final int OPEN    = 0,//TODO add arc modes
                            CHORD   = 1,
                            PIE     = 2;

    static int h,w;
    static Shape s;
    static Canvas instance;

    static JFrame frame;

    static boolean frameCreated = false;

    /*public Canvas(int height, int width) {
        super();
        setLocation(0, 0);
        h = height;
        w = width;
    }*/

    public Canvas() {
        super();
        setLocation(0, 0);
    }

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    public static Canvas getInstance(int h, int w) {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    public static void background(int value) {
        getInstance().setBackground(new Color(value, value, value));
    }
    public static void background(int r,int g,int b) {
        getInstance().setBackground(new Color(r, g, b));
    }
    public static void background(P5Color c) {
        getInstance().setBackground(new Color(c.m_r, c.m_g, c.m_b));
    }

    public static void createCanvas(String name) {
        frame = new JFrame(name);
        frame.setContentPane(getInstance());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setVisible(true);

        frameCreated = true;
    }
    public static void clear(){
        dispose();
    }
    public static void dispose(){
        getInstance().getGraphics().dispose();
    }
    public static void revalidateCanvas(){
        System.out.println("repainting");
        getInstance().revalidate();
        getInstance().repaint();
    }
    public static void createCanvas(int w,int h){
        frame = new JFrame();
        frame.setContentPane(getInstance());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w,h);
        frame.setVisible(true);

        frameCreated = true;
    }
    public void paint(Graphics g){
        super.paint(g);
        Shape.draw(g);
    }

    public static void main(String args[]){
        //Canvas p5 = new Canvas(100,100);
        Canvas.createCanvas("yo");
    }
}