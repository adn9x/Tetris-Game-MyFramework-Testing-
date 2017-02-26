package TetrisComponent.piece;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ducanh97 on 1/16/2017.
 */
public class StickPiece extends Piece {


    public StickPiece(int x, int y) {
        super(x, y);
    }

    @Override
    public ArrayList<Tile> initTiles() {

        int x = getX();
        int y = getY();

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(x , y));
        tiles.add(new Tile(x , y + Tile.SIZE_TILE));
        tiles.add(new Tile(x, y - 2 * Tile.SIZE_TILE));
        tiles.add(new Tile(x, y - Tile.SIZE_TILE));

        return tiles;
    }

    @Override
    public Color initColor() {
        return Color.PINK;
    }

}
