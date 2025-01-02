package lucioles;

// Fourni: Définition d'un générateur pseudo-aléatoire

public final class RandomGen {

	// Un générateur aléatoire disponible pour le projet.
	// Voir le fichier DemoAleatoire.java pour des exemples d'utilisation.
	public static final java.util.Random rGen = new java.util.Random();

	// Ne pas modifier. Vous n'avez pas besoin de comprendre cette fonction.
	private RandomGen() {
		throw new UnsupportedOperationException(
				"RandomGen est une classe qui ne peut pas être instanciée.");
	}
}
