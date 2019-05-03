package moodtracker.domainTest;


import java.util.EmptyStackException;
import moodtracker.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserTest {
    
    public UserTest() {
    }
    
    @Test
    public void returnsName() {
        String name = "name";
        String username = "nickname";
        User user1 = new User(username, name);
        String answer = user1.getName();
        assertEquals(answer, "name");
        
    }
    
    @Test
    public void returnUsername() {
        String name = "name";
        String username = "nickname";
        User user1 = new User(username, name);
        assertEquals(user1.getUsername(), "nickname");
    }

    @Test
    public void toStringWorks() {
        String name = "name";
        String username = "nickname";
        User user1 = new User(username, name);
        assertEquals(user1.toString(), "nickname");
    }
    
    


    

    
}
