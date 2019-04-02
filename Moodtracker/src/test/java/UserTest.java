
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
        assertTrue(answer.equals(name));
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    private void assertEquals(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
