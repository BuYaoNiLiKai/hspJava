package tank.tankgame;

import static java.lang.Thread.sleep;

// 子弹类
public class Shot implements Runnable {
    private int x;
    private int y;
    private int speed = 10;
    private int direction;
    boolean isLive = true; // 是否存活

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x -= speed;
                    break;
                case 3:
                    x += speed;
                    break;
                default:
                    break;
            }
            System.out.println(x + "      " + y);
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
                break;
            }
        }
    }
}
