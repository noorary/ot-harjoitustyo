package moodtracker.domainTest;



import moodtracker.dao.FileUserDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import moodtracker.domain.User;
import moodtracker.domain.MoodtrackerActions;
import moodtracker.dao.UserDao;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.HashMap;
import moodtracker.dao.FileUserDao;
import moodtracker.dao.FileMoodDao;
import moodtracker.dao.MoodDao;
import moodtracker.daoTest.FakeMoodDao;
import moodtracker.daoTest.FakeUserDao;
import moodtracker.domain.Mood;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;


public class MoodtrackerActionsTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;
    File moodFile;
    FileMoodDao moodDao;
    FileUserDao userDao;
    MoodtrackerActions actions;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public MoodtrackerActionsTest() {   
    }
    
    
    
    @Before
    public void setUp() throws Exception{
        
        
        
        userFile = testFolder.newFile("testfile_users.txt");
        moodFile = testFolder.newFile("testfile_moods.txt");
        UserDao userDao = new FakeUserDao();
        MoodDao moodDao = new FakeMoodDao();
        userDao.create(new User("esimerkki", "erkki"));
        
        actions = new MoodtrackerActions(userDao, moodDao);
        
        try (FileWriter file = new FileWriter(moodFile.getAbsolutePath())) {
            file.write("1;3;2019-01-12;esimerkki");
        }
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("esimerkki;erkki\n");
        }
        
        moodDao = new FileMoodDao(userFile.getAbsolutePath(), userDao);
        
        
    }
    
    @Test
    public void createUserWorksIfUserNameIsFree() {
        String username = "usernamename";
        String name = "name";
        
        assertTrue(actions.createUser(username, name));
    }
    
    @Test
    public void createUserIfUsernameIsTaken() {
        String username = "esimerkki";
        String name = "erkki";
        
        assertFalse(actions.createUser(username, name));
    }
    
    @Test
    public void createMoodWorks() {
        assertTrue(actions.createMood(3));
    }
    
    @Test
    public void loginWorksFine() {
        assertTrue(actions.login("esimerkki"));
        assertFalse(actions.login("erkki"));
    }
    
    
    
    
        
        
}
    
