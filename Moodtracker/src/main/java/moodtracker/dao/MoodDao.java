
package moodtracker.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import moodtracker.domain.Mood;
import moodtracker.domain.User;

public interface MoodDao {
    
    List<Mood> getAll();
    
    Mood create(Mood mood) throws Exception;
    
    ArrayList<Integer> usersMoods(User user) throws Exception;
    
    
    
}
