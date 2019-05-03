# Moodtracker App

## Ohjelmistotekniikka, harjoitustyö

Sovelluksen avulla käyttäjien on mahdollista pitää kirjaa mielialoistaan asteikolla 1-10.
Sovellukseen rekisteröidytään jonka jälkeen pääsee kirjautumaan sisään ja tallentamaan mielialoja.
Sovellus tarjoaa yhteenvetoja mielialojen kehityksestä.

### Dokumentaatio

[Vaatimusmäärittely](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Käyttöohje](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Arkkitehtuurikuvaus](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/noorarytila/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

### Releaset
[Viikko5](https://github.com/noorarytila/ot-harjoitustyo/releases)

[Viikko6](https://github.com/noorarytila/ot-harjoitustyo/releases/tag/viikko6)

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

JavaDoc generoidaan komennolla

```mvn javadoc:javadoc```

JavaDocia voi tarkastella avaamalla selaimella tiedosto *target/site/apidocs/index.html*

#### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/noorarytila/ot-harjoitustyo/blob/master/Moodtracker/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla

```mvn jxr:jxr checkstyle:checkstyle```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*
