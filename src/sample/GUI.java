package sample;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.lang.Math;
import java.util.ArrayList;

public class GUI {

    private Pane root;
    private Board board;
    private Stage primaryStage;
    private Scene gameScene;
    private Scene initScene;
    public SimpleGame simpleGame;
    public GeneralGame generalGame;

    private int boardSize;

    private ArrayList<Line> allStrikethroughLines;

    private Label blueTurn;
    private Label redTurn;
    private Label bluePlayerLabel;
    private ToggleGroup blue_SO_group;

    private RadioButton blueButtonS;
    private RadioButton blueButtonO;
    private Label redPlayerLabel;
    private ToggleGroup red_SO_group;

    private RadioButton redButtonS;
    private RadioButton redButtonO;
    private Label gameName;
    private ToggleGroup gameModeGroup;

    private RadioButton simpleGameButton;
    private RadioButton generalGameButton;

    private Label generalGameModeLabel;
    private Label simpleGameModeLabel;

    private Button newGame;
    private Label winnerLabel;

    private Label bluePlayerOptionsLabel;
    private Label redPlayerOptionsLabel;

    private ToggleGroup bluePlayerOptionsGroup;
    private ToggleGroup redPlayerOptionsGroup;

    private RadioButton blueComputerPlayerButton;
    private RadioButton blueHumanPlayerButton;

    private RadioButton redComputerPlayerButton;
    private RadioButton redHumanPlayerButton;

    public Boolean bluePlayerIsAI;
    public Boolean redPlayerIsAI;

    GUI(Pane root) {
        this.root = root;

        this.boardSize = 8;

        this.allStrikethroughLines = new ArrayList<Line>();

        this.blueTurn = new Label("Current turn: blue");
        this.redTurn = new Label("Current turn: red");
        this.bluePlayerLabel = new Label("Blue Player");
        this.blue_SO_group = new ToggleGroup();

        this.blueButtonS = new RadioButton("S");
        this.blueButtonO = new RadioButton("O");
        this.redPlayerLabel = new Label("Red Player");
        this.red_SO_group = new ToggleGroup();

        this.redButtonS = new RadioButton("S");
        this.redButtonO = new RadioButton("O");
        this.gameName = new Label("SOS");
        this.gameModeGroup = new ToggleGroup();

        this.simpleGameButton = new RadioButton("Simple Game");
        this.generalGameButton = new RadioButton("General Game");

        this.generalGameModeLabel = new Label("SOS: General Game");
        this.simpleGameModeLabel = new Label("SOS: Simple Game");

        this.newGame = new Button("New Game");


        this.bluePlayerOptionsLabel = new Label("Blue Player");
        this.redPlayerOptionsLabel = new Label("Red Player");

        this.bluePlayerOptionsGroup = new ToggleGroup();
        this.redPlayerOptionsGroup = new ToggleGroup();

        this.blueComputerPlayerButton = new RadioButton("Computer");
        this.blueHumanPlayerButton = new RadioButton("Human");

        this.redComputerPlayerButton = new RadioButton("Computer");
        this.redHumanPlayerButton = new RadioButton("Human");

    }

    public void setBoard(Board board) {
        this.board = board;
        this.simpleGame = new SimpleGame(board);
        this.generalGame = new GeneralGame(board);
    }

    public void setPrimaryStage (Stage primaryStage) { this.primaryStage = primaryStage; }
    public void setGameScene(Scene gameScene) { this.gameScene = gameScene; }
    public void setInitScene(Scene initScene) { this.initScene = initScene; }

    public void initializeBoardPane(Pane initRoot) {


        Label promptBoardSizeLabel = new Label("Select a game board size and a game mode below:");
        promptBoardSizeLabel.setFont(new Font("Arial", 14));
        promptBoardSizeLabel.setTranslateX(100);
        promptBoardSizeLabel.setTranslateY(100);

        Label gameSizeLabel = new Label("test");
        gameSizeLabel.setFont(new Font ("Arial", 14));

        gameSizeLabel.setTranslateX(210);
        gameSizeLabel.setTranslateY(150);

        gameName.setFont(new Font("Arial", 16));
        gameName.setTranslateX(100);
        gameName.setTranslateY(100);

        simpleGameButton.setFont(new Font("Arial", 14));
        simpleGameButton.setToggleGroup(gameModeGroup);
        simpleGameButton.setTranslateX(100 + 40);
        simpleGameButton.setTranslateY(225);
        simpleGameButton.setOnAction( e-> {
            simpleGame.isCurrentGameMode = true;
            generalGame.isCurrentGameMode = false;
        });

        generalGameButton.setFont(new Font("Arial", 14));
        generalGameButton.setToggleGroup(gameModeGroup);
        generalGameButton.setTranslateX(100 + 160);
        generalGameButton.setTranslateY(225);
        generalGameButton.setOnAction( e-> {
            generalGame.isCurrentGameMode = true;
            simpleGame.isCurrentGameMode = false;
        });

        bluePlayerOptionsLabel.setTranslateX(100);
        bluePlayerOptionsLabel.setTranslateY(275);
        bluePlayerOptionsLabel.setFont(new Font("Arial", 14));

        redPlayerOptionsLabel.setTranslateX(325);
        redPlayerOptionsLabel.setTranslateY(275);
        redPlayerOptionsLabel.setFont(new Font("Arial", 14));

        blueComputerPlayerButton.setTranslateX(110);
        blueComputerPlayerButton.setTranslateY(300);
        blueComputerPlayerButton.setFont(new Font("Arial", 13));
        blueComputerPlayerButton.setToggleGroup(bluePlayerOptionsGroup);
        blueComputerPlayerButton.setOnAction( e-> {
            bluePlayerIsAI = true;
            board.setBluePlayer(new ComputerPlayer());

        });

        blueHumanPlayerButton.setTranslateX(110);
        blueHumanPlayerButton.setTranslateY(325);
        blueHumanPlayerButton.setFont(new Font("Arial", 13));
        blueHumanPlayerButton.setToggleGroup(bluePlayerOptionsGroup);
        blueHumanPlayerButton.setOnAction( e-> {
            bluePlayerIsAI = false;
            board.setBluePlayer(new Player("S"));
        });

        redComputerPlayerButton.setTranslateX(335);
        redComputerPlayerButton.setTranslateY(300);
        redComputerPlayerButton.setFont(new Font("Arial", 13));
        redComputerPlayerButton.setToggleGroup(redPlayerOptionsGroup);
        redComputerPlayerButton.setOnAction( e-> {
            redPlayerIsAI = true;
            board.setRedPlayer(new ComputerPlayer());
        });

        redHumanPlayerButton.setTranslateX(335);
        redHumanPlayerButton.setTranslateY(325);
        redHumanPlayerButton.setFont(new Font("Arial", 13));
        redHumanPlayerButton.setToggleGroup(redPlayerOptionsGroup);
        redHumanPlayerButton.setOnAction( e-> {
            redPlayerIsAI = false;
            board.setRedPlayer(new Player("S"));
        });

        Slider boardSizeSlider = new Slider(3, 15, 8.9);
        boardSizeSlider.setLayoutX(175);
        boardSizeSlider.setLayoutY(175);
        boardSizeSlider.setOnMouseReleased( e -> {
            boardSize = (int) boardSizeSlider.getValue();
        });


        gameSizeLabel.textProperty().bind(
                Bindings.createStringBinding(
                        () -> String.format("%s x %s board", String.valueOf((int) boardSizeSlider.getValue()), String.valueOf((int) boardSizeSlider.getValue())),
                        boardSizeSlider.valueProperty()
                )
        );


        Button startGame = new Button("Start Game");
        startGame.setLayoutX(205);
        startGame.setLayoutY(400);

        initRoot.getChildren().addAll(promptBoardSizeLabel, gameSizeLabel, boardSizeSlider, startGame, simpleGameButton, generalGameButton, bluePlayerOptionsLabel, redPlayerOptionsLabel, blueComputerPlayerButton, blueHumanPlayerButton, redComputerPlayerButton, redHumanPlayerButton);


        startGame.setOnAction( e -> {
            board.initBoard(boardSize);

            createBoard();
            createBluePlayerPanel();
            createRedPlayerPanel();
            createGameModeLabel();
            initPlayerTurnLabels();
            displayPlayerTurn(true);
            createNewGameButton();

            primaryStage.setScene(gameScene);
            primaryStage.setWidth(160 + (boardSize + 3) * 50);
            primaryStage.setHeight(60 + (boardSize + 2) * 50);

            board.startAI();
        });

    }


    public void createBoard() {
        int col, row = 0;
        for (int i = 1; i < (boardSize + 1); i++) {
            for (int j = 3; j < (boardSize + 3); j++) {
                Tile tile = new Tile(50,50, board);
                tile.setTranslateX(j * 50);
                tile.setTranslateY(i * 50);

                row = i - 1;
                col = j - 3;
                board.addTile(tile, row, col);
                root.getChildren().add(tile);
            }
        }
    }


    public void createBluePlayerPanel() {
        int x_align = 20;


        bluePlayerLabel.setFont(new Font("Arial", 14));
        bluePlayerLabel.setTranslateX(x_align);
        bluePlayerLabel.setTranslateY(100);


        blueButtonS.setToggleGroup(blue_SO_group);
        blueButtonS.setTranslateX(x_align + 20);
        blueButtonS.setTranslateY(125);
        blueButtonS.setSelected(true);
        blueButtonS.setOnAction( e -> {
            board.bluePlayer.selectedPiece = "S";
        });


        blueButtonO.setToggleGroup(blue_SO_group);
        blueButtonO.setTranslateX(x_align + 20);
        blueButtonO.setTranslateY(150);
        blueButtonO.setOnAction( e -> {
            board.bluePlayer.selectedPiece = "O";
        });

        root.getChildren().addAll(bluePlayerLabel, blueButtonS, blueButtonO);

    }


    public void createRedPlayerPanel() {
        int x_align = 150 + ((boardSize + 1) * 50);


        redPlayerLabel.setFont(new Font("Arial", 14));
        redPlayerLabel.setTranslateX(x_align);
        redPlayerLabel.setTranslateY(100);


        redButtonS.setToggleGroup(red_SO_group);
        redButtonS.setTranslateX(x_align + 20);
        redButtonS.setTranslateY(125);
        redButtonS.setSelected(true);
        redButtonS.setOnAction( e -> {
            board.redPlayer.selectedPiece = "S";
        });


        redButtonO.setToggleGroup(red_SO_group);
        redButtonO.setTranslateX(x_align + 20);
        redButtonO.setTranslateY(150);
        redButtonO.setOnAction( e -> {
            board.redPlayer.selectedPiece = "O";
        });

        root.getChildren().addAll(redPlayerLabel, redButtonS, redButtonO);
    }


    public void createGameModeLabel() {
        int align_x = Math.round(boardSize/2) * 50;
        int align_y = 20;

        simpleGameModeLabel.setFont(new Font("Arial", 18));
        simpleGameModeLabel.setTranslateX(align_x);
        simpleGameModeLabel.setTranslateY(align_y);

        generalGameModeLabel.setFont(new Font("Arial", 18));
        generalGameModeLabel.setTranslateX(align_x);
        generalGameModeLabel.setTranslateY(align_y);

        if (simpleGame.isCurrentGameMode && root.getChildren().contains(generalGameModeLabel) && !root.getChildren().contains(simpleGameModeLabel)) {
            root.getChildren().remove(generalGameModeLabel);
            root.getChildren().add(simpleGameModeLabel);
        }

        else if (simpleGame.isCurrentGameMode && !root.getChildren().contains(generalGameModeLabel)  && !root.getChildren().contains(simpleGameModeLabel)) {
            root.getChildren().add(simpleGameModeLabel);
        }

        else if (generalGame.isCurrentGameMode && root.getChildren().contains(simpleGameModeLabel)  && !root.getChildren().contains(generalGameModeLabel)) {
            root.getChildren().remove(simpleGameModeLabel);
            root.getChildren().add(generalGameModeLabel);
        }

        else if ((generalGame.isCurrentGameMode && !root.getChildren().contains(simpleGameModeLabel)  && !root.getChildren().contains(generalGameModeLabel))) {
            root.getChildren().add(generalGameModeLabel);
        }

    }

    private void initPlayerTurnLabels() {
        int align_x = Math.round(boardSize/2) * 50;

        blueTurn.setFont(new Font("Arial", 18));
        blueTurn.setTranslateX(align_x + 75);
        blueTurn.setTranslateY(25 + (boardSize + 1) * 50);


        redTurn.setFont(new Font("Arial", 18));
        redTurn.setTranslateX(align_x + 75);
        redTurn.setTranslateY(25 + (boardSize + 1) * 50);
    }


    public void displayPlayerTurn(boolean isBlueTurn) {
        if (isBlueTurn) {
            if (root.getChildren().contains(redTurn))
                root.getChildren().remove(redTurn);

            else if (root.getChildren().contains(blueTurn))
                return;

            root.getChildren().add(blueTurn);
        }
        else {
            if (root.getChildren().contains(blueTurn))
                root.getChildren().remove(blueTurn);

            else if (root.getChildren().contains(redTurn))
                return;

            root.getChildren().add(redTurn);

        }

    }

    public void addStrikethroughToPieces(ArrayList<ArrayList<Integer>> SOS_Locations) {
        //draw line between first and last tiles of the SOS

        Line strikethroughLine = new Line();

        strikethroughLine.setStartX(board.getTile(SOS_Locations.get(0).get(0), SOS_Locations.get(0).get(1)).getCenterX());
        strikethroughLine.setStartY(board.getTile(SOS_Locations.get(0).get(0), SOS_Locations.get(0).get(1)).getCenterY());
        strikethroughLine.setEndX(board.getTile(SOS_Locations.get(2).get(0), SOS_Locations.get(2).get(1)).getCenterX());
        strikethroughLine.setEndY(board.getTile(SOS_Locations.get(2).get(0), SOS_Locations.get(2).get(1)).getCenterY());

        strikethroughLine.setStrokeWidth(4);

        if (board.isBlueTurn)
            strikethroughLine.setStroke(Color.RED);
        else
            strikethroughLine.setStroke(Color.BLUE);



        //System.out.println(SOS_Locations);

        allStrikethroughLines.add(strikethroughLine);

        root.getChildren().add(strikethroughLine);


    }

    public void drawWinnerLabel(String winner) {
        int align_x = Math.round(boardSize/2) * 50;
        if (!winner.equals("Draw"))
            winnerLabel = new Label(String.format("%s Won!", winner));
        else
            winnerLabel = new Label("Draw game");

        winnerLabel.setFont(new Font("Arial", 24));
        winnerLabel.setTranslateX(align_x + 75);
        winnerLabel.setTranslateY(25 + (boardSize + 1) * 50);

        if (!board.isBlueTurn)
            root.getChildren().remove(redTurn);
        else
            root.getChildren().remove(blueTurn);

        root.getChildren().addAll(winnerLabel);

    }

    public void changeTurn() {
        displayPlayerTurn(board.isBlueTurn);

        if (simpleGame.isCurrentGameMode) {
            if (simpleGame.isEndOfGame() && simpleGame.gameIsDraw) {
                drawWinnerLabel("Draw");
            }

            else if (simpleGame.isEndOfGame() && !simpleGame.gameIsDraw) {
                addStrikethroughToPieces(simpleGame.getWinningLocations());
                drawWinnerLabel(simpleGame.getWinner());
            }
        }

        else if (generalGame.isCurrentGameMode) {
            if (generalGame.isEndOfGame()) {
                drawWinnerLabel(generalGame.getWinner());
            }
        }
    }


    public void createNewGameButton() {

        newGame.setLayoutX(150 + ((boardSize + 1) * 50));
        newGame.setLayoutY(25 + (boardSize + 1) * 50);

        newGame.setOnAction( e -> {
            //change game mode to whatever is selected

            root.getChildren().removeAll(bluePlayerLabel, blueButtonS, blueButtonO, redPlayerLabel, redButtonS, redButtonO, gameName, simpleGameButton, generalGameButton, newGame);

            if (simpleGame.gameIsOver || generalGame.gameIsOver) {
                root.getChildren().remove(winnerLabel);
                simpleGame.gameIsOver = false;
                generalGame.gameIsOver = false;

            }

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    root.getChildren().remove(board.getTile(i, j));
                }
            }

            for (int i = 0; i < allStrikethroughLines.size(); i++) {
                root.getChildren().remove(allStrikethroughLines.get(i));
            }

            allStrikethroughLines = new ArrayList<Line>();
            generalGame.existingSOS = new ArrayList<ArrayList<ArrayList<Integer>>>();

            board.bluePlayer.resetToDefault();
            board.redPlayer.resetToDefault();



            board.clearBoard();
            primaryStage.setScene(initScene);

            primaryStage.setHeight(500);
            primaryStage.setWidth(500);

        });
        root.getChildren().add(newGame);

    }


}