
package moodtracker.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import moodtracker.dao.UserDao;
import moodtracker.dao.MoodDao;

/**
 * Luokka tarjoaa Moodtracker-sovelluksen toimintaan ja sovelluslogiikkaan
 * liittyvät metodit.
 * @author nrytila
 */

public class MoodtrackerActions {
    
    
    private UserDao userDao;
    private MoodDao moodDao;
    private LocalDate localdate;
    /**
     * Kirjautuneena oleva käyttäjä
     */
    public User currentlyLoggedIn;
    
    
    /**
     * Valmistelee käytettävän toiminnallisuusluokan
     * @param userDao toiminnallisuuksiin käytettävä käyttäjien tallentamiseen liittyvä Data Access Object
     * @param moodDao toiminnallisuuksiin käytettävä moodien tallentamiseen liittyvä Data Access Object
     */
    public MoodtrackerActions(UserDao userDao, MoodDao moodDao) {
        this.userDao = userDao;
        this.moodDao = moodDao;
        
    }
    
    
    /**
     * Metodi toteuttaa toiminnallisuuden uuden käyttäjän luomiseksi:
     * Metodi kutsuu userDao:n findUser metodia tarkistaakseen, että
     * käyttäjänimi ei ole varattu sekä create - metodia, jotta 
     * uusi käyttäjä luodaan ja talletetaan.
     * @param username luotavan käyttäjän käyttäjänimi
     * @param name luotavan käyttäjän nimi
     * @return true tai false sen mukaan, onnistuiko käyttäjän luominen
     */
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
    
    /**
     * Metodi toteuttaa sovelluslogiikan osalta sisäänkirjautumisen.
     * Metodi luo uuden user-olion kutsumalla userDao:n findUser-metodia
     * parametrinään käyttäjänimi ja asettaa kirjautuneen käyttäjän muuttujaan.
     * 
     * @param username sisäänkirjautuvan käyttäjän käyttäjänimi
     * @return true jos sisäänkirjautuminen onnistuu, false jos käyttäjää ei löydy ja kirjautuminen epäonnistuu
     */
    
    public boolean login(String username) {
        
        User user = userDao.findUser(username);
        if (user == null) {
            return false;
        }
        
        currentlyLoggedIn = user;
        
        return true;
    }
    
    
    /**
     * Metodi uuden moodin luomiseksi. Kutsuu moodDao:n create metodia,
     * jotta uusi moodi luodaan ja talletetaan.
     * @param value moodin numeerinen arvo
     * @return true jos moodin luominen onnistuu, false jos ei onnistu, esimerkiksi tiedostoon kirjoittamisvirheen takia.
     */
    
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
    
    /**
     * Metodi, joka palauttaa tietyn käyttäjän moodit ja niiden määrän HashMap:ina. 
     * Metodi kutsuu MoodDao:n saman nimistä metodia, jonka palauttamasta ArrayList:istä luodaan HashMap.
     * 
     * @return HashMapina käyttäjän moodit
     * @throws Exception 
     */
    
    public HashMap<Integer, Integer> usersMoods() throws Exception {
        
        ArrayList<Integer> usersmoods = moodDao.usersMoods(currentlyLoggedIn);
       
        HashMap<Integer, Integer> moodmap = new HashMap<>();
       
        for (int i = 0; i < usersmoods.size(); i++) {
            int moodvalue = usersmoods.get(i);
           
            if (moodmap.containsKey(moodvalue)) {
                moodmap.put(moodvalue, (moodmap.get(moodvalue) + 1));
            } else {
                moodmap.put(moodvalue, 1);
            }
        }
       
       
        return moodmap;

    } 
    
    
    
    
    
    
    
}
