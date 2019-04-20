
package moodtracker.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import moodtracker.dao.UserDao;
import moodtracker.dao.MoodDao;

public class MoodtrackerActions {
    
    
    private UserDao userDao;
    public User currentlyLoggedIn;
    private MoodDao moodDao;
    public LocalDate localdate;
    
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
    
    public boolean createMood(int value) {
        
        LocalDate now = LocalDate.now();
        Mood m = new Mood(0, value, now, currentlyLoggedIn);
        
        try {
            moodDao.create(m);
        } catch (Exception e) {
            return false;
        }
        
        return true;
        
        
    }
    
    public HashMap<Integer, Integer> usersMoods() throws Exception{
        
       ArrayList<Integer> usersmoods = moodDao.usersMoods(currentlyLoggedIn);
       
       HashMap<Integer, Integer> moodmap = new HashMap<>();
       
       for(int i=0; i < usersmoods.size(); i++) {
           int moodvalue =usersmoods.get(i);
           
           if(moodmap.containsKey(moodvalue)) {
               moodmap.put(moodvalue, (moodmap.get(moodvalue) +1));
           } else {
               moodmap.put(moodvalue, 1);
           }
       }
       
       return moodmap;
       
               
       
        
    } 
    
    
    
    
    
    
    
}
