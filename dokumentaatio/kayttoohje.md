# Käyttöohje

## Konfigurointi
Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto 
config.properties. Tiedoston tulee olla seuraavanlainen.

```
userFile=users.txt
moodFile=moods.txt
```

## Ohjelman käynnistäminen

Sovellus käynnistetään komennolla

```
java -jar moodtracker.jar
```

## Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään

![kirjautumisnäkymä](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kaytto1.png?raw=true)

Kirjautuminen onnistuu kirjoittamalla olemassaolevan käyttäjätunnus syötekenttään ja painamalla *LOGIN*

## Uuden käyttäjän luominen

Uusi käyttäjä luodaan painamalla kirjautumisnäkymässä *create new user* jonka jälkeen syötekenttiin
kirjoitetaan tiedot ja painetaan *CREATE*

![uuden käyttäjän luominen](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kaytto2.png?raw=true)

Jos käyttäjän luominen onnistuu, palataan kirjautumisnäkymään.

## Moodin lisääminen

Kirjautumisen jälkeen siirrytään moodien lisäämisnäkymään.

![moodin lisääminen](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kaytto3.png?raw=true)

Käyttäjä voi valita moodin numeerisen arvon 1-10 välillä. Moodi tallennetaan painamalla *Add mood*

## Sektoridiagrammin näyttäminen

Kun käyttäjä painaa *show moods in piechart" - painiketta, siirtyy sovellus näyttämään yhtenvedon
käyttäjän tallettamista moodeista. 

![sektoridiagrammi](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kaytto4.png?raw=true)

Diagramminäkymästä voi palata takaisin moodien lisäysnäkymään painamalla *Go Back* painiketta.

Kun käyttäjä painaa moodien lisäysnäkymässä *LOGOUT*-nappulaa, kirjautuu käyttäjä ulos ja sovellus
palaa takaisin kirjautumisnäkymään.
