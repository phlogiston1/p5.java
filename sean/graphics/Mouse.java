package sean.graphics;

import java.awt.MouseInfo;
import java.awt.event.*;

import sean.graphics.event.WheelEvent;

public class Mouse extends Canvas implements MouseListener, MouseWheelListener{
    public static double mouseX,
                         mouseY,
                         movedX,
                         movedY,
                         pmouseX,
                         pmouseY,
                         winMouseX,
                         winMouseY,
                         pwinMouseX,
                         pwinMouseY;
    private static double prevx, prevy;
    public static boolean mouseIsPressed = false;
    public static int mouseButton = 0;
    public static final int LEFT = 1,CENTER = 2, RIGHT = 3;
    public boolean listenersActive = false;
    public void addMouseListener(){
        System.out.println("adding listener");
        this.addMouseListener(this);
        this.addMouseWheelListener(this);
        if(frame  != null){
            frame.addMouseListener(this);
            frame.addMouseWheelListener(this);
        }
    }
    public void updateMouse(){
        pmouseX = mouseX;
        pmouseY = mouseY;
        pwinMouseX = winMouseX;
        pwinMouseY = winMouseY;
        double x = MouseInfo.getPointerInfo().getLocation().getX();
        double y = MouseInfo.getPointerInfo().getLocation().getY();
        mouseX = x - frame.getLocation().getX()-10;
        mouseY = y - frame.getLocation().getY()-30;
        movedX = prevx - x;
        movedY = prevy - y;
        winMouseX = x;
        winMouseY = y;
        if(x != prevx || y != prevy){
            if(!mouseIsPressed){
                mouseMoved();
            }else{
                mouseDragged();
            }
        }


        prevx = x;
        prevy = y;
    }
    public void mouseMoved(){}
    public void mouseDragged(){}
    public void mousePressed(){}
    public void mouseReleased(){}
    public void mouseClicked(){}
    public void mouseWheel(){}
    public void mouseWheel(WheelEvent event){}
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClicked();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseIsPressed = true;
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                mouseButton = LEFT;
                break;
            case MouseEvent.BUTTON2:
                mouseButton = CENTER;
                break;
            case MouseEvent.BUTTON3:
                mouseButton = RIGHT;
                break;
        }
        mousePressed();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseIsPressed = false;
        mouseReleased();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("wheelMoved");
        mouseWheel();
        mouseWheel(new WheelEvent(0, e.getPreciseWheelRotation()));
    }

}