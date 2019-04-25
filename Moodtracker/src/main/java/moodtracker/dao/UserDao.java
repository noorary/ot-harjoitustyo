
package moodtracker.dao;

import java.util.HashMap;
import moodtracker.domain.User;
import java.util.List;

/**
 * UserDao.java
 * Rajapinta joka tarjoaa Data Access Object - metodit käyttäjän
 * luomiseen, löytämiseen ja kaikkien käyttäjien listaamiseen.
 * @author nrytila
 */

public interface UserDao {
    
    /**
     * Metodi käyttäjän luomiseen 
     * @param user Parametrina luotavan käyttäjän  User-olio
     * @return User
     * @throws Exception Heittää mahdolliseen tiedostoonkirjoitusvirheen
     */
    User create(User user) throws Exception;
    
    /**
     * Metodi käyttäjän etsimiseen käyttäjänimen perusteella
     * @param username Etsittävän käyttäjän käyttäjänimi
     * @return User tai null
     */
    
    User findUser(String username);
    
    /** 
     * Metodi kaikkien käyttäjien listaamiseksi
     * @return lista käyttäjistä
     */
    List<User> getAll();
    
    
}
