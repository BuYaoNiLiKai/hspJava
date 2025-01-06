package tank.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    MyTank tank = null;
    Tank[] enemys = null;

    public MyPanel() {
        tank = new MyTank(100, 100, 0, 10);
        enemys = new Tank[3];
        for (int i = 0; i < enemys.length; i++) {
            enemys[i] = new Tank(tank.getX() + 60 * (i + 1), tank.getY(), i, 10);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充矩形
        drawTank(tank.getX(), tank.getY(), g, tank.getDirection(), 1);
        for (Tank enemy : enemys) {
            drawTank(enemy.getX() + 60, enemy.getY(), g, enemy.getDirection(), 0);
        }

    }

    /*
    坐标
    画笔
    方向
    类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
            default:
                System.out.println("未处理");
        }
        switch (direction) {
            // 上下左右
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;

            case 2:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            default:
                break;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            tank.moveUP();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            tank.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            tank.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            tank.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
