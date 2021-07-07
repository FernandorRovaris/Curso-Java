package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Created by desenv4 on 05/07/2021.
 */
public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getCollumn()];
        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j < board.getCollumn() ; j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    public ChessPiece performChessMove(ChessPositon sourcePosition, ChessPositon targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validatePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){
            throw new ChessExceptoin("The chosen piece cant't move to targe position!");
        }
    }

    private void validatePosition(Position position){
        if (!board.thereIsAPiece(position)){
            throw  new ChessExceptoin("There is no place on source position");
        }
        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessExceptoin("There is not possible moves for the chosen piece");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPositon(column,row).toPosition());
    }

    private  void initialSetup(){
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));

        placeNewPiece('e', 1, new King(board, Color.WHITE));

        placeNewPiece('h', 1, new Rook(board, Color.WHITE));


        placeNewPiece('a', 8, new Rook(board, Color.BLACK));

        placeNewPiece('e', 8, new King(board, Color.BLACK));

        placeNewPiece('h', 8, new Rook(board, Color.BLACK));

    }

}
