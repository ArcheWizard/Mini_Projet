
!!! Hadha chatgpt ch5damli, ama mouch kol chy s7i7, e7sbouh guide bsh y3awenna ntfahmou fl 5edma :^)

# Système de Gestion Bancaire avec Intégration de Base de Données

Ce projet Java implémente un **Système de Gestion Bancaire** avec une interface graphique (GUI) et une intégration de base de données. 
Les utilisateurs peuvent s'inscrire/se connecter en tant que **Gestionnaire** ou **Client** d'une banque. 
Le système utilise une base de données relationnelle pour stocker et récupérer les données des utilisateurs et des comptes de manière persistante, garantissant sécurité et évolutivité.

---

## Fonctionnalités

### Fonctionnalités Générales :
- Interface graphique (GUI) pour l'interaction utilisateur.
- Accès basé sur les rôles (Gestionnaire ou Client).
- **Intégration de base de données** pour le stockage et la récupération de données.

### Fonctionnalités du Gestionnaire :
- Connexion pour gérer la banque.
- Voir, créer, mettre à jour ou supprimer les comptes des clients.
- Accéder aux informations des clients et à l'historique des transactions.

### Fonctionnalités du Client :
- Inscription ou connexion à la banque.
- Accéder aux informations personnelles des comptes.
- Effectuer des transactions de base (ex. : dépôt, retrait, vérification du solde).
- Consulter l'historique des transactions.

---

## Structure des Classes

### 1. `Banque`
#### Objectif :
Contrôle central de la banque, y compris la connectivité à la base de données et les opérations de haut niveau.

#### Attributs :
- `String name` – Le nom de la banque.
- `Connection dbConnection` – Connexion à la base de données.

#### Méthodes :
- `void connectDatabase(String dbURL, String username, String password)` – Établit la connexion à la base de données.
- `void addClient(Client client)` – Insère un nouveau client dans la base de données.
- `void addManager(Manager manager)` – Insère un nouveau gestionnaire dans la base de données.
- `Client authenticateClient(String username, String password)` – Vérifie les identifiants du client dans la base de données.
- `Manager authenticateManager(String username, String password)` – Vérifie les identifiants du gestionnaire dans la base de données.

---

### 2. `Gerant`
#### Objectif :
Représente un gestionnaire bancaire avec des privilèges administratifs stockés dans la base de données.

#### Attributs :
- `string cin` – Identifiant unique du gestionnaire (généré automatiquement).
- `String nom` – Nom d'utilisateur du gestionnaire.
- `String prenom` – Prenom d'utilisateur du gestionnaire.
- `String pass` – Mot de passe du gestionnaire.

#### Méthodes :
- `void createAccount(Client client, double initialDeposit)` – Insère un nouveau compte pour un client dans la base de données.
- `void deleteAccount(int accountId)` – Supprime un compte de la base de données.
- `void updateClientDetails(Client client)` – Met à jour les informations du client dans la base de données.
- `ResultSet viewClientAccounts(int clientId)` – Récupère tous les comptes appartenant à un client.

---

### 3. `Client`
#### Objectif :
Représente un client bancaire avec des comptes et des identifiants stockés dans la base de données.

#### Attributs :
- `string cin` – Identifiant unique du client (généré automatiquement).
- `String name` – Nom du client.
- `String prenom` – Nom d'utilisateur du client.
- `String pass` – Mot de passe du client.

#### Méthodes :
- `void deposit(double amount, int accountId)` – Met à jour le solde du compte dans la base de données.
- `void withdraw(double amount, int accountId)` – Déduit le montant spécifié du solde dans la base de données.
- `double checkBalance(int accountId)` – Récupère le solde du compte dans la base de données.
- `ResultSet viewTransactionHistory(int accountId)` – Récupère l'historique des transactions du compte.

---

### 4. `Compte`
#### Objectif :
Représente un compte bancaire lié à un client, avec des données stockées dans la base de données.

#### Attributs :
- `string ref_compte` – Identifiant unique du compte (généré automatiquement).
- `double balance` – Solde actuel du compte.
- `string cin` – Identifiant du client propriétaire du compte.

#### Méthodes :
- `void deposit(double amount)` – Ajoute de l'argent au compte dans la base de données.
- `void withdraw(double amount)` – Retire de l'argent du compte dans la base de données.
- `double getBalance()` – Récupère le solde depuis la base de données.

---

## Schéma de la Base de Données

### Tables
1. **gerant**
   - `cin` (Clé Primaire)
   - `nom`
   - `prenom`
   - `pass`
   
2. **clients**
   - `cin` (Clé Primaire)
   - `nom`
   - `prenom`
   - `pass`
   
3. **comptes**
   - `ref_compte` (Clé Primaire)
   - `cin` (Clé Étrangère vers `clients`)
   - `balance`

4. **transactions**
   - `id` (Clé Primaire)
   - `ref_compte` (Clé Étrangère vers `comptes`)
   - `type` (ex. : "deposit" ou "withdraw")
   - `balance`

5. **demandes**
   - `ref_demande` (Clé Primaire)
   - `cin` (Clé Étrangère vers `clients`)
   - `type` (ex. : "Ajout" ou "Supprime")
   - `ref_compte` (Clé Étrangère vers `comptes`)


---

## Structure du Projet

```
mini_projet/
|
├── DBConnection.java     # Gère la connectivité de la base de données.
├── DBConnection.java     # Gère les requêtes de la base de données.
├── Bank.java             # Classe principale représentant la banque.
├── Manager.java          # Classe pour les gestionnaires.
├── Client.java           # Classe pour les clients.
├── Account.java          # Classe pour les comptes des clients.
├── LoginScreen.java      # Interface de connexion pour les clients et gestionnaires.
├── ManagerDashboard.java # Tableau de bord pour les gestionnaires.
├── ClientDashboard.java  # Tableau de bord pour les clients.
└── Program.java                 # Point d'entrée de l'application.
```

---

## Prérequis

- **Java Development Kit (JDK)** 11 ou supérieur.
- **Système de Gestion de Base de Données Relationnelle** (ex. : MySQL ou PostgreSQL).
- Un IDE avec support Java (ex. : IntelliJ IDEA, Eclipse ou NetBeans).

---

## Comment Exécuter

1. Clonez le dépôt :
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. Configurez la base de données :
   - Créez une base de données nommée `banque`.
   - Exécutez le script SQL fourni (`Database.sql`) pour créer les tables nécessaires.

3. Configurez la connexion à la base de données :
   - Mettez à jour le `dbURL`, `username` et `password` dans `DBConnection.java`.

4. Compilez et exécutez le projet :
   ```bash
   javac src/**/*.java
   java src.Program
   ```

5. Utilisez la GUI pour vous connecter en tant que **Gestionnaire** ou **Client** et interagir avec le système.

---

## Améliorations Futures

- Ajouter le chiffrement des mots de passe stockés.
- Améliorer la GUI pour une meilleure expérience utilisateur.
- Étendre les types de transactions (ex. : transferts internes et externes).
- Ajouter un rôle d'administrateur pour superviser les gestionnaires.

---

## Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

---   
              

            

               
              



               

                

               
                
               
             
               
                 
                
                

                

                
                