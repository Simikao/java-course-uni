# Program - Kalendarz tygodniowy zadań i spotkań

Napisać program realizujący poniższe założenia:

1. Program powinien obsługiwać kalendarz tygodniowy zadań i spotkań,
2. Utworzyć klasy: Zadanie, Spotkanie - zastosować reguły hermetyzacji/enkapsulacji,
3. W klasie Zadanie, atrybuty: czas początku, czas zakończenia, opis, status (planowane, potwierdzone, realizowane, wykonane),
4. W klasie Spotkanie, atrybuty: czas początku, czas zakończenia, opis, priorytet (normalny, wysoki, najwyższy),
5. Zastosować strukturę eliminującą redundancję zmiennych w klasach: Zadanie, Spotkanie. Należy zapewnić aby można było tworzyć obiekty tylko klas Zadanie oraz Spotkanie (zastosować klasę abstrakcyjną i dziedziczenie),
6. Należy wprowadzić kontrolę dziedziczenia z klasy abstrakcyjnej. Należy udostępnić możliwość dziedziczenia tylko dla klas Zadanie i Spotkanie, a także zamknąć drzewo dziedziczenia na poziomie tych dwóch klas,
7. W klasach Zadanie oraz Spotkanie należy przesłonić metodę toString().
8. W klasie Kalendarz zmodyfikować strukturę danych aby mogła przechowywać dowolną liczbę zadań i spotkań na każdy dzień tygodnia. Zastosować strukturę danych umożliwiającą przechowywanie obiektów obydwu klas w tej samej kolekcji.
9. Zastosować potrzebne zmienne i metody w klasie Kalendarz - klasa ta powinna mieć m.in. metody dodające i usuwające zadania (spotkania) z kalendarza,
10. Filtrowanie elementów należy zaimplementować przy wykorzystaniu jednej metody wykorzystującej interfejs Predicate.
11. Program ma umożliwiać użytkownikowi wykonanie następujących operacji:
    1. dodanie spotkania na wybrany dzień,
    2. dodanie zadania na wybrany dzień (zastosować mechanizm przeciążania metod albo pojedynczą metodę do dodawania zarówno obiektów klas Spotkanie jak i Zadanie),
    3. usunięcie wybranego spotkania z wybranego dnia,
    4. usunięcie wybranego zadania z wybranego dnia,
    5. wyświetlenie spotkań w wybranym dniu,
    6. wyświetlenie zadań w wybranym dniu,
    7. wyświetlenie spotkań w wybranym dniu o wybranym priorytecie,
    8. wyświetlenie zadań w wybranym dniu o wybranym statusie,
    9. wyświetlenie spotkań w wybranym dniu o wybranym priorytecie i zaczynających się nie j wcześniej niż od podanego czasu,
    10. wyświetlenie zadań w wybranym dniu o wybranym statusie i kończących się nie później niż do podanego czasu.
