package sample;

public class Player {
    public String selectedPiece;
    public int numOfSOS;

    Player() {}

    Player(String piece) {
        this.selectedPiece = piece;
        this.numOfSOS = 0;
    }

    public void resetToDefault() {
        this.selectedPiece = "S";
        this.numOfSOS = 0;
    }

    public void makeMove(Board board) {}

}