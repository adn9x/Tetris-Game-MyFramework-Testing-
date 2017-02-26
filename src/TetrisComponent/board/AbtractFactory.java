package TetrisComponent.board;

import TetrisComponent.piece.Piece;

/**
 * Created by ducanh97 on 2/13/2017.
 */
public abstract class AbtractFactory {

    public static int  DEFAULT_MODE = 0;

    int PYRAMID = 0;
    int SQUARE  = 1;
    int STICK   = 2;
    int NUMBER_OF_PIECES = 3;

    public static AbtractFactory getPieceFactory(int mode) {

        if (mode == DEFAULT_MODE) {
            return new PieceFactory();
        }

        return null;
    }

    public abstract Piece createPiece(int pieceId, int x, int y);
    public abstract Piece getRandomPiece(int x, int y);
}
