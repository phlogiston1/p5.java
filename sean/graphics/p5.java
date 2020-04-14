package sean.graphics;

public class p5 extends Constants implements Runnable {
    boolean running = true;
    static int frameRate = 30;
    static boolean clear = true;
    static int loop = -1;

    public static void noClear() {
        clear = false;
    }

    public p5() {
        setup();
        addMouseListener();
        addKeyboardListener();
        initCanvas();
        new Thread(this).run();
    }
    public static void loop(){
        loop = -1;
    }
    public static void noLoop(){
        loop = 0;
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
    public void redraw(){
        if(loop == 0) loop = 1;
    }
    public void redraw(int n){
        if(loop == 0) loop = n;
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
            updateMouse();
            if(loop != 0){
                clear();
                dispose();
                draw();
                if(loop > 0) loop--;
            }
            revalidateCanvas();
            try {
                Thread.sleep(1000/frameRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}