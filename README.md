# ApiApp
API REST Catalogue produits "Fruits & Légumes" avec gestion d'un panier


Etapes d'installation du projet :  

1-	Télécharger le source du code depuis Github avec le lien :
https://github.com/JavaTestNexio/ApiApp.git

2-	Importer le projet dans votre IDE en tant que Projet Maven

3-	Lancer « mvn clean install » (Partie Maven)

4-	Exécuter dans le terminal de votre IDE : mvn spring-boot:run 

5-	L’application web est accessible via le lien principal (Affichage du catalogue de produit): http://localhost:8080/produits   

- (1) Afficher un catalogue de produits 	         --> http://localhost:8080/produits   

- (2) Afficher le détail d’un produit (eg. Id=1)  -->  http://localhost:8080/produits/{id}

- (3) Ajouter un produit au panier 	             --> http://localhost:8080/produits/ajouterpanier

- (4) Enlever un produit du panier	               --> http://localhost:8080/produits/enleverpanier

- (5) Afficher le contenu du panier 	             --> http://localhost:8080/produits/monpanier




(Optionnel) : Si vous souhaitez déployer l’application et exécuter le code dans votre IDE, merci de suivre ces étapes complémentaires :

-	Utilisation de la librairie Lombok pour la génération des annotations et la réduction du code redondants (Getter/ Setter)

-	Pour la configuration sur IntelliJ (dans mon cas) : 

    - Aller à > File > Settings > Plugins (Télécharger Lombok Plugin)
    - Aller à > File > Settings > Build, Execution, Deployement > Compiler > Annotation Processors (Cocher: Enable annotation processing)
   
-	Crée une Application Runner et la pointer à la classe principale « ApiAppApplication.java »
