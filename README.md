# TP2

## Démarrer

Un membre du groupe crée une divergence (fork) avec le nom
`r402-tp2-groupeX`. Assurez-vous que ce dépôt est accessible en
lecture à l’enseignant chargé de TP, et en écriture à tous les membres
du groupe.

Une fois le nouveau dépôt cloné sur votre machine, vous pouvez lancer
le projet dans IntelliJ en ouvrant le fichier `pom.xml`

## Fichiers

Le ficher `src/main/java/Ensemble.java` donne un exemple de classe
avec sa spécification, mais sans implémentation (uniquement les
signatures des méthodes, et le strict minimum pour permettre la
compilation). L'objectif du TP est de produire une classe similaire, à
écrire dans un autre fichier.

Le fichier `src/test/java/EnsembleTests.java` donne un exemple de
tests pour la classe ci-dessus. Dans un développement piloté par les
tests, on écrit les tests immédiatement après la spécification, et
_avant_ l'implémentation. Vous pouvez exécutez les tests pour vérifier
qu'ils échouent tous.



LE JEU :

Le principe du jeu est très simple : le joueur choisit le nombre de Tamagoshi avec lequel il veut jouer et leur donne un nom, puis la partie se déroule tour par tour sachant que le joueur peut effectuer une seule interaction d'un type avec un Tamagoshi. Par exemple, il pourra choisir de nourrir un Tamagoshi, puis jouer avec un autre ou le même.

À chaque tour, les Tamagoshis expriment leurs émotions en fonction de leurs variables d'état. Par exemple, un Tamagoshi qui possède peu d'énergie exprimera un besoin de manger lorsque son état sera affiché. Idem pour le besoin de jouer. Par ailleurs, à chaque fin de tour les variables d'état des Tamagoshis sont décrémentées en fonction du type du Tamagoshi. Par exemple, pour un Tamagoshi normal, on fera baisser toutes les valeurs d'un point tout en augmentant son âge de un point. Si une valeur passe à 0, le tamagoshi est retiré du jeu.

Le nombre de tamagoshis initial ainsi que leurs noms seront entrés par l'utilisateur à l'initialisation du jeu. Le nombre de tamagoshis correspond au niveau de difficulté du jeu. Le score obtenu à la fin du jeu correspond au pourcentage de la somme de l'âge des tamagoshis par rapport à la somme de leur durée de vie potentielle. Par exemple, pour 3 tamagoshis, le maximum possible est 3*10, 30. Si tous les tamagoshis finissent avec un âge de 10, le score est de 100 %.

Pour pimenter le jeu, l'idée est d'avoir plusieurs sortes de Tamagoshi qui évolueront de manière différente, sans que le joueur ne connaisse le type exact des Tamagoshis : il s'agit de les deviner pendant la partie. Par exemple, on peut imaginer un type de Tamagoshi qui serait un gros mangeur et dont l'énergie diminue très rapidement, ce qui ferait qu'il serait souvent en demande d'être nourri. De la même manière, on peut imaginer des Tamagoshis légendaires qui récupèrent l'intégralité de leurs points d'énergie dès qu'on les nourrit. De plus, lorsqu'on donne à manger à un tamagoshi, le nombre de points d'énergie gagné est tiré aléactoirement entre 1 et 3. Idem pour l'attibut de fun.

Le jeu s'arrête lorsque les tamagoshis sont tous morts ou arrivés à leur âge limite.

Voici un exemple d'exécution pour une version très basique du jeu :

Entrez le nombre de tamagoshis désiré !

Saisissez un nombre > 0 :

3

Entrez le nom du tamagoshi numéro 1 :

Pierre

Entrez le nom du tamagoshi numéro 2 :

Paul

Entrez le nom du tamagoshi numéro 3 :

Jacques



------------ Tour n°1 -------------



Pierre : Tout va bien !

Paul : je suis affamé !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

1

Paul : Merci !



Jouer avec quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

0

Pierre : Laisse-moi tranquille, je bouquine !





------------ Tour n°2 -------------



Pierre : je suis affamé !

Paul : je m'ennuie à mourir !

Jacques : je suis affamé !



Nourrir quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

2

Jacques : Merci !



Jouer avec quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

1

Paul : On se marre !





------------ Tour n°3 -------------



Pierre : je suis affamé !

Paul : Tout va bien !

Jacques : je m'ennuie à mourir !



Nourrir quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

0

Pierre : Merci !



Jouer avec quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

2

Jacques : On se marre !





------------ Tour n°4 -------------



Pierre : je m'ennuie à mourir !

Paul : Tout va bien !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

2

Jacques : J'ai pas très faim...



Jouer avec quel tamagoshi ?

(0) Pierre (1) Paul (2) Jacques

Entrez un choix :

0

Pierre : On se marre !



Paul : snif : je fais une dépression, ciao!



------------ Tour n°5 -------------



Pierre : je m'ennuie à mourir !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

1

Jacques : J'ai pas très faim...



Jouer avec quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : On se marre !



------------ Tour n°6 -------------



Pierre : je m'ennuie à mourir !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : J'ai pas très faim...



Jouer avec quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : On se marre !





------------ Tour n°7 -------------



Pierre : je m'ennuie à mourir !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : J'ai pas très faim...



Jouer avec quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : On se marre !





------------ Tour n°8 -------------



Pierre : Tout va bien !

Jacques : je suis affamé et je m'ennuie à mourir !



Nourrir quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

1

Jacques : Merci !



Jouer avec quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

1

Jacques : On se marre !





------------ Tour n°9 -------------



Pierre : je m'ennuie à mourir !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

1

Jacques : J'ai pas très faim...



Jouer avec quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : On se marre !





------------ Tour n°10 -------------



Pierre : je m'ennuie à mourir !

Jacques : Tout va bien !



Nourrir quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : J'ai pas très faim...



Jouer avec quel tamagoshi ?

(0) Pierre (1) Jacques

Entrez un choix :

0

Pierre : On se marre !





--------- fin de partie !! ----------------





------------- bilan ------------

Pierre qui était un BigPlayer a survécu et vous remercie :)

Paul qui était un BigPlayer n'est pas arrivé au bout et ne vous félicite pas :(

Jacques qui était un BigEater a survécu et vous remercie :)



niveau de difficulté : 3, score obtenu : 76.0%