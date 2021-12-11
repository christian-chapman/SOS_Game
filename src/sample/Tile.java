package sample;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Tile extends StackPane {

    private Text text;
    private Rectangle box;

    private Board board;

    private int row;
    private int column;
    private ArrayList<Integer> cellLocation;

    public Tile(int length, int width, Board board, int row, int column) {
        this.board = board;
        this.text = new Text();
        this.box = new Rectangle(length, width);
        this.box.setFill(null);
        this.box.setStroke(Color.BLACK);
        this.text.setStyle("-fx-font-size: 40;");
        setAlignment(Pos.CENTER);

        cellLocation = new ArrayList<Integer>();
        cellLocation.add(row);
        cellLocation.add(column);

        getChildren().addAll(this.box, text);

        setOnMouseClicked( e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                tileAction();
            }
        });
    }


    public void tileAction() {
        if (board.gui.simpleGame.gameIsOver || board.gui.generalGame.gameIsOver) {
            return;
        }

        if (this.text.getText().isEmpty() && board.isBlueTurn) {

            if (board.bluePlayer.selectedPiece.equals("S"))
                drawS();
            else
                drawO();

            board.bluePlayer.recordMove(cellLocation, board.bluePlayer.selectedPiece);

            board.changeTurn();
        }

        else if (this.text.getText().isEmpty() && !board.isBlueTurn) {

            if (board.redPlayer.selectedPiece.equals("S"))
                drawS();
            else
                drawO();

            board.redPlayer.recordMove(cellLocation, board.redPlayer.selectedPiece);


            board.changeTurn();
        }


    }


    public void drawS() {
        this.text.setText("S");
    }

    public void drawO() {
        this.text.setText("O");
    }

    public String getGamePiece() {
        return this.text.getText();
    }

    public void clearGamePiece() {
        this.text.setText("");
    }

    public double getCenterX() {
        return getTranslateX() + 25;
    }

    public double getCenterY() {
        return getTranslateY() + 30;
    }

}