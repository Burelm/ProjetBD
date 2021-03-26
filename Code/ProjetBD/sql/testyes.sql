SELECT * FROM LesCommandes WHERE noClient = 2;
SELECT * FROM CodePromo WHERE noClient = 2;
SELECT * FROM FichierImage WHERE noClient = 2;

INSERT INTO LesCommandes VALUES(6,1,TO_DATE('26/03/2021','DD/MM/YYYY'),'rapide',1,'encours',1);
INSERT INTO Panier VALUES(6,5);
INSERT INTO Panier VALUES(6,4);
INSERT INTO Tirage VALUES(5,6,22,6,'Portrait');

SELECT * FROM LesCommandes WHERE idCommande = 6;
SELECT * FROM CodePromo  WHERE noClient = 2;
SELECT * FROM Panier WHERE idCommande = 6;
SELECT * FROM FichierImage WHERE noClient = 2;

UPDATE LesCommandes SET Statut = 'valide' WHERE idCommande = 6;

SELECT * FROM LesCommandes WHERE idCommande = 6;
SELECT * FROM CodePromo  WHERE noClient = 2;
SELECT * FROM Panier WHERE idCommande = 6;

UPDATE LesCommandes SET Statut = 'prepare' WHERE idCommande = 6;

SELECT * FROM LesCommandes WHERE idCommande = 6;
SELECT * FROM CodePromo  WHERE noClient = 2;
SELECT * FROM Panier WHERE idCommande = 6;
