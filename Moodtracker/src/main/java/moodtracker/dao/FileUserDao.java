
package moodtracker.dao;



import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import moodtracker.domain.User;

/** Luokka joka tarjoaa Data Access Object metodit käytttäjien
 * tallentamiseksi tiedostoon.
 * @author nrytila
 */
public class FileUserDao implements UserDao {
    private List<User> users;
    private String file;
    
    /**
     *
     * @param file käyttäjien tallentavan tiedoston nimi
     * @throws Exception heittää virheen, jos tiedoston luominen/
     * kirjoittaminen epäonnistuu
     */
    public FileUserDao(String file) throws Exception {
        users = new ArrayList<>();
        this.file = file;
        
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0], parts[1]);
                users.add(u);
            } 
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
        
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getUsername() + ";" + user.getName() + "\n");
            }
        }
    }
    
    /**
     * Metodi toteuttaa toiminnallisuuden, joka listaa kaikki
     * olemassaolevat käyttäjät
     * @return lista käyttäjistä
     */
        
    @Override
        public List<User> getAll() {
        return users;
    }
        
        
    /**
     * Metodi käyttäjän löytämiseksi käyttäjänimen perusteella
     * @param username etsittävän käyttäjän käyttäjänimi
     * @return käyttäjänimeä vastaava käyttäjä, tai jos sitä ei löydy niin null
     */    
    @Override
    public User findUser(String username) {
        return users.stream()
                    .filter(u -> u.getUsername()
                    .equals(username))
                    .findFirst()
                    .orElse(null);
    }
        
        
    
    /**
     * Metodi käyttäjän luomiseksi
     * @param user luotavan käyttäjän user-olio
     * @return luotu käyttäjä 
     * @throws Exception heittää virheen, jos tiedostoon kirjoittaminen epäonnistuu
     */    
    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();
        return user;
    }
      
    
}

