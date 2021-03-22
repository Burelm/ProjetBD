INSERT INTO LesClients(NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO LesClients(-1,"","","","",5);
INSERT INTO LesClients(1,"JJD@test.ts","Dupont","Jean-Jacque","1234",1);
INSERT INTO LesClients(2,"MD@test.ts","Dubourg","Micheline","5678",1);
INSERT INTO LesClients(3,"Deactivated@sadness.swag","Deactivated","Acount","0000",0);

INSERT INTO LesAdresseClients(NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO LesAdresseClients(-1,0,"Notworking",0,"NotexistantLand","00000");
INSERT INTO LesAdresseClients(1,1,"Rue de la Paix",12,"Grenoble","38000");
INSERT INTO LesAdresseClients(2,1,"Rue de l Amour",21,"Grenoble","38000");
INSERT INTO LesAdresseClients(3,2,"Rue de la Fraternité",96,"Grenoble","38000");

INSERT INTO FichierImage(NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO FichierImage(1,"/user/jj/image/photo1.png",1,"Incroyable plan raprocher","zoom *3 non pixelisé sur la libellule","4K",0,"22/03/21");
INSERT INTO FichierImage(1,"/user/jj/image/photo2.png",1,"Petit plan Américain","effet sepia","1920*1080",1,"22/03/21");
INSERT INTO FichierImage(2,"/user/md/image/lune.png",2,"Cadrage en contre plongé","Augmentation contraste","2560*1440",1,"15/03/21");
INSERT INTO FichierImage(2,"/user/md/image/famille.png",2,"Plan moyen","noir et blanc","HD",0,"16/03/21");
INSERT INTO FichierImage(2,"/user/md/image/lewanski.png",2,"Plan raproché épaule","pas de retouche","4096*2160",0,"21/03/21");
INSERT INTO FichierImage(2,"/user/md/image/funtogether.png",2,"Plan d'ensemble","effet sepia","FULL HD",1,"22/03/21");

INSERT INTO LesCommandes(NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO LesCommandes(1,1,"23/03/21","expresse",1,"encours",1);
INSERT INTO LesCommandes(2,1,"20/03/21","normale",0,"expédié",2);
INSERT INTO LesCommandes(3,2,"22/03/21","nope",1,"nope",3);
INSERT INTO LesCommandes(4,2,"22/03/21","normale",1,"validé",3);
INSERT INTO LesCommandes(5,2,"22/03/21","rapide",0,"préparé",3);

INSERT INTO Panier(NULL,NULL);
INSERT INTO Panier(-1,0);
INSERT INTO Panier(1,1);
INSERT INTO Panier(2,2);
INSERT INTO Panier(3,3);
INSERT INTO Panier(4,4);
INSERT INTO Panier(5,5);

INSERT INTO CodePromo(NULL,NULL);
INSERT INTO CodePromo(1,1);
INSERT INTO CodePromo(2,1);

--'Tirage','Impression','Cadre','Calendrier','Album'


