package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(isInvariantVerified());
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(forceCoup > 0);
		int forceTemp = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert(forceTemp > force);
	}
	
	private Boolean isInvariantVerified() {
		return force > 0;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
			case 2: {
				System.out.println("Le soldat " + nom + " est déjâ boen protégé !");
				break;
			}
			
			case 1: {
				if (equipements[0].equals(equipement)) {
					System.out.println("Le soldat " + nom + " possède déjâ un " + equipement.toString());
				} else {
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
					equipements[1] = equipement;
					nbEquipements++;
				}
				break;
			}
			default : {
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
				equipements[0] = equipement;
				nbEquipements++;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
