package sample;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecordGameTest {

    @Test
    void recordCell() {
        ArrayList<Integer> cell = new ArrayList<Integer>();
        cell.add(0);
        cell.add(1);

        RecordGame recordGame = new RecordGame();

        recordGame.recordCell(cell, "S");

        String rawData = "";
        try {
            rawData = new String(Files.readAllBytes(Paths.get("C:\\Users\\cchap\\IdeaProjects\\SOS_Game\\src\\game_data.txt")));

        } catch (Exception e) {
            System.out.println("Error occurred.");
        }

        assertEquals("0,1,S\n", rawData);
    }
}