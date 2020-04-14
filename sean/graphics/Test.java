package sean.graphics;

import sean.graphics.event.WheelEvent;

public class Test extends p5 {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Canvas c;
    public static void main(String args[]) {
        new Test().start();
    }
    public void setup(){
        c = createCanvas(400, 400);
        background(color(100,100,155));
        frameRate(30);
    }
    int i = 0;
    public void draw() {
        //i = (int)movedX;
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
        if(mouseIsPressed){
            System.out.println("mousePressed");
            if(mouseButton == RIGHT){
                System.out.println("RButton");
            }
            if(mouseButton == CENTER){
                System.out.println("CButton");
            }
            if(mouseButton == LEFT){
                System.out.println("LButton");
            }
        }
        if(keyIsPressed){
            i++;
        }
        textSize(32);
        textFont("Jokerman");
        textStyle(BOLD);
        text(""+key, 250,i - 10);
        //i++;
    }
    public void mouseDragged(){
        line((int)pmouseX, (int)pmouseY, (int)mouseX, (int)mouseY);
    }
    public void mouseWheel(WheelEvent e){
        System.out.println(e.deltaY);
        i += e.deltaY * 10;
    }
    public void mousePressed(){
        loop();
    }
    public void mouseReleased(){
        noLoop();
        redraw(i);
    }
}