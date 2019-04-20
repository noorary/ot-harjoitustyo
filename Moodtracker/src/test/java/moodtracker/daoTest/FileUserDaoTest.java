package moodtracker.daoTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
import java.io.FileInputStream;
import moodtracker.dao.UserDao;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author nrytila
 */
public class FileUserDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;
    UserDao dao;
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("esimerkki;erkki\n");
        }
        
        dao = new FileUserDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void userReadingWorks() {
        List<User> users = dao.getAll();
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("esimerkki", user.getUsername());
        assertEquals("erkki", user.getName());
    }
    
    @Test
    public void nonExistingUserIsNull() {
        User user = dao.findUser("mallikas");
        assertEquals(null, user);
    }
    
    @Test
    public void existingUserIsFound() {
        User user = dao.findUser("esimerkki");
        assertEquals("esimerkki", user.getUsername());
        assertEquals("erkki", user.getName());
    }
    
    @Test
    public void savedUserIsFound() throws Exception {
        User nu = new User("norppa", "noora");
        dao.create(nu);
        
        User user = dao.findUser("norppa");
        assertEquals("norppa", user.getUsername());
        assertEquals("noora", user.getName());
    }
    
    @After
    public void tearDown() {
        userFile.delete();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
