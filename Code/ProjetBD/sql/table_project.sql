Drop Table Impression;
Drop Table Cadre;
Drop Table Calendrier;
Drop Table Album;
Drop Table Tirage;
Drop Table Produit;
Drop Table CodePromo;
Drop Table Panier;
Drop Table Facture;
Drop Table LesCommandes;
Drop Table FichierImage;
Drop Table LesAdresseClients;
Drop Table LesClients;


CREATE TABLE LesClients(
   	noClient NUMBER(7) PRIMARY KEY,
   	addr_mail VARCHAR(50) ,
   	nom VARCHAR(50),
    prenom VARCHAR(50),
    mdp VARCHAR(16),
    etatCompte NUMBER(1) --
);

CREATE TABLE LesAdresseClients(
    idAdresse NUMBER(7),
    noClient NUMBER(7),
    nomRue VARCHAR(50),
    noRue NUMBER(3),
    Ville VARCHAR(25),
    Code_Postal VARCHAR(5),
    PRIMARY KEY (idAdresse,noClient),
    FOREIGN KEY (noClient) REFERENCES LesClients(noClient)
);

CREATE TABLE FichierImage(
    idImage NUMBER(7) PRIMARY KEY,
    chemin_access VARCHAR(50),
    noClient NUMBER(7),
    PriseDeVue VARCHAR(50),
    paramRetouche VARCHAR(50),
    Resolution VARCHAR(50),
    Partage INTEGER NOT NULL CHECK (partage IN(0,1)),
    DateUtilisation DATE,
    FOREIGN KEY (noClient) REFERENCES LesClients(noClient)
);

CREATE TABLE LesCommandes(
	idCommande NUMBER(7) PRIMARY KEY,
	noClient NUMBER(7),
	dateCommande DATE,
	livraison VARCHAR(10) NOT NULL CHECK (livraison IN('expresse', 'normale', 'rapide')),
	Promo NUMBER(1),
	Statut VARCHAR(10) NOT NULL CHECK (Statut IN('encours', 'valide', 'prepare','expedie')),
	idAdresse NUMBER(7),
	FOREIGN KEY (noClient) REFERENCES LesClients(noClient),
	FOREIGN KEY (idAdresse,noClient) REFERENCES LesAdresseClients(idAdresse,noClient)
);

CREATE TABLE Facture(
  idFacture NUMBER PRIMARY KEY,
  dateCommande DATE,
  price FLOAT,
  FOREIGN KEY (idFacture) REFERENCES LesCommandes(idCommande)
  );

CREATE TABLE Panier(
    idCommande NUMBER(7),
    idProduit NUMBER(7),
    FOREIGN KEY (idCommande) REFERENCES LesCommandes(idCommande)
);

CREATE TABLE CodePromo(
    CodePromo NUMBER(7) PRIMARY KEY,
    noClient NUMBER(7),
    FOREIGN KEY (noClient) REFERENCES LesClients(noClient)
);

CREATE TABLE Produit( -- creer une liste de produit prédéfinie dans la documentation
    idProduit NUMBER(7) PRIMARY KEY,
    typeImpr VARCHAR(20) NOT NULL CHECK (typeImpr IN('Tirage','Impression','Cadre','Calendrier','Album')),-- A gerer comme si c'était une énumeration
    Qualite VARCHAR(20) NOT NULL CHECK (Qualite IN('Bonne','Moyenne','Haute')),-- A gerer comme si c'était une énumeration
    Prix FLOAT,
    Description VARCHAR(100)
);

CREATE TABLE Tirage(
    idProduit NUMBER(7),
    idCommande NUMBER(7),
    RefTirage NUMBER(7) PRIMARY KEY,
    idImage NUMBER(7),
    formatImg VARCHAR(100), --format prédéfinie ?
    FOREIGN KEY (idCommande) REFERENCES LesCommandes(idCommande),
    FOREIGN KEY (idProduit) REFERENCES Produit(idProduit)
);

CREATE TABLE Impression(
      RefTirage NUMBER(7),
      Ordre INTEGER,
      FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);

CREATE TABLE Cadre(
  RefTirage NUMBER(7),
  Taille VARCHAR(100),
  Model VARCHAR(100), -- Ajout d'énumeration de modele
  FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);

CREATE TABLE Calendrier(
  RefTirage NUMBER(7),
  miseEnPage VARCHAR(100), -- Imposition de mise en page?
  FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);

CREATE TABLE Album(
  RefTirage NUMBER(7),
  Titre VARCHAR(100),
  miseEnPage VARCHAR(100), -- Imposition de mise en page?
  Descriptif VARCHAR(100),
  FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);

