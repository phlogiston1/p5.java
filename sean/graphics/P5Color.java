package sean.graphics;

import java.awt.Color;

public class P5Color extends Canvas{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public int m_r = 0, m_g = 0, m_b = 0;
    public P5Color(int r, int g, int b){
        m_r = r;
        m_g = g;
        m_b = b;
    }
    public int m_alpha;
    public P5Color(int alpha){
        m_alpha = alpha;
    }
    public P5Color(){}
    public void setRed(int r){
        m_r = r;
    }
    public void setBlue(int b){
        m_b = b;
    }
    public void setGreen(int g){
        m_g = g;
    }

    public static Stroke stroke = new P5Color().new Stroke();
    public static void stroke(int r, int g, int b){
        stroke.stroke = true;
        stroke.r = r;
        stroke.g = g;
        stroke.b = b;
    }
    public static void noStroke(){
        stroke.stroke = false;
    }
    public static Stroke getStroke(){
        return stroke;
    }
    public static void strokeWeight(int w){
        stroke.weight = w;
    }

    public static Fill fill = new P5Color().new Fill();
    public static void noFill(){
        fill.fill = false;
    }
    public static void fill(int r, int g, int b){
        fill.fill = true;
        fill.r = r;
        fill.g = g;
        fill.b = b;
    }
    public static Fill getFill(){
        return fill;
    }

    public static P5Color color(int r, int g, int b){
        return new P5Color(r,g,b);
    }
    public static P5Color color(int a){
        return new P5Color(a);
    }
    public static Color getColor(P5Color c){
        return new Color(c.m_r, c.m_g, c.m_b);
    }
    public static int alpha(P5Color c){
        return (c.m_r+c.m_g+c.m_b)/3;
    }
    public static int blue(P5Color c){
        return c.m_b;
    }
    public static int green(P5Color c){
        return c.m_g;
    }
    public static int red(P5Color c){
        return c.m_r;
    }
    public class Fill{
        public Fill(boolean f, int inR, int inG, int inB){
            fill = f;
            r = inR;
            g = inG;
            b = inB;
        }
        public Fill(){
        }
        public boolean fill = false;
        public int r = 0,g = 0,b = 0;
        public Color getColor(){
            return new Color(r,g,b);
        }
    }
    public static Fill fillFrom(Fill oFill){
        return new P5Color().new Fill(oFill.fill, oFill.r, oFill.g, oFill.b);
    }

    public class Stroke{
        public Stroke(boolean f, int inR, int inG, int inB, int w){
            stroke = f;
            r = inR;
            g = inG;
            b = inB;
            weight = w;
        }
        public Stroke(){
        }
        public boolean stroke = true;
        public int r = 0,g = 0,b = 0;
        public int weight = 1;
        public Color getColor(){
            return new Color(r,g,b);
        }
    }
    public static Stroke strokeFrom(Stroke oStroke){
        return new P5Color().new Stroke(oStroke.stroke, oStroke.r, oStroke.g, oStroke.b, oStroke.weight);
    }
}