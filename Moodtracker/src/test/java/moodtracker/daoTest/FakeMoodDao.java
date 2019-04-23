package moodtracker.daoTest;




import java.util.ArrayList;
import java.util.List;
import moodtracker.dao.MoodDao;
import moodtracker.domain.Mood;
import moodtracker.domain.User;

public class FakeMoodDao implements MoodDao {
    List<Mood> moods;
    
    public FakeMoodDao() {
        moods = new ArrayList<>();
        
    }
    
    @Override
    public List<Mood> getAll() {
        return moods;
    }
    
    @Override
    public Mood create(Mood mood) {
        mood.setId(moods.size()+1);
        moods.add(mood);
        return mood;
    }
    
    @Override
    public ArrayList<Integer> usersMoods(User user) {
        ArrayList<Integer> moods = new ArrayList<>();
        return moods;
    }
    
}
