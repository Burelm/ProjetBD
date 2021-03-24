CREATE OR REPLACE TRIGGER imageDateUpdater
AFTER INSERT,UPDATE ON Tirage
FOR EACH ROW
BEGIN
  UPDATE FichierImage SET DateUtilisation = SYSDATE() WHERE idImage = :new.idImage;
END;
/
