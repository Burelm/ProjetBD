CREATE OR REPLACE PROCEDURE imageSuppr (iddImage IN INT, idClient IN INT)
IS
BEGIN
DELETE FROM FichierImage
WHERE idIMage = iddImage AND iddImage NOT IN (SELECT idImage FROM TIRAGE) AND noClient = idClient;
COMMIT;
END;
/
