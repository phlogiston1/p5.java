package sean.graphics;


public class Test extends p5 {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) {
        new Test().start();
    }
    public void setup(){
        createCanvas(400,400);
        background(color(100,100,155));
        frameRate(30);
    }
    int i = 0;
    public void draw() {
        stroke(0,255,0);
        strokeWeight(10);
        point(40,40);
        line(0,0,200,i);
        strokeWeight(2);
        rect(10,10,10, 20, 5,10);
        noFill();
        circle(150,i - 50,100);
        fill(255,255,255);
        ellipse(100,100,10,50);
        arc(150,i - 50,100, 100, 0, i);
        i++;
    }
}