# Stock Hibernate – TP Gestion de Stock
## Description

Ce projet est un TP d’évaluation réalisé en Java avec Hibernate et Maven.

Il s’agit d’une application de gestion de stock permettant de :

- Gérer les Catégories

- Gérer les Produits

- Gérer les Commandes

- Gérer les Lignes de Commande

- Manipuler une base de données via Hibernate (ORM)

## L’architecture du projet respecte une organisation en couches :

classes → Entités JPA

dao → Interface DAO

service → Logique métier

util → Configuration Hibernate

test → Classe de test principale

## Technologies utilisées

Java

Hibernate

Maven

MySQL 

## Structure du projet
stock_hibernate/
![strecture de projet](stock-hibernate/screenshots/strecture_projet.jpeg)
## Configuration
### Base de données

Configurer les informations de connexion dans :

src/main/resources/hibernate.cfg.xml

Modifier :

URL

Username

Password

Dialect

Exemple :

<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/stock_db</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">1234</property>


## Fonctionnalités testées

Dans la classe Test.java, on retrouve :

## Ajout de catégories

![strecture de projet](stock-hibernate/screenshots/ajout_categorie.jpeg)

## Ajout de produits

![strecture de projet](stock-hibernate/screenshots/ajout_produit.jpeg)

## Création de commandes

![strecture de projet](stock-hibernate/screenshots/ajout_commande.jpeg)



## Affichage des données


![strecture de projet](stock-hibernate/screenshots/produits_avec_prix100.jpeg)

![strecture de projet](stock-hibernate/screenshots/produits_d_une_commande.jpeg)

![strecture de projet](stock-hibernate/screenshots/produits_entre_dates.jpeg)

![strecture de projet](stock-hibernate/screenshots/produits_par_categorie.jpeg)

![strecture de projet](stock-hibernate/screenshots/WhatsApp%20Image%202026-03-02%20at%2020.49.36.jpeg)


-----------------------------------------------------------------------------------------------------------


# Gestion des projets - Java / Hibernate / MySQL

## Description
Ce projet est une application Java développée avec Maven, Hibernate et MySQL pour gérer :

- les employés,
- les projets,
- les tâches,
- et les tâches réalisées par les employés.

L’objectif est de manipuler les relations entre ces entités et d’exécuter des requêtes métiers, notamment :

- afficher les tâches dont le prix est supérieur à 1000 DH,
- afficher les tâches réalisées entre deux dates.

---

## Technologies utilisées

- Java
- Maven
- Hibernate
- JPA
- MySQL

---

## Structure du projet

![strecture de projet ](gestion-projets/screens/StrectureProjet.jpeg)



## crée un employé

![Employe ](gestion-projets/screens/CreatioEmploye.jpeg)

## crée un projet

![projet](gestion-projets/screens/CreationProjet.jpeg)

## crée deux tâches

![Taches ](gestion-projets/screens/CreationTaches.jpeg)

## affecte une tâche réalisée à un employé

![EmployeTaches ](gestion-projets/screens/CrerationEmployeTaches.jpeg)


## exécute les deux requêtes demandées

- ### Afficher les tâches dont le prix est supérieur à 1000
![Afficher](gestion-projets/screens/TachePrixSup100.jpeg)

- ### Afficher les tâches réalisées entre deux dates

![Afficher](gestion-projets/screens/TachesEntreDates.jpeg)


---------------------------------------------------------------------------------------------------------------------


# Gestion État Civil - Hibernate + MySQL

Application Java développée avec **Hibernate (JPA)** et **MySQL** permettant de gérer :

-  Hommes
-  Femmes
-  Mariages (avec dates et nombre d’enfants)

Le projet démontre l’utilisation de :
- HQL
- NamedQuery
- Named Native Query
- Criteria API
- Héritage JPA

---

#  Technologies utilisées

- Java 8+
- Maven
- Hibernate ORM
- MySQL
- JPA Annotations

---





insère des données

exécute toutes les requêtes demandées

affiche les résultats dans la console

## Structure du projet

![Strecture de projet](Gestion-etat-civil/screens/strecture_projet.jpeg)


 ## Tables générées automatiquement

![Tables généries](Gestion-etat-civil/screens/tables.jpeg)



## Sortie affichée :

 ### Liste des femmes :



![Liste des femmes](Gestion-etat-civil/screens/listes_femmes.jpeg)



### Femme la plus âgée



### La femme la plus âgée est :


![La femme la plus âgée](Gestion-etat-civil/screens/femme_plus_agée.jpeg)




  ### Épouses entre deux dates
  

![Épouses entre deux dates](Gestion-etat-civil/screens/epause_entre_dates.jpeg)



### Nombre d’enfants :


![Nombre d’enfants](Gestion-etat-civil/screens/nombres_enfants.jpeg)



### Femmes mariées au moins 2 fois :


![Femmes mariées au moins 2 fois](Gestion-etat-civil/screens/femme_marié_auMoin2Fois.jpeg)

### Nombre d'hommes mariés à 4 femmes :


![Nombre d'hommes mariés à 4 femmes](Gestion-etat-civil/screens/marie_4.jpeg)

### Mariages de l'homme :

![Mariage d'un homme](Gestion-etat-civil/screens/mariage_homme.jpeg)




