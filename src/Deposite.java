
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Deposite {

	
	String temp_money;
	TextField txt_account,txt_amount;

	Stage stage;
	
		Deposite(){
			
			Stage Home_stage = new Stage();
			stage=Home_stage;
			Home_stage.setWidth(580);
			Home_stage.setHeight(720);
			Home_stage.setResizable(false);
			Home_stage.setTitle("International Bank - DEPOSITE");
			Group root = new Group();
			addComponent(root);
			Scene Home_Scene = new Scene(root,Color.DARKSEAGREEN);
			Home_stage.setScene(Home_Scene);
			Home_stage.show();
		}
		
		
		private void addComponent(Group root) {
			Text lbl_deposite = new Text("Deposite");
			lbl_deposite.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,60));
			lbl_deposite.setFill(Color.WHITE);
			lbl_deposite.setStroke(Color.DARKBLUE);
			lbl_deposite.setTranslateX(150);
			lbl_deposite.setTranslateY(100);
			
			Image img = new Image("file://../Images/deposite.jpg");
			ImageView imgv = new ImageView(img);
			imgv.setFitWidth(800);
			imgv.setFitHeight(720);
			imgv.setTranslateX(-150);
			
			
			Text lbl_account = new Text("Account Number");
			lbl_account.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,30));
			lbl_account.setTranslateX(70);
			lbl_account.setTranslateY(240);
			lbl_account.setFill(Color.WHITE);
			lbl_account.setStroke(Color.DARKBLUE);
			
			txt_account = new TextField();
			txt_account.setTranslateX(70);
			txt_account.setTranslateY(250);
			txt_account.setPrefWidth(360);
			txt_account.setPrefHeight(45);
			txt_account.setPromptText("Account Number");
			txt_account.setStyle("-fx-background-color:white;  -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
			
			Text lbl_amount = new Text("Amount");
			lbl_amount.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,30));
			lbl_amount.setTranslateX(70);
			lbl_amount.setTranslateY(350);
			lbl_amount.setFill(Color.WHITE);
			lbl_amount.setStroke(Color.DARKBLUE);
			
			txt_amount = new TextField();
			txt_amount.setTranslateX(70);
			txt_amount.setTranslateY(360);
			txt_amount.setPrefWidth(230);
			txt_amount.setPrefWidth(360);
			txt_amount.setPrefHeight(45);
			txt_amount.setPromptText("Amount");
			txt_amount.setStyle("-fx-background-color:white;  -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
			
			
			Button btn_deposite = new Button("Deposite");
			btn_deposite.setTranslateX(70);
			btn_deposite.setTranslateY(420);
			btn_deposite.setPrefWidth(360);
			btn_deposite.setPrefHeight(45);
			btn_deposite.setStyle("-fx-background-color:white;  -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");

			btn_deposite.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					
					if (validateFields()) 
					{
						if (checkData()) {
				
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Deposited");
						alert.setHeaderText("Thanks for Deposite");
						alert.setContentText(temp_money+"$ has been deposited in your account");
						alert.showAndWait();
						stage.close();
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Incorrect Account");
						alert.setContentText("Your account number is incorrect");
						alert.showAndWait();
						stage.close();
					}
					
					}

				}		
				
			});
			root.getChildren().addAll(imgv,lbl_deposite,lbl_account,txt_account,lbl_amount,txt_amount,btn_deposite);
			
		}// end of addComponents
		
		private boolean validateFields() {
			if (txt_account.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Field");
				alert.setHeaderText(null);
				alert.setContentText("Please Enter Acount");
				alert.showAndWait();
				return false;
			}
			if (txt_amount.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Field");
				alert.setHeaderText(null);
				alert.setContentText("Please Add Amount");
				alert.showAndWait();
				return false;
			}
			return true;

		}// end of validateFields
	
		private boolean checkData() {
				
			 int dipUserAccNum = Integer.parseInt(txt_account.getText());
	         int dipUserAccBal = Integer.parseInt(txt_amount.getText());
		    		
		    try {	
		 
		    	if(MainPage.account[MainPage.takeAccNum].accountNumber == dipUserAccNum &&  dipUserAccBal <= 0) {	
		    				
		    		return false;
		    	}
		    			
		    	else if(MainPage.account[MainPage.takeAccNum].accountNumber == dipUserAccNum &&  dipUserAccBal > 0) {
		    				
		    		MainPage.deposit(dipUserAccNum, dipUserAccBal);
		    				
		    		temp_money = Integer.toString(dipUserAccBal);
		    				
		    		return true;
		    	}
		    			 
		    	}catch(Exception e) {
		    		
		    		System.out.println(e);
		    	}
		            return false;
				
			}  //end of checkData
		 
}
