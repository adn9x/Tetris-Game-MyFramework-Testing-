package TetrisComponent.board;

import TetrisComponent.piece.Piece;
import TetrisComponent.piece.PyramidPiece;
import TetrisComponent.piece.SquarePiece;
import TetrisComponent.piece.StickPiece;

import java.util.Random;

/**
 * Created by ducanh97 on 1/14/2017.
 */
public class PieceFactory extends AbtractFactory {


    private Random r = new Random();
    private Piece piece;

    public PieceFactory() {

    }


    @Override
    public Piece createPiece(int piecePieceID, int x, int y) {

        if (piecePieceID == PYRAMID) {
            piece = new PyramidPiece(x, y);
        } else if (piecePieceID == SQUARE) {
            piece = new SquarePiece(x, y);
        } else if (piecePieceID == STICK) {
            piece = new StickPiece(x, y);
        }
        return piece;
    }

    @Override
    public Piece getRandomPiece(int x, int y) {

        int id = r.nextInt(NUMBER_OF_PIECES);

        return createPiece(id, x, y);
    }
}
