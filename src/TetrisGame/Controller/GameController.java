package TetrisGame.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by ducanh97 on 1/14/2017.
 */

public final class GameController extends KeyAdapter {

    public boolean up, down, left, right, space;

    public static final GameController instance = new GameController();

    private GameController() {

    }

    public static GameController getController() {
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {


        int keyCode = e.getKeyCode();

        switch (keyCode) {

            case KeyEvent.VK_RIGHT:
                right = true;
                break;

            case KeyEvent.VK_LEFT:
                left = true;
                break;

            case KeyEvent.VK_DOWN:
                down = true;
                break;

            default:
                break;
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        switch (keyCode) {


            case KeyEvent.VK_UP:
                up = true;
                break;

            case KeyEvent.VK_SPACE:
                space = true;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            default:
                break;
        }
    }
}
