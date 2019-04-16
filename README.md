# Moodtracker App

## Ohjelmistotekniikka, harjoitustyö

Sovelluksen avulla käyttäjien on mahdollista pitää kirjaa mielialoistaan asteikolla 1-10.
Sovellukseen rekisteröidytään jonka jälkeen pääsee kirjautumaan sisään ja tallentamaan mielialoja.
Sovellus tarjoaa yhteenvetoja mielialojen kehityksestä.

### Dokumentaatio

[Vaatimusmäärittely](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

Käyttöohje tulossa

[Arkkitehtuurikuvaus](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

Testausdokumentti tulossa

### Releaset
tulossa

### Komentorivikomennot

#### Testaus

Testit suoritetaan komennolla

```mvn test```

Testikattavuusraportti luodaan komennolla

```mvn jacoco:report```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

#### Suoritettavan jarin generointi

Komento

```mvn package```

generoi hakemistoon *target* suoritettavan jar-tiedoston Moodtracker-1.0-SNAPSHOT.jar

#### JavaDoc

**tulossa**

JavaDoc generoidaan komennolla

```mvn javadoc:javadoc```

JavaDocia voi tarkastella avaamalla selaimella tiedosto *target/site/apidocs/index.html*

#### Checkstyle

Tiedostoon **checkstyle.xml(linkki tulossa)* määritellyt tarkistukset suoritetaan komennolla

```mvn jxr:jxr checkstyle:checkstyle```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*
