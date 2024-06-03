# Oferty sprzedaży - mieszkań i domów

Napisać program realizujący poniższe założenia:

1. Program powinien obsługiwać oferty sprzedaży mieszkań i domów,
2. Utworzyć klasy: Dom, Mieszkanie - zastosować reguły hermetyzacji/enkapsulacji,
3. W klasie Dom, atrybuty: ulica, numer domu, miejscowość, kod pocztowy, powierzchnia, cena, powierzchnia działki, data obowiązywania oferty,
4. W klasie Mieszkanie, atrybuty: ulica, numer domu, numer mieszkania, miejscowość, kod pocztowy, powierzchnia, numer piętra, cena, data obowiązywania oferty,
5. Zastosować potrzebne zmienne i metody instancji w klasach Dom i Mieszkanie,
6. Zastosować klasę abstrakcyjną i dziedziczenie w celu eliminacji redundancji zmiennych instancji w klasach: Dom, Mieszkanie.
7. Należy wprowadzić kontrolę dziedziczenia z klasy abstrakcyjnej. Należy udostępnić możliwość dziedziczenia tylko dla klas Dom i Mieszkanie, a także zamknąć drzewo dziedziczenia na poziomie tych dwóch klas,
8. Utworzyć klasę ListaOfert i w klasie tej zadeklarować strukturę mogącą przechowywać dowolną liczbę zarówno ofert sprzedaży domów jak i mieszkań,
9. Zastosować strukturę danych umożliwiającą przechowywanie obydwu typów elementów w jednej liście ofert,
10. Filtrowanie elementów należy zaimplementować przy wykorzystaniu jednej metody wykorzystującej interfejs Predicate,
11. Program ma umożliwiać użytkownikowi wykonanie następujących operacji:
    1. dodanie oferty sprzedaży domu z podaniem parametrów
    2. dodanie oferty sprzedaży mieszkania z podaniem parametrów,
    3. wyświetlenie wszystkich aktualnych ofert sprzedaży domów (data obowiązywania oferty póżniejsza lub równa dacie bieżącej)
    4. wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań,
    5. wyświetlenie wszystkich aktualnych ofert sprzedaży domów, w podanej miejscowości, o powierzchni nie mniejszej niż podana wartość,
    6. wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań, w podanej miejscowości, nie droższych niż podana wartość i od podanego piętra wzwyż,
12. W klasach Dom oraz Mieszkanie należy przesłonić metodę toString(),
13. Zastosować pętle, instrukcje warunkowe, klasy: String, ArrayList, LocalDate oraz interfejs Predicate.
14. Utworzyć metodę dodającą przykładowe obiekty klas Dom i Mieszkanie do listy ofert (min. 5 obiektów klasy Dom i 7 obiektów klasy Mieszkanie).
