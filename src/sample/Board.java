package sample;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Board {

    private ArrayList<ArrayList<Tile>> board;

    public GUI gui;

    public Player bluePlayer;
    public Player redPlayer;

    public boolean isBlueTurn;

    Board(Player blue, Player red) {
        this.bluePlayer = blue;
        this.redPlayer = red;
    }

    public void setBluePlayer(Player blue) {
        this.bluePlayer = blue;
    }

    public void setRedPlayer(Player red) {
        this.redPlayer = red;
    }

    public void initBoard(int size) {
        this.board = new ArrayList<ArrayList<Tile>>();
        this.isBlueTurn = true;

        for (int i = 0; i < size; i++) {
            this.board.add(new ArrayList<Tile>());
        }
    }

    public void initTiles(int boardSize) {
        for (int i = 0; i < (boardSize); i++) {
            for (int j = 0; j < (boardSize); j++) {
                addTile(new Tile(50, 50, this), i, j);
            }
        }
    }

    public void changeTurn() {
        isBlueTurn = !isBlueTurn;

        gui.changeTurn();

        if ((gui.simpleGame.isCurrentGameMode && !gui.simpleGame.gameIsOver || gui.generalGame.isCurrentGameMode && !gui.generalGame.gameIsOver)) {
            if (isBlueTurn && gui.bluePlayerIsAI) {
                bluePlayer.makeMove(this);


                changeTurn();
            }

            else if (!isBlueTurn && gui.redPlayerIsAI) {
                redPlayer.makeMove(this);


                changeTurn();
            }
        }

    }

    public void startAI() {
        if (gui.bluePlayerIsAI) {
            bluePlayer.makeMove(this);

            changeTurn();
        }
    }


    public void addTile(Tile tile, int row, int col) {
        this.board.get(row).add(col, tile);
    }

    public Tile getTile(int row, int col) {
        return this.board.get(row).get(col);
    }

    public int getSize() {
        return this.board.size();
    }

    public void clearBoard() {
        this.board.clear();

    }

}