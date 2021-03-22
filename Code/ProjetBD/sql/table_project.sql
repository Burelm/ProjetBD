Drop Table Tirage;
Drop Table Produit;
Drop Table CodePanier;
Drop Table Panier;
Drop Table LesCommandes;
Drop Table LesAdresseClients;
Drop Table FichierImage;
Drop Table LesClients;

CREATE TABLE LesClients(
    noClient NUMBER(7) PRIMARY KEY,
    addr_mail VARCHAR(50) ,
    nom VARCHAR(13),
    prenom VARCHAR(13),
    mdp VARCHAR(16),
    etatCompte NUMBER(1)
);

CREATE TABLE LesAdresseClients(
    idAdresse NUMBER(7),
    noClient NUMBER(7),
    nomRue VARCHAR(13),
    noRue NUMBER(3),
    Ville VARCHAR(25),
    Code_Postal NUMBER(5),
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
    Partage NUMBER(1),
    FOREIGN KEY (noClient) REFERENCES LesClients(noClient)
);

CREATE TABLE LesCommandes(
	idCommande NUMBER(7) PRIMARY KEY,
	noClient NUMBER(7), 
	dateCommande DATE, 
	livraison VARCHAR(10) NOT NULL CHECK (livraison IN('expresse', 'normale', 'rapide')),
	Promo NUMBER(1),
	Statut VARCHAR(10) NOT NULL CHECK (Statut IN('encours', 'validé', 'préparé','expédié')),
	idAdresse NUMBER(7),
	FOREIGN KEY (noClient) REFERENCES LesClients(noClient),
	FOREIGN KEY (idAdresse,noClient) REFERENCES LesAdresseClients(idAdresse,noClient)
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

CREATE TABLE Produit(
    idProduit NUMBER(7) PRIMARY KEY,
    typeImpr VARCHAR(20) NOT NULL CHECK (typeImpr IN('Tirage','Impression','Cadre','Calendrier','Album')),-- A gerer comme si c'était une énumeration
    Qualite VARCHAR(20) NOT NULL CHECK (Qualite IN('Bonne','Moyenne','Haute')),-- A gerer comme si c'était une énumeration
    Prix FLOAT(2),
    Description VARCHAR(100)
);
CREATE TABLE FichierImage (
    idImage NUMBER(7) PRIMARY KEY,
    chemin_access VARCHAR2(50),
    noClient NUMBER(7),
    PriseDeVue VARCHAR2(50),
    paramRetouche VARCHAR2(50),
    Resolution VARCHAR2(50),
    Partage INTEGER NOT NULL CHECK (partage IN(0,1)),
    FOREIGN KEY (noClient) REFERENCES LesClients(noClient)
);

CREATE TABLE Tirage(
    idProduit NUMBER(7),
    idCommande NUMBER(7),
    RefTirage NUMBER(7) PRIMARY KEY,
    idImage NUMBER(7),
    format VARCHAR(100),
    FOREIGN KEY (idCommande) REFERENCES LesCommandes(idCommande),
    FOREIGN KEY (idProduit) REFERENCES Produit(idProduit),
    FOREIGN KEY (idImage) REFERENCES Produit(idProduit)
);
CREATE TABLE Impression(
      RefTirage NUMBER(7),
      Ordre INTEGER,
      FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);

CREATE TABLE Cadre(
  RefTirage NUMBER(7),
  Taille VARCHAR(100),
  Model VARCHAR(100),
  FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);
CREATE TABLE Calendrier(
  RefTirage NUMBER(7),
  miseEnPage VARCHAR(100),
  FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);
CREATE TABLE Album(
  RefTirage NUMBER(7),
  Titre VARCHAR(100),
  miseEnPage VARCHAR(100),
  Descriptif VARCHAR(100),
  FOREIGN KEY (RefTirage) REFERENCES Tirage(RefTirage)
);
