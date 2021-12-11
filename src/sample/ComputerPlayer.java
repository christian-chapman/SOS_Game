package sample;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    ComputerPlayer() {
        super("S");
    }

    @Override
    public void makeMove(Board board) {
        // goal is to find any almost "SOS" completions, so it will be looking for "SO"s and "S_S"s
        // if no "SO" and "S_S" are found, it will randomly place an S or an O

        ArrayList<Integer> SO_Finish_Location = findFirstSO_Completion(board);
        ArrayList<Integer> SS_Finish_Location = findFirstSS_Completion(board);

        if (SO_Finish_Location.contains(-1) && SS_Finish_Location.contains(-1)) {
            // neither SO or SS were found, place random S or O
            Random rand = new Random();

            int randomInt1, randomInt2;

            do {
                randomInt1 = rand.nextInt(board.getSize());
                randomInt2 = rand.nextInt(board.getSize());
            } while (!board.getTile(randomInt1, randomInt2).getGamePiece().isEmpty());


            if (rand.nextInt(100) % 2 == 0) {// choose whether to draw an S or an O
                board.getTile(randomInt1, randomInt2).drawS();

                ArrayList<Integer> cellLocation = new ArrayList<Integer>();
                cellLocation.add(randomInt1);
                cellLocation.add(randomInt2);

                recordMove(cellLocation, "S");
            }

            else {
                board.getTile(randomInt1, randomInt2).drawO();

                ArrayList<Integer> cellLocation = new ArrayList<Integer>();
                cellLocation.add(randomInt1);
                cellLocation.add(randomInt2);

                recordMove(cellLocation, "O");
            }

        }

        else if (SS_Finish_Location.contains(-1)) {
            // SO was found, place at the spot where the next S goes
            board.getTile(SO_Finish_Location.get(0), SO_Finish_Location.get(1)).drawS();

            recordMove(SO_Finish_Location, "S");

        }

        else {
            // SS was found, place at the spot where the next O goes
            board.getTile(SS_Finish_Location.get(0), SS_Finish_Location.get(1)).drawO();

            recordMove(SS_Finish_Location, "O");
        }
    }


    public ArrayList<Integer> findFirstSO_Completion(Board board) {

        // check all horizontals
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(i, j).getGamePiece().equals("S")
                        && board.getTile(i, j+1).getGamePiece().equals("O")
                        && board.getTile(i, j+2).getGamePiece().equals("")) {
                    ArrayList<Integer> firstSO_Completion = new ArrayList<Integer>();
                    firstSO_Completion.add(i);
                    firstSO_Completion.add(j+2);

                    return firstSO_Completion;
                }

            }
        }

        // check all verticals
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(j, i).getGamePiece().equals("S")
                        && board.getTile(j+1, i).getGamePiece().equals("O")
                        && board.getTile(j+2, i).getGamePiece().equals("")) {
                    ArrayList<Integer> firstSO_Completion = new ArrayList<Integer>();
                    firstSO_Completion.add(j+2);
                    firstSO_Completion.add(i);

                    return firstSO_Completion;
                }
            }
        }

        // check for diagonal case 1
        for (int i = 0; i < board.getSize() - 2; i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(i, j).getGamePiece().equals("S")
                        && board.getTile(i+1, j+1).getGamePiece().equals("O")
                        && board.getTile(i+2, j+2).getGamePiece().equals("")) {
                    ArrayList<Integer> firstSO_Completion = new ArrayList<Integer>();
                    firstSO_Completion.add(i+2);
                    firstSO_Completion.add(j+2);

                    return firstSO_Completion;
                }

            }
        }

        // check for diagonal case 2
        for (int i = 0; i < board.getSize() - 2; i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(i, j+2).getGamePiece().equals("S")
                        && board.getTile(i+1, j+1).getGamePiece().equals("O")
                        && board.getTile(i+2, j).getGamePiece().equals("")) {
                    ArrayList<Integer> firstSO_Completion = new ArrayList<Integer>();
                    firstSO_Completion.add(i+2);
                    firstSO_Completion.add(j);

                    return firstSO_Completion;
                }

            }
        }

        ArrayList<Integer> firstSO_Completion = new ArrayList<Integer>();
        firstSO_Completion.add(-1);

        return firstSO_Completion;
    }

    public ArrayList<Integer> findFirstSS_Completion(Board board) {
        // check all horizontals
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(i, j).getGamePiece().equals("S")
                        && board.getTile(i, j+1).getGamePiece().equals("")
                        && board.getTile(i, j+2).getGamePiece().equals("S")) {
                    ArrayList<Integer> firstSS_Completion = new ArrayList<Integer>();
                    firstSS_Completion.add(i);
                    firstSS_Completion.add(j+1);

                    return firstSS_Completion;
                }

            }
        }

        // check all verticals
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(j, i).getGamePiece().equals("S")
                        && board.getTile(j+1, i).getGamePiece().equals("")
                        && board.getTile(j+2, i).getGamePiece().equals("S")) {
                    ArrayList<Integer> firstSS_Completion = new ArrayList<Integer>();
                    firstSS_Completion.add(j+1);
                    firstSS_Completion.add(i);

                    return firstSS_Completion;
                }
            }
        }

        // check for diagonal case 1
        for (int i = 0; i < board.getSize() - 2; i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(i, j).getGamePiece().equals("S")
                        && board.getTile(i+1, j+1).getGamePiece().equals("")
                        && board.getTile(i+2, j+2).getGamePiece().equals("S")) {
                    ArrayList<Integer> firstSS_Completion = new ArrayList<Integer>();
                    firstSS_Completion.add(i+1);
                    firstSS_Completion.add(j+1);

                    return firstSS_Completion;
                }

            }
        }

        // check for diagonal case 2
        for (int i = 0; i < board.getSize() - 2; i++) {
            for (int j = 0; j < board.getSize() - 2; j++) {
                if (board.getTile(i, j+2).getGamePiece().equals("S")
                        && board.getTile(i+1, j+1).getGamePiece().equals("")
                        && board.getTile(i+2, j).getGamePiece().equals("S")) {
                    ArrayList<Integer> firstSS_Completion = new ArrayList<Integer>();
                    firstSS_Completion.add(i+1);
                    firstSS_Completion.add(j+1);

                    return firstSS_Completion;
                }

            }
        }

        ArrayList<Integer> firstSS_Completion = new ArrayList<Integer>();
        firstSS_Completion.add(-1);

        return firstSS_Completion;
    }

}

