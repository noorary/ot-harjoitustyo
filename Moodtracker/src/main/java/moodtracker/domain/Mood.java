
package moodtracker.domain;

import java.lang.Object;
import java.time.LocalDate;
import moodtracker.domain.User;

public class Mood {
    
    private int id;
    private int value;
    private LocalDate date;
    private User user;
    
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    
    
}
