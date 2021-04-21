
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

public class CheckBalance {

	String  temp_AccNo,temp_name,temp_gender,temp_money;
	TextField txt_account;
	Stage stage;
	
	
	CheckBalance(){
		
		Stage Home_stage = new Stage();
		stage=Home_stage;
		Home_stage.setWidth(500);
		Home_stage.setHeight(720);
		Home_stage.setResizable(false);
		Home_stage.setTitle("internationalBank - BALANCE CHECK");
		
		
		Group root = new Group();
		addComponent(root);
		
		Scene Home_Scene = new Scene(root,Color.LIGHTGREEN);
		
		Home_stage.setScene(Home_Scene);
		Home_stage.show();
	}
	
	private void addComponent(Group root) {
		Text lbl_title = new Text("Balance Info");
		lbl_title.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,60));
		lbl_title.setFill(Color.WHITE);
		lbl_title.setStroke(Color.DARKBLUE);
		lbl_title.setTranslateX(90);
		lbl_title.setTranslateY(100);
		
		Image img = new Image("file://../Images/checkbalance.jpg");
		ImageView imgv = new ImageView(img);
		imgv.setFitWidth(900);
		imgv.setFitHeight(720);
		
		
		Text lbl_account = new Text("Account Number");
		lbl_account.setFont(Font.font("",FontWeight.BOLD,FontPosture.REGULAR,30));
		lbl_account.setTranslateX(70);
		lbl_account.setTranslateY(350);
		lbl_account.setFill(Color.WHITE);
		lbl_account.setStroke(Color.DARKBLUE);
		
		txt_account = new TextField();
		txt_account.setTranslateX(70);
		txt_account.setTranslateY(380);
		txt_account.setPrefWidth(360);
		txt_account.setPrefHeight(45);
		txt_account.setPromptText("Account Number");
		txt_account.setStyle("-fx-background-color:white;  -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
		
		Button btn = new Button("Check");
		btn.setTranslateX(70);
		btn.setTranslateY(440);
		btn.setPrefWidth(360);
		btn.setPrefHeight(45);
		btn.setStyle("-fx-background-color:white;  -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");

		btn.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent arg0) {
				
				if (validateFields()) 
				{if (checkData()) {
					
					Alert msg = new Alert(AlertType.CONFIRMATION);
					msg.setTitle("Balance Inquiry");
					msg.setHeaderText("Balanace : "+temp_money+"$");
					msg.setContentText(" Name: "+temp_name+", Account Number: " + temp_AccNo + ", Gender: "+temp_gender);
					msg.showAndWait();
					
					
					for (int i=0; i<MainPage.nextAccount; i++){
				        System.out.print("Customer  Name: "+(MainPage.account[i].customerName)+"\n");
				        System.out.print("Account Number: "+Integer.toString(MainPage.account[i].accountNumber)+"\n");
				        System.out.print("Account Balance: "+Integer.toString(MainPage.account[i].accountBalance)+"\n");
				        System.out.println("Account Balance: "+(MainPage.account[i].gender)+"\n");
				    }
					
					stage.close();
				}
				else {
					Alert msg = new Alert(AlertType.ERROR);
					msg.setTitle("Error");
					msg.setHeaderText("Invalid Account");
					msg.setContentText(" Account number not Found");
					msg.showAndWait();
				}
				
				}	}
			
		
		});
		root.getChildren().addAll(imgv,lbl_title,lbl_account,txt_account,btn);
		
	}// end of addComponents
	
	private boolean validateFields() {
		if (txt_account.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid Field");
			alert.setHeaderText(null);
			alert.setContentText("Please Enter Acount no");
			alert.showAndWait();
			return false;
		}
		return true;

	}// end of validateFields
	
	private boolean checkData() {
		
		 int checkUserAccNum = Integer.parseInt(txt_account.getText());
        		
	    try {	
	 
	    	if(MainPage.account[MainPage.takeAccNum].accountNumber == checkUserAccNum ){	
	    		
	    		temp_money = Integer.toString(MainPage.account[MainPage.takeAccNum].accountBalance);
	    		temp_name = MainPage.account[MainPage.takeAccNum].customerName;
	    		temp_gender = MainPage.account[MainPage.takeAccNum].gender;
	    		temp_AccNo = Integer.toString(MainPage.account[MainPage.takeAccNum].accountNumber);
	    		
	    		return true;
	    	}
	    		 
	    	}catch(Exception e) {
	    		
	    		System.out.println(e);
	    	}
	            return false;
			
		}  //end of checkData
}
