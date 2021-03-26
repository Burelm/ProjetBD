import java.sql.CallableStatement;
import java.sql.SQLException;
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
			System.out.println("Entrer: \n1-Se connecter \n2-Creer un nouveau compte \n3-Quitter");
			int menu=LectureClavier.lireEntier("Saisisez une des fonctionnalites :");
			while (menu<1 && menu>3) {
				menu = LectureClavier.lireEntier("Mauvaise fonctionnalite, uniquement de 1 a 3:");
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
							System.out.println("Saisir:\n 1- Pour reessayer\n 2- Pour revenir au menu");
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
						menu=LectureClavier.lireEntier("1- Reessayer avec un nouveau mail\n2- Creer un nouveau compte\n3-Quitter");
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
						  menu=LectureClavier.lireEntier("1- Reessayer avec un nouveau mail\n2- Creer un nouveau compte\n3-Quitter");
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
			System.out.println("1- Ajouter une Adresse de livraison\n 2- Ajouter des images\n3- Créer un tirage\n5-Consulter des informations\n6- Supprimer une image\n7- Se deconnecter");
			int menu=LectureClavier.lireEntier("Saisisez une des fonctionnalites :");
			while (menu<1 && menu>7) {
				menu = LectureClavier.lireEntier("Mauvaise fonctionnalite uniquement de 1 a 7:");
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
                        System.out.println("Saisissez le parametre de retouche de votre image");
                        String parametreRetouche = LectureClavier.lireChaine();
                        System.out.println("Saisissez la resolution de votre image");
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
                        
                        System.out.println("Voulez vous mettre une autre image ? (oui/non)");
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
					int typeProduit=LectureClavier.lireEntier("Vous souhaitez creer un produit, veuillez choisir son type ci dessous:\n 1:Tirage\n 2:Impression\n 3:Cadre\n 4:Album\n 5:Calendrier\n");
					int nbrPhoto=LectureClavier.lireEntier("Combien voulez vous de photos dans votre tirage ?");
					ArrayList<FichierImage> photoDispo= FimageDAO.readAll(Client.getnoClient());
					ArrayList<Integer> listPhoto = new ArrayList<Integer>();
					ArrayList<String> formatImage=new ArrayList<String>();
					int idCommande=0;//ici requÃÆÃÂªte de Tariq
					String miseEnPage;
					switch(typeProduit) {
						case 1://tirage
							idProduit=0;
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								tirageDAO.create(new Tirage(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i)));
							}
							break;
						case 2://impression
							idProduit=1;
							System.out.println("Penser a rentrer vos photos dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								impressionDAO.create(new Impression(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i));
							}
							break;
						case 3://cadre
							idProduit=2;
							System.out.println("Quel Mode de cadre ?");

							String model=LectureClavier.lireChaine();
							System.out.println("Quelle Taille ?");

							String taille=LectureClavier.lireChaine();
							System.out.println("Penser a rentre vos photos dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								
								cadreDAO.create(new Cadre(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i,taille,model));
							}
							break;
						case 4://calendrier
							idProduit=3;
							
							
							System.out.println("Penser a rentre vos photos dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								System.out.println("Quelle mise en page ?");
								miseEnPage=LectureClavier.lireChaine();
								calendrierDAO.create(new Calendrier(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i,miseEnPage));
							}
							break;
						case 5://album
							idProduit=4;
							System.out.println("Quel titre pour votre album ?");
							String titre=LectureClavier.lireChaine();
							
							
							String descriptif;
							System.out.println("Penser a rentre vos photos dans l'ordre dans lequel elles doivent apparaitre");
							Choix(photoDispo,listPhoto,formatImage,nbrPhoto);
							for(int i=0;i<listPhoto.size();i++) {
								System.out.println("Quelle mise en page ?");
								miseEnPage=LectureClavier.lireChaine();
								System.out.println("Quel Descriptif ?");
								descriptif=LectureClavier.lireChaine();
								albumDAO.create(new Album(idCommande,idProduit,i,listPhoto.get(i),formatImage.get(i),i,titre,miseEnPage,descriptif));
							}
							break;
							
						
					
					}
					break;
				case 5: // Consultation
					int choix = LectureClavier.lireEntier("1- Consulter une commande \n 2- Informations Compte \n 3- Liste des impressions \n 4- Liste des images partagees");
					switch(choix) {
					case 1:
						ArrayList<Integer> idCommandes = new ArrayList<Integer>();
						CommandeDAO commandeDAO = new CommandeDAO(TheConnection.getInstance());
						int i = 0;
						ArrayList<Commande> lesCommandes = commandeDAO.readAll(Client.getnoClient());
						for (Commande commande: lesCommandes) {
							System.out.print("Commande numero :" + commande.getidCommande() + " | ");
							System.out.println("Index : " + i);
							idCommandes.add(commande.getidCommande());//Peut Ãªtre qu'il manque un CAST
							i++;
						}
						int idCommandeConsult = LectureClavier.lireEntier("Saisir l'index de la commande a consulter");
						//TODO Controle de saisie
						lesCommandes.get(idCommandeConsult).afficher();
						break;
					case 2:
						Client.afficher();
						//TODO Afficher les codes promos
						break;
					case 3:
						System.out.println("Fonctionnalite pas encore implementee");
						break;
					case 4:
						ArrayList<FichierImage> lesFichiersImage = FimageDAO.readImageAutoriser(Client.getnoClient());
						for(FichierImage fi : lesFichiersImage) {
								fi.afficher();
						}
					}
					
					break;
				case 6://Supprime image
					System.out.println("liste de mes photos");
					FichierImageDAO fiDAO = new FichierImageDAO(TheConnection.getInstance());
					ArrayList<FichierImage> mesphoto=fiDAO.readAll(Client.getnoClient());
					for(int i=0;i<mesphoto.size();i++) {
						System.out.println(mesphoto.get(i).afficherImage());
					}
					int idImage=LectureClavier.lireEntier("l'id de l'image en question");
					DAO<FichierImage> fichierimgdao= new FichierImageDAO(TheConnection.getInstance());
					FichierImage todelete = fichierimgdao.read(idImage);
					String queryedquery = "{CALL imageSuppr(" + idImage + "," + Client.getnoClient() + ")}";
				CallableStatement request;
				try {
					request = TheConnection.getInstance().prepareCall(queryedquery);
					todelete = fichierimgdao.read(idImage);
					System.out.println(todelete);
					System.out.println("Le fichier image n'as pas ete suprime");
					request.execute();
					request.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				case 7://déconnexion
					Connexion=false;
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
