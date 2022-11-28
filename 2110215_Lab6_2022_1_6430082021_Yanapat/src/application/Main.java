package application;

import component.KeyboardPane;
import component.PlayerPane;
import component.TimerPane;
import component.TurnPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.GameLogic;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {	
		GameLogic.init();
		
		StackPane root = new StackPane();
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Scene scene = new Scene(root, 854,512);
		
		VBox mainVBox = new VBox();
		mainVBox.setAlignment(Pos.TOP_CENTER);
		
		HBox topPane = new HBox();
		
		TimerPane tp1 = new TimerPane(0);
		TimerPane tp2 = new TimerPane(1);
		
		TurnPane turn = new TurnPane();
		
		GameLogic.setTimerPane(0, tp1);
		GameLogic.setTimerPane(1, tp2);
		GameLogic.setTurnPane(turn);
		
		topPane.setPrefWidth(854);
		topPane.setAlignment(Pos.CENTER);
		
		topPane.getChildren().add(tp1);
		topPane.getChildren().add(turn);
		topPane.getChildren().add(tp2);
		
		mainVBox.getChildren().add(topPane);
		
		//============Set up Middle Pane=========
		PlayerPane p1 = new PlayerPane(0);
		PlayerPane p2 = new PlayerPane(1);
		
		GameLogic.setPlayerPane(0, p1);
		GameLogic.setPlayerPane(1, p2);
		
		HBox middlePane = new HBox();
		middlePane.setPrefWidth(854);
		middlePane.setAlignment(Pos.CENTER);
		
		middlePane.getChildren().add(p1);
		middlePane.getChildren().add(p2);
		
		mainVBox.getChildren().add(middlePane);
		//=========================================
		
		KeyboardPane kb = new KeyboardPane();
		
		GameLogic.setKeyPane(kb);
		
		mainVBox.getChildren().add(kb);
		
		//Canvas canvas = new Canvas(854,480);
		root.getChildren().add(mainVBox);
		
		primaryStage.setTitle("Word Royale");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		GameLogic.prepareTurns(0);
		
		//This is so all the threads exits properly upon closing the program.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		       @Override
		       public void handle(WindowEvent e) {
		          Platform.exit();
		          System.exit(0);
		       }
		    });
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
