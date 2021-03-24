CREATE OR REPLACE TRIGGER imageDateUpdater
AFTER INSERT OR UPDATE ON Tirage
FOR EACH ROW
BEGIN
  UPDATE FichierImage SET DateUtilisation = SYSDATE() WHERE idImage = :new.idImage;
END;
/
