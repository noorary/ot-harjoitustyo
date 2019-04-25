# Ohjelman käynnistäminen

Sovellus käynnistetään palautusrepositoriossa komennolla

```
mvn compile exec:java -Dexec.mainClass=moodtracker.ui.MoodtrackerUi
```

# Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään

![kirjautumisnäkymä](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ko1.png?raw=true)

Kirjautuminen onnistuu kirjoittamalla olemassaolevan käyttäjätunnus syötekenttään ja painamalla *LOGIN*

# Uuden käyttäjän luominen

Uusi käyttäjä luodaan painamalla kirjautumisnäkymässä *create new user* jonka jälkeen syötekenttiin
kirjoitetaan tiedot ja painetaan *CREATE*

![uuden käyttäjän luominen](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ko2.png?raw=true)

Jos käyttäjän luominen onnistuu, palataan kirjautumisnäkymään.

# Moodin lisääminen

Kirjautumisen jälkeen siirrytään moodien lisäämisnäkymään.

![moodin lisääminen](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ko3.png?raw=true)

Käyttäjä voi valita moodin numeerisen arvon 1-10 välillä. Moodi tallennetaan painamalla *Add mood*

# Sektoridiagrammin näyttäminen

Kun käyttäjä painaa *show moods in piechart" - painiketta, siirtyy sovellus näyttämään yhtenvedon
käyttäjän tallettamista moodeista. 

![sektoridiagrammi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/ko4.png?raw=true)

Diagramminäkymästä voi palata takaisin moodien lisäysnäkymään painamalla *Go Back* painiketta.

Kun käyttäjä painaa moodien lisäysnäkymässä *LOGOUT*-nappulaa, kirjautuu käyttäjä ulos ja sovellus
palaa takaisin kirjautumisnäkymään.
