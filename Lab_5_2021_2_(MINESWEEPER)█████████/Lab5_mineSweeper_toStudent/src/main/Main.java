package main;

import gui.ControlGridPane;
import gui.ControlPane;
import gui.MineSweeperPane;
import gui.MineSweeperSquare;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setPrefHeight(400);
		root.setPrefWidth(800);
		MineSweeperPane mineSweeperPane = new MineSweeperPane();
		ControlPane controlPane = new ControlPane(mineSweeperPane);
		ControlGridPane controlGridPane = new ControlGridPane(controlPane);
		GameLogic.getInstance().setControlPane(controlPane);
		root.getChildren().addAll(mineSweeperPane, controlGridPane);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MineSweeper");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
