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
![Kuva käyttöliittymäluonnoksesta](https://raw.githubusercontent.com/noorarytila/ot-harjoitustyo/master/dokumentaatio/kayttoliittymaluonnos.jpg)
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
