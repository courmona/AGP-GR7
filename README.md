# AGP-GR7
comment installer glassfish:

0- bouton droite dans la section server de eclipse et new server et choisir glassfish le repertoire 
et dans le repertoire choisi glassfish et suit l'installation (pour choisir l'emplacement de glassfish sur ton pc fais le telechargement de glassfish dans l'etape 1)

si dans le cas ta pas glassfish dans le bouton droit new server repertoire glassfish choisi "glassfish tools" 
une fois t'a choisi ça eclipse install le plugins glassfish) une fois qu'il as fini restart eclipse et refait bouton droit new server glassfish et mtn tu trouve glassfish
1 download:
http://download.oracle.com/glassfish/4.1.2/release/glassfish-4.1.2.zip
2 creation de connexion pool et connexion resource:
https://www.youtube.com/watch?v=f1z-3zlkXj8
3- apres creation de connexion pool clicker sur ping pour verifier tous va bien.
(pour acceder a la console de glassfish: http://localhost:4848/common/index.jsf)
une fois que tous va bien creer la connexion resource.
4-une fois tous est fini stop start glassfish de eclipse .
apres le start bouton droit "add/remove" ajouter le war .
5- bouton droit glassfish publish.
6 le lien de l'application est:
http://localhost:8080/agenceVoyage/

*****************
ajouter les jar dans ddossierglassfish\\glassfish\lib
mysql-connector-java-5.1.45-bin.jar
lucene-sandbox-7.2.1.jar
lucene-queryparser-7.2.1.jar
lucene-queries-7.2.1.jar
lucene-core-7.2.1.jar

on peux les trouver ici https://mvnrepository.com/artifact/org.apache.lucene