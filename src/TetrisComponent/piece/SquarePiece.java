package TetrisComponent.piece;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ducanh97 on 1/15/2017.
 */
public class SquarePiece extends Piece {


    public SquarePiece(int x, int y) {
        super(x, y);
    }

    @Override
    public ArrayList<Tile> initTiles() {

        ArrayList<Tile> tiles = new ArrayList<>();

        int x = getX();
        int y = getY();

        tiles.add(new Tile(x, y));
        tiles.add(new Tile(x + Tile.SIZE_TILE, y + Tile.SIZE_TILE));
        tiles.add(new Tile(x + Tile.SIZE_TILE, y));
        tiles.add(new Tile(x, y + Tile.SIZE_TILE));

        return tiles;
    }

    @Override
    public Color initColor() {
        return  Color.BLUE;
    }

    @Override
    public void rotateClockwise() {
        return;
    }

    public void rotateCounterClockwise() { return; }
}
