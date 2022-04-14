import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.layout.*;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Standard Model of PArticle Physics");
		// set the title of the stage to Standard Model of Particle Physics
		//will also set the logo later


		VBox vb = new VBox();
		// create a new Vbox
		// this will hold all of our panes
		// the initial labels, as well as the single labels for each particle


		Label lb= new Label("Standard Model Of Particle Physics");
		// create a new Label - this is the top label


		vb.getChildren().addAll(lb);
		// this is the place for adding all the final elements 
		// nothing should be added to vb before this


		Scene sc = new Scene(vb,300,200);
		// create new scene, set the size

		stage.setScene(sc);
		// set the scene 

		stage.setFullScreen(true);
		// set fullscreen mode = true


		stage.show();
		// finally show the stage

	}

	public static void main(String[] args) {
		// main function - this should not be edited at any time
		// read only
		Application.launch(args);
	}


}