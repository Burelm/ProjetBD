import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import DAO.AlbumDAO;
import Metier.Album;
import Metier.Cadre;
import Metier.Calendrier;
import DAO.LesAdressesClientsDAO;
import DAO.ProduitDAO;
import DAO.CadreDAO;
import DAO.CalendrierDAO;
import DAO.TirageDAO;
import DAO.AlbumDAO;
import DAO.ImpressionDAO;
import Metier.Impression;
import Metier.Tirage;
import DAO.CadreDAO;
import DAO.ClientDAO;
import DAO.CodePromoDAO;
import DAO.CommandeDAO;
import DAO.DAO;
import DAO.FichierImageDAO;
import Metier.AdresseClient; 
import DAO.LesAdressesClientsDAO;
import Metier.Client;
import Metier.CodePromo;
import Metier.Commande;
import Metier.FichierImage;
import Metier.LesClients;
import Metier.Produit;


public class Test { 
	public static void main(String[] args) { 
		TirageDAO tirageDAO= new TirageDAO(TheConnection.getInstance());
		ImpressionDAO impressionDAO= new ImpressionDAO(TheConnection.getInstance());
		CadreDAO cadreDAO= new CadreDAO(TheConnection.getInstance());
		AlbumDAO albumDAO= new AlbumDAO(TheConnection.getInstance());
		CalendrierDAO calendrierDAO= new CalendrierDAO(TheConnection.getInstance());
		FichierImageDAO FimageDAO =new FichierImageDAO(TheConnection.getInstance());	
	    	DAO<LesClients> clientDao = new ClientDAO(TheConnection.getInstance());
		DAO<Commande> commandeDao = new CommandeDAO(TheConnection.getInstance());
    		DAO<Produit> produitDao = new ProduitDAO(TheConnection.getInstance());
    		DAO<CodePromo> promoDao = new CodePromoDAO(TheConnection.getInstance());
		DAO<ArrayList<AdresseClient>> adresseDao = new LesAdressesClientsDAO(TheConnection.getInstance());
		LesClients listeClients = clientDao.read(1);
		
		boolean Connexion = false;
		boolean inMenu = true;
		String mail;
		String mdp;
		Client Client=new Client();
		
		while (inMenu) {
			//Demande de choix d'action
			System.out.println("Entrer: \n1-Se connecter \n2-CrÃ©er un nouveau compte \n3-Quitter");
			int menu=LectureClavier.lireEntier("Saisisez une des fonctionnalitÃ© :");
			while (menu<1 && menu>3) {
				menu = LectureClavier.lireEntier("Mauvaise fonctionnalitÃ© uniquement de 1 Ã  3:");
			}

			//Cas des different choix
			switch(menu) {
				//Si connexion
				case 1:
					System.out.println("Saisissez votre adresse mail:");
					mail = LectureClavier.lireChaine();

					if(listeClients.indiceClientavecMail(mail) != -1) {
						Client=listeClients.getClient(listeClients.indiceClientavecMail(mail));
						System.out.println("Saisissez votre mot de passe:");
						mdp = LectureClavier.lireChaine();
						while (!Client.getMdp().equals(mdp)&& menu==1) {
							System.out.println("Mauvais mot de passe !");
							System.out.println("Saissir:\n 1- Pour rÃ©essayer\n 2- Pour revenir au menu");
							menu = LectureClavier.lireEntier("");
							if (menu == 1) {
								System.out.println("Mot de passe:");
								mdp=LectureClavier.lireChaine();
							}
						}	
						if (Client.getMdp().equals(mdp)&& menu==1) {
							Connexion = true;
							inMenu = false;
							System.out.println("Bienvenue "+Client.getNom()+" "+Client.getPrenom()+"!");
						}
					}
					else {
						System.out.println("Compte inexistant !");
						menu=LectureClavier.lireEntier("1- RÃ©essayÃ© avec un nouveau mail\n2- Creer un nouveau compte\n3-Quitter");
					}
					break;

				//Si creation profil
				case 2:
					System.out.println("Saisissez votre adresse mail:");
					mail=LectureClavier.lireChaine();
					String nom;
					String prenom;
					int nC;
					LesClients C = new LesClients();
					Client NewClient;
					if(listeClients.indiceClientavecMail(mail) == -1) {
						System.out.println("Saisissez votre mot de passe:");
						mdp=LectureClavier.lireChaine();
						System.out.println("Saisissez votre nom:");
						nom=LectureClavier.lireChaine();
						System.out.println("Saisissez votre prenom:");
						prenom=LectureClavier.lireChaine();
						nC = listeClients.getNumClientDispo();
						NewClient = new Client(nC, nom, prenom, mail, mdp);
						listeClients.addClient(NewClient);
						C.addClient(NewClient);
						clientDao.create(C);
					}
					else {
						  System.out.println("Compte existant !");
						  menu=LectureClavier.lireEntier("1- RÃ©essayÃ© avec un nouveau mail\n2- Creer un nouveau compte\n3-Quitter");
					}
					Connexion = false;
					inMenu = true;
					break;

				//Si Quitte
				default:
					System.out.println ("Au revoir !!!");
					Connexion = false;
					inMenu = false;
					break;
			}
		}
		
		while(Connexion) {
			Connexion=true;
			System.out.println("Compte Client"+Client.getNom()+" "+Client.getPrenom());
			System.out.println("1- Ajouté une Adresse de livraison\n 2- modifier mes image\n3- Modifié une commande\n4-Ajouté une Commande\n5- Me déconnecté");
			int menu=LectureClavier.lireEntier("Saisisez une des fonctionnalité :");
			while (menu<1 && menu>4) {
				menu = LectureClavier.lireEntier("Mauvaise fonctionnalité uniquement de 1 à 4:");
			}

			switch(menu){
				case 1:
					System.out.println("Saisissez votre numero de rue:");
					int numR=LectureClavier.lireEntier("");

					System.out.println("Saisissez votre nom de rue:");
					String nomR=LectureClavier.lireChaine();

					System.out.println("Saisissez votre code postal:");
					int codeP=LectureClavier.lireEntier("");

					System.out.println("Saisissez votre ville:");
					String villeC=LectureClavier.lireChaine();

					AdresseClient adrC = new AdresseClient(nomR, numR, villeC, codeP);
					ArrayList<AdresseClient> newadress= new ArrayList<AdresseClient>();
					newadress.add(adrC);
					DAO<ArrayList<AdresseClient>> ajoutAdresseDao = new LesAdressesClientsDAO(TheConnection.getInstance(),Client.getnoClient());
					ajoutAdresseDao.create(newadress);
					Client.addAdresse(adrC);
					break;
				case 2:
                    boolean continuer = true;
                    while(continuer) {
                        System.out.println("Saisissez l'URL de votre image");
                        String url = LectureClavier.lireChaine();
                        System.out.println("Saisissez la prise de vue de votre image");
                        String priseDeVue = LectureClavier.lireChaine();
                        System.out.println("Saisissez le param�tre de retouche de votre image");
                        String parametreRetouche = LectureClavier.lireChaine();
                        System.out.println("Saisissez la r�solution de votre image");
                        String resolution = LectureClavier.lireChaine();
                        System.out.println("Souhaitez vous partager l'image ? (oui/non)");
                        String choix = LectureClavier.lireChaine();
                        boolean partage;
                        while (!choix.equals("oui") && !choix.equals("non")) {
                            System.out.println("Erreur : Mot incorrect. Saisir oui ou non");
                            choix = LectureClavier.lireChaine();
                        }
                        if (choix.equals("oui")) {
                            partage = true;
                        } else {
                            partage = false;
                        }
                        Long millis = System.currentTimeMillis();
                        Date date = new Date(millis);
                        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                        
                        FichierImage fi = new FichierImage(Client.getnoClient(), url, priseDeVue, parametreRetouche, resolution, partage, formater.format(date));
                        FichierImageDAO fiDAO = new FichierImageDAO(TheConnection.getInstance());
                        fiDAO.create(fi);
                        
                        System.out.println("Voulez vous mettre une autre image ?");
                        choix = LectureClavier.lireChaine();
                        while (!choix.equals("oui") && !choix.equals("non")) {
                            System.out.println("Erreur : Mot incorrect. Saisir oui ou non");
                            choix = LectureClavier.lireChaine();
                        }
                        if (choix.equals("non")) {
                            continuer = false;
                        }
                    }
                    break;
						
						
					
				case 3:
					int idProduit;
					int typeProduit=LectureClavier.lireEntier("Vous souhaitez crée un produit, veuillez choisir son type ci dessous:\n 1:Tirage\n 2:Impression\n 3:Cadre\n 4:Album\n 5:Calendrier\n");
					int nbrPhoto=LectureClavier.lireEntier("Combien voulez vous de photo dans votre tirage ?");
					ArrayList<FichierImage> photoDispo= FimageDAO.readAll(Client.getnoClient());
					ArrayList<Integer> listPhoto = new ArrayList<Integer>();
					ArrayList<String> formatImage=new ArrayList<String>();
					int idCommande=0;//ici requête de Tariq
					String miseEnPage;
					switch(typeProduit) {
						case 1://tirage
							idProduit=0;
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								tirageDAO.create(new Tirage(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i)));
							}
						case 2://impression
							idProduit=1;
							System.out.println("Penser à rentre vos photo dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								impressionDAO.create(new Impression(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i));
							}
						case 3://cadre
							idProduit=2;
							System.out.println("Quel Modèle de cadre ?");

							String model=LectureClavier.lireChaine();
							System.out.println("Quel Taille ?");

							String taille=LectureClavier.lireChaine();
							System.out.println("Penser à rentre vos photo dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								
								cadreDAO.create(new Cadre(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i,taille,model));
							}
						case 4://calendrier
							idProduit=3;
							
							
							System.out.println("Penser à rentre vos photo dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								System.out.println("Quel mise en page ?");
								miseEnPage=LectureClavier.lireChaine();
								calendrierDAO.create(new Calendrier(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i,miseEnPage));
							}
						case 5://album
							idProduit=4;
							System.out.println("Quel titre pour votre album ?");
							String titre=LectureClavier.lireChaine();
							
							
							String descriptif;
							System.out.println("Penser à rentre vos photo dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								System.out.println("Quel mise en page ?");
								miseEnPage=LectureClavier.lireChaine();
								System.out.println("Quel Descriptif ?");
								descriptif=LectureClavier.lireChaine();
								albumDAO.create(new Album(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i,titre,miseEnPage,descriptif));
							}
					
					}
					break;
					}
			}
			Connexion=false;
		
		
		System.out.println("Au revoir !!!");
		/*
		System.out.println (listeClients.getClient(0).getNom()+ " "+listeClients.getClient(0).getMail()+"--"+listeClients.getClient(0).getMdp());
		System.out.println (listeClients.getClient(1).getNom()+" "+listeClients.getClient(1).getMail());
		System.out.println (listeClients.getClient(2).getNom());	
		System.out.println (listeClients.getClient(3).getNom());
		System.out.println (listeClients.getClient(4).getNom());
		System.out.println (listeClients.getClient(5).getNom());
		*/
		
		
	}
	public static void  Choix(ArrayList<FichierImage> photoDispo,ArrayList<Integer> listidPhoto,ArrayList<String> formatImage,int nbrPhoto) {
		for(int i=0;i<nbrPhoto;i++) {
			for(int j=0;j<photoDispo.size();j++) {
				int id=photoDispo.get(j).getIdImage();
				System.out.println ("id= "+photoDispo.get(j).getChemin_acces()+"\n");
				System.out.println ("id= "+id+"\n");
				if(LectureClavier.lireOuiNon("Prendre celle-ci ?\n")) {
					listidPhoto.add(i, id);	
					System.out.println ("A quel format ?");
					formatImage.add(LectureClavier.lireChaine());
				}
			}
		}
	}
}
