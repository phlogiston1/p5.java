package sean.graphics;

public class p5 extends Constants implements Runnable {
    boolean running = true;
    static int frameRate = 30;
    static boolean clear = true;

    public static void noClear() {
        clear = false;
    }

    public p5() {
        setup();
        initCanvas();
        new Thread(this).run();
    }

    public static void main(String args[]) {
        new p5().start();
    }

    public void start() {
        setup();
        new Thread(this).run();
    }

    public static void frameRate(int rate) {
        frameRate = rate;
    }

    public void setup() {
    }

    public void draw() {
    }

    public static void clear() {
        if (clear)
            clearEverything();
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