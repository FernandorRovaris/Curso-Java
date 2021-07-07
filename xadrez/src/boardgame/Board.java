package boardgame;

/**
 * Created by desenv4 on 05/07/2021.
 */
public class Board {

    private int rows;
    private int collumns;
    private Piece[][] pieces;

    public Board(int rows, int collumns) {
        if (rows < 1 || collumns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.collumns = collumns;
        pieces =  new Piece[rows][collumns];
    }

    public int getRow() {
        return rows;
    }

    public int getCollumn() {
        return collumns;
    }

    public Piece piece(int row, int collumn){
        if (!positonExists(row, collumn)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][collumn];
    }

    public Piece piece(Position position){
        if (!positonExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()]= piece;
        piece.positon = position;
    }

    public Piece removePiece(Position position){
        if (!positonExists(position)){
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.positon = null;

        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positonExists(int row, int column){
        return  row >= 0 && row < rows && column >= 0 && column < collumns;
    }

    public boolean positonExists(Position position){
        return  position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >= 0 && position.getColumn() < collumns;
    }

    public boolean thereIsAPiece(Position position){
        if (!positonExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }

}
