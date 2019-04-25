# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kolmitasoista arkkitehtuuria, ja koodin pakkaurakenne on seuraavanlainen

![pakkausrakenne](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne.png?raw=true)

Pakkaus  *moodtracker.ui* sisältää JavaFX:llä toteutetun käyttöliittymän, *moodtracker.domain*
sisältää sovelluslogiikan ja moodtracker.dao sisältää tietojen tallennuksesta vastaava koodin.

## Käyttöliittymä
Käyttöliittymä sisältää seuraavat neljä näkymää

* Kirjautuminen
* Uuden käyttäjän luominen
* Moodien lisääminen
* Moodien yhteenveto sektoridiagrammina

Jokainen näkymä on toteutettu omana Scene-oliona. Näkymistä yksi kerrallaan on sijoitettu sovelluksen
stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa [moodtracker.ui.MoodtrackerUi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/Moodtracker/src/main/java/moodtracker/ui/MoodtrackerUi.java)

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
[config.properties](https://github.com/noorarytila/ot-harjoitustyo/blob/master/Moodtracker/config.properties) tiedosto, joka määrittelee tiedostojen nimet.

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

Painikkeen painamiseen reagoiva tapahtumakäsittelijä kutsuu sovleluslogiikan login metodia parametrinään
käyttäjätunnus. Sovelluslogiikka kysyy *UserDao*:lta onko käyttäjätunnus jo olemassa. Jos on, niin
kirjautuminen onnistuu ja käyttöliittymä vaihtaa sceneksi *mainScenen*.

**Uuden käyttäjän luominen**

Kun käyttäjä on uuden käyttäjän luomisnäkymässä syöttänyt käyttäjänimen ja nimen tekstikenttiin ja
klikkaa *CREATE* nappia, etenee käyttäjän luominen seuraavasti

![uusikäyttäjäsekvenssi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/uusikayttajasekvenssi.png?raw=true)

Tapahtumakäsittelijä kutsuu sovelluslogiikan *createUser*-metodia parametrinaan luotavan käyttäjän tiedot.
Sovelluslogiikka kysyy *userDao*:lta onko käyttäjätunnus jo olemassa. Jos ei ole, niin sovelluslogiikka
luo *User*-olion ja tallettaa sen kutsumalla *userDao*:n metodia *create*. Käyttöliittymä vaihtaa näkymäksi
*startScenen*.

**Moodin tallentaminen**

Kun käyttäjä on valinnut Moodille arvon ja klikkaa *Add new mood* - nappia etenee moodin lisääminen seuraavasti

![moodintallennussekvenssi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/moodintallentsekvenssi.png?raw=true)

Tapahtumakäsittelijä kutsuu sovelluslogiikan *createMood*-metodia parametrinaan Moodin numeraalinen arvo.
Sovelluslogiikka generoi moodille id:n, ja päivän ja luo uuden moodin. Moodi talletetaan, kun sovelluslogiikka
kutsuu *MoodDao*:n metodia *create*. 

**Sektoridiagrammin näyttäminen**

Kun käyttäjä klikkaa moodin lisäysnäkymässä *Show moods in  piechart*-painiketta, etenee sovelluksen
toiminta seuraavasti

![piirakkasekvenssi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sektorisekvenssi.png?raw=true)

Tapahtumakäsittelijä kutsuu UI:n omaa *showPieChart*-metodia parametrinaan stage ja paluu-nappi. 
Metodissa UI kutsuu sovelluslogiikan *usersMoods*-metodia, joka taas kutsuu *MoodDao*:n *usersMoods*-metodia
*MoodDao* palauttaa sovelluslogiikalle ArrayListin moodeista, joiden avulla sovelluslogiikka palauttaa
UI:lle HashMapin käyttäjän moodeista. Käyttöliittymä luo HashMapin datan perusteella sektoridiagrammin
ja vaihtaa nkymäksi *piechartScenen*.
