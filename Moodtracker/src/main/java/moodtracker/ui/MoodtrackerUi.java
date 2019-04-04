//to-do sovellusnäkymän scene
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
    
    private Scene startScene;
    private Scene newUserScene;
    private Scene mainScene;
    

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
        VBox startPane = new VBox(30);
        VBox newuserPane = new VBox(15);
        VBox mainPane = new VBox(15);
        
        loginPane.setPadding(new Insets(10));
        startPane.setPadding(new Insets(20));
        Label appName = new Label("MoodTracker");
        
        Label usernameLabel = new Label("Username");
        TextField usernameInput = new TextField();
        Button login = new Button("LOGIN");
        Button newUser = new Button("Create new user");
        
        Label userCreated = new Label("");
        
        Label mainTitle = new Label("WELCOME TO MOODTRACKER");
        
        loginPane.getChildren().addAll(usernameInput, usernameLabel, login);
        startPane.getChildren().addAll(appName, loginPane, newUser, userCreated);
        mainPane.getChildren().addAll(mainTitle);
        
        login.setOnAction(e ->{
            String inputUsername = usernameInput.getText();
            
            if(moodtrackerActions.login(inputUsername)) {
                stage.setScene(mainScene);
            }
        });
        
        newUser.setOnAction(e->{
            usernameInput.setText("");
            stage.setScene(newUserScene);
        });
        
        TextField newUsernameField = new TextField();
        Label newUsername = new Label("username");
        TextField newNameField = new TextField();
        Label newName = new Label("name");
        Label errorMessage = new Label("");
        
        Button createNewUserButton = new Button("CREATE");
        
        newuserPane.getChildren().addAll(newUsernameField, newUsername, newNameField, newName, createNewUserButton, errorMessage);
        
        
        
        createNewUserButton.setOnAction(e->{
            String username = newUsernameField.getText();
            String name = newNameField.getText();
            
            // to- do: jos käyttäjätunnus on varattu ilmoitus siitä
   
            if ( username.length()==2 || name.length()<2 ) {
                errorMessage.setText("name or username too short");
            } else if (moodtrackerActions.createUser(username, name)) {
                userCreated.setText("user created");
                stage.setScene(startScene);      
            } 
 
        });
        
        startScene = new Scene(startPane, 400, 300);
        newUserScene = new Scene(newuserPane, 400, 300);
        mainScene = new Scene(mainPane, 400, 300);
        
        
        //setup start stage
        
        stage.setTitle("Moods");
        stage.setScene(startScene);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
