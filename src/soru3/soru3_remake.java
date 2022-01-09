package soru3;

import java.util.Optional;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class soru3_remake extends Application{
	
	public TextField textfield1 = new TextField();
	public TextField textfield2 = new TextField();
	public TextField txf_secret = new TextField();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}
	
	@Override
	public void start(Stage stage1) throws Exception {
		// TODO Auto-generated method stub
		
		VBox vBox = new VBox ();
		vBox.setSpacing(15);
		vBox.setAlignment(Pos.CENTER);
		
		
		Button randomBut =new Button ("Rasgele sayi uret");
		
		Label label1= new Label ("tahmin ettigi sayi gir 1-20");
		//TextField textfield1 = new TextField();
		textfield1.setMaxWidth(200);
		
		Button checkBut = new Button ("tahmin dogru mu?");
		//TextField textfield2 = new TextField();
		textfield2.setEditable(false);
		textfield2.setMaxWidth(200);
		
		//TextField txf_secret = new TextField();
		txf_secret.setText(""+  0);
		txf_secret.setVisible(false);
		vBox.getChildren().addAll(randomBut, label1, textfield1, checkBut, textfield2, txf_secret);
		
		
		
		 //int magicNo = 0;
		randomBut.setOnAction(new EventHandler<ActionEvent>() {
		      
			  int magicNo;

			public int getMagicNo() {
				return magicNo;
			}

			public void setMagicNo(int magicNo) {
				this.magicNo = magicNo;
			}

			@Override // Override the handle method
		      public void  handle(ActionEvent h) {
		    	
		    	
		  	    Random rand = new Random();
		  	    magicNo=rand.nextInt(20)+1;
		  	    //this.setMagicNo(rand.nextInt(20)+1);
		        
		  	   txf_secret.setText(""+ magicNo);
		  	   
		 
		      }

 
		    });
		
		
		checkBut.setOnAction(new EventHandler<ActionEvent>() {
		      //private int magicNo;
			

			@Override // Override the handle method
		      public void handle(ActionEvent h) {
		         
				testNo+=2;
				int mg = Integer.parseInt(txf_secret.getText());
				//mg = soru3_remake.this.;
		    	  if (Integer.parseInt(textfield1.getText()) == mg ) {
		    		  
		    		  textfield2.setText("correct");
		    		  
		    	  }
		    	  
		    	  else if  (Integer.parseInt(textfield1.getText()) > mg ){
		    		  textfield2.setText("azalt:  " );
		    	 
		    	  }
		    	  
		    	  else {
		    		  textfield2.setText("aratir:  " );
		    	  }
		        
		        
		      }
		    });
		
		
		checkBut.setOnMouseEntered(e ->{
	    	//text1 = new Text(40, 20, "don't touch me!!!");
			checkBut.setTextFill(Color.RED);
	  });
	    
		checkBut.setOnMouseExited(e ->{
	    	checkBut.setTextFill(Color.BLACK);
	  });
		
		
	 
		
		stage1.setOnShowing(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
				System.out.println("rasgele bir sayi uretiniz...");			
				}
			
		});
		
		stage1.setOnHiding(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
				System.out.println("oyun kapatildi");			
				}
			
		});
		
	    
	    // create a alert
	 	Alert a = new Alert(AlertType.NONE);	    
	    stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
 
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
	    
		
		
		
		Scene scene1= new Scene (vBox,300,400);
		stage1.setScene(scene1);
		stage1.setTitle(STYLESHEET_MODENA);
		stage1.show();
		
		
		
	}

	int testNo;
	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public void randomNumberGen (){
		  this.testNo=0;
		  
		  int mg = Integer.parseInt(txf_secret.getText());
			//mg = soru3_remake.this.;
	    	  if (Integer.parseInt(textfield1.getText()) == mg ) {
	    		  
	    		  textfield2.setText("correct");
	    		  
	    	  }
	    	  
	    	  else if  (Integer.parseInt(textfield1.getText()) > mg ){
	    		  textfield2.setText("azalt:  " );
	    	 
	    	  }
	    	  
	    	  else {
	    		  textfield2.setText("artir:  " );
	    	  }
	        
	        
	      }
		 
	}
 
	
	
	
	
 
