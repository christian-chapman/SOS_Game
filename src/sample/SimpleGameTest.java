package sample;

import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGameTest {

    @Test
    void isEndOfGameTest() {
        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(8);
        board.initTiles(8);


        SimpleGame simpleGame = new SimpleGame(board);

        assertFalse(simpleGame.isEndOfGame());

        board.getTile(0,0).drawS();
        board.getTile(0,1).drawO();
        board.getTile(0,2).drawS();

        assertTrue(simpleGame.isEndOfGame());
    }

}