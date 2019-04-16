
import java.util.ArrayList;
import java.util.List;
import moodtracker.dao.UserDao;
import moodtracker.domain.User;

public class FakeUserDao implements UserDao {
    List<User> users = new ArrayList<>();
    
    
    public FakeUserDao() {
        users.add(new User("esimerkki", "erkki"));
    }
    
    @Override
    public User findUser(String username) {
        return users.stream().filter(u-> u.getUsername().equals(username)).findFirst().orElse(null);
        
        
    }
    
    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }
    
    @Override
    public List<User> getAll() {
        return users;
    }
}
