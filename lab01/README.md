# Program - Bryła geometryczna, Walec

Napisać program realizujący poniższe założenia:

1. utworzyć klasę Walec - zastosować hermetyzację (_ang. encapsulation_) dla zmienych oraz metod instancji,
2. w klasie Walec zadeklarować <u>zmienne instancji</u>: promień podstawy oraz wysokość,
3. zmienne instancji powinny być dostępne tylko dla elementów składowych klas Walec,
4. umożliwić zmianę wartości zmiennych instancji obiektu klasy Walec - utworzyć metody ustawiające wartości zmiennych instancji,
5. umożliwić odczyt wartości zmiennych instancji obiektu klasy Walec - utworzyć metody pobierające wartości zmiennych instancji,
6. utworzyć <u>konstruktor</u> (z dwoma parametrami) inicjujący wartości zmiennych instancji,
7. utworzyć drugi <u>konstruktor</u> (bezparametrowy) z pustym ciałem metody,
8. klasa Walec powinna mieć metody wyliczające:
   - Pole powierzchni podstawy: $P_p = \pi \times r^2$
   - Pole powierzchni bocznej: $P_b = 2 \times \pi \times r \times h$
   - Pole powierzchni całkowitej: $P_c = 2 \times P_p + P_b$
   - Objętość: $V = P_p \times h$,
9. metoda wyliczająca pole powierzchni całkowitej powinna korzystać z metody wyliczania powierzchni podstawy oraz pole powierzchni bocznej,
10. wykorzystać metodę potęgowania (pow) i stałą $\pi$ (PI) z klasy Math, pakiet java.lang,
11. program główny: wyświetlić informacje o tym do czego służy użytkownikowi na konsoli,
12. program główny: powołać i wykonywać operacje na <u>jednym</u> obiekcie klasy Walec,
13. program główny: zastosować jedną <u>zmienną referencyjną</u> do operacji na obiekcie klasy Walec.
14. program główny powinien mieć następujące opcje:
<ol type='a'>
    <li> wyświetlenie wartości zmiennych instancji obiektu klasy Walec, </li>
    <li> ustawienie wartości zmiennych instancji obiektu klasy Walec należy pobrać od użytkownika,</li>
    <li> wyliczenie i wyświetlenie na konsoli pól powierzchni obiektu klasy Walec,</li>
    <li> wyliczenie i wyświetlenie na konsoli objętości obiektu klasy Walec,</li>
    <li> wyjście z programu.</li>
</ol>
