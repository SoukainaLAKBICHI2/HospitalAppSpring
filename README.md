# HospitalApp - Gestion des Patients

## Description
**HospitalApp** est une application web développée en **Spring Boot** qui permet de gérer les patients d'un hôpital.
Elle offre des fonctionnalités pour :
- Ajouter un patient
- Supprimer un patient
- Modifier les informations d'un patient
- Afficher la liste des patients enregistrés dans une base de données MySQL
- Rechercher des patients à l'aide d'un mot-clé

## Technologies utilisées
- **Spring Boot** (MVC, Data JPA, Validation, DevTools)
- **Thymeleaf** (pour le rendu côté client)
- **MySQL** (base de données relationnelle)
- **Bootstrap** et **Bootstrap Icons** (interface utilisateur)
- **Lombok** (réduction du code boilerplate)
- **H2 Database** (pour le développement et les tests en mémoire)

## Prérequis
- JDK 17+
- Maven
- MySQL installé et configuré

## Installation
1. **Cloner le repository**
```bash
    git clone https://github.com/SoukainaLAKBICHI/HospitalAppSpring.git
    cd HospitalAppSpring
```
2. **Configurer la base de données**
   - Modifier `application.properties` ou `application.yml` pour ajouter vos identifiants MySQL :
     
   ```properties
   server.port=8084
   spring.datasource.url=jdbc:mysql://localhost:3306/HopitalDB?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
   ```
3. **Lancer l'application**
```bash
    mvn spring-boot:run
```

## Utilisation
- Accéder à l'application via : `http://localhost:8084/index`
- Utiliser l'interface pour gérer les patients (ajouter, supprimer, modifier, rechercher)

## Structure du Projet
```
HospitalApp/
│── src/
│   ├── main/
│   │   ├── java/com/example/hospital/
│   │   │   ├── web/
│   │   │   ├── entities/
│   │   │   ├── repositories/
│   │   │   ├── HospitalAppApplication.java
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   ├── static/
│   │   │   ├── application.properties
│── pom.xml
│── README.md
```

## Améliorations futures
- Ajout d'une gestion des rôles et des utilisateurs (Spring Security)
- Export des données en PDF/Excel
- Ajout d'une API REST pour une intégration avec d'autres applications
## Demo

## Auteur
Développé par **Soukaina LAKBICHI**


