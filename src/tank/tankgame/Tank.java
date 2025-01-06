package tank.tankgame;

public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed;


    public Tank(int x, int y, int direction, int speed) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUP() {
        y -= speed;
        direction = 0;
    }

    public void moveDown() {
        y += speed;
        direction = 1;
    }

    public void moveLeft() {
        x -= speed;
        direction = 2;
    }

    public void moveRight() {
        x += speed;
        direction = 3;
    }


}

