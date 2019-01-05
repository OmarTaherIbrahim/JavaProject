
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utils.server.ServerManager;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
<<<<<<< HEAD


			Parent root = FXMLLoader.load(getClass().getResource("../ui/FXML/PlusMinusTest.fxml"));
=======
			ServerManager severManager = new ServerManager();
			severManager.sendString();
			Parent root = FXMLLoader.load(getClass().getResource("../ui/FXML/Learn.fxml"));
>>>>>>> 4c2a52e193d6dc28d5f116e9f181cd823d152444
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("");
			primaryStage.show();
		} catch(Exception e) {
		System.out.println("you f ");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

