# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjä voi pitää kirjaa mielialoistaan päiväkirjatyylisesti,
mutta helpommin. Sovellus koostaa mielialoista visuaalisen yhteenvedon.
## Käyttäjät
Alkuvaiheessa sovelluksella on vain yksi käyttäjärooli eli *normaali käyttäjä*. Myöhemmin on mahdolli
sta lisätä sovellukseen suuremmilla oikeuksilla varustettu *pääkäyttäjä*.
## Käyttöliittymä
Sovelluksessa on neljä eri näkymää. Sovellus aukeaa kirjautumisnäkymään, josta
käyttäjä voi kirjautua sisään tai siirtyä luomaan uutta käyttäjää.
Uuden käyttäjän ja kirjautumisen lisäksi on moodien lisäysnäkymä sekä
mahdollisuus siirtyä tarkastelemaan yhteenvetoa.
## Perusversion tarjoama toiminnallisuus
### Ennen kirjautumista
* Käyttäjä voi luoda käyttäjätunnuksen
  * käyttäjätunnuksen tulee olla uniikki ja vähintään 6 merkkiä pitkä
* Käyttäjä voi kirjautua järjestelmään
  * kirjautuminen tapahtuu syöttämällä käyttäjätunnus ja painamalla 'login'
  * jos käyttäjätunnusta ei ole olemassa, sovellus ilmoittaa tästä
### Kirjautumisen jälkeen
* Käyttäjä näkee sovelluksen perusnäkymän
* Käyttäjä voi lisätä uuden moodin valitsemalla sen numeerisen arvon ja painamalla *add mood*. 
* Käyttäjä voi kirjautua ulos painamalla *LOG OUT*
* Käyttäjä voi painaa 'Show moodsummary' tarkastellakseen yhteenvetoa
### Add mood - näkymä
* Käyttäjä voi lisätä mielialan
  * mieliala valitaan 1-10 välillä
  * lisääminen tapahtuu painamalla 'add', jonka jälkeen sovellus ilmoittaa lisäyksen onnistumisesta
### Show moodsummary - näkymä 
* Käyttäjä näkee yhteenvedon kaikista lisäämistään moodeista sektoridiagrammina
* Käyttäjä voi palata takaisin perusnäkymään painamalla 'back'
## Jatkokehitysideoita
Perusversion jälkeen järjestelmää voidaan täydentää ajan salliessa esim. seuraavilla toiminnallisuuksilla
* usean mielialan lisääminen samalle päivälle
* kommentin lisääminen mielialan lisäämisen yhteydessä
* lisävalintojen mahdollistaminen, esim. 'kipeänä', 'lomalla' jne.
* erilaisten yhteenvetojen mahdollistaminen, sektoridiagrammin lisäksi esimerkiksi xy-akseli
* käyttäjien yhteyteen salasana, jota vaaditaan kirjautuessa
* käyttäjätunnuksen poisto
* pääkäyttäjäroolin lisääminen
