package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneralGame extends SimpleGame {

    public ArrayList<ArrayList<ArrayList<Integer>>> existingSOS;

    GeneralGame(Board board) {
        super(board);
        existingSOS = new ArrayList<ArrayList<ArrayList<Integer>>>();
    }

    @Override
    public void findSOS() {
        winningLocations = new ArrayList<ArrayList<Integer>>();

        // check all horizontal wins
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(i, j).getGamePiece().equals("S")
                        && this.board.getTile(i, j + 1).getGamePiece().equals("O")
                        && this.board.getTile(i, j + 2).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i,j+1)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i,j+2)));

                    if (this.existingSOS.contains(winningLocations)) {
                        winningLocations = new ArrayList<ArrayList<Integer>>();
                        continue;
                    }

                    else {
                        board.gui.addStrikethroughToPieces(winningLocations);
                        existingSOS.add(winningLocations);
                        if (board.isBlueTurn) {
                            board.redPlayer.numOfSOS++;
                        }

                        else {
                            board.bluePlayer.numOfSOS++;
                        }
                    }
                }

                winningLocations = new ArrayList<ArrayList<Integer>>();
            }
        }

        winningLocations = new ArrayList<ArrayList<Integer>>();
        // check all vertical wins
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(j, i).getGamePiece().equals("S")
                        && this.board.getTile(j + 1, i).getGamePiece().equals("O")
                        && this.board.getTile(j + 2, i).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(j,i)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(j + 1,i)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(j + 2,i)));

                    if (this.existingSOS.contains(winningLocations)) {
                        winningLocations = new ArrayList<ArrayList<Integer>>();
                        continue;
                    }

                    else {
                        board.gui.addStrikethroughToPieces(winningLocations);
                        existingSOS.add(winningLocations);
                        if (board.isBlueTurn) {
                            board.redPlayer.numOfSOS++;
                        }

                        else {
                            board.bluePlayer.numOfSOS++;
                        }
                    }
                }

                winningLocations = new ArrayList<ArrayList<Integer>>();
            }
        }

        winningLocations = new ArrayList<ArrayList<Integer>>();
        // check for diagonal case 1
        for (int i = 0; i < this.board.getSize() - 2; i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(i, j).getGamePiece().equals("S")
                        && this.board.getTile(i + 1, j + 1).getGamePiece().equals("O")
                        && this.board.getTile(i + 2, j + 2).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 1, j + 1)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 2, j + 2)));

                    if (this.existingSOS.contains(winningLocations)) {
                        winningLocations = new ArrayList<ArrayList<Integer>>();
                        continue;
                    }

                    else {
                        board.gui.addStrikethroughToPieces(winningLocations);
                        existingSOS.add(winningLocations);
                        if (board.isBlueTurn) {
                            board.redPlayer.numOfSOS++;
                        }

                        else {
                            board.bluePlayer.numOfSOS++;
                        }
                    }
                }

                winningLocations = new ArrayList<ArrayList<Integer>>();
            }
        }

        winningLocations = new ArrayList<ArrayList<Integer>>();
        // check for diagonal case 2 (other diagonal)
        for (int i = 0; i < this.board.getSize() - 2; i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(i, j + 2).getGamePiece().equals("S")
                        && this.board.getTile(i + 1, j + 1).getGamePiece().equals("O")
                        && this.board.getTile(i + 2, j).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i, j + 2)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 1, j + 1)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 2, j)));

                    if (this.existingSOS.contains(winningLocations)) {
                        winningLocations = new ArrayList<ArrayList<Integer>>();
                        continue;
                    }

                    else {
                        board.gui.addStrikethroughToPieces(winningLocations);
                        existingSOS.add(winningLocations);
                        if (board.isBlueTurn) {
                            board.redPlayer.numOfSOS++;
                        }

                        else {
                            board.bluePlayer.numOfSOS++;
                        }
                    }
                }

                winningLocations = new ArrayList<ArrayList<Integer>>();
            }
        }

        // check for full game board, which signals end of game
        gameIsOver = true;
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                if (this.board.getTile(i,j).getGamePiece().equals("")) {
                    gameIsOver = false;
                }
            }
        }
    }

    @Override
    public Boolean isEndOfGame() {
        findSOS();
        return gameIsOver;
    }

    @Override
    public String getWinner() {
        if (this.board.bluePlayer.numOfSOS > this.board.redPlayer.numOfSOS) {
            return "Blue";
        }

        else if (this.board.bluePlayer.numOfSOS < this.board.redPlayer.numOfSOS) {
            return "Red";
        }

        return "Draw";

    }
}
