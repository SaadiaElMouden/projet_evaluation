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
![strecture de projet](screenshots/strecture_projet.jpeg)
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

![strecture de projet](screenshots/ajout_categorie.jpeg)

## Ajout de produits

![strecture de projet](screenshots/ajout_produit.jpeg.jpeg)

## Création de commandes

![strecture de projet](screenshots/ajout_commande.jpeg)



## Affichage des données


![strecture de projet](screenshots/produits_avec_prix100.jpeg)

![strecture de projet](screenshots/produits_d_une_commande.jpeg)

![strecture de projet](screenshots/produits_entre_dates.jpeg)

![strecture de projet](screenshots/produits_par_categorie.jpeg)

![strecture de projet](screenshots/WhatsApp%20Image%202026-03-02%20at%2020.49.36.jpeg)





