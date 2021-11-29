package sample;

import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    private JFXPanel jfxPanel = new JFXPanel();


    @Test
    void makeMoveTest1() {
        // tests that the AI only makes one move. No more, no less.

        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(3);
        board.initTiles(3);

        GUI gui = new GUI(new Pane());
        gui.setBoard(board);

        board.gui = gui;

        Player bluePlayer = new Player("S");
        ComputerPlayer redPlayer = new ComputerPlayer();

        board.setBluePlayer(bluePlayer);
        board.setRedPlayer(redPlayer);

        gui.bluePlayerIsAI = false;
        gui.redPlayerIsAI = true;

        gui.simpleGame.isCurrentGameMode = false;
        gui.generalGame.isCurrentGameMode = true;

        board.getTile(0,0).drawS(); // Draws S for the human player
        board.changeTurn(); // changes turn and activates the AI

        int counter = 0;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getTile(i, j).getGamePiece().equals("S") || board.getTile(i, j).getGamePiece().equals("O")) {
                    counter++;
                }
            }
        }

        assertEquals(2, counter);
    }

    @Test
    void makeMoveTest2() {
        // Ensures that the AI completes an SOS

        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(3);
        board.initTiles(3);

        GUI gui = new GUI(new Pane());
        gui.setBoard(board);

        board.gui = gui;

        Player bluePlayer = new Player("S");
        ComputerPlayer redPlayer = new ComputerPlayer();

        board.setBluePlayer(bluePlayer);
        board.setRedPlayer(redPlayer);

        gui.bluePlayerIsAI = false;
        gui.redPlayerIsAI = true;

        gui.simpleGame.isCurrentGameMode = false;
        gui.generalGame.isCurrentGameMode = true;

        board.getTile(0,0).drawS(); // Draws S for the human player
        board.isBlueTurn = false;

        board.getTile(0, 1).drawO(); // Draws O for the AI player (to ensure everything is set up for its next turn)
        board.isBlueTurn = true;

        board.getTile(1, 0).drawS(); // Draw S for human player in a random spot
        board.changeTurn(); //change turn and now activate AI

        assertEquals(1, board.redPlayer.numOfSOS); // asserting that the AI completed the SOS and it is stored correctly

    }

    @Test
    void findFirstSO_CompletionTest() {
        // testing to make sure my findFirstSO_Completion method works as expected

        Board board = new Board(new Player("S"), new Player("S"));
        board.initBoard(3);
        board.initTiles(3);

        GUI gui = new GUI(new Pane());
        gui.setBoard(board);

        board.gui = gui;

        Player bluePlayer = new Player("S");
        ComputerPlayer redPlayer = new ComputerPlayer();

        board.setBluePlayer(bluePlayer);
        board.setRedPlayer(redPlayer);

        gui.bluePlayerIsAI = false;
        gui.redPlayerIsAI = true;

        gui.simpleGame.isCurrentGameMode = false;
        gui.generalGame.isCurrentGameMode = true;

        board.getTile(0,0).drawS();
        board.getTile(0,1).drawO();

        ArrayList<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(0);
        expectedResult.add(2);

        assertEquals(expectedResult, redPlayer.findFirstSO_Completion(board));
    }

}