package fr.voxi.administration;

abstract class Utilisateur {
	
	public static final int CONNECTE = 1 ; 
	public static final int DECONNECTE = 2 ; 
	
	private String nom ; 
	private String prenom ; 
	private String email ; 
	private String mdp ; 
	private int etat = DECONNECTE ;
	
	public Utilisateur(String nom, String prenom, String email, String mdp, int etat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public static int getConnecte() {
		return CONNECTE;
	}

	public static int getDeconnecte() {
		return DECONNECTE;
	} 
	
	public int seDeconnecter() {
		return this.etat = 2 ; 
	}
	
	public abstract boolean seConnecter(String email , String mdp );
	
	
	

}
