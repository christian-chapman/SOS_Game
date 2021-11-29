package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleGame {

    public Boolean gameIsOver = false;
    public Boolean gameIsDraw = false;

    public Board board;
    public ArrayList<ArrayList<Integer>> winningLocations;
    public Boolean isCurrentGameMode;


    SimpleGame(Board board) {
        this.board = board;
    }

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

                    gameIsOver = true;
                    return;
                }
            }


        }


        // check all vertical wins
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(j, i).getGamePiece().equals("S")
                        && this.board.getTile(j + 1, i).getGamePiece().equals("O")
                        && this.board.getTile(j + 2, i).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(j,i)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(j + 1,i)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(j + 2,i)));

                    gameIsOver = true;
                    return;
                }
            }
        }

        // check for diagonal case 1
        for (int i = 0; i < this.board.getSize() - 2; i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(i, j).getGamePiece().equals("S")
                        && this.board.getTile(i + 1, j + 1).getGamePiece().equals("O")
                        && this.board.getTile(i + 2, j + 2).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 1, j + 1)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 2, j + 2)));

                    gameIsOver = true;
                    return;
                }
            }
        }

        // check for diagonal case 2 (other diagonal)
        for (int i = 0; i < this.board.getSize() - 2; i++) {
            for (int j = 0; j < this.board.getSize() - 2; j++) {

                if (this.board.getTile(i, j + 2).getGamePiece().equals("S")
                        && this.board.getTile(i + 1, j + 1).getGamePiece().equals("O")
                        && this.board.getTile(i + 2, j).getGamePiece().equals("S")) {
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i, j + 2)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 1, j + 1)));
                    winningLocations.add(new ArrayList<Integer>(Arrays.asList(i + 2, j)));

                    gameIsOver = true;
                    return;
                }
            }
        }

        // check for full game board, which signals draw
        gameIsDraw = true;
        gameIsOver = true;
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                if (this.board.getTile(i,j).getGamePiece().equals("")) {
                    gameIsDraw = false;
                    gameIsOver = false;
                }
            }
        }


    }


    public Boolean isEndOfGame() {
        findSOS();
        return gameIsOver;
    }


    public ArrayList<ArrayList<Integer>> getWinningLocations() {
        return winningLocations;
    }

    public String getWinner() {
        if (gameIsDraw)
            return "Draw";

        else if (board.isBlueTurn)
            return "Red";

        return "Blue";
    }




}