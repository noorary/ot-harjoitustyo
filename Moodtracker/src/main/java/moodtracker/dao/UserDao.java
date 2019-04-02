
package moodtracker.dao;

import moodtracker.domain.User;
import java.util.List;

public interface UserDao {
    
    User create(User user) throws Exception;
    
    User findUser(String username);
    
    List<User> getAll();
}
