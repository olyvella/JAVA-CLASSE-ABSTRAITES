package fr.voxi.administration;

public class Membre extends Utilisateur {
	
	private boolean bloque = false ; 
	
	public Membre(String nom, String prenom, String email, String mdp, int etat, boolean bloque) {
		super(nom, prenom, email, mdp, etat);
		this.bloque = bloque;
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}
	
	public String visuNotif( String message ) {
		return " Il y a une alerte " ;
		
	}

	@Override
	public String toString() {
		return "Membre [bloque=" + bloque + "]";
	}

	@Override
	public boolean seConnecter(String email, String mdp) {
		
		if( email == this.getEmail() && mdp == this.getMdp() && this.bloque == false ) {
			
			this.setEtat(CONNECTE);
			
			return true ; 
			
		}else {
			
			return false; 
		}
		
	
	}
	
	
	
	

}
