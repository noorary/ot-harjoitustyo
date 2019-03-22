
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }
    
    @Test
    public void hello() {}
    
    
    @Test
    public void rahamaaraOikein() {
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void myydytLounaatOikein() {
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0 && kassapaate.maukkaitaLounaitaMyyty() == 0);
        
    }
    
    @Test
    public void KassassaOlevaRahamaaraKasvaa() {
        kassapaate.syoEdullisesti(240);
        assertTrue(kassapaate.kassassaRahaa() == 100240);
    }
    
    @Test
    public void VaihtorahaOikein() {
        
        assertTrue(kassapaate.syoMaukkaasti(1000) == 600);
        
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaa() {
        kassapaate.syoEdullisesti(240);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void eiRiittavastiRahaa() {
        kassapaate.syoEdullisesti(200);
        assertTrue(kassapaate.syoEdullisesti(200) == 200);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
    }
}
