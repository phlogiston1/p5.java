package sean.Editor;

import javax.swing.*;

public class Editor {
    public static void main(String args[]){
        new Editor();
    }
    public Editor(){
        JFrame win = new JFrame("Seans editor");
        win.setSize(1000,800);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}