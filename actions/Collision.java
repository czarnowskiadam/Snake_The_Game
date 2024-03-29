package actions;

import clocks.GameClock;
import game.Snake;

public class Collision {

    public static boolean collideSelf() {
        for(int i = 0; i<Snake.tails.size(); i++){
            if(Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY()
                    && !Snake.tails.get(i).isWait()){
                return true;
            }

        }

        return false;
    }

    public static boolean collideWall() {
        return (Snake.head.getX() < 0 || Snake.head.getX() > 41 || Snake.head.getY() < 0 || Snake.head.getY() > 41);
    }

    public static void collidePickUp() {
        if (Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()) {
            Snake.pickup.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup2.getX() && Snake.head.getY() == Snake.pickup2.getY()){
            Snake.pickup2.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup3.getX() && Snake.head.getY() == Snake.pickup3.getY()){
            Snake.pickup3.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup4.getX() && Snake.head.getY() == Snake.pickup4.getY()){
            Snake.pickup4.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup5.getX() && Snake.head.getY() == Snake.pickup5.getY()){
            Snake.pickup5.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.frog.getX() && Snake.head.getY() == Snake.frog.getY()){
            Snake.frog.reset();
            Snake.addTail();
            Snake.addTail();
            Snake.addTail();
            Snake.score +=3;
            if (GameClock.hugeGrowSoundCounter < 1){
                GameClock.hugeGrowSound.playSound(GameClock.filepathHugeGrowSound);
                GameClock.hugeGrowSoundCounter++;
            }
        }
    }

    public static boolean collideObstacle() {
        return (Snake.head.getX() >= 6 && Snake.head.getX() < 36 && Snake.head.getY() >= 19 && Snake.head.getY() < 23);
    }

}
