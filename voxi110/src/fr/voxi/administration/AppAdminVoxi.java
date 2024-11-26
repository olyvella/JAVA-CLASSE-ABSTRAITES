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
			
			System.out.println( " connecter " ) ;
			
		}else {
			
			System.out.println( " Pas connecter " ) ;
		}


		//7. Écrire le code qui a pour rôle de tenter d'authentifier tous les utilisateurs (nom de connexion/adresse électronique et mot de passe corrects). //
		
		for( Utilisateur user : utilisateurs ) {
			
			if ( user.getEtat() == 2 ) {
				
				user.seConnecter() ; 
				
				System.out.println( user.getNom() + "     " +user.getEtat()  ) ; 
			
			}
		}

		//8. Écrire les instructions relatives au scénario suivant : // 
		
		// 9. Écrire les instructions relatives au scénario suivant : //
		
		// 10. Écrire les instructions relatives au traitement suivant : //


		
	}

}
