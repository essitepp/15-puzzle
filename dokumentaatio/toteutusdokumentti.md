# Toteutusdokumentti


Ohjelmassa on käytössä tekstikäyttöliittymä. Pelin logiikasta huolehtii luokka Puzzle. Näiden lisäksi ohjelmassa on erilaisia tietorakenneluokkia.

Ratkaisualgoritmina sovelluksessa on A*-algoritmi, jota varten sovellukseen on toteutettu minimikeko. Kekoon tallennetaan pelitilanteita, jotka sisältävät tiedon peliruudukon järjestyksestä sekä tilanteen saavuttamiseen käytettyjen siirtojen määrän. Lisäksi pelitilanteeseen sisältyy tieto edeltävän tilanteen peliruudukon järjestyksestä, jotta ratkaisua etsittäessä voidaan välttää tekemästä edestakaisia siirtoja. Pelitilanteet järjestetään keossa niiden etäisyyden pelin ratkaisusta mukaan. Tilanteen etäisyys ratkaisusta lasketaan summaamalla kaikkien laattojen etäisyydet niiden oikeista sijainneista ja tilanteeseen pääsemiseen käytettyjen siirtojen määrä.

A*-algoritmin aikavaativuus on O(b<sup>d</sup>), missä d on ratkaisuun vaadittavien siirtojen määrä ja b on haarautumistekijä. Pelissä jokaisella tilanteella on vähintään yksi ja enintään kolme seuraajaa, riippuen tyhjän ruudun sijainnista. Haarautumistekijä on siis jotain näiden väliltä.


### Puutteet ja parannusehdotukset
Sovelluksen ratkaisualgoritmia tulisi parantaa. Tämänhetkinen ratkaisualgoritmi ei toimi, jos ratkaisuun pääsemiseen tarvittavien siirtojen määrä on suuri, koska muisti ei riitä kaikkien vaihtoehtojen käsittelemiseen.


#### Lähteet
https://en.wikipedia.org/wiki/A*_search_algorithm
