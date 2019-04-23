package moodtracker.domainTest;



import java.time.LocalDate;
import java.time.Month;
import moodtracker.domain.Mood;
import moodtracker.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MoodTest {
    
    public MoodTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
        
    }
    
    @Test
    public void returnsId() {
        User u = new User("name", "name");
        LocalDate date = LocalDate.now();
        Mood m = new Mood (2, 3, date, u);
        
        assertEquals(m.getId(), 2);
    }
    
    @Test
    public void returnsValue() {
        User u = new User("name", "name");
        LocalDate date = LocalDate.now();
        Mood m = new Mood (2, 3, date, u);
        
        assertEquals(m.getValue(), 3);
    }
    
    @Test
    public void returnsUsers() {
        
        User u = new User("name", "name");
        LocalDate date = LocalDate.now();
        Mood m = new Mood (2, 3, date, u);
        
        assertEquals(m.getUser(), u);
    }
    
    @Test
    public void returnsDate() {
        User u = new User("name", "name");
        LocalDate date = LocalDate.now();
        Mood m = new Mood (2, 3, date, u);
        
        LocalDate now = LocalDate.now();
        
        assertEquals(m.getDate(), now);
    }
    
    @Test
    public void setIdWorks() {
        User u = new User("name", "name");
        User u2 = new User("esim", "erkki");
        
        LocalDate date = LocalDate.now();
        Mood m = new Mood(2, 3, date, u);
        m.setId(3);
        
        assertEquals(m.getId(), 3);
    }
    

}
