package TetrisComponent.piece;


import GameComponent.Action;

/**
 * Created by ducanh97 on 1/19/2017.
 */
public class FallAction extends Action {

    private Piece piece;


    public FallAction(Piece piece) {
        this.piece = piece;
    }

    @Override
    public int initTickPerAct() {
        return piece.NORMAL_SPEED;
    }

    @Override
    public void act() {

        for (Tile tile : piece.getTiles()) {

            tile.tick();

        }

        piece.setY(piece.getY() + Tile.SIZE_TILE);
    }
}
