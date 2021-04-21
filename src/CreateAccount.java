
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreateAccount {
	
	TextField txtName,txtAmount; 
	ToggleGroup toggle;
	RadioButton rBtn_1,rBtn_2;
	
	Stage stCreate = new Stage();
	
CreateAccount() {
		
		stCreate.setTitle("International Bank - Create Account");
		stCreate.setWidth(1370);
		stCreate.setHeight(630);
		stCreate.setResizable(false);
		//stCreate.setX(100);
		//stCreate.setY(50);
		//stCreate.centerOnScreen();
		Group root1 = new Group();
		addComponent(root1);
		Scene CreateScene = new Scene(root1,Color.DARKCYAN);
		stCreate.setScene(CreateScene);
		stCreate.show();
	}


public void clearData() {
	txtName.clear();
	txtAmount.clear();
	
}

private void addComponent(Group root1) 
{
	Text title = new Text();
	title.setText("Create Account");
	title.setTranslateX(230);
	title.setTranslateY(50);
	title.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 50));
	title.setFill(Color.WHITE);
	title.setStroke(Color.WHITE);
	
	Image img = new Image("file://../Images/create.png");
	ImageView imgv = new ImageView(img);
	imgv.setFitWidth(600);
	imgv.setFitHeight(630);
	imgv.setX(710);
	
	Text txt_name = new Text();
	txt_name.setText("Name:");
	txt_name.setTranslateX(190);
	txt_name.setTranslateY(120);
	txt_name.setFill(Color.WHITE);
	txt_name.setStroke(Color.WHITE);
	txt_name.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 30));
	txtName = new TextField();
	txtName.setPromptText("Name");
	txtName.setTranslateX(320);
	txtName.setTranslateY(90);
	txtName.setStyle("-fx-background-color:white; -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 30px 'Arail' ;-fx-opacity: 0.70;");
	
	Text lblAmount = new Text();
	lblAmount.setText("Amount:");
	lblAmount.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 30));
	lblAmount.setFill(Color.WHITE);
	lblAmount.setStroke(Color.WHITE);
	lblAmount.setTranslateX(150);
	lblAmount.setTranslateY(190);
	txtAmount = new TextField();
	txtAmount.setPromptText("Amount");
	txtAmount.setTranslateX(320);
	txtAmount.setTranslateY(155);
	txtAmount.setStyle("-fx-background-color:white; -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 30px 'Arail' ;-fx-opacity: 0.70;");
	
	
	
	Text gender = new Text();
	gender.setText("Gender:");
	gender.setFont(Font.font("GEorgia", FontWeight.BOLD, FontPosture.ITALIC, 30));
	gender.setFill(Color.WHITE);
	gender.setStroke(Color.WHITE);
	gender.setTranslateX(150);
	gender.setTranslateY(250);
	rBtn_1 = new RadioButton("Male");
	rBtn_1.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 20));
	rBtn_1.setTextFill(Color.WHITE);
	rBtn_1.setTranslateX(360);
	rBtn_1.setTranslateY(230);
	
	rBtn_2 = new RadioButton("Female");
	rBtn_2.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 20));
	rBtn_2.setTextFill(Color.WHITE);
	rBtn_2.setTranslateX(510);
	rBtn_2.setTranslateY(230);
	toggle = new ToggleGroup();
	rBtn_1.setToggleGroup(toggle);
	rBtn_2.setToggleGroup(toggle);
	
	Button create_btn = new Button("Create");
	create_btn.setTextFill(Color.DARKBLUE);
	create_btn.setFont(Font.font("GEorgia", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));
	create_btn.setTranslateX(280);
	create_btn.setTranslateY(300);
	create_btn.setStyle("-fx-background-color:white; -fx-text-fill:black;-fx-opacity: 0.70;");
	create_btn.setPrefWidth(200);
	
	create_btn.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent e) {
			
			if(validateFields()) {
			String gender="Male";
			if(rBtn_2.isSelected())
				gender="Female";
			
		       try {
		             String userName = txtName.getText();
		            int userInitialBal = Integer.parseInt(txtAmount.getText());
		            
		            if(userInitialBal<100){
		            
		            	Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Amount Should Be More Than 100$ ");
						alert.showAndWait();
		                
		            }
		            else
		            {
		            	
		            	Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("Your account has been Sucessfully created \n Your Account Number is: "+MainPage.nextAccountNumber);
						alert.showAndWait();
						
						MainPage.createAccount(userName, userInitialBal,gender);
						
						clearData();
		           
		            } 
		       }
		        catch (Exception ex) {
		           
		           
		        }
			
		}// validateFields
	}

	});
	
	Button btnClose = new Button("Close");
	btnClose.setTextFill(Color.DARKBLUE);
	btnClose.setFont(Font.font("GEorgia", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30));
	btnClose.setTranslateX(490);
	btnClose.setTranslateY(300);
	btnClose.setStyle("-fx-background-color:white; -fx-text-fill:black;-fx-opacity: 0.70;");
	btnClose.setPrefWidth(200);
	btnClose.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent e) {
		stCreate.close();
			
		}

	});
	
	root1.getChildren().addAll(imgv, title, txt_name,txtName,lblAmount,txtAmount, gender,create_btn,rBtn_1,rBtn_2 ,btnClose);
}

private boolean validateFields() {
	if (txtName.getText().isEmpty()) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Invalid Field");
		alert.setHeaderText(null);
		alert.setContentText("Please Enter Name");
		alert.showAndWait();
		return false;
	}
	
	if(txtAmount.getText().isEmpty()){
		Alert alert = new  Alert(AlertType.WARNING);
		alert.setTitle("invalid field");
		alert.setContentText("Please enter mobile");
		alert.setHeaderText(null);
		alert.showAndWait();
		return false;
	}

	if(!rBtn_1.isSelected()&!rBtn_2.isSelected()) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Invalid Field ");
		alert.setHeaderText(null);
		alert.setContentText("Please Select Gender");
		alert.showAndWait();
		return false;
	}
	
	return true;
	}  // end validateFields

}
