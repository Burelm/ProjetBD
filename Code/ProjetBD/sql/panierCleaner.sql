CREATE OR REPLACE TRIGGER panierCleaner
AFTER UPDATE ON LesCommandes
FOR EACH ROW 
BEGIN
  IF :new.Statut = 'prepare' THEN DELETE FROM PANIER WHERE :new.idCommande = idCommande;
  END IF;
END;
/
