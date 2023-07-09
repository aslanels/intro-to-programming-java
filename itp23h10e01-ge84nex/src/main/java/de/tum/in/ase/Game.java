package de.tum.in.ase;

import de.tum.in.ase.logic.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Game extends Application {
    private GameBoard gameBoard;
    private Hero hero;
    private GridPane gridPane = new GridPane();
    private Button[][] buttons = new Button[SIZE_X][SIZE_Y];
    private List<Button> directionButtons;
    private List<Button> specialDirectionButtons;
    private HBox firstControlButtonsRow;
    private HBox secondControlButtonsRow;

    // Constants used for configuration/setup.
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;
    private Scene scene;
    private Stage stage;
    private static final double BUTTON_SIZE = 70;
    private static final double SCENE_WIDTH = 400;
    private static final double SCENE_HEIGHT = 550;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        // Do not change the hero type.
        this.hero = new Mage(this);
        this.gameBoard = new GameBoard(SIZE_X, SIZE_Y);

        // Initialization of the gameBoard visualization.
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        for (int row = 0; row < SIZE_Y; row++) {
            for (int col = 0; col < SIZE_X; col++) {
                Button button = new Button();
                button.setTextAlignment(TextAlignment.CENTER);
                button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                gridPane.add(button, col, row);
                buttons[col][row] = button;
            }
        }
        scene = new Scene(gridPane, SCENE_WIDTH, SCENE_HEIGHT);


        // Movement buttons configuration.
        directionButtons = new ArrayList<>();

        Button up = new Button("Up");
        Button down = new Button("Down");
        Button left = new Button("Left");
        Button right = new Button("Right");

        directionButtons.add(up);
        directionButtons.add(down);
        directionButtons.add(left);
        directionButtons.add(right);

        applyStyleForButtons(directionButtons);
        addDirectionButtonsFunctionality();

        // Ability buttons configuration.
        specialDirectionButtons = new ArrayList<>();

        Button sUp = new Button("Special Up");
        Button sDown = new Button("Special Down");
        Button sLeft = new Button("Special Left");
        Button sRight = new Button("Special Right");

        specialDirectionButtons.add(sUp);
        specialDirectionButtons.add(sDown);
        specialDirectionButtons.add(sLeft);
        specialDirectionButtons.add(sRight);

        applyStyleForButtons(specialDirectionButtons);
        addSpecialDirectionButtonsFunctionality();


        // Add an HBox for the movement buttons

        firstControlButtonsRow = new HBox();
        firstControlButtonsRow.setSpacing(5);
        firstControlButtonsRow.setAlignment(Pos.CENTER);
        firstControlButtonsRow.getChildren().addAll(up, down, left, right);

        // Add an HBox for the ability buttons
        secondControlButtonsRow = new HBox();
        secondControlButtonsRow.setSpacing(5);
        secondControlButtonsRow.setAlignment(Pos.CENTER);
        secondControlButtonsRow.getChildren().addAll(sUp, sDown, sRight, sLeft);

        // Add them to a VBox
        VBox vBox = new VBox();
        vBox.getChildren().addAll(firstControlButtonsRow, secondControlButtonsRow);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        // Add the VBox to the gridPane.
        gridPane.add(vBox, 0, SIZE_Y + 1, 5, 2);

        // Stage setup.
        stage.setScene(scene);
        stage.setTitle("Game");
        stage.setResizable(false);
        stage.show();

        // Displaying actual game status.
        updateUI();
    }

    /**
     * Applies custom (inline) css to the buttons.
     *
     * @param buttonsList List of the buttons without styles.
     */
    private void applyStyleForButtons(List<Button> buttonsList) {
        // TODO: Task 1.2, Movement buttons configuration.
        String buttonStyle = "-fx-background-color: #b482cb; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-font-size: 14px; "
                + "-fx-font-weight: bold; ";
        for (Button button : buttonsList) {
            button.setStyle(buttonStyle);
        }

    }

    /**
     * Adds functionality to specified direction buttons.
     * When a direction button is clicked, it will call the move method with the corresponding direction and then update the UI.
     */
    private void addDirectionButtonsFunctionality() {
        // TODO: Task 1.2, Movement buttons configuration.
        for (Button button: directionButtons) {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String direction = button.getText();
                    try {
                        move(direction.charAt(0));
                        updateUI();
                    } catch (IllegalMoveException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    }

    /**
     * Adds functionality to specified hero's special ability buttons.
     * When a hero's special ability button is clicked, it will call the hero's special ability method with the corresponding direction and then update the UI.
     */
    private void addSpecialDirectionButtonsFunctionality() {
        // TODO: Task 1.3, Ability buttons configuration.
        for (Button button: specialDirectionButtons) {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String direction = button.getText();
                    try {
                        hero.useSpecialPower(direction.charAt(8));
                        updateUI();
                        if (isWon()) {
                            informationAlert("You won!", "You won the game!");
                            restart();
                        }
                        if (gameBoard.get(hero.getPosX(), hero.getPosY()) == 'M') {
                            informationAlert("You died!", "A monster has killed you!");
                            restart();
                        }



                    } catch (IllegalMoveException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    /**
     * Updates the current game status by updating text of the buttons in the
     * gridPane.
     */
    private void updateUI() {
        for (int i = 0; i < gameBoard.getSizeX(); i++) {
            for (int j = 0; j < gameBoard.getSizeY(); j++) {
                 buttons[i][j].setText(String.valueOf(gameBoard.get(i, j)));
            }
        }
    }

    /**
     * Moves the character on the gameBoard in the indicated direction.
     *
     * @param direction Direction to move.
     * @throws IllegalMoveException Thrown if unsupported move has been detected.
     */
    public void move(char direction) throws IllegalMoveException {
        int deltaX = 0;
        int deltaY = 0;
        if (direction == 'L') {
            deltaX = -1;
            if (this.hero.getPosX() == 0) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move left, out of bounds!");
            }
        } else if (direction == 'R') {
            deltaX = 1;
            if (this.hero.getPosX() == this.gameBoard.getSizeX() - 1) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move right, out of bounds!");
            }
        } else if (direction == 'U') {
            deltaY = -1;
            if (this.hero.getPosY() == 0) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move up, out of bounds!");
            }
        } else if (direction == 'D') {
            deltaY = 1;
            if (this.hero.getPosY() == this.gameBoard.getSizeY() - 1) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move down, out of bounds!");
            }
        }
        if (this.gameBoard.get(this.hero.getPosX() + deltaX, this.hero.getPosY() + deltaY) == 'M') {
            informationAlert("You died!", "A monster has killed you!");
            restart();
        }
        this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), '_');
        this.hero.setPosX(this.hero.getPosX() + deltaX);
        this.hero.setPosY(this.hero.getPosY() + deltaY);
        this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), 'H');
        if (isWon()) {
            informationAlert("You won!", "You won the game!");
            restart();
        }
    }

    private void restart() {
        stage.close();
        Game game = new Game();
        game.start(stage);
    }

    /**
     * Shows user information alert.
     *
     * @param title   Title of the alert window.
     * @param content Content text of the alert.
     */
    private void informationAlert(String title, String content) {
        // TODO: Task 2.2, Displaying information alerts.
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Verify if the hero reached the goal.
     *
     * @return Result of the verification.
     */
    public boolean isWon() {
        return gameBoard.get(gameBoard.getSizeX() - 1, gameBoard.getSizeY() - 1) == 'H' && this.hero.getPosX() == gameBoard.getSizeX() - 1 && this.hero.getPosY() == gameBoard.getSizeY() - 1;
    }

    // Required for logic.
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    // Required for logic.
    public Hero getHero() {
        return this.hero;
    }

}
