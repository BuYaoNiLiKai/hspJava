package tank.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Event extends JFrame {
    public Event() {
        this.setTitle("Tank Event");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        MP1 mp = new MP1();
        this.add(mp);
        this.setVisible(true);
        this.addKeyListener(mp);

    }

    public static void main(String[] args) {
        new Event();

    }
}

class MP1 extends JPanel implements KeyListener {

    int x;
    int y;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 10, 10);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            this.x++;
        }
        this.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}