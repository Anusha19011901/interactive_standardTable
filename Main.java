import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import java.io.*;
import java.util.*;


public class Main extends Application {
	Vector<Vector<String>> pictureFiles =new Vector<Vector<String>>();
	Vector<String> v=new Vector<String>();



	public void setImageStrings(File imgDirectory){
		try{
			if(imgDirectory.isDirectory()){
				File[] subDirectories = imgDirectory.listFiles();
				// System.out.println(subDirectories);
				for(int i=0;i<subDirectories.length;i++){
					// System.out.println(subDirectories[i];
					for(File f:subDirectories[i].listFiles()){
						v.add(f.getAbsolutePath());
						// System.out.println(f.getAbsolutePath());
					}
					pictureFiles.add(v);
					v=new Vector<String>();
				}
				// System.out.println("All images read");
				// for(int i=0;i<pictureFiles.size();i++){
				// 	for(int j=0;j<pictureFiles.get(i).size();j++){
				// 		System.out.println(pictureFiles.get(i).get(j));
				// 	}
				// }
			}
			else throw new NotDirectoryException();

		}
		catch(NotDirectoryException E){
			System.out.println("please give a valid directory name");
		}
	}






	public VBox setTitleComponent(){
		VBox vb= new VBox();

		Label lb= new Label("Standard Model Of Particle Physics");
		// create a new Label - this is the top label


		HBox topLabels = new HBox();
		// new HBoxox for the three particles - fermions, antifermions, bosons

		VBox fermion_label = new VBox();
		//two labels, one below each other

		Label fermion1 = new Label("three generations of matter");
		Label fermion2 =new Label("(elementary fermions)");
		// two labels for two lines

		fermion_label.getChildren().addAll(fermion1, fermion2);
		// add the two labels to the vbox



		VBox antifermion_label = new VBox();
		//two labels, one below each other

		Label antifermion1 = new Label("three generations of anti-matter");
		Label antifermion2 =new Label("(elementary anti-fermions)");
		// two labels for two lines

		antifermion_label.getChildren().addAll(antifermion1, antifermion2);


		VBox boson_label = new VBox();
		//two labels, one below each other

		Label boson1 = new Label("interactions/force carriers");
		Label boson2 =new Label("(elementary bosons)");
		// two labels for two lines

		boson_label.getChildren().addAll(boson1, boson2);


		topLabels.getChildren().addAll(fermion_label,antifermion_label, boson_label);
		topLabels.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(lb,topLabels);
		// this is the place for adding all the final elements 
		// nothing should be added to vb before this
		vb.setAlignment(Pos.CENTER);
		return vb;


	}














	public GridPane setParticles(Vector<Vector<String>> pictureFiles) throws FileNotFoundException{
		GridPane gd=new GridPane();
		// new grid pane for storing all the particles


		FileInputStream fi;
		ImageView imgv;
		Image img;
		// for reading and creating image files

		


		for(int i=0;i<pictureFiles.size();i++){
			for(int j=0;j<pictureFiles.get(i).size();j++){
				// loop over each image


				fi=new FileInputStream(pictureFiles.get(i).get(j));
				img =new Image(fi);
				imgv= new ImageView(img);
				// System.out.println("Accessed one image");
				gd.add(imgv, j*5, i*5, 5, 5);
			}
		}
		gd.setHgap(10);
		gd.setVgap(10);
		// set vertical and horizontal gaps


		return gd;
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Standard Model of Particle Physics");
		// set the title of the stage to Standard Model of Particle Physics
		//will also set the logo later

		VBox vb = new VBox();
		// create a new Vbox
		// this will hold all of our panes
		// the initial labels, as well as the single labels for each particle

		vb.getChildren().add(this.setTitleComponent());
		setImageStrings(new File("./images"));

		// try{

		// }
		// catch(FileNotFoundException f){
		// 	System.out.println("No such file");
		// }

		vb.getChildren().add(setParticles(pictureFiles));




		Scene sc = new Scene(vb,500,500);
		// create new scene, set the size
		stage.setScene(sc);
		// set the scene 

		// stage.setFullScreen(true);
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





class NotDirectoryException extends Exception{
	NotDirectoryException(){
		System.out.println("This file is not a directory!");
	}
}



