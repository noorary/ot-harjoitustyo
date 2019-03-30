
package moodtracker.domain;

import moodtracker.dao.DatabaseUserDao;


public class MoodtrackerActions {
    
    private DatabaseUserDao DBuserDao;
    
    public MoodtrackerActions(DatabaseUserDao dbuserDao) {
        this.DBuserDao = dbuserDao;
    }
    
    public boolean createUser(String username, String name) {
        User user = new User(username, name);
        try {
            DBuserDao.create(user);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
}
