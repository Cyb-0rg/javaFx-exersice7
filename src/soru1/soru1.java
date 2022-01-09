package soru1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class soru1 extends Application{
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
		

	}
	 
	
	private Parent createContent_hbox() {
		
		
		
		HBox hBox = new HBox();
		hBox.setPrefSize(300, 40);
		hBox.setSpacing(15);
		hBox.setAlignment(Pos.CENTER); 
		
		
		
		//TextField text= new TextField(); //how to get an ID XX
		
		
		Button start = new Button("start"); //
		Button continue1 = new Button("1-continue"); //
		Button continue2 = new Button("2-continue"); //
		Button finish = new Button("finish"); //
		hBox.getChildren().addAll(start, continue1,continue2,finish); //all are buttons
		//Label space = new Label("  ");
		
		
		//////////////////
		
		start.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent h) {
		        System.out.println("start clicked");
		      }
		    });
		
		continue1.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent h) {
		        System.out.println("I'm the middle but close to start");
		      }
		    });
		
		continue2.setOnAction(new EventHandler<ActionEvent>() { 
		      @Override // Override the handle method
		      public void handle(ActionEvent h) {
		        System.out.println("I'm the middle but close to finish");
		      }
		    });
		
		finish.setOnAction(new EventHandler<ActionEvent>() {
		      @Override // Override the handle method
		      public void handle(ActionEvent h) {
		        System.out.println("finish clicked");
		      }
		    });
 
		return hBox;
 
	}
 
	@Override
	public void start(Stage stage1) throws Exception {
		// TODO Auto-generated method stub
 
		
		//////////////////// Scene
		
		Scene scene1 =new Scene(createContent_hbox(), 300, 50); //Hbox is packed
		stage1.setScene(scene1);		 
		//stage1.setScene(new Scene(createContent_hbox(), 300, 50));
		stage1.setTitle(STYLESHEET_CASPIAN);
		//stage1.set
		stage1.show();
		
	}



}
