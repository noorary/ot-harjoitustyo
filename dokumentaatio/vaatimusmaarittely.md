# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjä voi pitää kirjaa mielialoistaan päiväkirjatyylisesti, mutta helpommin.
Sovelluksella voi seurata mielialojen yhteenvetoa ja kehittymistä esim viikon. Sovellusta voi käyttää useampi rekisteröitynyt käyttäjä ja jokaisella käyttäjällä on
yksilöllinen seurantanäkymä.
## Käyttäjät
Alkuvaiheessa sovelluksella on vain yksi käyttäjärooli eli *normaali käyttäjä*. Myöhemmin on mahdolli
sta lisätä sovellukseen suuremmilla oikeuksilla varustettu *pääkäyttäjä*.
## Käyttöliittymäluonnos
Sovelluksessa on neljä eri näkymää.
![Kuva käyttöliittymäluonnoksesta](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttoliittymaluonnos.jpg?raw=true)
Sovellus aukee kirjautumisnäkymään, josta on mahdollista siirty uuden käyttäjän luomisnäkymään tai
kirjautua sisään ja siirtyä sovelluksen 'etusivulle'. Etusivulta voi siirtyä lisäämään uuden mielialan
tai tarkastelemaan yhteenvetoa.
## Perusversion tarjoama toiminnallisuus
### Ennen kirjautumista
* Käyttäjä voi luoda käyttäjätunnuksen
  * käyttäjätunnuksen tulee olla uniikki ja vähintään 6 merkkiä pitkä
* Käyttäjä voi kirjautua järjestelmään
  * kirjautuminen tapahtuu syöttämällä käyttäjätunnus ja painamalla 'login'
  * jos käyttäjätunnusta ei ole olemassa, sovellus ilmoittaa tästä
### Kirjautumisen jälkeen
* Käyttäjä näkee sovelluksen perusnäkymän
* Käyttäjä voi painaa 'add mood' lisätäkseen uuden mielialan
* Käyttäjä voi painaa 'view summary' tarkastellakseen yhteenvetoa
### Add mood - näkymä
* Käyttäjä voi lisätä mielialan
  * mieliala valitaan 1-10 välillä ja valitsemalla päivä
  * lisääminen tapahtuu painamalla 'add', jonka jälkeen palataan perusnäkymään
### View summary - näkymä 
* Käyttäjä näkee yhteenvedon neljän viimeisemmän viikon mielialoista
* Käyttäjä voi palata takaisin perusnäkymään painamalla 'back'
## Jatkokehitysideoita
Perusversion jälkeen järjestelmää voidaan täydentää ajan salliessa esim. seuraavilla toiminnallisuuksilla
* usean mielialan lisääminen samalle päivälle
* kommentin lisääminen mielialan lisäämisen yhteydessä
* lisävalintojen mahdollistaminen, esim. 'kipeänä', 'lomalla' jne.
* erilaisten yhteenvetojen mahdollistaminen, esim viikko, kuukausi, vuosi, koko sovelluksen käyttöajalta
* erilaisten yhteenvetojen toteuttaminen, esim. ympyrädiagrammi eri mielialojen määrästä
* käyttäjien yhteyteen salasana, jota vaaditaan kirjautuessa
* käyttäjätunnuksen poisto
