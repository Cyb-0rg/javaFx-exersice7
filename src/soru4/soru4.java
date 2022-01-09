package soru4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class soru4 extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
		
 

	}

	@Override
	public void start(Stage stage1) throws Exception {
		// TODO Auto-generated method stub
		
		BorderPane BorderPane = new BorderPane();
	 
		
		
		Button button1 = new Button("TOP"); //
		button1.setMinSize(250, 30);
		//button1.setAlignment(Pos.TOP_CENTER);
		Button button2 = new Button("BOTTOM"); //
		button2.setMinSize(250, 30);
		Button button3 = new Button("CENTER"); //
		button3.setMinSize(125, 70);
		Button button4 = new Button("RIGHT"); //
		button4.setMinSize(25, 90);
		Button button5 = new Button("LEFT"); //
		button5.setMinSize(25, 90);
		
		
		BorderPane.setTop(button1);
		BorderPane.setBottom(button2);
		BorderPane.setRight(button4);
		BorderPane.setLeft(button5);
		BorderPane.setCenter(button3);
		/*
		 * BorderPane.getChildren().add(button1);
		 * 
		 * BorderPane.getChildren().add(button2); BorderPane.getChildren().add(button3);
		 * BorderPane.getChildren().add(button4); BorderPane.getChildren().add(button5);
		 */
		
		
		
		
		Scene scene1= new Scene(BorderPane,250, 150);
		
		stage1.setScene(scene1 );
		stage1.setTitle(STYLESHEET_CASPIAN);
		stage1.show();
		
		
	}

}
