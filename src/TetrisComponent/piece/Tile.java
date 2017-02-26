package TetrisComponent.piece;

import java.awt.*;

/**
 * Created by ducanh97 on 1/14/2017.
 */
public class Tile {

    public static final int SIZE_TILE = 15;


    private int x, y;
    private Color color;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE_TILE, SIZE_TILE);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, SIZE_TILE, SIZE_TILE);
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void tick() {
        this.y = this.y + SIZE_TILE;
    }
}
