#Arkkitehtuurikuvaus

##Rakenne

Ohjelman rakenne noudattaa kolmitasoista arkkitehtuuria, ja koodin pakkaurakenne on seuraavanlainen

LISÄÄ KUVA PAKKAUSRAKENTEESTA

Pakkaus  *moodtracker.ui* sisältää JavaFX:llä toteutetun käyttöliittymän, *moodtracker.domain*
sisältää sovelluslogiikan ja moodtracker.dao sisältää tietojen tallennuksesta vastaava koodin.

##Käyttöliittymä
Käyttöliittymä sisältää seuraavat neljä näkymää

* Kirjautuminen
* Uuden käyttäjän luominen
* Moodien lisääminen
* Moodien yhteenveto sektoridiagrammina

## Pakkauskaavio
![luokka/pakkauskaavio](https://raw.githubusercontent.com/noorarytila/ot-harjoitustyo/master/dokumentaatio/Moodtracker%20luokka_pakkauskaavio.png)

## Kirjautuminen sekvenssikaaviona

Kun kirjautumiskenttään on kirjoitettu käyttäjätunnus ja loginButton:ia
painetaan, etenee kirjautuminen seuraavasti

![kirjautuminensekvenssi](https://raw.githubusercontent.com/noorarytila/ot-harjoitustyo/master/dokumentaatio/kirjautuminen.jpg)
