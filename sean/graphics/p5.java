package sean.graphics;

public class p5 extends Constants implements Runnable {
    boolean running = true;
    static int frameRate;

    public p5() {
        setup();
        new Thread(this).run();
    }
    public static void main(String args[]){
        new p5().start();
    }
    public void start(){
        setup();
        new Thread(this).run();
    }
    public static void frameRate(int rate){
        frameRate = rate;
    }

    public void setup() {
    }

    public void draw() {
    }
    public static void clear(){
        clearLines();
        clearArcs();
        clearEllipses();
        clearCircles();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void run() {
        while (running) {
            dispose();
            draw();
            revalidateCanvas();
            try {
                Thread.sleep(1000/frameRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clear();
        }
    }
}