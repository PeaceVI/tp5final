# Gestion_Bib V3: version refactorée (TP métriques CKJM)

Application Java simulant la gestion d'une bibliothèque, refactorée à partir de
[gestion_Bib_V2](https://github.com/qazdar/gestion_Bib_V2) après une analyse des métriques Chidamber & Kemerer avec CKJM.

## Structure

```
src/library/
├── model/    Lendable (interface), Book, DigitalBook
├── service/  Library, Customer
├── util/     NumberClassifier
└── app/      LibraryApp (main)
docs/         Rapport_TP_CKJM.pdf, metrics_avant.txt, metrics_apres.txt
```

## Compiler et exécuter (JDK 8+)

```
mkdir bin
javac -encoding UTF-8 -source 1.8 -target 1.8 -d bin src/library/app/*.java src/library/model/*.java src/library/service/*.java src/library/util/*.java
java -cp bin library.app.LibraryApp
```

## Mesurer avec CKJM

```
java -cp "bin;ckjm-1.8.jar" gr.spinellis.ckjm.MetricsFilter bin/library/app/*.class bin/library/model/*.class bin/library/service/*.class bin/library/util/*.class > metrics.txt
```

(Sous Linux/macOS, remplacer `;` par `:`. Ne pas utiliser `-jar` : il ignore `-cp`, et CKJM calcule alors un DIT faux pour `DigitalBook`.)

## Refactorings appliqués

1. `complexMethodExample` est sortie de `Book` vers `util.NumberClassifier` (SRP, extraction de méthode `classify`).
2. `Library` dépend uniquement de l'interface `Lendable` (`isBorrowed()`, `getDescription()`) : plus d'`instanceof Book`.
3. Bug corrigé : `getAvailableItems()` exclut désormais les livres empruntés.
4. Séparation métier / affichage : `borrow()` et `returnItem()` renvoient un `boolean`, et `listAllItems()` renvoie les descriptions.

| Classe  | CBO   | RFC     | Ca    |
|---------|-------|---------|-------|
| Library | 2 → 1 | 18 → 14 | 1 → 1 |
| Book    | 1 → 1 | 13 → 11 | 3 → 2 |

L'analyse complète se trouve dans `docs/Rapport_TP_CKJM.pdf`. Le détail de chaque modification (code avant/après, raisons, effet sur les métriques) est dans `docs/Compte_Rendu_Refactoring.docx`. Les captures d'écran avant/après sont dans `docs/captures/`.
