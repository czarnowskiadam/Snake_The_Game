package game;

import gui.Gui;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Frog {
    int x, y, jump;

    public Frog() {
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);
    }

    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);
    }

    public void move() throws InterruptedException
    {
        this.jump = ThreadLocalRandom.current().nextInt(0,4);

        if (jump == 0){
            if (getY() - 1 >= 0){
                setY(getY() - 1);
            }
        } else if (jump == 1) {
            if (getY() + 1 <= 41){
                setY(getY() + 1);
            }
        } else if (jump == 2) {
            if (getX() - 1 >= 0){
                setX(getX() - 1);
            }
        } else {
            if (getX() + 1 <= 41){
                setX(getX() + 1);
            }
        }
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * Gui.dimension + Gui.xoff;
        p.y = y * Gui.dimension + Gui.yoff;

        return p;
    }

}
