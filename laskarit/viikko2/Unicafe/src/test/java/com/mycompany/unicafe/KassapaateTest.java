
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
    
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void rahamaaraOikein() {
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void myydytLounaatOikeinEdulliset() {
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
        
    }
    
    @Test
    public void myydytLounaatOikeinMaukkaat() {
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 0);
        
    }
    
    @Test
    public void KassassaOlevaRahamaaraKasvaaEdullinen() {
        kassapaate.syoEdullisesti(240);
        assertTrue(kassapaate.kassassaRahaa() == 100240);
    }
    
    @Test
    public void KassassaOlevaRahamaaraKasvaaMaukas() {
        kassapaate.syoMaukkaasti(400);
        assertTrue(kassapaate.kassassaRahaa() == 100400);
    }
    
    @Test
    public void VaihtorahaOikeinMaukas() {
        
        assertTrue(kassapaate.syoMaukkaasti(1000) == 600);
        
    }
    
    @Test
    public void VaihtorahaOikeinEdullinen() {
        
        assertTrue(kassapaate.syoEdullisesti(1000) == 760);
        
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaEdulliset() {
        kassapaate.syoEdullisesti(240);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaMaukkaat() {
        kassapaate.syoMaukkaasti(400);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void eiRiittavastiRahaa() {
        kassapaate.syoEdullisesti(200);
        assertTrue(kassapaate.syoEdullisesti(200) == 200);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void edullisenOstoKortillaToimii() {
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void maukkaanOstoKortillaToimii() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaaMaukas() {
        kassapaate.syoMaukkaasti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 2);
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaaEdullinen() {
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoEdullisesti(kortti);
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 4);
    }
    
    @Test
    public void rahamaaraEiMuutuKortillaOstettaessaEdullinen() {
        kassapaate.syoEdullisesti(kortti);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void rahamaaraEiMuutuKortillaOstettaessaMaukas() {
        kassapaate.syoMaukkaasti(kortti);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void kortinSaldoJaKassanSaldoMuuttuu() {
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertTrue(kortti.saldo() == 2000);
        assertTrue(kassapaate.kassassaRahaa() == 101000);
    }
    
    @Test
    public void negatiivisenSaldonLataaminenEiOnnistu() {
        kassapaate.lataaRahaaKortille(kortti, -1000);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
        
        
    }
}
