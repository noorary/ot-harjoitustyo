
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
import moodtracker.domain.MoodtrackerActions;


public class MoodtrackerUi extends Application {
    
    private MoodtrackerActions moodtrackerActions;
    
    private Scene mainScene;
    private Scene newUserScene;

    
    public void start(Stage stage) {
        
        //login scene
        
        VBox loginPane = new VBox(15);
        VBox mainPane = new VBox(30);
        VBox newuserPane = new VBox(15);
        
        loginPane.setPadding(new Insets(10));
        mainPane.setPadding(new Insets(20));
        Label appName = new Label("MoodTracker");
        Label username = new Label("Username");
        TextField usernameInput = new TextField();
        Button login = new Button("LOGIN");
        Button newUser = new Button("Create new user");
        
        loginPane.getChildren().addAll(usernameInput, username, login);
        mainPane.getChildren().addAll(appName, loginPane, newUser);
        
        newUser.setOnAction(e->{
            usernameInput.setText("");
            stage.setScene(newUserScene);
        });
        
        TextField newUsernameField = new TextField();
        Label newUsername = new Label("username");
        TextField newNameField = new TextField();
        Label newName = new Label("name");
        
        Button createNewUserButton = new Button("CREATE");
        
        newuserPane.getChildren().addAll(newUsernameField, newUsername, newNameField, newName, createNewUserButton);
        
        newUserScene = new Scene(newuserPane, 400, 300);
        
        createNewUserButton.setOnAction(e ->{
            String usersusername = newUsernameField.getText();
            String usersname = newNameField.getText();
            moodtrackerActions.createUser(usersusername, usersname);
            stage.setScene(mainScene);
        });
        
        mainScene = new Scene(mainPane, 400, 300);
        
        
        
        //setup primary stage
        
        stage.setTitle("Moods");
        stage.setScene(mainScene);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
