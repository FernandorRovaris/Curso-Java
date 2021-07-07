package chess;

import boardgame.BoardException;

/**
 * Created by desenv4 on 05/07/2021.
 */
public class ChessExceptoin extends BoardException {

    public static final long serialVersionUID = 1L;

    public ChessExceptoin(String message) {
        super(message);
    }
}
