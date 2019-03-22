package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Kassapaate kassapaate;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
        kassapaate = new Kassapaate();
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void saldonKasvattaminenToimii() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosKortillaOnRahaa() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
        
        
    }
    
    @Test
    public void saldoEiMuutuJosLiianVahanRahaa() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals("saldo: 2.0", kortti.toString());
    }
    
    @Test
    public void palauttaaOikeanBooleanin() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test 
    public void palauttaaOikeanBooleanin2() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        
    }
}
