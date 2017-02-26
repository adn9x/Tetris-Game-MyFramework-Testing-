package TetrisGame.State;

import GameComponent.Stage;
import GameComponent.State;
import TetrisComponent.board.Board;

import java.awt.*;

/**
 * Created by ducanh97 on 2/3/2017.
 */
public class GameState extends State {

    private Stage stage;

    public GameState() {
        this.stage = new Stage();
        stage.addActor(new Board());
    }

    @Override
    public void tick() {
        stage.tick();
    }

    @Override
    public void render(Graphics2D g) {
        stage.render(g);
    }
}
