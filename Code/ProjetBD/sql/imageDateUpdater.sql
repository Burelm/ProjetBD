CREATE OR REPLACE TRIGGER imageDateUpdater
AFTER INSERT ON Tirage
FOR EACH ROW
BEGIN
  UPDATE FichierImage SET DateUtilisation = SYSDATE() WHERE idImage = :new.idImage;
END;
/
