package TetrisComponent.piece;


import GameComponent.Action;
import GameComponent.Actor;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ducanh97 on 1/14/2017.
 */

public abstract class Piece extends Actor {

    public static final int NORMAL_SPEED = 20;
    public static final int FAST_SPEED = 2;

    private int speed = NORMAL_SPEED;

    private ArrayList<Tile> tiles;
    private Action action;

    public Piece(int x, int y) {

        super(x, y);

        tiles = new ArrayList<>();

        tiles = initTiles();

        for (Tile tile : tiles) {
            tile.setColor(initColor());
        }

        action = new FallAction(this);
        addAction(action);

    }

    public void setSpeed(int speed) {
        action.setTickPerAct(speed);
    }

    public void setTiles(ArrayList<Tile> tiles) { this.tiles = tiles; }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public abstract ArrayList<Tile> initTiles();

    public abstract Color initColor();

    public void rotateClockwise() {
        
        int x = getX();
        int y = getY();

        int newX;
        int newY;


        for (int i = 0; i < tiles.size(); i++) {

            Tile tile = tiles.get(i);
            newX  = x - tile.getY() + y;
            newY = y + tile.getX() - x;

            tile.setX(newX);
            tile.setY(newY);
        }
    }


    public void moveLeft() {

        setX(getX() - Tile.SIZE_TILE);

        tiles.forEach(tile -> tile.setX(tile.getX() - Tile.SIZE_TILE));
    }

    public void moveRight() {

        setX(getX() + Tile.SIZE_TILE);

        tiles.forEach(tile -> tile.setX(tile.getX() + Tile.SIZE_TILE));
    }


    public void rotateCounterClockwise() {

        for (int i = 0; i < 3; i++) {
            rotateClockwise();
        }
    }


    @Override
    public void render(Graphics2D g) {

        super.render(g);
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).render(g);
        }
    }


    @Override
    public void tick() {

        super.tick();
    }
}
