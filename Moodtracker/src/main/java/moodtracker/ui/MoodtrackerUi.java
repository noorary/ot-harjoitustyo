//to-do sovellusnäkymän scene
package moodtracker.ui;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import moodtracker.dao.FileMoodDao;
import moodtracker.dao.FileUserDao;
import moodtracker.domain.MoodtrackerActions;
import moodtracker.domain.User;


public class MoodtrackerUi extends Application {
    
    private MoodtrackerActions moodtrackerActions;
    
    private Scene startScene;
    private Scene newUserScene;
    private Scene mainScene;
    private User currentlyLoggedIn;
    private LocalDate localdate;
    

    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        
        FileInputStream inputstream = new FileInputStream("config.properties");
        
        properties.load(inputstream);
        
        String userFile = properties.getProperty("userFile");
        String moodFile = properties.getProperty("moodFile");
        
        FileUserDao userDao = new FileUserDao(userFile);
        FileMoodDao moodDao = new FileMoodDao(moodFile, userDao);
        
        moodtrackerActions = new MoodtrackerActions(userDao, moodDao);
        
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
        
        
        //todo käyttöliittymän hienosäätö
        
        Label mainTitle = new Label("");
        Label addNewMood = new Label("Add new mood, 1 = lowest, 10 = highest");
        
        ToggleGroup group = new ToggleGroup();
        RadioButton m1 = new RadioButton("1");
        RadioButton m2 = new RadioButton("2");
        RadioButton m3 = new RadioButton("3");
        RadioButton m4 = new RadioButton("4");
        RadioButton m5 = new RadioButton("5");
        RadioButton m6 = new RadioButton("6");
        RadioButton m7 = new RadioButton("7");
        RadioButton m8 = new RadioButton("8");
        RadioButton m9 = new RadioButton("9");
        RadioButton m10 = new RadioButton("10");
        m1.setToggleGroup(group);
        m1.setSelected(true);
        m2.setToggleGroup(group);
        m3.setToggleGroup(group);
        m4.setToggleGroup(group);
        m5.setToggleGroup(group);
        m6.setToggleGroup(group);
        m7.setToggleGroup(group);
        m8.setToggleGroup(group);
        m9.setToggleGroup(group);
        m10.setToggleGroup(group);
//        DateFormat dateFormat = new SimpleDateFormat("yyy-mm-dd");
//        LocalDate n = LocalDate.now();
//        String ns = dateFormat.format(n);
//        Button date = new Button(ns);
        
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
            
            // todo: jos käyttäjätunnus on varattu ilmoitus siitä
   
            if ( username.length()==2 || name.length()<2 ) {
                errorMessage.setText("name or username too short");
            } else if (moodtrackerActions.createUser(username, name)) {
                userCreated.setText("user created");
                stage.setScene(startScene);      
            } 
 
        });
        
        m1.setOnAction(e -> {
            int mood = Integer.valueOf(m1.getText());
            
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
