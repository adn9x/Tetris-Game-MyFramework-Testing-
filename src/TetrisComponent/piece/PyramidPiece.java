package TetrisComponent.piece;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ducanh97 on 1/14/2017.
 */
public class PyramidPiece extends Piece {

    public PyramidPiece(int x, int y) {

        super(x, y);
    }

    @Override
    public ArrayList<Tile> initTiles() {

        ArrayList<Tile> tiles = new ArrayList<>();

        int x = getX();
        int y = getY();

        tiles.add(new Tile(x, y));
        tiles.add(new Tile(x -Tile.SIZE_TILE, y));
        tiles.add(new Tile(Tile.SIZE_TILE + x, y));
        tiles.add(new Tile(x, Tile.SIZE_TILE + y));

        return tiles;
    }

    @Override
    public Color initColor() {
        return Color.RED;
    }

}
