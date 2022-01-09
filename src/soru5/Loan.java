package soru5;

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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Loan extends Application{
	
	  TextField tfAnnualInterestRate = new TextField(); 
	  TextField tfNumberOfYears = new TextField();
	  TextField tfLoanAmount = new TextField();
	  TextField tfMonthlyPayment = new TextField();
	  TextField tfTotalPayment = new TextField();
	  Button btCalculate = new Button("Hesapla");
	 // private Label announce = new Label (""); 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch (args);
	}//main exe

 
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		

		GridPane gridPane = new GridPane();
		
		
		 
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setAlignment(Pos.CENTER);
	    
	 
	    
	    gridPane.add(new Label("*kredi miktari, faiz orani ve yili giriniz"), 0, 0);
	    gridPane.add(new Label("Yillik Faiz Orani:"), 0, 1);
	    gridPane.add(tfAnnualInterestRate, 1, 1);
	    gridPane.add(new Label("Yil sayisi:"), 0, 2);
	    gridPane.add(tfNumberOfYears, 1, 2);
	    gridPane.add(new Label("Kredi Miktari:"), 0, 3);
	    gridPane.add(tfLoanAmount, 1, 3);
	    gridPane.add(new Label("Aylik Odeme:"), 0, 4);
	    gridPane.add(tfMonthlyPayment, 1, 4);
	    gridPane.add(new Label("Toplam Odeme:"), 0, 5);
	    gridPane.add(tfTotalPayment, 1, 5);
	    gridPane.add(btCalculate, 1, 6);
	    
	    tfMonthlyPayment.setEditable(false);
	    tfTotalPayment.setEditable(false); 
	    
	    //lamda
	    btCalculate.setOnAction(e -> calculateLoanPayment());
		
	    
	    btCalculate.setOnMouseEntered(e ->{
	    	//text1 = new Text(40, 20, "don't touch me!!!");
	        btCalculate.setTextFill(Color.RED);
	        
	  });
	    
	    btCalculate.setOnMouseExited(e ->{
	    	btCalculate.setTextFill(Color.BLACK);
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
			}
		});
	    
	  
		
	     
	    Scene scene = new Scene(gridPane, 400, 300);
	    primaryStage.setTitle("Kredi Hesaplayici"); 
	    primaryStage.setScene(scene);  
	    primaryStage.show();  
	    
	  }//start
	

	   void calculateLoanPayment() {
		  
		    
		    double interest = Double.parseDouble(tfAnnualInterestRate.getText());
		    int year = Integer.parseInt(tfNumberOfYears.getText());
		    double loanAmount = Double.parseDouble(tfLoanAmount.getText());

		    
		    double monthlyInterestRate = interest / 1200;
		    double monthlyPayment = loanAmount * monthlyInterestRate
					/ (1 - (1 / Math.pow(1 + monthlyInterestRate, year * 12)));
		    
		    double totalPayment = monthlyPayment * year * 12;
		    

		    tfMonthlyPayment.setText(String.format("TL %.3f", monthlyPayment ));
		    tfTotalPayment.setText(String.format("TL %.2f",totalPayment));
		    
		  }
	
	
	
		
		
	}//Main class 
	
	


