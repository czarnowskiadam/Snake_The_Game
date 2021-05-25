package clocks;

import actions.Collision;
//import game.Score;
import game.Snake;
import gui.Draw;
import gui.Gui;
import gui.State;

import java.io.IOException;

public class GameClock extends Thread{
    public static boolean running = true;
    public static int level = 200;

    public void run(){
        while(running){
            try {
                if (Draw.getSt() == gui.State.HOME){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                } else if (Draw.getSt() == gui.State.GAME){
                    sleep(level);
                    Snake.move();
                    Snake.waitToMove = false;
                    Collision.collidePickUp();
                    if(Collision.collideSelf()){
//                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Draw.st = gui.State.OVER;
                    }
                    if(Collision.collideWall()){
//                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Draw.st = gui.State.OVER;
                    }
                } else if (Draw.getSt() == gui.State.OVER){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
