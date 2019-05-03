package moodtracker.ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.awt.GraphicsEnvironment;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import moodtracker.dao.FileMoodDao;
import moodtracker.dao.FileUserDao;
import moodtracker.domain.Mood;
import moodtracker.domain.MoodtrackerActions;
import moodtracker.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Luokka sisältää käyttöliittymän rakentavan koodin
 * @author nrytila
 */

public class MoodtrackerUi extends Application {
    
    private MoodtrackerActions moodtrackerActions;
    
    private Scene startScene;
    private Scene newUserScene;
    private Scene mainScene;
    private Scene piechartScene;
    private User currentlyLoggedIn;
    private LocalDate localdate;
    
    private List<Mood> moods;
    
    
    /**
     * Metodi valmistelee tarvittavat elementit sovelluksen käynnistämistä varten.
     * @throws Exception 
     */
    @Override
    public void init() throws Exception{
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
    
    
    /**
     * Metodi sisältää käyttöliittymän komponentit ja tapahtumakäsittelijät.
     * @param stage metodi saa applikaation stagen parametrinä
     */
    
    @Override
    public void start(Stage stage) {
        
        
        VBox loginPane = new VBox(15);
        VBox startPane = new VBox(30);
        VBox newuserPane = new VBox(15);
        VBox mainPane = new VBox(15);
        HBox moodButtonPane = new HBox(15);
        HBox titleAndLogoutPane = new HBox(10);
        
        loginPane.setPadding(new Insets(10));
        startPane.setPadding(new Insets(20));
        Label appName = new Label("MoodTracker");
        Font font = Font.font("Cousine", 50);
        appName.setFont(font);
        Label userNotFound = new Label("");
        
        Label usernameLabel = new Label("Username");
        TextField usernameInput = new TextField();
        Button login = new Button("LOGIN");
        Button newUser = new Button("Create new user");
        
        Label userCreated = new Label("");
        
        Label mainTitle = new Label("");
        Label addNewMood = new Label("Add new mood, 1 = lowest, 10 = highest");
        
        ToggleGroup group = new ToggleGroup();
        RadioButton m1 = new RadioButton("1");
        m1.setGraphic(new Circle(10));
        
        RadioButton m2 = new RadioButton("2");
        Circle darkred = new Circle(10);
        darkred.setFill(Color.DARKRED);
        m2.setGraphic(darkred);
        
        RadioButton m3 = new RadioButton("3");
        Circle red = new Circle(10);
        red.setFill(Color.RED);
        m3.setGraphic(red);
        
        RadioButton m4 = new RadioButton("4");
        Circle darkviolet = new Circle(10);
        darkviolet.setFill(Color.DARKVIOLET);
        m4.setGraphic(darkviolet);
        
        RadioButton m5 = new RadioButton("5");
        Circle mediumblue = new Circle(10);
        mediumblue.setFill(Color.MEDIUMBLUE);
        m5.setGraphic(mediumblue);
        
        RadioButton m6 = new RadioButton("6");
        Circle deepsky = new Circle(10);
        deepsky.setFill(Color.DEEPSKYBLUE);
        m6.setGraphic(deepsky);
        
        RadioButton m7 = new RadioButton("7");
        Circle turquoise = new Circle(10);
        turquoise.setFill(Color.TURQUOISE);
        m7.setGraphic(turquoise);
        
        RadioButton m8 = new RadioButton("8");
        Circle cyan = new Circle(10);
        cyan.setFill(Color.CYAN);
        m8.setGraphic(cyan);
        
        RadioButton m9 = new RadioButton("9");
        Circle lime = new Circle(10);
        lime.setFill(Color.LIME);
        m9.setGraphic(lime);
        
        RadioButton m10 = new RadioButton("10");
        Circle greenyellow = new Circle(10);
        greenyellow.setFill(Color.GREENYELLOW);
        m10.setGraphic(greenyellow);
        
        m1.setToggleGroup(group);
        m2.setToggleGroup(group);
        m3.setToggleGroup(group);
        m4.setToggleGroup(group);
        m5.setToggleGroup(group);
        m6.setToggleGroup(group);
        m7.setToggleGroup(group);
        m8.setToggleGroup(group);
        m9.setToggleGroup(group);
        m10.setToggleGroup(group);
        m1.setUserData(m9);
        
        Button add = new Button("Add mood");
        Label moodCreated = new Label("");
        
        Button showPieChart = new Button("Show moodsummary");
        
        Button logout = new Button("LOG OUT");
        Button back = new Button("BACK");

        titleAndLogoutPane.getChildren().addAll(mainTitle, logout);
        loginPane.getChildren().addAll(usernameInput, usernameLabel, login, userNotFound);
        startPane.getChildren().addAll(appName, loginPane, newUser, userCreated);
        moodButtonPane.getChildren().addAll(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10);
        mainPane.getChildren().addAll(titleAndLogoutPane, addNewMood, moodButtonPane, add, moodCreated, showPieChart);
        
        login.setOnAction(e ->{
            String inputUsername = usernameInput.getText();
            
            if(moodtrackerActions.login(inputUsername)) {
                usernameInput.setText("");
                mainTitle.setText("Welcome to MoodTracker! ");
                stage.setScene(mainScene);
            } else {
                
                userNotFound.setTextFill(Color.RED);
                userNotFound.setText("Username was not found");
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
   
            if ( username.length()==2 || name.length()<2 ) {
                errorMessage.setText("Name or username too short");
            } else if (moodtrackerActions.createUser(username, name)) {
                newUsernameField.setText("");
                newNameField.setText("");
                userCreated.setText("User created");
                stage.setScene(startScene);      
            } else {
                errorMessage.setText("Username is taken");
            }
 
        });
        
        add.setOnAction(e ->{
            
            RadioButton rb = (RadioButton)group.getSelectedToggle();
            String sv = rb.getText();
            Integer moodvalue = Integer.parseInt(sv);
            
            moodtrackerActions.createMood(moodvalue);
            
            moodCreated.setText("Mood saved! :)");
            rb.setSelected(false); 
        });
        
        showPieChart.setOnAction(e -> {
            showPieChart(stage, back);   
        });
        
        logout.setOnAction(e -> {
            stage.setScene(startScene);
        });
        
        
        
        startScene = new Scene(startPane, 750, 400);
        newUserScene = new Scene(newuserPane, 750, 400);
        mainScene = new Scene(mainPane, 750, 400);
        
        
        
        
        //setup start stage
        
        stage.setTitle("Moods");
        stage.setScene(startScene);
        stage.show();
        
        back.setOnAction(e -> {
            stage.setScene(mainScene);
        });
        
        
    }
    
    /**
     * metodi käynnistää sovelluksen
     * @param args 
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void showPieChart(Stage stage, Button back) {

        int value1 = 0;
        int value2 = 0;
        int value3 =0;
        int value4 =0;
        int value5 =0;
        int value6 =0;
        int value7 =0;
        int value8 =0;
        int value9 =0;
        int value10 =0;
        
            try {
                
                HashMap<Integer, Integer> moodmap = moodtrackerActions.usersMoods();
                System.out.println(moodmap);
                if(moodmap.containsKey(1)) {
                    value1 = moodmap.get(1);
                } 
                
                if(moodmap.containsKey(2)) {
                    value2 = moodmap.get(2);
                }
                
                if(moodmap.containsKey(3)) {
                    value3 = moodmap.get(3);
                }
                
                if(moodmap.containsKey(4)) {
                    value4 = moodmap.get(4);
                }
                
                if(moodmap.containsKey(5)) {
                    value5 = moodmap.get(5);
                }
                
                if(moodmap.containsKey(6)) {
                    value6 = moodmap.get(6);
                }
                
                if(moodmap.containsKey(7)) {
                    value7 = moodmap.get(7);
                }
                
                if(moodmap.containsKey(8)) {
                    value8 = moodmap.get(8);
                }
                if(moodmap.containsKey(9)) {
                    value9 = moodmap.get(9);
                }
                
                if(moodmap.containsKey(10)) {
                    value10 = moodmap.get(10);
                }
                
                
            } catch (Exception ex) {
                Logger.getLogger(MoodtrackerUi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int div = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10;
            
            System.out.println(value1);
            System.out.println(value2);
            System.out.println(value3);
            System.out.println(value4);
            System.out.println(value5);
            System.out.println(value6);
            System.out.println(value7);
            System.out.println(value8);
            System.out.println(value9);
            System.out.println(value10);
            
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
               
                
                new PieChart.Data("1", value1),
                new PieChart.Data("2", value2),
                new PieChart.Data("3", value3),
                new PieChart.Data("4", value4),
                new PieChart.Data("5", value5),
                new PieChart.Data("6", value6),
                new PieChart.Data("7", value7),
                new PieChart.Data("8", value8),
                new PieChart.Data("9", value9),
                new PieChart.Data("10", value10)
             
            );
             
            
             
                final PieChart pieChart = new PieChart(pieChartData);

                FlowPane chartPane = new FlowPane(pieChart, back);
                 
                piechartScene = new Scene(chartPane, 750, 400);
                stage.setScene(piechartScene);
              
                 
                
    }
    
    
}
