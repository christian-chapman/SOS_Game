package sample;

import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralGameTest {


    private JFXPanel jfxPanel = new JFXPanel();

    @Test
    void isEndOfGameTest() {

        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(3);
        board.initTiles(3);

        GUI gui = new GUI(new Pane());
        gui.setBoard(board);

        board.gui = gui;

        GeneralGame generalGame = new GeneralGame(board);

        assertFalse(generalGame.isEndOfGame());

        board.getTile(0, 0).drawS();
        board.getTile(0, 1).drawO();
        board.getTile(0, 2).drawS();

        board.getTile(1, 0).drawS();
        board.getTile(1, 1).drawS();
        board.getTile(1, 2).drawS();

        board.getTile(2, 0).drawO();
        board.getTile(2, 1).drawO();
        board.getTile(2, 2).drawS();

        assertTrue(generalGame.isEndOfGame());

    }

    @Test
    void getWinnerTest() {
        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(3);
        board.initTiles(3);

        GeneralGame generalGame = new GeneralGame(board);

        board.getTile(0,0).drawS();
        board.getTile(0,1).drawO();
        board.getTile(0,2).drawS();
        board.bluePlayer.numOfSOS++;

        board.getTile(1,0).drawS();
        board.getTile(1,1).drawO();
        board.getTile(1,2).drawS();
        board.redPlayer.numOfSOS++;

        board.getTile(2,0).drawS();
        board.getTile(2,1).drawO();
        board.getTile(2,2).drawS();
        board.bluePlayer.numOfSOS++;

        assertEquals("Blue", generalGame.getWinner());
    }
}