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
import javafx.scene.layout.HBox;
import moodtracker.dao.FileUserDao;
import moodtracker.domain.MoodtrackerActions;
import moodtracker.domain.User;


public class MoodtrackerUi extends Application {
    
    private MoodtrackerActions moodtrackerActions;
    
    private Scene startScene;
    private Scene newUserScene;
    private Scene mainScene;
    private User currentlyLoggedIn;
    

    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        
        FileInputStream inputstream = new FileInputStream("config.properties");
        
        properties.load(inputstream);
        
        String userFile = properties.getProperty("userFile");
        
        FileUserDao userDao = new FileUserDao(userFile);
        
        moodtrackerActions = new MoodtrackerActions(userDao);
        
        currentlyLoggedIn = moodtrackerActions.currentlyLoggedIn;
        
    }
    
    @Override
    public void start(Stage stage) {
        
        //login scene
        
        VBox loginPane = new VBox(15);
        VBox startPane = new VBox(30);
        VBox newuserPane = new VBox(15);
        VBox mainPane = new VBox(15);
        HBox moodButtonPane = new HBox(15);
        
        loginPane.setPadding(new Insets(10));
        startPane.setPadding(new Insets(20));
        Label appName = new Label("MoodTracker");
        
        Label usernameLabel = new Label("Username");
        TextField usernameInput = new TextField();
        Button login = new Button("LOGIN");
        Button newUser = new Button("Create new user");
        
        Label userCreated = new Label("");
        
        
        Label mainTitle = new Label("");
        Label addNewMood = new Label("Add new mood, 1 = lowest, 10 = highest");
        Button m1 = new Button("1");
        Button m2 = new Button("2");
        Button m3 = new Button("3");
        Button m4 = new Button("4");
        Button m5 = new Button("5");
        Button m6 = new Button("6");
        Button m7 = new Button("7");
        Button m8 = new Button("8");
        Button m9 = new Button("9");
        Button m10 = new Button("10");
        
        loginPane.getChildren().addAll(usernameInput, usernameLabel, login);
        startPane.getChildren().addAll(appName, loginPane, newUser, userCreated);
        moodButtonPane.getChildren().addAll(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10);
        mainPane.getChildren().addAll(mainTitle, addNewMood, moodButtonPane);
        
        login.setOnAction(e ->{
            String inputUsername = usernameInput.getText();
            
            if(moodtrackerActions.login(inputUsername)) {
                mainTitle.setText("Welcome to MoodTracker! ");
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
        
        startScene = new Scene(startPane, 600, 500);
        newUserScene = new Scene(newuserPane, 600, 500);
        mainScene = new Scene(mainPane, 600, 500);
        
        
        //setup start stage
        
        stage.setTitle("Moods");
        stage.setScene(startScene);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
