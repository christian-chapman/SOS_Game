package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Pane root = new Pane();
    private Pane initRoot = new Pane();

    private RecordGame recordGame = new RecordGame();

    private Player bluePlayer = new Player("S");
    private Player redPlayer = new Player("S");

    private Scene gameScene = new Scene(root, 500, 500);
    private Scene initScene = new Scene(initRoot, 500, 500);

    private GUI gui = new GUI(root);
    private Board board = new Board (bluePlayer, redPlayer);


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("SOS logo.jpg"));

        board.gui = gui;

        gui.setPrimaryStage(primaryStage);
        gui.setGameScene(gameScene);
        gui.setInitScene(initScene);

        gui.initializeBoardPane(initRoot);
        gui.setBoard(board);

        primaryStage.setScene(initScene);


        primaryStage.setTitle("SOS Game");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}