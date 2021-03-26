CREATE OR REPLACE TRIGGER factureCreator
AFTER UPDATE ON LesCommandes
FOR EACH ROW
  DECLARE 
   sumPrice FLOAT;
   pragma autonomous_transaction;
BEGIN
  SELECT SUM(PRIX) INTO sumPrice FROM (SELECT PRIX, C.idCommande FROM LesCommandes C JOIN Panier P ON C.idCommande = P.idCommande JOIN Produit A ON P.idProduit = A.idProduit WHERE noClient = :new.noClient);
  IF  :new.Statut = 'valide' THEN INSERT INTO Facture VALUES (:new.idCommande,:new.dateCommande,sumPrice);
  END IF;
  COMMIT;
END;
/