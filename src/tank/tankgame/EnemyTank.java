package tank.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank {
    public Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }
}
