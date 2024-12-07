
!!! gerant wl client wl compte ye5dmou, ma na9es kn transaction twa!

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
<- To Do ->

#### Méthodes :
- `public static boolean Login(Client client)` – 
- `public static Client get_Client(Client client)` – 
- `public static Client get_Client(String cin)` – 
- `public static Compte get_Compte(Client client)` – 
- `public static boolean Login(Gerant gerant)` – 
- `public static Gerant get_Gerant(Gerant gerant)` – 
- `public static void Ajout_Client(Client client)` –
- `public static void Ajout_Transaction(Transaction transaction)` –
- `public static void Ajout_Demande(Demande demande)` –
- `public static void Supprimer_Transaction(Transaction transaction)` –
- `public static void Supprimer_Demande(Demande demande)` –

---

### 2. 'Personne'
#### Objectif :
<- To Do ->

#### Attributs :
- `string cin` – Identifiant unique du client.
- `String name` – Nom du client.
- `String prenom` – Nom d'utilisateur du client.
- `String pass` – Mot de passe du client.

#### Méthodes :
<- To Do ->

---

### 2. `Gerant` extends 'Personne'
#### Objectif :
Représente un gestionnaire bancaire avec des privilèges administratifs stockés dans la base de données.

#### Attributs :
<- N/A ->

#### Méthodes :
- `public static void Consulter_Clients()` – 
- `public static void Consulter_Client(String cin)` – 
- `public static void Consulter_Comptes()` – 
- `public static void Consulter_Compte(String ref_compte)` – 
- `public static void Supprimer_Client(Client client)` – 


---

### 3. `Client` extends 'Personne'
#### Objectif :
Représente un client bancaire avec des comptes et des identifiants stockés dans la base de données.

#### Attributs :
- `Compte compte` – Représente un compte bancaire

#### Méthodes :
- `public static void Consulter_Compte_Client(Client client)` – 
- `public static void Ajout_Compte(Client client)` – 
- `XXXXXXX` – 

---

### 4. `Compte`
#### Objectif :
Représente un compte bancaire lié à un client, avec des données stockées dans la base de données.

#### Attributs :
- `string ref_compte` – Identifiant unique du compte (généré automatiquement).
- `double balance` – Solde actuel du compte.

#### Méthodes :
- `public String generer_ref_compte(String nom, String prenom, String cin)` – 
- `public void depot(double montant)` – 
- `public void retrait(double montant)` – 
- `public void transfer(Compte compte, double montant)` – 
- `public static void Depot(Compte compte, double montant)` – 
- `public static void Retrait(Compte compte, double montant)` – 
- `public static void Transferer(Client client_sender, Client client_receiver, double montant)` – 

---

### 5. `Transaction`
#### Objectif :
<-- To_Do -->

#### Attributs :
- `string ref_transaction` – Identifiant unique du transaction (généré automatiquement).
- `string type` – Type de transaction ('depot', 'retrait', 'transfer').
- `double montant` – Montant de la transaction.

#### Méthodes :
<-- To_Do -->

---

### 6. `Demande`
#### Objectif :
<-- To_Do -->

#### Attributs :
- `string ref_demande` – Identifiant unique du transaction (généré automatiquement).
- `string cin` – Identifiant unique du client.
- `string ref_compte` – Identifiant unique du compte (généré automatiquement).
- `string type` – Type de transaction ('ajout_client', 'supprime_client', 'ajout_compte', 'supprime_compte').

#### Méthodes :

<-- To_Do -->

---

### 7. `DBConnection`
#### Objectif :

<-- To_Do -->

#### Attributs :

- `Connection connection` – <-- To_Do -->
- `string url` – <-- To_Do -->
- `string user` – <-- To_Do -->
- `string password` – <-- To_Do -->

#### Méthodes :

<-- To_Do -->

---

### 8. `DB`
#### Objectif :

<-- To_Do -->

#### Méthodes :

<-- To_Do -->

---

### 9. `Menu`
#### Objectif :

<-- To_Do -->

#### Méthodes :

<-- To_Do -->

---

### 10. `Program`
#### Objectif :

<-- To_Do -->

---

## Schéma de la Base de Données

### Tables
1. **gerants**
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
├── Banque.java           # Classe principale représentant la banque.
├── Client.java           # Classe pour les clients.
├── Compte.java           # Classe pour les comptes des clients.
├── DB.java               # Gère les requêtes de la base de données.
├── DBConnection.java     # Gère la connectivité de la base de données.
├── Demandes.java         # Classe pour les demandes des clients.
├── Gerant.java           # Classe pour les gestionnaires.
├── Menu.java             # Menu d'application en terminal.
├── Personne.java         # Classe pour les personnes.
├── Program.java          # Point d'entrée de l'application.
├── Transaction.java      # Classe pour les transactions des clients.
├── Database.sql          # La base de données.
└── README.txt            # Ce fichier.
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
              

            

               
              



               

                

               
                
               
             
               
                 
                
                

                

                
                