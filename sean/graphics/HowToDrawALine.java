package sean.graphics;

public class HowToDrawALine extends p5{
    public static void main(String args[]){
        new HowToDrawALine().run();
    }
    public void setup() {
        createCanvas(500,500);
    }
    int i = 0;
    public void draw(){
        line(0,0,(int)mouseX,(int)mouseY); //line from 0,0 to mouse
    }
}