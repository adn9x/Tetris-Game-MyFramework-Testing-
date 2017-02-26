package TetrisGame;


import GameComponent.Game;
import GameComponent.State;
import TetrisGame.Controller.GameController;
import TetrisGame.Controller.MenuController;
import TetrisGame.State.GameState;
import TetrisGame.State.IDState;
import TetrisGame.State.MenuState;

/**
 * Created by ducanh97 on 1/14/2017.
 */
public class Tetris {

    public static final String GAME_TITLE = "TETRIS";

    private Game game;

    private State menuState, gameState;

    public Tetris() {

        game = new Game(GAME_TITLE, 520, 520);

        gameState = new GameState();
        menuState = new MenuState();

        game.addState(IDState.GAME_STATE, gameState);

        game.addState(IDState.MENU_STATE, menuState);

        game.setCurrentState(IDState.MENU_STATE);

        game.setCurrentState(IDState.MENU_STATE);

        game.addKeyListener(new MenuController( menuState));

    }




    public static void main(String[] args) {

        new Tetris();

    }
}
