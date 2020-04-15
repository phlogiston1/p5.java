package sean.graphics;

import java.awt.*;
import java.util.ArrayList;

import sean.graphics.shapes.ShapeBase;

public class Typography extends P5Color{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static ArrayList<Text> txts = new ArrayList<Text>();

    public static Font cFont = new Font("", Font.PLAIN, 12);

    public static final int NORMAL  = 0,
                            ITALIC  = 1,
                            BOLD    = 2,
                            BOLDITALIC = 3;

    public class Text implements ShapeBase {
        String contents;
        int mx, my;
        Font mFont;
        public int translateX = 0, translateY = 0;

        public Text(String s, int x, int y, Font font) {
            contents = s;
            mx = x;
            my = y;
            mFont = font;
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setFont(mFont);
            g2d.drawString(contents, mx + translateX, my + translateY);
        }

        @Override
        public void fill(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setFont(mFont);
            g2d.drawString(contents, mx + translateX, my + translateY);
        }

        @Override
        public void setST(double s, int tX, int tY) {
            translateX = tX;
            translateY = tY;
        }
    }
    public static void textSize(float newSize){
        cFont = cFont.deriveFont(newSize);
    }
    public static void textFont(String newFont){
        cFont = new Font(newFont, cFont.getStyle(), cFont.getSize());
    }
    public static void textStyle(int style){
        switch(style){
            case NORMAL:
                cFont = cFont.deriveFont(Font.PLAIN);
            case ITALIC:
                cFont = cFont.deriveFont(Font.ITALIC);
            case BOLD:
                cFont = cFont.deriveFont(Font.BOLD);
            case BOLDITALIC:
                cFont = cFont.deriveFont(Font.BOLD | Font.ITALIC);
        }
    }
}