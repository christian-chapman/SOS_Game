package sample;

import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReplayGameTest {

    private JFXPanel jfxPanel = new JFXPanel();


    @Test
    void play() {

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

        ArrayList<Integer> cell = new ArrayList<Integer>();
        cell.add(0);
        cell.add(1);

        RecordGame recordGame = new RecordGame();

        recordGame.recordCell(cell, "S");

        ReplayGame replayGame = new ReplayGame(board);

        replayGame.play();

        assertEquals("S", board.getTile(0,1).getGamePiece());

    }
}