package sample;

import javafx.scene.layout.Pane;
import javafx.scene.control.*;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @org.junit.jupiter.api.Test
    void drawS() {
        Board board = new Board(new Player("S"), new Player("S"));
        Tile tile = new Tile(50, 50, board, 0, 0);
        tile.drawS();
        assertEquals("S", tile.getGamePiece());
    }

    @org.junit.jupiter.api.Test
    void drawO() {
        Board board = new Board(new Player("S"), new Player("S"));
        Tile tile = new Tile(50, 50, board, 0, 0);
        tile.drawO();
        assertEquals("O", tile.getGamePiece());
    }

    @org.junit.jupiter.api.Test
    void getGamePiece() {
        Board board = new Board(new Player("S"), new Player("S"));
        Tile tile = new Tile(50, 50, board, 0, 0);
        tile.drawS();
        assertEquals("S", tile.getGamePiece());
    }

    @org.junit.jupiter.api.Test
    void TileActionTest1() {
        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(8);
        board.gui = new GUI(new Pane());

        Tile tile = new Tile(50, 50, board, 0 ,0);
        tile.tileAction();
        assertEquals("S", tile.getGamePiece());
    }

    @org.junit.jupiter.api.Test
    void TileActionTest2() {
        Board board = new Board(new Player("S"), new Player("O"));
        board.initBoard(8);
        board.gui = new GUI(new Pane());

        Tile tile = new Tile(50, 50, board,0 ,0);
        tile.tileAction();
        tile.tileAction(); // simulates it being clicked when it has already been clicked once
        assertEquals("S", tile.getGamePiece());
    }
}