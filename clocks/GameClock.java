package clocks;

import actions.Collision;
import game.Score;
import game.Dir;
import game.Snake;
import gui.Gui;
import sounds.Sounds;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class GameClock extends Thread{
    public static boolean running = true;
    public static int level = 200;
    public static String filepathOverSound = "./src/sounds/over.wav";
    public static String filepathHomeSound = "./src/sounds/home.wav";
    public static String filepathDeadSound = "./src/sounds/dead.wav";
    public static String filepathGrowSound = "./src/sounds/grow.wav";
    public static String filepathHugeGrowSound = "./src/sounds/hugegrow.wav";
    public static int overSoundCounter = 0;
    public static int homeSoundCounter = 0;
    public static int deadSoundCounter = 0;
    public static int growSoundCounter = 0;
    public static int hugeGrowSoundCounter = 0;

    public static Sounds overSound = new Sounds();
    public static Sounds homeSound = new Sounds();
    public static Sounds deadSound = new Sounds();
    public static Sounds growSound = new Sounds();
    public static Sounds hugeGrowSound = new Sounds();

    public void run(){
        while(running){
            try {
                if (Gui.getSt() == gui.State.HOME){
                    overSoundCounter = 0;
                    deadSoundCounter = 0;
                    if (homeSoundCounter < 1){
                        homeSound.playSound(filepathHomeSound);
                        homeSoundCounter++;
                    }
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.score = 0;
                } else if (Gui.getSt() == gui.State.GAME){
                    overSoundCounter = 0;
                    homeSoundCounter = 0;
                    sleep(level);
                    Snake.move();
                    Snake.waitToMove = false;
                    Snake.frog.move();
                    Collision.collidePickUp();
                    growSoundCounter = 0;
                    hugeGrowSoundCounter = 0;
                    if(Collision.collideSelf()){
                        if (deadSoundCounter < 1){
                            deadSound.playSound(filepathDeadSound);
                            deadSoundCounter++;
                        }
                        sleep(1000);
                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Gui.st = gui.State.OVER;
                    }
                    if(Collision.collideWall()){
                        if (deadSoundCounter < 1){
                            deadSound.playSound(filepathDeadSound);
                            deadSoundCounter++;
                        }
                        sleep(1000);
                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Gui.st = gui.State.OVER;
                    }
                    if(Collision.collideObstacle()){
                        if (deadSoundCounter < 1){
                            deadSound.playSound(filepathDeadSound);
                            deadSoundCounter++;
                        }
                        sleep(1000);
                        Score.Write(Snake.score);
                        Snake.tails.clear();
                        Snake.head.setX(7);
                        Snake.head.setY(7);
                        Snake.score = 0;
                        Gui.st = gui.State.OVER;
                    }
                } else if (Gui.getSt() == gui.State.OVER){
                    if (overSoundCounter < 1){
                        overSound.playSound(filepathOverSound);
                        overSoundCounter++;
                    }
                    homeSoundCounter = 0;
                    deadSoundCounter = 0;
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
