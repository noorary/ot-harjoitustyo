# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kolmitasoista arkkitehtuuria, ja koodin pakkaurakenne on seuraavanlainen

LISÄÄ KUVA PAKKAUSRAKENTEESTA

Pakkaus  *moodtracker.ui* sisältää JavaFX:llä toteutetun käyttöliittymän, *moodtracker.domain*
sisältää sovelluslogiikan ja moodtracker.dao sisältää tietojen tallennuksesta vastaava koodin.

## Käyttöliittymä
Käyttöliittymä sisältää seuraavat neljä näkymää

* Kirjautuminen
* Uuden käyttäjän luominen
* Moodien lisääminen
* Moodien yhteenveto sektoridiagrammina

Jokainen näkymä on toteutettu omana Scene-oliona. Näkymistä yksi kerrallaan on sijoitettu sovelluksen
stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa moodtracker.ui.MoodtrackerUi (LINKKI)

Käyytöliittymä on eriytetty sovelluslogiikasta ja se kutsuu vain tarvittavia sovelluslogiikan
toteuttavan MoodtrackerActions-luokan metodeja.

## Sovelluslogiikka

Ohjelman osien suhdetta kuvaava luokka/pakkauskaavio

![luokka/pakkauskaavio](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Moodtracker%20luokka_pakkauskaavio.png?raw=true)

## Tietojen pysyväistallennus

Pakkauksen moodtracker.dao luokat FileUserDao ja FileMoodDao toteuttavat tietojen tallentamisen
tiedostoihin.

Luokat noudattavat Data Access Object - suunnittelumallia. Luokat on eristetty rajapintojen UserDao ja
MoodDao taakse ja sovelluslogiikka ei käytä luokkia suoraan. Sovelluksen datan talletustapaa on 
mahdollistaa vaihtaa myöhemmmin.

### Tiedostot

Sovellus tallettaa käyttäjien ja moodien tiedot erillisiin tiedostoihin. Sovelluksen juureen on sijoitettu
config.properties (LINKKI) tiedosto, joka määrittelee tiedostojen nimet.

Sovellus tallettaa käyttäjät muodossa, jossa käyttäjänimi ja nimi erotetaan puolipisteellä

```
esimerkki;Erkki Esimerkillinen
noorarosa;Noora Rytilä

```
Moodit talletetaan samoin puolipisteillä niin, että ensin on moodin id, sitten sen numeerinen arvo 
välillä 1-10, sitten päivämäärä ja viimeisenä moodin lisänneen käyttäjän käyttäjänimi.

```
1;6;2019-3-27;noorarosa
2;9;2019-4-25;noorarosa
3;2;2019-4-25;esimerkki
```

## Päätoiminnallisuudet

Sovelluksen toimintalogiikka tärkeimpien päätoiminnallisuuksien osalta sekvenssikaaviona
  
**Kirjautuminen**

Kun kirjautumiskenttään on kirjoitettu käyttäjätunnus ja loginButton:ia
painetaan, etenee kirjautuminen seuraavasti

![kirjautumissekvenssi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kirjautuminen.jpg?raw=true)

**Uuden käyttäjän luominen**

**Moodin tallentaminen**

**Sektoridiagrammin näyttäminen**
