
package moodtracker.domain;

import java.lang.Object;
import java.time.LocalDate;
import moodtracker.domain.User;


/**
 * Luokka tarjoaa Moodin luomiseen tarvittavan toiminnallisuuden ja
 * luomiseen ja päivittämiseen tarvittavia metodeja.
 * @author nrytila
 */

public class Mood {
    
    private int id;
    private int value;
    private LocalDate date;
    private User user;
    
    /**
     * Konstruktori, jonka avulla voidaan luoda moodi-olion
     * @param id moodin yksilöivä id
     * @param value moodin numeerinen arvo
     * @param date moodin tallennuspäivämäärä
     * @param user moodiin liittyvä käyttäjä
     */
    
    public Mood(int id, int value, LocalDate date, User user) {
        
        this.id = id;
        this.value = value;
        this.date = date;
        this.user = user;
        
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
