CREATE OR REPLACE TRIGGER promoCreator
BEFORE INSERT ON LesCommandes
FOR EACH ROW
  DECLARE 
   sumPrice INT;
   countNbPromo INT;
BEGIN
  SELECT COUNT(*) INTO countNbPromo FROM CodePromo;
  SELECT SUM(PRIX) INTO sumPrice FROM (SELECT PRIX, C.idCommande FROM LesCommandes C JOIN Panier P ON C.idCommande = P.idCommande JOIN Produit A ON P.idProduit = A.idProduit WHERE noClient = :new.noClient);
  IF sumPrice > 100 THEN INSERT INTO CodePromo VALUES (countNbPromo+1,:new.noClient);
  END IF;
END;
/
