
package moodtracker.dao;

import java.util.List;
import moodtracker.domain.Mood;

public interface MoodDao {
    
    Mood create(Mood mood) throws Exception;
    
    List<Mood> getAll();
    
    void setDone(int id) throws Exception;
    
}
