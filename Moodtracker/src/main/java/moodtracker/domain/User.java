
package moodtracker.domain;

import java.util.ArrayList;
import java.util.List;
import moodtracker.dao.UserDao;

public class User {
    
    private String name;
    private String username;
    
    public User(String username, String name) {
        this.name = name;
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
    
}
