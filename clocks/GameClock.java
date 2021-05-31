package clocks;

import actions.Collision;
import game.Score;
import game.Dir;
import game.Snake;
import gui.Gui;

import javax.sound.sampled.*;
import java.io.IOException;

public class GameClock extends Thread{
    public static boolean running = true;
    public static int level = 200;

    public void run(){
        while(running){
            try {
                if (Gui.getSt() == gui.State.HOME){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.score = 0;
                } else if (Gui.getSt() == gui.State.GAME){
                    sleep(level);
                    Snake.move();
                    Snake.waitToMove = false;
                    Snake.frog.move();
                    Collision.collidePickUp();
                    if(Collision.collideSelf()){
                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Gui.st = gui.State.OVER;
                    }
                    if(Collision.collideWall()){
                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Gui.st = gui.State.OVER;
                    }
                    if(Collision.collideObstacle()){
                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Gui.st = gui.State.OVER;
                    }
                } else if (Gui.getSt() == gui.State.OVER){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.score = 0;
                }


            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }


}
