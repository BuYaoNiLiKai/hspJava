package tank.tankgame;

import javax.swing.*;

public class MyFrame extends JFrame {

    //
    public
    MyPanel panel = null;

    public MyFrame() {
        panel = new MyPanel();
        this.add(panel);
        this.setSize(1000, 750);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();

    }

}
