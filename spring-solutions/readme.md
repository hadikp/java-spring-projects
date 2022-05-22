# Spring példa feladat JPA nélkül

Docker futtatása:

A lebildelt docker image-ot a következő Docker paranccsal indíthatod el:

```shell
docker run -d -p 8080:8080 spring-solutions
```

A feladatleírást olvasd el részletesen, és nézd meg az egyes részfeladatokhoz tartozó teszteseteket is,
hogy milyen inputra mi az elvárt viselkedése az alkalmazásnak!

## Feladatleírás

A feladatban egy mozi foglalási rendszerét kell megvalósítanod.


A `Movie` osztályban továbbá szerepeljen egy metódus ami paraméterül vár egy egész számot,
ami a beérkezett foglalás szám. Ha van elég szabad hely akkor a paraméter értékét vonjuk
le a szabad helyek számából, különben dobjunk `IllegalStateException`-t!


A `MovieController` osztály alapértelmezetten a `/api/cinema` URL-en várja a kéréseket és
a következő funkciókat valósítja meg:

* Le lehet kérdezni az összes filmet, és opcionálisan a film címére is rá lehet szűrni.
  Ekkor mindig a címet, az időpontot és szabad helyek számát adjuk vissza!

*
* Lehessen törölni az összes filmet.

* A következő szempontokat vegyük még figyelembe:
    * Új film címe nem lehet üres, és legalább 20 helynek kell lennie rá.
    * Ha a megfelelő `id`-n keresztül nem található a film akkor `404`-es státuszkóddal térjünk vissza.
    * Ha több helyet akarunk foglalni, mint ahány szabad hely van, akkor ne történjen meg a foglalás.
      Térjünk vissza `400 BAD_REQUEST` státuszkóddal.