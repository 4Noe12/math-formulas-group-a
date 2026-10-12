# Math Formulas – Group A

Projektarbeit im Modul **Advanced Software Engineering**. Ziel der Gruppenaufgabe war es, eine bestehende Java-basierte REST-API für mathematische Formeln um die Berechnung von **Quadraten (`square`)** zu erweitern und die Implementierung automatisiert zu testen.

## Projektumfang

Die bestehende Anwendung basiert auf **Java 21**, **Quarkus 3.15.1** und **Maven** und enthält bereits Funktionen für Rechtecke. Im Rahmen der Gruppenarbeit wurde die Quadrat-Funktionalität in die vorhandene Projektstruktur integriert.

Für ein Quadrat mit Seitenlänge `a` werden folgende Werte berechnet:

- **Flächeninhalt:** `A = a * a`
- **Umfang:** `U = 4 * a`

Die Implementierung umfasst REST-Ressourcen, Eingabemodell, Validierung und Berechnungslogik. Die Eingabe erfolgt als JSON mit der Seitenlänge `a`. Fehlende oder negative Seitenlängen werden durch die Eingabevalidierung abgefangen; die API gibt dann `null` für nicht berechnete Werte und zusätzliche Fehlermeldungen zurück.

## Technologien

- Java 21
- Quarkus 3.15.1
- Maven
- Jakarta REST (JAX-RS)
- JUnit 5 und Quarkus Test
- REST Assured für API-Tests
- Postman für manuelle API-Tests

## Projektstruktur

```text
Gruppe-A-math-formulas/
├── README.md
├── Square Collection.postman_collection.json
└── TIF24_math-formulas/
    ├── pom.xml
    ├── mvnw / mvnw.cmd
    └── src/
        ├── main/
        │   ├── java/dev/gugel/mathformulas/
        │   │   ├── common/Formulas.java
        │   │   └── shape2d/v1/
        │   │       ├── calc/SquareCalc.java
        │   │       ├── input/SquareInput.java
        │   │       ├── input/validation/SquareInputValidation.java
        │   │       └── resources/SquareResources.java
        │   └── resources/application.properties
        └── test/java/dev/gugel/mathformulas/
            ├── common/FormulasTest.java
            └── shape2d/v1/resources/SquareResourcesTest.java
```

## Voraussetzungen und Start

Vorausgesetzt werden **JDK 21** und eine passende Maven-Installation. Maven-Wrapper-Skripte (`mvnw` und `mvnw.cmd`) sind vorhanden; für deren Nutzung muss gegebenenfalls eine lokale Maven-Installation beziehungsweise eine vollständige Wrapper-Konfiguration zur Verfügung stehen.

Repository klonen und das Maven-Projekt öffnen:

```bash
git clone https://github.com/4Noe12/math-formulas-group-a.git
cd math-formulas-group-a/TIF24_math-formulas
```

Anwendung im Entwicklungsmodus starten:

```bash
mvn quarkus:dev
```

## Square-API

Alle Berechnungsendpunkte werden mit **HTTP POST** aufgerufen und erwarten JSON. Die Endpunkte sind durch **HTTP Basic Authentication** geschützt.

| Endpunkt | Methode | Ergebnis |
| --- | --- | --- |
| `/v1/square` | POST | Fläche und Umfang |
| `/v1/square/area` | POST | Fläche |
| `/v1/square/perimeter` | POST | Umfang |
| `/v1/square/doc` | GET | Textdokumentation des Eingabeformats |

### Beispielanfrage

```bash
curl -X POST http://localhost:8888/v1/square \
  -u restUser:changeit \
  -H "Content-Type: application/json" \
  -d '{"a":5.0}'
```

Erwartete Berechnung:

```json
{
  "area": 25.0,
  "perimeter": 20.0
}
```

Je nach JSON-Serialisierung können zusätzlich Felder mit `null` auftreten oder weggelassen werden.

## Automatisierte Tests

Zur Überprüfung der Funktion wurden sowohl **Unit-Tests für die mathematischen Berechnungen** als auch **REST-API-Tests** implementiert.

**`FormulasTest.java`** überprüft unter anderem:

- Flächenberechnung des Quadrats: `a = 4.0` → `16.0`
- Umfangsberechnung des Quadrats: `a = 4.0` → `16.0`
- Verhalten der Berechnungsfunktionen bei `null`-Eingaben

**`SquareResourcesTest.java`** überprüft unter anderem:

- Erfolgreiche Berechnung von Fläche und Umfang (`a = 5.0` → `25.0` und `20.0`)
- Separate REST-Aufrufe für Flächeninhalt und Umfang
- Verhalten bei `null` und negativen Eingaben
- HTTP-Status `401` bei fehlender Authentifizierung
- Erreichbarkeit des Dokumentationsendpunkts

Alle Tests ausführen:

```bash
mvn test
```

Nur die quadratbezogenen Testklassen ausführen:

```bash
mvn -Dtest=FormulasTest,SquareResourcesTest test
```

## Manuelle API-Tests mit Postman

Im Repository befindet sich die Datei **`Square Collection.postman_collection.json`** mit vorbereiteten Anfragen für die Quadrat-Endpunkte. Diese kann in Postman importiert werden. Danach die lokale Anwendung starten und die Basic-Auth-Zugangsdaten überprüfen beziehungsweise eintragen.

## Lizenz

Im Maven-Projekt ist eine **MIT-Lizenz** enthalten (siehe `TIF24_math-formulas/LICENSE`).

---

**Modul:** Advanced Software Engineering  
**Gruppe:** A  
**Repository:** [4Noe12/math-formulas-group-a](https://github.com/4Noe12/math-formulas-group-a)
