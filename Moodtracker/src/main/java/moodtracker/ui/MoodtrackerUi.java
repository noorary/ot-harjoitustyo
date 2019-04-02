
package moodtracker.ui;

import java.io.FileInputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import moodtracker.dao.FileUserDao;
import moodtracker.domain.MoodtrackerActions;


public class MoodtrackerUi extends Application {
    
    private MoodtrackerActions moodtrackerActions;
    
    private Scene mainScene;
    private Scene newUserScene;
    

    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        
        FileInputStream inputstream = new FileInputStream("config.properties");
        
        properties.load(inputstream);
        
        String userFile = properties.getProperty("userFile");
        
        FileUserDao userDao = new FileUserDao(userFile);
        
        moodtrackerActions = new MoodtrackerActions(userDao);
    }
    
    @Override
    public void start(Stage stage) {
        
        //login scene
        
        VBox loginPane = new VBox(15);
        VBox mainPane = new VBox(30);
        VBox newuserPane = new VBox(15);
        
        loginPane.setPadding(new Insets(10));
        mainPane.setPadding(new Insets(20));
        Label appName = new Label("MoodTracker");
        Label usernameLabel = new Label("Username");
        TextField usernameInput = new TextField();
        Button login = new Button("LOGIN");
        Button newUser = new Button("Create new user");
        
        loginPane.getChildren().addAll(usernameInput, usernameLabel, login);
        mainPane.getChildren().addAll(appName, loginPane, newUser);
        
        newUser.setOnAction(e->{
            usernameInput.setText("");
            stage.setScene(newUserScene);
        });
        
        TextField newUsernameField = new TextField();
        Label newUsername = new Label("username");
        TextField newNameField = new TextField();
        Label newName = new Label("name");
        Label creationMessage = new Label("");
        
        Button createNewUserButton = new Button("CREATE");
        
        newuserPane.getChildren().addAll(newUsernameField, newUsername, newNameField, newName, createNewUserButton, creationMessage);
        
        newUserScene = new Scene(newuserPane, 400, 300);
        
        createNewUserButton.setOnAction(e->{
            String username = newUsernameField.getText();
            String name = newNameField.getText();
   
            if ( username.length()==2 || name.length()<2 ) {
                creationMessage.setText("name or username too short");
            } else if (moodtrackerActions.createUser(username, name)) {
                creationMessage.setText("user created");
                stage.setScene(mainScene);      
            } 
 
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
