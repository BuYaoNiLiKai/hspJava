package tank.tankgame;

public class Hero extends Tank {
    Shot shot;

    public Hero(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    public void shotEnemy() {
        switch (getDirection()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 20, getY() + 60, 1);
                break;
            case 2:
                shot = new Shot(getX(), getY() + 20, 2);
                break;
            case 3:
                shot = new Shot(getX() + 60, getY() + 20, 3);
                break;
            default:
                break;
        }
        new Thread(shot).start();
    }
}
