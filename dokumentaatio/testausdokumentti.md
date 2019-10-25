## Testausdokumentti



Sovelluksen luokkia, käyttöliittymäluokkaa lukuunottamatta, on testattu JUnit-testeillä. Käyttöliittymä on testattu manuaalisesti. Myös luokan Puzzle metodin solve testaus on tehty manuaalisesti.

### Luokkien testikattavuudet

![](https://github.com/essitepp/15-puzzle/blob/master/dokumentaatio/kuvat/testikattavuus1.png)  
![](https://github.com/essitepp/15-puzzle/tree/master/dokumentaatio/kuvat/testikattavuus2.png)  


## Ratkaisualgoritmin tehokkuus

Ratkaisuaika on laskettu keskiarvona kymmenen ratkaisukerran ajasta.

|Siirtoja|Aika|
|---|---|
|16|1,4 ms
|20|4,6 ms
|28|32,6 ms
|30|41,9 ms
|36|850,2 ms

Tarvittavien siirtojen määrän kasvaessa suureksi ratkaisualgoritmi ei toimi, koska läpikäytävien vaihtoehtojen määrä on niin suuri, että muisti ei riitä ratkaisun löytämiseen.


