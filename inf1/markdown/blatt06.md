# Blatt 06

## 6.4

1. Was sind erlaubte Werte im Spielfeld?
0-9
2. Welche Bedeutung hat die "0" dabei?
Noch nicht ausgefullt

3. Warum ist die Reihung testSpielFelder dreidimensional?
Weil sie mehrere Spielfelder beinhaltet.

4. Was steht in der 1., 2. und 3. Dimension?
Spielfelder->Reihen->Spalten

5. Welche Dimension hat die Reihung testFeld in der Methode testSudokuChecker?
Reihen

6. In der Methode testSudokuChecker wird this.spielFeld\[8\]\[8\] auf 8
   geändert. Ändert sich dadurch testSpielFelder auch? Wieso (nicht)?
   Streng genommen nein, da testSpielFelder nur eine Reihung an Referenzen ist.
   Allerdings ändert sich der Inhald. testSpielFelder ändert sich da keine
   Kopie des Inhalts gemacht wird. this.spielFeld zeigt auf die gleiche Adresse
   im heap wie testFeld, welches in test

7. Wie/wieso funktioniert die For-Each-Schleife in der Methode
   testSudokuChecker? Was wird hier durchlaufen?
