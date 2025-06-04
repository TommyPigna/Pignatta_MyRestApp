# **MYRESTAPP_TOMMASOPIGNATTA**

Un'applicazione Android sviluppata in Kotlin e XML tramite Android Studio, progettata per realizzare delle chiamate attraverso l'uso delle REST API, gestione di più activity, parsing JSON e comunicazione tra interfacce grafiche.

---

## **SCOPO DEL PROGETTO**

L’obiettivo dell'app è permettere agli utenti di autenticarsi tramite una schermata di login e, una volta effettuato l’accesso, cercare film tramite una chiamata HTTP all'API pubblica OMDb. I risultati vengono visualizzati con titolo, anno e locandina in un'interfaccia grafica quanto piu' coerente possibile.

---

## **STRUTTURA DELL'APPLICAZIONE**

L’app è composta da **quattro activity principali**, ognuna con una funzione specifica:

1. **Main (LoginActivity)**: schermata iniziale in cui l’utente inserisce nome utente e password. Se le credenziali sono corrette, l'utente accede alla schermata principale.

2. **Menu**: consente all’utente di cercare un film tramite un campo di testo. I risultati vengono ottenuti da OMDb API e mostrati in una lista con titolo, anno e poster.

3. **MovieAdapter**: adattatore della `RecyclerView` che riceve la lista dei film e li visualizza usando immagini dinamiche caricate con Glide.

4. **WebView**: activity predisposta per future funzionalità, come la visualizzazione di trailer o pagine web relative ai film cercati. Inizialmente mostra solo un layout vuoto.

---

## **FUNZIONALITÀ**

- **Login con validazione delle credenziali**
  - Le credenziali corrette sono hardcoded (username: `TommyPigna`, password: `16112006`)
  - La password, se corretta, viene cifrata con SHA-256 e codificata in Base64

- **Ricerca film da API**
  - L’utente inserisce un titolo da cercare
  - Viene effettuata una richiesta HTTP alla OMDb API
  - I risultati vengono convertiti da JSON a oggetti Kotlin

- **Visualizzazione dei risultati**
  - I film trovati vengono mostrati in una lista con `RecyclerView`
  - Per ogni film si vedono titolo, anno e locandina
  - Se il poster non è disponibile, viene mostrata un'immagine di default

---

## **NAVIGAZIONE TRA LE ACTIVITY**

1. `Main`: l’utente inserisce le credenziali e accede al menu se sono corrette  
2. `Menu`: l’utente può cercare film e vedere i risultati  
3. `MovieAdapter`: gestisce l'adattamento dei dati nel layout dei film  
4. `WebView`: activity per visualizzare le caratteristiche del film ricercato  

---

## **RISORSE GRAFICHE**

Tutte le immagini vanno posizionate nella cartella `res/drawable/`:

- `ic_launcher_background`: immagine di default per poster mancanti  
- Le immagini dei poster vengono caricate tramite URL esterni (OMDb API)

---

## **REQUISITI TECNICI**

- Android Studio  
- SDK Android versione 21 o superiore  
- Linguaggio: Kotlin  
- Connessione a Internet per usare l’API  

---

## **AVVIO DELL'APP**

1. Clonare o scaricare il progetto  
2. Aprirlo in Android Studio  
3. Eseguire il progetto su un emulatore o dispositivo fisico  
4. Inserire le credenziali nella schermata di login  
5. Iniziare a cercare film nella schermata `Menu`  

---

## **LICENZA**

Progetto realizzato da **TOMMASO PIGNATTA**  
