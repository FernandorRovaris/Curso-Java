package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Created by desenv4 on 05/07/2021.
 */
public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getCollumn()];

        Position p = new Position(0,0);

        p.setValues(positon.getRow() - 1, positon.getColumn());
        while(getBoard().positonExists(p) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           p.setRow(p.getRow() - 1);
        }
        if (getBoard().positonExists(p) && isThereOpponnentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow(), positon.getColumn() - 1);
        while(getBoard().positonExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if (getBoard().positonExists(p) && isThereOpponnentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow(), positon.getColumn() + 1);
        while(getBoard().positonExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if (getBoard().positonExists(p) && isThereOpponnentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() + 1, positon.getColumn());
        while(getBoard().positonExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positonExists(p) && isThereOpponnentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
