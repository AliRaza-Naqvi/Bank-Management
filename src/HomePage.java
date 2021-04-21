import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomePage {

	Stage stHomePage = new Stage();

	HomePage() {

		
		stHomePage.setWidth(500);
		stHomePage.setHeight(720);
		stHomePage.setResizable(false);
		stHomePage.setTitle("International Bank - HOME");

		Group root = new Group();
		addComponent(root);

		Scene sceneHome = new Scene(root,Color.MINTCREAM);

		stHomePage.setScene(sceneHome);
		stHomePage.show();
		
	}
	
private void addComponent(Group root) {

		

		Image img = new Image("file://../Images/home.jpg");
		ImageView imgv = new ImageView(img);
		imgv.setFitWidth(500);
		imgv.setFitHeight(720);


		Button btn_deposite = new Button("Deposite");
		btn_deposite.setTextFill(Color.BLACK);
	
		btn_deposite.setTranslateX(70);
		btn_deposite.setTranslateY(200);
		btn_deposite.setPrefWidth(360);
		btn_deposite.setPrefHeight(80);
		
		btn_deposite.setStyle(
				"-fx-background-color:white;-fx-border-color:black; -fx-text-fill:black; -fx-hightlight-fill:red;  -fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
	btn_deposite.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				 new Deposite();
			}

		});

		Button btn_withdraw = new Button("Withdraw");
		btn_withdraw.setTextFill(Color.BLACK);
		btn_withdraw.setTranslateY(300);
		btn_withdraw.setTranslateX(70);
		btn_withdraw.setPrefWidth(360);
		btn_withdraw.setPrefHeight(80);
		btn_withdraw.setStyle(
				"-fx-background-color:white;-fx-border-color:black; -fx-text-fill:black;-fx-opacity: 0.60;-fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
		btn_withdraw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Withdraw();

			}

		});

		Button btn_checkinfo = new Button("Check Balance");
		btn_checkinfo.setTextFill(Color.BLACK);
		btn_checkinfo.setTranslateY(400);
		btn_checkinfo.setTranslateX(70);
		btn_checkinfo.setPrefWidth(360);
		btn_checkinfo.setPrefHeight(80);
		btn_checkinfo.setStyle(
				"-fx-background-color:white; -fx-border-color:black;-fx-text-fill:black;-fx-opacity: 0.60;-fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
		btn_checkinfo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new CheckBalance();

			}

		});
		Button btn_EXIT = new Button("Exit");
		btn_EXIT.setTextFill(Color.BLACK);
		btn_EXIT.setTranslateY(500);
		btn_EXIT.setTranslateX(70);
		btn_EXIT.setPrefWidth(360);
		btn_EXIT.setPrefHeight(80);
		btn_EXIT.setStyle(
				"-fx-background-color:white; -fx-border-color:black;-fx-text-fill:black;-fx-opacity: 0.60;-fx-padding: 2;-fx-font: normal bold 20px 'Arail' ;-fx-opacity: 0.70;");
		btn_EXIT.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stHomePage.close();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("EXIT");
				alert.setHeaderText(null);
				alert.setContentText(" EXIT Sucessfull");
				alert.showAndWait();
			}

		});

		root.getChildren().addAll(imgv, btn_deposite, btn_withdraw, btn_checkinfo,btn_EXIT);
	}
}
