import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private boolean isXTurn = true; // Track whose turn it is
    private Button[][] buttons = new Button[3][3]; // Store buttons for the grid
    private int playerXScore = 0; // Score for Player X
    private int playerOScore = 0; // Score for Player O
    private Label scoreBoard; // Scoreboard label

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("Tic Tac Toe");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold;");

        // Scoreboard
        scoreBoard = new Label("Player X: 0 | Player O: 0");
        scoreBoard.setStyle("-fx-font-size: 18px;");

        HBox displayArea = new HBox(20, title, scoreBoard);
        displayArea.setAlignment(Pos.CENTER);

        // Game Board
        GridPane board = new GridPane();
        board.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        board.setAlignment(Pos.CENTER);
        board.setPrefSize(300, 300);
        board.setHgap(5); // Add horizontal gaps
        board.setVgap(5); // Add vertical gaps

        // Create 3x3 grid of buttons
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new Button();
                buttons[row][col].setPrefSize(100, 100);
                buttons[row][col].setStyle("-fx-font-size: 24px; -fx-border-color: black; -fx-border-width: 1px;");
                buttons[row][col].setOnAction(e -> handleButtonClick((Button) e.getSource()));
                board.add(buttons[row][col], col, row);
            }
        }

        // Layout: BorderPane
        BorderPane root = new BorderPane();
        root.setStyle("-fx-border-color: gray; -fx-border-width: 3px; -fx-padding: 10px;");
        root.setTop(title);
        root.setCenter(board);
        root.setBottom(scoreBoard);

        // Align elements
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setAlignment(scoreBoard, Pos.CENTER);
        GridPane.setAlignment(board, Pos.CENTER);

        // Scene and Stage
        Scene scene = new Scene(root, 400, 450);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handle button clicks
    private void handleButtonClick(Button clickedButton) {
        if (!clickedButton.getText().isEmpty()) {
            // If button is already clicked, do nothing
            return;
        }

        // Place X or O based on the current turn
        clickedButton.setText(isXTurn ? "X" : "O");

        // Check for a winner
        if (checkWinner()) {
            String winner = isXTurn ? "Player X" : "Player O";
            updateScore(winner);
            showAlert(winner + " wins!");
            resetBoard();
        } else if (isBoardFull()) {
            showAlert("It's a draw!");
            resetBoard();
        }

        // Switch turn
        isXTurn = !isXTurn;
    }

    // Check for a winner
    private boolean checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().isEmpty()) {
                return true;
            }

            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().isEmpty()) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().isEmpty()) {
            return true;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().isEmpty()) {
            return true;
        }

        return false;
    }

    // Check if the board is full
    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    // Update score
    private void updateScore(String winner) {
        if (winner.equals("Player X")) {
            playerXScore++;
        } else {
            playerOScore++;
        }
        scoreBoard.setText("Player X: " + playerXScore + " | Player O: " + playerOScore);
    }

    // Reset the board
    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
        isXTurn = true; // Reset turn to Player X
    }

    // Show alert dialog
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
