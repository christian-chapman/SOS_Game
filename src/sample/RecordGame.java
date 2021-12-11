package sample;

import java.util.ArrayList;
import java.io.*;

public class RecordGame {

    private File gameFile;

    RecordGame() {
        gameFile = new File("C:\\Users\\cchap\\IdeaProjects\\SOS_Game\\src\\game_data.txt");

        try {
            if (!gameFile.createNewFile()) {
                new FileWriter("C:\\Users\\cchap\\IdeaProjects\\SOS_Game\\src\\game_data.txt", false).close();
            }
        }
        catch (Exception e) {
            System.out.println("Error occurred. See below:");
            System.out.println(e.toString());
        }
    }

    public void recordCell(ArrayList<Integer> cellLocation, String piece) {

        try {
            FileWriter writer = new FileWriter(gameFile, true);

            String data = String.format("%d,%d,%s\n", cellLocation.get(0), cellLocation.get(1), piece);

            writer.write(data);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error occurred. See below:");
            System.out.println(e.toString());
        }

    }


    public void deleteRecording() {
        try {
            new FileWriter("C:\\Users\\cchap\\IdeaProjects\\SOS_Game\\src\\game_data.txt", false).close();
        }
        catch (Exception e) {

        }
    }

}
