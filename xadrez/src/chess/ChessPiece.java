package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * Created by desenv4 on 05/07/2021.
 */
public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponnentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return  p != null && getColor() != color;
    }
}
