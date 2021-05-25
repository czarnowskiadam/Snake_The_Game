package game;

import java.util.concurrent.ThreadLocalRandom;

public class PickUp4 {
    int x, y;

    public PickUp4(){
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);

    }

    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);
    }

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
}
