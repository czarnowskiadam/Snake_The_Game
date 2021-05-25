package actions;

import game.Dir;
import game.Snake;
import gui.Draw;
import gui.Gui;
import gui.Gui;
import gui.State;
import clocks.GameClock;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (!(Snake.head.getDir() == Dir.DOWN) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.UP);
                    Snake.waitToMove = true;
                    System.out.println("W");
                }
                break;
            case KeyEvent.VK_A:
                if (!(Snake.head.getDir() == Dir.RIGHT) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.LEFT);
                    Snake.waitToMove = true;
                    System.out.println("A");
                }
                break;
            case KeyEvent.VK_S:
                if (!(Snake.head.getDir() == Dir.UP) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.DOWN);
                    Snake.waitToMove = true;
                    System.out.println("S");
                }
                break;
            case KeyEvent.VK_D:
                if (!(Snake.head.getDir() == Dir.LEFT) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.waitToMove = true;
                    System.out.println("D");
                }
                break;
            case KeyEvent.VK_SPACE:
                if (Draw.st != State.GAME){
                    Draw.st = State.GAME;
                    System.out.println("space");
                }
                break;
            case KeyEvent.VK_ESCAPE:
                if (Draw.st != State.GAME){
                    System.exit(0);
                }
                break;
            case KeyEvent.VK_CONTROL:
                if (Draw.st != State.GAME && Draw.st != State.OVER){
                    if (GameClock.level == 200){
                        GameClock.level = 150;
                    } else if (GameClock.level == 150){
                        GameClock.level = 100;
                    } else if (GameClock.level == 100){
                        GameClock.level = 200;
                    }
                } else if (Draw.st != State.GAME){
                    Draw.st = State.HOME;
                }
                break;
            case KeyEvent.VK_0:
                System.out.println(Draw.getSt());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
