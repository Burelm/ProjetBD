import java.util.ArrayList;

import DAO.ClientDAO;
import DAO.DAO;
import Metier.AdresseClient; 
import DAO.LesAdressesClientsDAO;
import Metier.Client;
import Metier.LesClients;


public class Test { 
	public static void main(String[] args) { 
		
	    DAO<LesClients> clientDao = new ClientDAO(TheConnection.getInstance());
		DAO<ArrayList<AdresseClient>> adresseDao = new LesAdressesClientsDAO(TheConnection.getInstance());
		LesClients listeClients = clientDao.read(1);
		
		boolean Connexion = false;
		boolean inMenu = true;
		String mail;
		String mdp;
		Client Client=new Client();
		
		while (inMenu) {
			//Demande de choix d'action
			System.out.println("Entrer: \n1-Ce connecter \n2-Créer un nouveau compte \n3-Quitter");
			int menu=LectureClavier.lireEntier("Saisisez une des fonctionnalité :");
			while (menu<1 && menu>3) {
				menu = LectureClavier.lireEntier("Mauvaise fonctionnalité uniquement de 1 à 3:");
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
							System.out.println("Saissir:\n 1- Pour réessayer\n 2- Pour revenir au menu");
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
						menu=LectureClavier.lireEntier("1- Réessayé avec un nouveau mail\n2- Creer un nouveau compte\n3-Quitter");
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
						  menu=LectureClavier.lireEntier("1- Réessayé avec un nouveau mail\n2- Creer un nouveau compte\n3-Quitter");
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
			System.out.println("Compte Client"+Client.getNom()+" "+Client.getPrenom());
			System.out.println("1- Modifié mes Adresse de livraison\n2- modifier mes image\n3- Modifié une commande\n4-Ajouté une Commande\n5- Me déconnecté");
			int menu=LectureClavier.lireEntier("Saisisez une des fonctionnalité :");
			while (menu<1 && menu>4) {
				menu = LectureClavier.lireEntier("Mauvaise fonctionnalité uniquement de 1 à 4:");
			}

			switch(menu){
				case 1:
					/*System.out.println("Saisissez votre numero de rue:");
					int numR=LectureClavier.lireEntier();

					System.out.println("Saisissez votre nom de rue:");
					String nomR=LectureClavier.lireChaine();

					System.out.println("Saisissez votre code postal:");
					int codeP=LectureClavier.lireEntier();

					System.out.println("Saisissez votre ville:");
					String villeC=LectureClavier.lireChaine();

					AdresseClient adrC = new AdresseClient(nomR, numR, villeC, codeP);
					adresseDao.create(adrC);*/
					break;
					

			}
			Connexion=false;
		}
		
		System.out.println ("Au revoir !!!");
		/*
		System.out.println (listeClients.getClient(0).getNom()+ " "+listeClients.getClient(0).getMail()+"--"+listeClients.getClient(0).getMdp());
		System.out.println (listeClients.getClient(1).getNom()+" "+listeClients.getClient(1).getMail());
		System.out.println (listeClients.getClient(2).getNom());	
		System.out.println (listeClients.getClient(3).getNom());
		System.out.println (listeClients.getClient(4).getNom());
		System.out.println (listeClients.getClient(5).getNom());
		*/
		
		
	}
}