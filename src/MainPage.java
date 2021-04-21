
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPage extends Application{

	Stage main;				
	TextField txt_name ;
	PasswordField pswd_Field;

	
	public static void main(String[] args) {
		
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		main=primaryStage;	
		primaryStage.setTitle("Bank Management System");
		primaryStage.setWidth(1370);
		primaryStage.setHeight(720);
		primaryStage.setResizable(false);
		
		
		Group root = new Group();
		addComponent(root);
		
		Scene s1 = new Scene(root);
		primaryStage.setScene(s1);
		primaryStage.show();
		
	}
	
	private void addComponent(Group root) {
		 
		Image img = new Image("file://../Images/bank.jpg");
		ImageView imgv = new ImageView(img);
		imgv.setFitWidth(1360);
		imgv.setFitHeight(700);
		
		
		Text txt_tit = new Text();
		
		txt_tit.setText("Welcome To International");
		txt_tit.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,FontPosture.REGULAR,32));
		txt_tit.setX(500);
		txt_tit.setY(100);
		txt_tit.setFill(Color.WHITE);
		txt_tit.setStroke(Color.DARKBLUE);
		txt_tit.setStyle("-fx-background-color:red;-fx-text-fill:white");
		
		Text name = new Text();
		name.setText("Name:");
		name.setFill(Color.WHITE);
		name.setStroke(Color.DARKBLUE);
		name.setX(409);
		name.setY(210);
		name.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,FontPosture.REGULAR,30));
		
		 txt_name = new TextField();
		 txt_name.setPromptText("Name");
		 txt_name.setTranslateX(520);
		 txt_name.setTranslateY(179);
		 txt_name.setPrefWidth(360);
		 txt_name.setPrefHeight(45);
		 txt_name.setStyle("-fx-background-color:white; -fx-text-fill:blue; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'TimesNewRoman' ;-fx-opacity: 0.70;");
			

		Text password = new Text();
		password.setText("Password:");
		password.setFill(Color.WHITE);
		password.setStroke(Color.DARKBLUE);
		password.setX(360);
		password.setY(275);
		password.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,FontPosture.REGULAR,30));
		
		pswd_Field = new PasswordField();
		pswd_Field.setPromptText("Account Number");
		pswd_Field.setTranslateX(520);
		pswd_Field.setTranslateY(240);
		pswd_Field.setPrefWidth(360);
		pswd_Field.setPrefHeight(45);
		pswd_Field.setStyle("-fx-background-color:white; -fx-text-fill:blue; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'TimesNewRoman' ;-fx-opacity: 0.70;");
		

		
		
		Button btn_login = new Button("Login");
		btn_login.setTranslateX(520);
		btn_login.setTranslateY(300);
		btn_login.setTextFill(Color.BLUE);
		btn_login.setTextFill(Color.BLACK);
		btn_login.setPrefWidth(360);
		btn_login.setPrefHeight(45);
		btn_login.setStyle("-fx-background-color:white; -fx-text-fill:blue; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'TimesNewRoman' ;-fx-opacity: 0.70;");
		

		btn_login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				if(validateFields()){
					if(checkData()) {
						
						new HomePage();
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("login successfull");
						alert.showAndWait();
						cleardata();
						main.close();
					}
		
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Login Error ");
						alert.setHeaderText("login Failed ");
						alert.setContentText( null);
						alert.showAndWait();
						cleardata();
					}

				
				}
			}
		});
		
		Button btn_create = new Button("Create Account");
		btn_create.setTranslateX(520);
		btn_create.setTranslateY(360);
		btn_create.setTextFill(Color.BLUE);
		btn_create.setTextFill(Color.BLACK);
		btn_create.setPrefWidth(360);
		btn_create.setPrefHeight(45);
		btn_create.setStyle("-fx-background-color:white; -fx-text-fill:blue; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'TimesNewRoman' ;-fx-opacity: 0.70;");
		

		btn_create.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				cleardata();
				new CreateAccount();
			}
		});
		Button btn_EXIT = new Button("EXIT");
		btn_EXIT.setTranslateX(520);
		btn_EXIT.setTranslateY(420);
		btn_EXIT.setTextFill(Color.BLUE);
		btn_EXIT.setTextFill(Color.BLACK);
		btn_EXIT.setPrefWidth(360);
		btn_EXIT.setPrefHeight(45);
		btn_EXIT.setStyle("-fx-background-color:white; -fx-text-fill:blue; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'TimesNewRoman' ;-fx-opacity: 0.70;");
		btn_EXIT.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				 cleardata();
				 main.close();
			}
		});

		root.getChildren().addAll(imgv,txt_tit,name,txt_name,password,pswd_Field,btn_login,btn_create,btn_EXIT);
	}
	
	public void cleardata() {
		txt_name.clear();
		pswd_Field.clear();
	}
	
	private boolean validateFields() {
		if (txt_name.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid Field");
			alert.setHeaderText(null);
			alert.setContentText("Please Enter Name");
			alert.showAndWait();
			return false;}
			if (pswd_Field.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Invalid Field");
				alert.setHeaderText(null);
				alert.setContentText("Please Enter Password/Account no");
				alert.showAndWait();
				return false;
		}return true;
		
	}// end of validateFields
	
    private boolean checkData() {
		
    	MainPage.takeAccNum = Integer.parseInt(pswd_Field.getText());
    	MainPage.takeAccName  =  txt_name.getText();
    		
    	try {
    		for (int i = 0; i < nextAccountNumber; i++) {
				
 
    			if(MainPage.account[i].accountNumber == takeAccNum &&  MainPage.account[i].customerName.equals(takeAccName)) {
    				
    				
    				return true;
    			}
    		
    		} 
    	}catch(Exception e) {
    		
    		System.out.println(e);
    	}
            return false;
		
	}  //end of checkData
	
	public static class Account {
	    String customerName;
	    int accountNumber;
	    int accountBalance;
	    String gender;
	}
	
	 public static  int nextAccount=0;
	 public static  int nextAccountNumber=0;
	 public static int i;
	 public static int takeAccNum;
	 public static String takeAccName;
	  
	  public static Account[] account=new Account[20];//array
	     
	    
	    public static void createAccount(String customerName, int accountBalance, String gender){
	    	
	    	account[nextAccount]=new Account();
	        
	        account[nextAccount].customerName = customerName;
	        account[nextAccount].accountBalance = accountBalance;
	        account[nextAccount].gender = gender;
	        
	        account[nextAccount].accountNumber=nextAccountNumber++;
	        
	          nextAccount++;     
	    }// end of createAccount
	    

	    public static void deposit(int accountNumber, int accountBalance) {
	    
	        account[accountNumber].accountBalance+=accountBalance;
	        
	    }// end of deposite
	    
	    public static void withdraw(int accountNumber, int accountBalance)  {

	        account[accountNumber].accountBalance-=accountBalance;  
	         
	    }// end o withdraw

}// end of MainPage


