package fr.voxi.administration;
import java.util.ArrayList;

public class AppAdminVoxi {


	public static void main(String[] args) {
		
		//1. Déclarer et initialiser la variable utilisateurs. // 
		
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>() ; 
		
		utilisateurs.add(new Membre("ZAKI", "Selma" , "s.zaki@gns.fr" , "azerty" , Utilisateur.DECONNECTE, false ) ) ;
		
		utilisateurs.add(new Moderateur("LEBRETON" , "Jules", "j.lebreton@gmail.com",  "azerty" , Utilisateur.DECONNECTE , "jbreton", 33 )) ;
		
		utilisateurs.add(new Moderateur ("BA", "Béchir", "bechir.ba@gmail.com" , "azerty" , Utilisateur.CONNECTE, "bba", 103 )) ;
		
		utilisateurs.add(new Membre("CAMOIT", "Alexis" , "a.camoit@gns.fr" , "azerty" , Utilisateur.DECONNECTE, true ) ) ;
		
		utilisateurs.add(new Membre("KARIM", "Lamia" , "l.karim@gns.fr" , "azerty" , Utilisateur.CONNECTE, false) ) ; 
		
		utilisateurs.add(new Moderateur ("ESSAMAMI", "Hamza", "hamza.mami@gmail.com" , "azerty" , Utilisateur.DECONNECTE, "hessa", 8 )) ;

		//2. Écrire le code qui a pour rôle d'afficher le nom et le prénom de chaque utilisateur.//

		System.out.println( utilisateurs ) ; 
		
		//3. Écrire le code qui a pour rôle de compter puis d'afficher le nombre d'utilisateurs connectés.//
		
		for( Utilisateur user : utilisateurs ) {
			
			int cpt = 0 ; 
			
			if ( user.getEtat() == 1 ) {
				 cpt++ ; 
				 System.out.println( "Utilisateurs connectés " + cpt );
			}
		}
		
		//4. Écrire le code qui a pour rôle de déconnecter tous les utilisateurs, puis qui affiche le nom et l'état de chaque utilisateur.//
		
		for( Utilisateur user : utilisateurs ) {
			
			if ( user.getEtat() == 1 ) {
				
				user.seDeconnecter() ; 
				
				System.out.println( user.getNom() + "     " +user.getEtat()  ) ; 
			
			}
		}
		
		
		//5. Écrire le code qui a pour rôle de tenter d'authentifier le premier utilisateur qui a pour nom de connexion jberto et le mot de passe azerty. Le résultat de la tentative d'authentification est affiché.//
		
		
		if (((Membre)(utilisateurs.get(0))).seConnecter("jberto","azerty") == true) {
			
			System.out.println( " connecter " ) ;
		}
		else {
			
			System.out.println( " Authentification échoué") ; 
		}
		

		//6. Écrire le code qui a pour rôle de tenter d'authentifier l'auditrice Selma Zaki. Le résultat de la tentative d'authentification est affiché. //
		
		if ( utilisateurs.get(0).seConnecter( "s.zaki@gns.fr" , "azerty") == true ){
			
			System.out.println( " L'auditrice est connectée " ) ;
			
		}else {
			
			System.out.println( " Pas connecter " ) ;
		}


		//7. Écrire le code qui a pour rôle de tenter d'authentifier tous les utilisateurs (nom de connexion/adresse électronique et mot de passe corrects). //
		
		for( Utilisateur user : utilisateurs ) {
			
			if ( user instanceof Membre ) {
				
				user.seConnecter( user.getEmail()  , user.getMdp() ) ; 
				
				System.out.println( "L'utilsateur" + "    " + user.getNom() + "    " +  " est connecter :  " + user.getEtat() ) ;
			
			}else {
				
				user.seConnecter((( Moderateur)user).getLogin() , user.getMdp()); 
				
				System.out.println( "L'utilsateur" + "    " + user.getNom() + "    " +  " est connecter  : " + user.getEtat() ) ;
				
			}
		}

		//8. Écrire les instructions relatives au scénario suivant : // 
		
		Utilisateur admin1 = new Moderateur("LEBRETON" , "Jules", "j.lebreton@gmail.com",  "azerty" , Utilisateur.DECONNECTE , "jbreton", 33 ) ;
		utilisateurs.add(admin1) ;
		
		Utilisateur user1 = new Membre("CAMOIT", "Alexis" , "a.camoit@gns.fr" , "azerty" , Utilisateur.DECONNECTE, true ) ;
		utilisateurs.add(user1) ;
		
		((Moderateur)admin1).debloquer((Membre)user1) ;
		
		System.out.println("L'auditeur Alexis CAMOIT vient d'être débloquer .");
		System.out.println(user1.seConnecter("a.camoit@gns.fr", "azerty"));
		
		// 9. Écrire les instructions relatives au scénario suivant : //
			
		Utilisateur admin2 = new Moderateur("ESSAMAMI", "Hamza", "hamza.mami@gmail.com" , "azerty" , Utilisateur.DECONNECTE, "hessa", 8 ) ;
		utilisateurs.add(admin2) ;
		
		Utilisateur user2 = new Membre("ZAKI", "Selma" , "s.zaki@gns.fr" , "azerty" , Utilisateur.DECONNECTE, false ) ;
		utilisateurs.add(user2) ;
		
		((Moderateur)admin2).bloquer((Membre)user2);
		System.out.println("L'auditeur Selma ZAKI vient d'être bloquer .");
		System.out.println(user1.seConnecter("s.zaki@gns.fr", "azerty"));
		
		
		// 10. Écrire les instructions relatives au traitement suivant : //
		
		Utilisateur admin3 = new Moderateur("BA", "Béchir", "bechir.ba@gmail.com" , "azerty" , Utilisateur.CONNECTE, "bba", 103 ) ;
		utilisateurs.add(admin3) ;
		
		Utilisateur user3 = new Membre("KARIM", "Lamia" , "l.karim@gns.fr" , "azerty" , Utilisateur.CONNECTE, false) ; 
		utilisateurs.add(user3) ;
		
		System.out.println( ((Moderateur)admin3).getNbAlertesEnvoyees() ) ;
		
		((Moderateur)admin3).alerter((Membre)user3, " Vos propos sont injurieux");	
		
		System.out.println(  ((Moderateur)admin3).getNbAlertesEnvoyees()  ) ;
		
		
		


		
	}

}
