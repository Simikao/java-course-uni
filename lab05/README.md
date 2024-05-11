# Program - Kalendarz tygodniowy spotkań (wyrażenia lambda)

Napisać program realizujący poniższe założenia:

1. Program powinien obsługiwać kalendarz tygodniowy spotkań.
2. Program powinien spełniać wszystkie wymagania postawione w podstawowej wersji zadania.
3. Program ma umożliwić użytkownikowi (w klasie brzegowej, np. `Main`, `App`):
   1. dodanie spotkania na wybrany dzień,
   2. usunięcie wybranego spotkania z wybranego dnia,
   3. wyświetlenie wszystkich spotkań w wybranym dniu,
   4. wyświetlenie spotkań w wybranym dniu o danym priorytecie,
   5. wyświetlenie spotkań w wybranym dniu <u>zaczynających się nie wcześniej niż od podanego czasu</u>,
   6. wyświetlenie spotkań w wybranym dniu <u>odbywających się pomiędzy podanymi czasami włącznie</u>,
   7. wyświetlenie spotkań w wybranym dniu o wybranym priorytecie i <u>zaczynających się nie wcześniej niż od podanego czasu</u>.
4. Filtrowanie spotkań w klasie Kalendarz należy zaimplementować przy wykorzystaniu <u>jednej</u> metody <u>wykorzystującej interfejs `Predicate`&.
5. Przy wyświetlaniu spotkań w klasie brzegowej (wszystkie opcje wyświetlania 3.3-3.7) należy wykorzystać metodę filtrującą spotkania z <u>zastosowaniem wyrażeń lambda</u>.
6. W klasie Spotkanie należy <u>przesłonić</u> metodę `toString()`.
7. Zastosować pętlę, instrukcje warunkowe, klasy: `String`, `ArrayList`, `LocalTime` oraz interfejs funkcjyny `Predicate`.
