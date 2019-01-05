
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;


			Parent root = FXMLLoader.load(getClass().getResource("../ui/FXML/PlusMinusTest.fxml"));
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

