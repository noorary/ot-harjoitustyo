# Ohjelman käynnistäminen

Sovellus käynnistetään palautusrepositoriossa komennolla

```
mvn compile exec:java -Dexec.mainClass=moodtracker.ui.MoodtrackerUi
```

# Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään

KUVA

Kirjautuminen onnistuu kirjoittamalla olemassaolevan käyttäjätunnus syötekenttään ja painamalla *LOGIN*

# Uuden käyttäjän luominen

Uusi käyttäjä luodaan painamalla kirjautumisnäkymässä *create new user* jonka jälkeen syötekenttiin
kirjoitetaan tiedot ja painetaan *CREATE*

KUVA

Jos käyttäjän luominen onnistuu, palataan kirjautumisnäkymään.

# Moodin lisääminen

Kirjautumisen jälkeen siirrytään moodien lisäämisnäkymään.

KUVA

Käyttäjä voi valita moodin numeerisen arvon 1-10 välillä. Moodi tallennetaan painamalla *Add mood*

# Sektoridiagrammin näyttäminen

Kun käyttäjä painaa *show moods in piechart" - painiketta, siirtyy sovellus näyttämään yhtenvedon
käyttäjän tallettamista moodeista. 

KUVA

Diagramminäkymästä voi palata takaisin moodien lisäysnäkymään painamalla *Go Back* painiketta.

Kun käyttäjä painaa moodien lisäysnäkymässä *LOGOUT*-nappulaa, kirjautuu käyttäjä ulos ja sovellus
palaa takaisin kirjautumisnäkymään.
