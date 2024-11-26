package fr.voxi.administration;

public class Moderateur extends Utilisateur implements Administrateur {
	
	private String login ; 
	private int nbAlertesEnvoyees = 0 ;
	
	public Moderateur(String nom, String prenom, String email, String mdp, int etat, String login,
			int nbAlertesEnvoyees) {
		super(nom, prenom, email, mdp, etat);
		this.login = login;
		this.nbAlertesEnvoyees = nbAlertesEnvoyees;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getNbAlertesEnvoyees() {
		return nbAlertesEnvoyees;
	}

	public void setNbAlertesEnvoyees(int nbAlertesEnvoyees) {
		this.nbAlertesEnvoyees = nbAlertesEnvoyees;
	}
	
	public void alerter( Membre membre , String message ) {
		
		nbAlertesEnvoyees = nbAlertesEnvoyees ++ ; 	
	}

	@Override
	public String toString() {
		return "Moderateur [login=" + login + ", nbAlertesEnvoyees=" + nbAlertesEnvoyees + "]";
	}

	@Override
	public void bloquer(Membre membre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debloquer(Membre membre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean seConnecter(String login, String mdp) {
		
		if( login == this.getLogin() && mdp == this.getMdp() ) {
			
			this.setEtat(CONNECTE);
			
			return true ; 
			
		}else {
			
			return false; 
		}
	}


	
}
