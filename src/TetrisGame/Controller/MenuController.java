package TetrisGame.Controller;

import GameComponent.State;
import TetrisGame.State.GameState;
import TetrisGame.State.IDState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by ducanh97 on 2/13/2017.
 */
public class MenuController extends KeyAdapter {

    private State menuState;

    public MenuController(State menuState) {
        this.menuState = menuState;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() > 0) {

            menuState.getGame().setCurrentState(IDState.GAME_STATE);
        }
    }
}
