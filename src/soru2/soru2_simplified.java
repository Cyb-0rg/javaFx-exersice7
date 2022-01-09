package soru2;

 

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;



public class soru2_simplified extends Application{ 
	


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
	    
	    
	
	    btCalculate.setOnAction(e -> calculateNewSalary());

	    
	    tfYillikZamOrani.setOnKeyPressed(e -> keypressedEvent(e,  primaryStage));
	    
	    btCalculate.setOnMouseExited(e -> MouseExited( ));
	    btCalculate.setOnMouseEntered(e -> MouseEntered( ));
	  

	    // create a alert
	 	Alert a = new Alert(AlertType.NONE);

	    primaryStage.setOnCloseRequest(e -> closeReqEvent(e, a));
	    primaryStage.setOnShowing(e -> showingEvent());
	      
		
		  Scene scene = new Scene(gridPane, 550, 300);
		  primaryStage.setTitle("Zam Hesaplayici"); primaryStage.setScene(scene);
		  primaryStage.show();
		 
	    
	  }//start
	
	
	

	private void MouseEntered( ) {
		// TODO Auto-generated method stub
		
		btCalculate.setTextFill(Color.RED);
		
	}

	private void MouseExited( ) {
		// TODO Auto-generated method stub
		btCalculate.setTextFill(Color.BLACK);
	}
	
	

	private void keypressedEvent(KeyEvent e, Stage primaryStage) {
		// TODO Auto-generated method stub
		
		switch (e.getCode()) {
        case E: primaryStage.close();;
        
        ; 
        break;

        default: 
          if (Character.isLetterOrDigit(e.getText().charAt(0)))
            
          	System.out.println ();
   
      } 

	}
	

	private void closeReqEvent(WindowEvent e, Alert a) {
		// TODO Auto-generated method stub
		
		a.setAlertType(AlertType.CONFIRMATION);
		
		a.setTitle("EXIT PROGRAM");
		a.setHeaderText("CONFIRM EXIT");
		a.setContentText("ARE YOU SURE YOU WANT TO EXIT THE PROGRAM?");

		Optional <ButtonType> choice = a.showAndWait();
		if (choice.isPresent() && choice.get() == ButtonType.OK) {
			Platform.exit();
			
		}
		
		else {
			e.consume();
		}		
		
		
	}
	
	

	private void showingEvent() {
		// TODO Auto-generated method stub
		   
		   System.out.println("uygulamaya hos geldiniz");
		
	}
	   
	   
	   

	void calculateNewSalary() {
		  
		    
		    double zamOrani = Double.parseDouble(tfYillikZamOrani.getText());
		    int kidem = Integer.parseInt(tfKidem.getText());
		    double SuankiMaas = Double.parseDouble(tfSuankiMaas.getText());

		    
		    double ZamliMaas = SuankiMaas * ( 1+ ((zamOrani + kidem)/ 100));
   
		    tfZamliMaas.setText(String.format("TL %.2f", ZamliMaas));
 
		
	}

}
