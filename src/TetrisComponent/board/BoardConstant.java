package TetrisComponent.board;

import TetrisComponent.piece.Tile;

/**
 * Created by ducanh97 on 1/16/2017.
 */
public final class   BoardConstant {


    public static final int ROW = 28;
    public static final int COLUMN = 13;
    public static final int STARTING_AREA = 4;

    public static final int MIN_X_POSITION = 2 * Tile.SIZE_TILE;
    public static final int MIN_Y_POSITION = 5 * Tile.SIZE_TILE;

    public static final int SIZE_TILE = Tile.SIZE_TILE;


    public static int getMaxXPosition() {
        return MIN_X_POSITION + COLUMN * Tile.SIZE_TILE;
    }

    public static int getMaxYPosition() {
        return MIN_Y_POSITION + ROW * Tile.SIZE_TILE;
    }

    public static int getWidth() {
        return getMaxXPosition() - MIN_X_POSITION;
    }

    public static int getHeight() {
        return getMaxYPosition() - MIN_Y_POSITION;
    }

    public static int convertX2Column(int x) {
        return (x - BoardConstant.MIN_X_POSITION) / Tile.SIZE_TILE;
    }

    public static int convertY2Row(int y) {
        return (y - BoardConstant.MIN_Y_POSITION) / Tile.SIZE_TILE;
    }

    private BoardConstant() {

    }
}
