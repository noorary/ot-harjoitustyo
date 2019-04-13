
package moodtracker.domain;

import moodtracker.dao.UserDao;
import moodtracker.dao.MoodDao;

public class MoodtrackerActions {
    
    
    private UserDao userDao;
    public User currentlyLoggedIn;
    private MoodDao moodDao;
    
    public MoodtrackerActions(UserDao userDao, MoodDao moodDao) {
        this.userDao = userDao;
        this.moodDao = moodDao;
    }
    
    public boolean createUser(String username, String name) {
        if (userDao.findUser(username) != null) {
            return false;
        }
        
        User newuser = new User(username, name);
        
        try {
            userDao.create(newuser);
        } catch (Exception e) {
            return false;
        }
        
        return true;
        
    }
    
    public boolean login(String username) {
        
        User user = userDao.findUser(username);
        if (user == null) {
            return false;
        }
        
        currentlyLoggedIn = user;
        
        return true;
    }
    
    
    
    
    
}
