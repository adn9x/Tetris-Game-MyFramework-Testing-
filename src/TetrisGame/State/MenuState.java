package TetrisGame.State;


import GameComponent.Stage;
import GameComponent.State;

import java.awt.*;

/**
 * Created by ducanh97 on 2/3/2017.
 */
public class MenuState extends State {

    private Stage stage = new Stage();

    public MenuState() {
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.CYAN);
        g.drawRect(30, 30, 300, 100);
        g.setFont(new Font(null, Font.PLAIN, 20));
        g.drawString("Start", 80, 85);

    }

}
