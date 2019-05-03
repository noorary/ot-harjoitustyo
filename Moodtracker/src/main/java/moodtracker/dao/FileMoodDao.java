
package moodtracker.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import moodtracker.domain.User;
import moodtracker.domain.Mood;
import java.time.LocalDate;
import java.util.Properties;


/**
 * Luokka joka tarjoaa Data Access Object metodit moodien tallentamiseksi tiedostoon 
 * @author nrytila
 */
public class FileMoodDao implements MoodDao {
    
    private List<Mood> moods;
    private String file;
    
    /**
     * Konstruktori, joka valmistelee tiedoston moodien tallettamista ja lukemista varten
     * @param file tiedoston nimi
     * @param users UserDao 
     * @throws Exception 
     */
    
    public FileMoodDao(String file, UserDao users) throws Exception {
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
    
    /**
     * Metodi luo moodille id:n
     * @return id
     */       
    public int generateId() {
        return moods.size() + 1;
    }
    
    /**
     * Metodi kaikkien talletettujen moodien listaamiseen
     * @return lista talletetuista moodeista
     */
    @Override
    public List<Mood> getAll() {
                
        return moods;

    }
     
    /**
     * Metodi moodin luomiseksi ja tallettamiseksi tiedostoon.
     * @param mood
     * @return luo moodi olions
     * @throws Exception 
     */
    
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
    
    /**
     * Metodi luo tietyn käyttäjän moodeista ArrayListin
     * @param user käyttäjä, jonka moodeja luetaan
     * @return arraylist käyttäjän moodeista
     * @throws Exception 
     */
    
    public ArrayList<Integer> usersMoods(User user) throws Exception {
        
        ArrayList<Integer> usersmoods = new ArrayList<>();
        Scanner reader = new Scanner(new FileReader("moods.txt"));
        
        while (reader.hasNextLine()) {
            String[] parts = reader.nextLine().split(";");
            
            
            String userf = user.toString();
            if (parts[3].equals(userf)) {
                usersmoods.add(Integer.parseInt(parts[1]));
            }
            
            
        }
        
        return usersmoods;
       
    }
             
             
            
            
            
            
            
    
}
