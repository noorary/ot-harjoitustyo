package moodtracker.daoTest;



import moodtracker.daoTest.FakeUserDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;
import moodtracker.dao.FileMoodDao;
import moodtracker.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import moodtracker.domain.Mood;
import moodtracker.domain.User;


public class FileMoodDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;
    FileMoodDao dao;
    
    public FileMoodDaoTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");
        UserDao userDao = new FakeUserDao();
        userDao.create(new User("esimerkki", "erkki"));
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("1;3;2019-01-12;esimerkki");
        }
        
        dao = new FileMoodDao(userFile.getAbsolutePath(), userDao);
    }
    
    @Test
    public void moodsAreReadCorrectlyFromFile() {
        List<Mood> moods = dao.getAll();
        assertEquals(1, moods.size());
        Mood mood = moods.get(0);
        assertEquals(3, mood.getValue());
        //todo päivämäärän testaus
        assertEquals("esimerkki", mood.getUser().getUsername());
    }
    
    @Test
    public void generatesId() {
        List<Mood> moods = dao.getAll();
        int id = moods.size() + 1;
        
        assertEquals(dao.generateId(), id);
   
    }
    
    @Test
    public void createMoodWorks() throws Exception{
        LocalDate d = LocalDate.now();
        User u = new User("esim", "erika");
        Mood m = new Mood(0, 9, d, u);
        
        assertEquals(dao.create(m), m);
    }
    
}
