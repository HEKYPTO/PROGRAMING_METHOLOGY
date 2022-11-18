package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {
    private Text gameText = new Text();
    private Button newGameButton = new Button();
    private Button secureModeButton = new Button();
    private MineSweeperPane mineSweeperPane;

    public ControlPane(MineSweeperPane mineSweeperPane) {
        setMineSweeperPane(mineSweeperPane);
        setAlignment(Pos.CENTER);
        setPrefWidth(300);
        setSpacing(20);
        initializeGameText();
        initializeNewGameButton();
        initializeSecureModeButton();
        getChildren().add(gameText);
        getChildren().add(newGameButton);
        getChildren().add(secureModeButton);
    }

    private void initializeGameText() {
        gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
        gameText.setFont(new Font(35));
    }

    public void updateGameText(String text) {
        this.gameText.setText(text);
    }

    private void initializeNewGameButton() {
        newGameButton.setText("New Game");
        newGameButton.setPrefWidth(100);
        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newGameButtonHandler();
            }
        });
    }

    private void initializeSecureModeButton() {
        secureModeButton.setText("Secure mode : OFF");
        secureModeButton.setPrefWidth(150);
        secureModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secureModeButtonHandler();
            }
        });
    }

    public void newGameButtonHandler() {
        GameLogic.getInstance().newGame();
        secureModeButton.setText("Secure mode : OFF");
        gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
        for (MineSweeperSquare square: mineSweeperPane.getAllCells()) {
            square.initializeCellColor();
        }
    }

    public void secureModeButtonHandler() {
        GameLogic.getInstance().toggleSecureMode();
        if (!GameLogic.getInstance().isSecureMode()) {
            secureModeButton.setText("Secure mode : OFF");
        } else {
            secureModeButton.setText("Secure mode : ON");
        }
    }

    public MineSweeperPane getMineSweeperPane() {
        return mineSweeperPane;
    }

    public void setMineSweeperPane(MineSweeperPane mineSweeperPane) {
        this.mineSweeperPane = mineSweeperPane;
    }
}