
package moodtracker.domain;

import moodtracker.dao.UserDao;


public class MoodtrackerActions {
    
    
    private UserDao userDao;
    private User currentlyLoggedIn;
    
    public MoodtrackerActions(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public boolean createUser(String username, String name) {
        if (userDao.findUser(username) != null) {
            return false;
        }
        
        User newuser = new User(username, name);
        
        try {
            userDao.create(newuser);
        } catch(Exception e) {
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
