package sean.graphics;

public class HowToDrawALine extends p5{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static void main(String args[]){
        new HowToDrawALine().run();
    }
    public void setup(){
        createCanvas(500,500);
        background(color(0,0,200));
    }
    public void draw(){
        strokeWeight(3);
        stroke(0,200,0);
        line((int)(pmouseX + movedX),(int)(pmouseY + movedY),(int)mouseX,(int)mouseY);
        point(250,250);
        translate((int)movedX, (int)movedY);
    }
}