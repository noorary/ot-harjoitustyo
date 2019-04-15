
package moodtracker.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import moodtracker.domain.User;
import moodtracker.domain.Mood;
import java.time.LocalDate;


public class FileMoodDao implements MoodDao {
    
    public List<Mood> moods;
    private String file;
    
    public FileMoodDao  (String file, UserDao users) throws Exception {
        moods = new ArrayList<>();
        this.file = file;
        
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                int value = Integer.parseInt(parts[1]);
                LocalDate date = LocalDate.parse(parts[2]);
                User user = users.getAll().stream().filter(u -> u.getUsername().equals(parts[3])).findFirst().orElse(null);
                Mood mood = new Mood(id, value, date, user);
                moods.add(mood);
            } 
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
        
        
        }
    
            @Override
             public List<Mood> getAll() {
                
                return moods;
        
        }
             
             private int generateId() {
                 return moods.size() + 1;
             }
             
             @Override
             public Mood create(Mood mood) throws Exception {
                 mood.setId(generateId());
                 moods.add(mood);
                 save();
                 return mood;
             }
             
             private void save() throws Exception {
                 try (FileWriter writer = new FileWriter(new File(file))) {
                     for (Mood mood : moods) {
                         writer.write(mood.getId() + ";" + mood.getValue() + ";" + mood.getDate() + ";" + mood.getUser() + "\n");
                     }
                 }
             }
             
             
            
            
            
            
            
    
}
