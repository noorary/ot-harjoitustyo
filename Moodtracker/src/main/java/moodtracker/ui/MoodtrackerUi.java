
package moodtracker.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;


public class MoodtrackerUi extends Application {
    
    private Scene inputScene;

    
    public void start(Stage stage) {
        
        //login scene
        
        VBox loginPane = new VBox(15);
        VBox inputPane = new VBox(15);
        loginPane.setPadding(new Insets(10));
        Label appName = new Label("MoodTracker");
        TextField usernameInput = new TextField();
        
        inputPane.getChildren().add(usernameInput);
        
        inputScene = new Scene(inputPane, 300, 250);
        
        //setup primary stage
        
        stage.setTitle("Moods");
        stage.setScene(inputScene);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
