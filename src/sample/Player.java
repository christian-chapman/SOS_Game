package sample;

import java.util.ArrayList;

public class Player {
    public String selectedPiece;
    public int numOfSOS;
    public Boolean isRecordingMoves;
    public RecordGame recordGame;

    Player() {}

    Player(String piece) {
        this.selectedPiece = piece;
        this.numOfSOS = 0;
        this.isRecordingMoves = false;
        this.recordGame = new RecordGame();
    }

    public void resetToDefault() {
        this.selectedPiece = "S";
        this.numOfSOS = 0;
    }

    public void makeMove(Board board) {}

    public void recordMove(ArrayList<Integer> cellLocation, String piece) {
        if (!isRecordingMoves) {
            return;
        }
        if (recordGame != null)
            recordGame.recordCell(cellLocation, piece);
        else {
            System.out.println("howdy");
        }
    }
}