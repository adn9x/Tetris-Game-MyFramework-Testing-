package TetrisComponent.board;

import GameComponent.Actor;
import TetrisComponent.piece.Piece;
import TetrisComponent.piece.Tile;
import TetrisGame.Controller.GameController;

import java.awt.*;

/**
 * Created by ducanh97 on 1/14/2017.
 */

public class Board extends Actor {

    private AbtractFactory pieceFactory;
    private Piece fallingPiece;
    private int score = 0;
    private int currentNormalSpeed = Piece.NORMAL_SPEED;

    public Board() {
        super(BoardConstant.MIN_X_POSITION, BoardConstant.MIN_Y_POSITION);

        pieceFactory = AbtractFactory.getPieceFactory(AbtractFactory.DEFAULT_MODE);

    }


    private final Tile[][] tileCoordinate = new Tile[BoardConstant.ROW][BoardConstant.COLUMN];


    public void setPieceFactory(AbtractFactory pieceFactory) {
        this.pieceFactory = pieceFactory;
    }


    public Tile[][] getTileCoordinate() {
        return tileCoordinate;
    }

    public void moveFallingPieceLeft() {

        fallingPiece.moveLeft();

        if (!validPosition()) {
            fallingPiece.moveRight();
        }
    }

    public void moveFallingPieceRight() {


        fallingPiece.moveRight();

        if (!validPosition()) {
            fallingPiece.moveLeft();
        }
    }

    public void rotateFallingPiece() {

        fallingPiece.rotateClockwise();

        if (!validPosition()) {
            fallingPiece.rotateCounterClockwise();
        }
    }


    public void setSpeed(int speed) {

        fallingPiece.setSpeed(speed);
    }


    public void addPiece2TileCoordinate() {

        for (Tile tile : fallingPiece.getTiles()) {

            tileCoordinate[BoardConstant.convertY2Row(tile.getY())][BoardConstant.convertX2Column(tile.getX())] = tile;
        }
    }

    public void collapseFallingPiece() {

        while (pieceCanFall()) {
            fallingPiece.tick();
        }

    }

    public void removeFullRow(int row) {

        for (int i = row; i > 0; i--) {
            for (int j = 0; j < BoardConstant.COLUMN; j++) {

                tileCoordinate[i][j] = tileCoordinate[i - 1][j];
                if (tileCoordinate[i - 1][j] != null) {
                    tileCoordinate[i - 1][j].tick();
                }
            }
        }

        updateScoreAndSpeed();
    }

    public void updateScoreAndSpeed() {
        score += 100;
        if (currentNormalSpeed <= 5) {
            return;
        }

        if (score % 500 == 0) {
            currentNormalSpeed -= 5;
        }

    }

    public boolean isFullRow(int row) {
        int countTile = 0;

        for (int j = 0; j < BoardConstant.COLUMN; j++ ) {
            if (tileCoordinate[row][j] == null) {
                return false;
            }
            countTile++;
        }

        if (countTile == BoardConstant.COLUMN) {
            return true;
        }

        return false;
    }


    public boolean fallingPieceOutOfBoard() {

        for (Tile tile : fallingPiece.getTiles()) {

            int x = tile.getX();
            int y = tile.getY();

            if (x < BoardConstant.MIN_X_POSITION || x >= BoardConstant.getMaxXPosition()) {
                return true;
            }
        }

        return false;
    }

    public boolean validPosition() {
        return  ( !fallingPieceOutOfBoard() ) && ( ! fallingPieceIntersectWithOtherTiles() );
    }


    public boolean fallingPieceIntersectWithOtherTiles() {

        for (Tile tile : fallingPiece.getTiles()) {

            int row = BoardConstant.convertY2Row(tile.getY());
            int col = BoardConstant.convertX2Column(tile.getX());

            if (row >= BoardConstant.ROW || col >= BoardConstant.COLUMN) {
                return true;
            }

            if (tileCoordinate[row][col] != null) {
                return true;
            }
        }

        return false;
    }


    @Override
    public void tick() {

        super.tick();

        if (fallingPiece == null) {
            fallingPiece = pieceFactory.
                    getRandomPiece(BoardConstant.COLUMN / 2 * Tile.SIZE_TILE + BoardConstant.MIN_X_POSITION,
                            BoardConstant.MIN_Y_POSITION + 2 * Tile.SIZE_TILE);
        }

        update();

        if (pieceCanFall()) {

            fallingPiece.tick();

        } else {

            addPiece2TileCoordinate();

            for (Tile tile : fallingPiece.getTiles()) {
                int row = BoardConstant.convertY2Row(tile.getY());
                int col = BoardConstant.convertX2Column(tile.getX());



                if (isFullRow(row)) {
                    removeFullRow(row);
                }
            }

            fallingPiece = null;
        }


    }



    public boolean pieceCanFall() {

        if (fallingPiece == null) {
            return false;
        }

        for (Tile tile : fallingPiece.getTiles()) {

            int x = tile.getX();
            int y = tile.getY();

            if (y >= BoardConstant.getMaxYPosition() - Tile.SIZE_TILE) {
                return false;
            }

            int row = BoardConstant.convertY2Row(y);
            int col = BoardConstant.convertX2Column(x);

            if (col < 0 || col >= BoardConstant.COLUMN) {
                return true;
            }

            if (tileCoordinate[row + 1][col] != null) {
                return false;
            }
        }



        return true;
    }

    public void renderBoardBackground(Graphics2D g) {

        g.setColor(Color.CYAN);

        g.drawRect(BoardConstant.MIN_X_POSITION, BoardConstant.MIN_Y_POSITION, BoardConstant.getWidth()
                , BoardConstant.getHeight());

        g.drawRect(BoardConstant.MIN_X_POSITION, BoardConstant.MIN_Y_POSITION + 4 * Tile.SIZE_TILE,
                BoardConstant.getWidth()
                , BoardConstant.getHeight() - BoardConstant.STARTING_AREA * Tile.SIZE_TILE);

        g.setColor(Color.BLACK);

        g.drawLine(BoardConstant.MIN_X_POSITION, BoardConstant.MIN_Y_POSITION, BoardConstant.getMaxXPosition(),
                BoardConstant.MIN_Y_POSITION);

        g.setColor(Color.CYAN);
        g.drawString("" + score, BoardConstant.MIN_X_POSITION, BoardConstant.MIN_Y_POSITION);
    }

    @Override
    public void render(Graphics2D g) {

        super.render(g);
        renderBoardBackground(g);


        if (fallingPiece != null) {
            fallingPiece.render(g);
        }

        for (int i = 0; i < BoardConstant.ROW; i++) {

            for (int j = 0; j < BoardConstant.COLUMN; j++) {

                if (tileCoordinate[i][j] == null) { continue; }

                tileCoordinate[i][j].render(g);
            }
        }
    }


    public void update() {

        GameController controller = GameController.getController();

        if (controller.up) {
            rotateFallingPiece();
            controller.up = false;
        }
        if (controller.down) {
            setSpeed(Piece.FAST_SPEED);
        } else {
            setSpeed(Piece.NORMAL_SPEED);
        }
        if (controller.left) {
            moveFallingPieceLeft();
        }
        if (controller.right) {
            moveFallingPieceRight();
        }
        if (controller.space) {
            collapseFallingPiece();
            controller.space = false;
        }

    }


}
