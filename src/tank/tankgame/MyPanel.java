package tank.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<EnemyTank> enemys = null;
    int enemyNum = 4;

    public MyPanel() {
        hero = new Hero(100, 100, 0, 10);
        enemys = new Vector<>();
        for (int i = 0; i < enemyNum; i++) {
            EnemyTank enemyTank = new EnemyTank(hero.getX() + 60 * (i + 1), hero.getY(), i % 4, 10);
            Shot shot = new Shot(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirection());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemys.add(enemyTank);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充矩形
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        if (hero.shot != null && hero.shot.isLive) {
            g.draw3DRect(hero.shot.getX(), hero.shot.getY(), 5, 5, false);
        }
        for (EnemyTank enemy : enemys) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 0);
            for (Shot shot : enemy.shots) {
                if (shot.isLive) {
                    g.draw3DRect(shot.getX(), shot.getY(), 5, 5, false);
                } else {
                    enemy.shots.remove(shot);
                }

            }
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
            hero.moveUP();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("开始设计");
            hero.shotEnemy();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }

    }
}
