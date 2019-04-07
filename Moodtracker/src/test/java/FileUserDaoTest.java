/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import moodtracker.dao.FileUserDao;
import moodtracker.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nrytila
 */
public class FileUserDaoTest {
    
    private List<User> users;
    private String file;
    
    public FileUserDaoTest() throws IOException {
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
    
    @Test
    public void getAllWorks() {
        User e = new User("esimerkki", "erkki");
        users.add(e);
        try {
            FileUserDao fileuserDao = new FileUserDao(file);
            assertEquals(users, fileuserDao.getAll());
        } catch (Exception ex) {
            Logger.getLogger(FileUserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
