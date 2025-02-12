Certo, riorganizzerò le prime 10 pagine del documento originale, indicando il riferimento alle pagine di origine.

---

# Il Linguaggio XML

## Introduzione a XML

- **XML (eXtensible Markup Language)**: Un metalinguaggio di markup che aiuta a definire altri linguaggi di markup. Non ha tag predefiniti, ma una sintassi specifica per rappresentare strutture di dati e documenti.
- **Specifiche**: Definite dal W3C (World Wide Web Consortium).
- **Utilizzo**: Compatibile con vari dispositivi hardware e software, utilizzato in diversi contesti.

*(Pagina 1)*

---

# Il Linguaggio XML

## Caratteristiche di XML

- **Separazione dei dati dalla loro rappresentazione**: XML separa i dati dalla loro visualizzazione.
- **Regole comuni**: Utilizza un insieme di regole comuni per vari contesti.
- **Tag identificativi**: I tag identificano immediatamente il tipo di dato, come `<nome>`.
- **Compatibilità con HTML**: Può essere associato a file HTML per rendere la rappresentazione indipendente dai dati.
- **Interoperabilità**: Rende compatibili tra loro formati dati di diversi database.

*(Pagina 2)*

---

# Il Linguaggio XML

## Esempio di Utilizzo

- **Contesto di utilizzo**: XML è estendibile con un numero ampio di tag, rendendolo adattabile a diversi contesti.
- **Esempio**: I dati possono essere immagazzinati in un documento XML separato, mentre l'HTML si occupa della visualizzazione.

*(Pagina 3)*

---

# Il Linguaggio XML

## Sintassi di XML

- **Struttura**: XML ha una struttura gerarchica ad albero, simile all'HTML.
- **Prologo**: Indica il set di caratteri e la versione di XML.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <book category="cooking">
        <title lang="en">Everyday Italian</title>
        <author>Giada De Laurentiis</author>
        <year>2005</year>
        <price>30.00</price>
    </book>
</bookstore>
```

*(Pagina 4)*

---

# Il Linguaggio XML

## Regole Sintattiche

- **Dichiarazione corretta**: Ogni documento XML deve avere una dichiarazione corretta.
- **Elemento radice unico**: Il corpo deve possedere un unico elemento radice.
- **Tag di apertura e chiusura**: Ogni elemento deve avere un tag di apertura e chiusura.
- **Nidificazione corretta**: I tag inferiori devono essere aperti e chiusi correttamente.
- **Case-sensitive**: XML è case-sensitive.
- **Nomi dei tag**: Non possono iniziare con underscore o numero e non devono avere spazi.
- **Valori degli attributi**: Devono essere chiusi tra virgolette.

*(Pagina 5)*

---

# Il Linguaggio XML

## Esempio di Creazione di un Elemento di Rubrica

```xml
<?xml version="1.0" encoding="UTF-8"?>
<RUBRICA>
    <PERSONA qualifica="operaio">
        <NOME>Paolo</NOME>
        <COGNOME>Rossi</COGNOME>
        <QUALIFICA>Operaio</QUALIFICA>
    </PERSONA>
    <PERSONA>
        <NOME>Mario Bianchi</NOME>
        <COGNOME>Rossi</COGNOME>
    </PERSONA>
</RUBRICA>
```

*(Pagina 6)*

---

# Il Linguaggio XML

## Aggiunta di un Campo Data in un Messaggio

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<messaggio>
    <data>2017-07-12</data>
    <mittente>Mario</mittente>
    <destinatario>Maria</destinatario>
    <oggetto>promemoria</oggetto>
    <testo>Ricordati che siamo d'accordo di vederci venerdì sera</testo>
</messaggio>
```

*(Pagina 7)*

---

# Il Linguaggio XML

## Spazio dei Nomi (Namespace)

- **Namespace**: Utilizzato per distinguere nomi di tag uguali con significati diversi.
- **URI (Uniform Resource Identifier)**: Utilizzato come prefisso per identificare lo spazio dei nomi.

### Esempio di Namespace

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<ib:libro xmlns:lb="mioSito.com/libri">
    <ib:titolo>Libro di informatica</ib:titolo>
    <ca:capitolo xmlns:ca="mioSito.com/capitoli">
        <ca:titolo>Documento in stile XML</ca:titolo>
        <ca:testo>testo testo testo</ca:testo>
    </ca:capitolo>
</ib:libro>
```

*(Pagina 8)*

---

# Il Linguaggio XML

## Esempio con XML Notepad

```xml
<?xml version="1.0" encoding="utf-8"?>
<biblioteca>
    <libro>
        <titolo>Libro di esempio 1</titolo>
        <autore>John Doe</autore>
        <anno_pubblicazione>2023</anno_pubblicazione>
    </libro>
    <libro>
        <titolo>Libro di esempio 2</titolo>
        <autore>Jane Smith</autore>
        <anno_pubblicazione>2022</anno_pubblicazione>
    </libro>
</biblioteca>
```

*(Pagina 9)*

---

# Il Linguaggio XML

## Validazione con DTD

- **DTD**: Document Type Definition, utilizzato per validare i documenti XML.
- **Vincoli**: Definisce gli elementi e gli attributi del documento XML, ma non il tipo di contenuto.

### Esempio di DTD

```xml
<!ELEMENT posta (messaggio)*>
<!ELEMENT messaggio (mittente, destinatario, intestazione, testo)>
<!ELEMENT mittente (#PCDATA)>
<!ELEMENT destinatario (#PCDATA)>
<!ELEMENT intestazione (#PCDATA)>
<!ELEMENT testo (#PCDATA)>
```

*(Pagina 10)*

---
