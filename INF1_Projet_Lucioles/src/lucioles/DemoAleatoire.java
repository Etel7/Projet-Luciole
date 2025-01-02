package lucioles;

// Fourni : Exemple démontrant l'utilisation du générateur pseudo-aléatoire

public class DemoAleatoire {

	public static void main(String[] args) {

		// RandomGen.rGen.nextDouble() renvoie un double dans [0.0 ; 1.0]
		System.out.println("nextDouble() : " + RandomGen.rGen.nextDouble());
		System.out.println("nextDouble() : " + RandomGen.rGen.nextDouble());

		// RandomGen.rGen.nextInt(int bound) renvoie un entier dans [0 ; bound[
		System.out.println("nextInt() : " + RandomGen.rGen.nextInt(20));
		System.out.println("nextInt() : " + RandomGen.rGen.nextInt(20));

	}

}
