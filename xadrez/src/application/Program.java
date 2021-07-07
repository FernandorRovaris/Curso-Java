package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessExceptoin;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPositon;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desenv4 on 05/07/2021.
 */
public class Program {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPositon source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPositon target = UI.readChessPosition(sc);

                ChessPiece capturePiece = chessMatch.performChessMove(source, target);
            }catch (ChessExceptoin e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }

}
