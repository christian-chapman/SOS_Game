package sample;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReplayGame {

    private Board board;
    private ArrayList<ArrayList<String>> gameData;
    public int currentIteration;

    ReplayGame(Board board) {
        this.board = board;
        this.gameData = new ArrayList<ArrayList<String>>();
        this.currentIteration = 0;
        readGameData();
    }

    public void play() {
        if (currentIteration >= gameData.size()) {
            return;
        }

        board.gui.bluePlayerIsAI = false;
        board.gui.redPlayerIsAI = false;


        ArrayList<String> cellData = gameData.get(currentIteration);

        if (cellData.get(2).equals("S"))
            board.getTile(Integer.parseInt(cellData.get(0)), Integer.parseInt(cellData.get(1))).drawS();
        else
            board.getTile(Integer.parseInt(cellData.get(0)), Integer.parseInt(cellData.get(1))).drawO();

        board.changeTurn();
        currentIteration++;

    }

    private void readGameData() {
        String rawData = "";
        try {
            rawData = new String(Files.readAllBytes(Paths.get("C:\\Users\\cchap\\IdeaProjects\\SOS_Game\\src\\game_data.txt")));

        } catch (Exception e) {
            System.out.println("Error occurred.");
        }

        String[] modifiedData = rawData.split("\n");

        for (String line : modifiedData) {
            List<String> l =  Arrays.asList(line.split(","));
            gameData.add(new ArrayList<String>(l));
        }
    }

}
