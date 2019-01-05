
package ui.controller;

import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import data.lists.AlphabetsList;
import data.lists.ColorsList;
import data.lists.ShapesList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class TestMenuController implements Initializable {

	 @FXML
	 private JFXButton imageTest2;

	 @FXML
	 private JFXButton imageTest3;

	 @FXML
	 private JFXButton imageTest1;
	 
	 @FXML
	 private JFXButton A1;
	 
	 @FXML
	 private JFXButton S1;

	 @FXML
	 private JFXButton S3;
	 @FXML
	 private JFXButton A2;

	 @FXML
	 private JFXButton A3;

	 @FXML
	 private JFXButton S2;
	 
	 @FXML
	 private JFXButton M1;
	 @FXML
	 private JFXButton M2;
	 @FXML
	 private JFXButton M3;
	 @FXML
	 private JFXButton M4;
	 @FXML
	 private JFXButton M5;
	 @FXML
	 private JFXButton M6;
	 @FXML
	 private JFXButton M7;
	 @FXML
	 private JFXButton M8;
	 @FXML
	 private JFXButton M9;
	 @FXML
	 private JFXButton M10;


	
	@FXML
    private Tab backtab;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    @FXML
    void goback(ActionEvent event) {
    	Parent p;
		try {
			p = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
		
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void gobackTab(ActionEvent event) {
    	event.consume();
    	goback(event);
    }
    
    @FXML
    void imageTestABC(ActionEvent event) {
    	
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ImageTest.fxml"));
			p=L.load();
			ImageTestController controller=L.<ImageTestController>getController();
			controller.setLessonList(new AlphabetsList());
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void imageTestColor(ActionEvent event) {
    	
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ImageTest.fxml"));
			p=L.load();
			ImageTestController controller=L.<ImageTestController>getController();
			controller.setLessonList(new ColorsList());
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void imageTestShape(ActionEvent event) {
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ImageTest.fxml"));
			p=L.load();
			ImageTestController controller=L.<ImageTestController>getController();
			controller.setLessonList(new ShapesList());
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void gotolevel1Additon(ActionEvent event) {
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/PlusMinusTest.fxml"));
			p=L.load();
			PlusMinusTestController controller=L.<PlusMinusTestController>getController();
			controller.setTest(1, "+");
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void gotolevel2Addition(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/PlusMinusTest.fxml"));
    			p=L.load();
    			PlusMinusTestController controller=L.<PlusMinusTestController>getController();
    			controller.setTest(2, "+");
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }

    @FXML
    void gotolevel3Addition(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/PlusMinusTest.fxml"));
    			p=L.load();
    			PlusMinusTestController controller=L.<PlusMinusTestController>getController();
    			controller.setTest(3, "+");
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel1Subtraction(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/PlusMinusTest.fxml"));
    			p=L.load();
    			PlusMinusTestController controller=L.<PlusMinusTestController>getController();
    			controller.setTest(1, "-");
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel2Subtraction(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/PlusMinusTest.fxml"));
    			p=L.load();
    			PlusMinusTestController controller=L.<PlusMinusTestController>getController();
    			controller.setTest(2, "-");
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel3Subtraction(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/PlusMinusTest.fxml"));
    			p=L.load();
    			PlusMinusTestController controller=L.<PlusMinusTestController>getController();
    			controller.setTest(3, "-");
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel1Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(1);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel2Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(2);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel3Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(3);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel4Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(4);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel5Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(5);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel6Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(6);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }

    @FXML
    void gotolevel7Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(7);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel8Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(8);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel9Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(9);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }
    
    @FXML
    void gotolevel10Multiplication(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/multiTest.fxml"));
    			p=L.load();
    			MultiTestController controller=L.<MultiTestController>getController();
    			controller.setlvl(10);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }

}

