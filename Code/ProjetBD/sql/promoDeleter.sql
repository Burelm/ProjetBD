CREATE OR REPLACE TRIGGER promoDeleter
AFTER INSERT ON LesCommandes
FOR EACH ROW
BEGIN
  DELETE CodePromo WHERE noClient = :new.noClient AND :new.Promo = 1 AND ROWNUM <= 1;
END;
/
