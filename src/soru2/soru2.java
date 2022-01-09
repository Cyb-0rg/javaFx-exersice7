package soru2;

 

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;



public class soru2 extends Application{ 
	


	  TextField tfYillikZamOrani = new TextField(); 
	  TextField tfKidem = new TextField();
	  TextField tfSuankiMaas = new TextField();
	  TextField tfZamliMaas = new TextField();
	  Button btCalculate = new Button("Hesapla");
	  Label lbYillikZamOrani = new Label("Yillik zam Orani:");
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		launch(args);	

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		

		GridPane gridPane = new GridPane();
		
		
		 
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setAlignment(Pos.CENTER);
	    
	 
	    
	    gridPane.add(new Label("*maas miktari, zam orani ve kidem biigisini giriniz"), 0, 0);
	    gridPane.add(lbYillikZamOrani, 0, 1);
	    gridPane.add(tfYillikZamOrani, 1, 1);
	    gridPane.add(new Label("kidem:"), 0, 2);
	    gridPane.add(tfKidem, 1, 2);
	    gridPane.add(new Label("suanki maas:"), 0, 3);
	    gridPane.add(tfSuankiMaas, 1, 3);
	    gridPane.add(new Label("Zamli Maasi:"), 0, 4);
	    gridPane.add(tfZamliMaas, 1, 4);
	    gridPane.add(btCalculate, 1, 6);
	    
	     
	    tfZamliMaas.setEditable(false); 
	    
	    
	    //lamda
	    btCalculate.setOnAction(e -> calculateNewSalary());
	    
		
	    tfYillikZamOrani.setOnKeyPressed(e -> {          
	        switch (e.getCode()) {
	          case E:  System.out.println("E key basildi, program sonladi");
	          
	          ; 
	          break;
 
	          default: 
	            if (Character.isLetterOrDigit(e.getText().charAt(0)))
	              //System.out.println (e.getText());
	            	System.out.println ();
	              
	               
	              
	        }
	    });
	    
	    
	    
	    
	    btCalculate.setOnMouseEntered(e ->{
	    	//text1 = new Text(40, 20, "don't touch me!!!");
	        btCalculate.setTextFill(Color.RED);
	  });
	    
	    btCalculate.setOnMouseExited(e ->{
	    	btCalculate.setTextFill(Color.BLACK);
	  });
	  
	    
	    btCalculate.addEventHandler(MouseEvent.ANY,  new EventHandler<MouseEvent>() {
	    	

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(arg0.getEventType());
			}
	    	
	    });
	    
	    primaryStage.addEventHandler(WindowEvent.ANY,  new EventHandler<WindowEvent>() {
	    	

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(arg0.getEventType());
			}
	    	
	    });
	    
	    
	    // create a alert
	 	Alert a = new Alert(AlertType.NONE);	    
	    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
 
			@Override
			public void handle(WindowEvent arg0) {
				//primaryStage.hide();
				//System.out.println("uygulama kapandi");
				
				// set alert type
				a.setAlertType(AlertType.CONFIRMATION);
				a.setTitle("EXIT PROGRAM");
				a.setHeaderText("CONFIRM EXIT");
				a.setContentText("ARE YOU SURE YOU WANT TO EXIT THE PROGRAM?");

				Optional <ButtonType> choice = a.showAndWait();
				if (choice.isPresent() && choice.get() == ButtonType.OK) {
					Platform.exit();
					
				}
				
				else {
					arg0.consume();
				}
				
				// show the dialog
				//a.show();
				
			}
		});
	    
	    
	    
		
		  primaryStage.setOnShowing(new EventHandler<WindowEvent>() {
		  
		  @Override 
		  public void handle(WindowEvent arg0) {
			  //primaryStage.hide();
			  System.out.println("uygulamaya hos geldiniz");
			  } });
		 
	    
	   
	    
	    
		
	     
		
		  Scene scene = new Scene(gridPane, 550, 300);
		  primaryStage.setTitle("Zam Hesaplayici"); primaryStage.setScene(scene);
		  primaryStage.show();
		 
	    
	  }//start

	   
	   
	   

	void calculateNewSalary() {
		  
		    
		    double zamOrani = Double.parseDouble(tfYillikZamOrani.getText());
		    int kidem = Integer.parseInt(tfKidem.getText());
		    double SuankiMaas = Double.parseDouble(tfSuankiMaas.getText());

		    
		    double ZamliMaas = SuankiMaas * ( 1+ ((zamOrani + kidem)/ 100));
   
		    tfZamliMaas.setText(String.format("TL %.2f", ZamliMaas));
 
		
	}

}
