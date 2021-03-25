INSERT INTO LesClients VALUES (1,'JJD@test.ts','Dupont','Jean-Jacque','1234',1);
INSERT INTO LesClients VALUES (2,'MD@test.ts','Dubourg','Micheline','5678',1);
INSERT INTO LesClients VALUES (3,'Deactivated@sadness.swag','Deactivated','Acount','0000',0);
INSERT INTO LesClients VALUES (4, 'mahi@live.fr', 'Mahi', 'Tariq', 'jesuisla', 1);
INSERT INTO LesClients VALUES (5, 'hebert@orange.fr', 'Hebert', 'Corentin', 'ILoveSalt', 1);
INSERT INTO LesClients VALUES (6, 'Burel@gmail.com', 'Burel', 'Marvin', 'jaimelestulippes', 1);
INSERT INTO LesClients VALUES (7, 'Fornara@gmail.com', 'Fornara', 'Antonin', 'valide', 1);
INSERT INTO LesClients VALUES (8, 'Kaili@gmail.com', 'Kaili', 'Rayan', 'DZ4life', 1);



INSERT INTO LesAdresseClients VALUES (1,1,'Rue de la Paix',12,'Grenoble','38000');
INSERT INTO LesAdresseClients VALUES (2,1,'Rue de l Amour',21,'Grenoble','38000');
INSERT INTO LesAdresseClients VALUES (3,2,'Rue de la Fraternité',96,'Grenoble','38000');


INSERT INTO LesAdresseClients VALUES (4, 1, 'Rue des Fleurs', 3, 'Grenoble', 38000);
INSERT INTO LesAdresseClients VALUES (5, 1, 'Rue Saint Laurent', 32, 'Grenoble', 38000);
INSERT INTO LesAdresseClients VALUES (6, 2, 'Rue Montaigne', 42, 'Paris', 75000);
INSERT INTO LesAdresseClients VALUES (7, 3, 'Allée des ifs', 25, 'Lyon', 69000);
INSERT INTO LesAdresseClients VALUES (8, 4, 'Rue du Velodrome', 58, 'Marseille', 13000);



INSERT INTO FichierImage VALUES (1,'/user/jj/image/photo1.png',1,'Incroyable plan raprocher','zoom *3 non pixelisé sur la libellule','4096*2160',0,TO_DATE('22/03/2021','DD/MM/YYYY'));
INSERT INTO FichierImage VALUES (2,'/user/jj/image/photo2.png',1,'Petit plan Américain','effet sepia','1920*1080',1,TO_DATE('22/03/2021','DD/MM/YYYY'));
INSERT INTO FichierImage VALUES (3,'/user/md/image/lune.png',2,'Cadrage en contre plongé','Augmentation contraste','2560*1440',1,TO_DATE('15/03/2021','DD/MM/YYYY'));
INSERT INTO FichierImage VALUES (4,'/user/md/image/famille.png',2,'Plan moyen','noir et blanc','1280*720',0,TO_DATE('16/03/2021','DD/MM/YYYY'));
INSERT INTO FichierImage VALUES (5,'/user/md/image/lewanski.png',2,'Plan raproché épaule','pas de retouche','4096*2160',0,TO_DATE('21/03/2021','DD/MM/YYYY'));
INSERT INTO FichierImage VALUES (6,'/user/md/image/funtogether.png',2,'Plan d ensemble','effet sepia','1920*1080',1,TO_DATE('22/03/2021','DD/MM/YYYY'));


INSERT INTO LesCommandes VALUES (1,1,TO_DATE('23/03/2021','DD/MM/YYYY'),'expresse',1,'encours',1);
INSERT INTO LesCommandes VALUES (2,1,TO_DATE('20/03/2021','DD/MM/YYYY'),'normale',0,'expédié',2);
INSERT INTO LesCommandes VALUES (3,2,TO_DATE('22/03/2021','DD/MM/YYYY'),'normale',1,'encours',3);   
INSERT INTO LesCommandes VALUES (4,2,TO_DATE('22/03/2021','DD/MM/YYYY'),'normale',1,'valide',3);
INSERT INTO LesCommandes VALUES (5,2,TO_DATE('22/03/2021','DD/MM/YYYY'),'rapide',0,'préparé',3);


INSERT INTO Panier VALUES (1,1);
INSERT INTO Panier VALUES (2,2);
INSERT INTO Panier VALUES (3,3);
INSERT INTO Panier VALUES (4,4);
INSERT INTO Panier VALUES (5,5);


INSERT INTO CodePromo VALUES (1,1);
INSERT INTO CodePromo VALUES (2,1);



INSERT INTO Produit VALUES (1,'Tirage','Moyenne',25.50,'Un tirage classique');
INSERT INTO Produit VALUES (2,'Cadre','Haute',40.22,'Un beau cadre');
INSERT INTO Produit VALUES (3,'Calendrier','Bonne',35.50,'Petit calendrier des familles');
INSERT INTO Produit VALUES (4,'Album','Haute',101.0,'Album pour tout le monde');
INSERT INTO Produit VALUES (5,'Impression','Moyenne',15.50,'Une impression cordiale');


INSERT INTO Tirage VALUES (1,1,1,1,'Portrait');

INSERT INTO Tirage VALUES (2,2,2,2,'Paysage');

INSERT INTO Tirage VALUES (3,3,3,3,'Paysage');
INSERT INTO Tirage VALUES (3,3,4,4,'Paysage');
INSERT INTO Tirage VALUES (3,3,5,5,'Paysage');
INSERT INTO Tirage VALUES (3,3,6,5,'Paysage');
INSERT INTO Tirage VALUES (3,3,7,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,8,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,9,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,10,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,11,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,12,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,13,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,14,2,'Paysage');
INSERT INTO Tirage VALUES (3,3,15,2,'Paysage');

INSERT INTO Tirage VALUES (4,4,16,2,'Paysage');
INSERT INTO Tirage VALUES (4,4,17,3,'Paysage');
INSERT INTO Tirage VALUES (4,4,18,4,'Paysage');

INSERT INTO Tirage VALUES (5,5,19,2, 'Paysage');
INSERT INTO Tirage VALUES (5,5,20,3, 'Paysage');
INSERT INTO Tirage VALUES (5,5,21,4, 'Paysage');


INSERT INTO Cadre VALUES (2,'400*1500','Boisée');


INSERT INTO Calendrier VALUES (3,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (4,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (5,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (6,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (7,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (8,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (9,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (10,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (11,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (12,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (13,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (14,'Image en haut de page et Calendrier en bas de page');
INSERT INTO Calendrier VALUES (15,'Image en haut de page et Calendrier en bas de page');


INSERT INTO Album VALUES (16,'Un homme','Photo centrée titre en dessous et descritpion sur le côté droit','Un homme en photo');
INSERT INTO Album VALUES (17,'Pleine lune','Photo centrée titre en dessous et descritpion sur le côté droit','Pleine Lune bien prise');
INSERT INTO Album VALUES (18,'Ma famille','Photo centrée titre en dessous et descritpion sur le côté droit','Ma famille =)');


INSERT INTO Impression VALUES (19,2);
INSERT INTO Impression VALUES (20,1);
INSERT INTO Impression VALUES (21,3);


