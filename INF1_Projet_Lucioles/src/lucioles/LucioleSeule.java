package lucioles;

// Étape 1 : Simulation d'une seule luciole

public class LucioleSeule {

	// Seuil au delà duquel une luciole émet un flash.
	public static final double SEUIL = 100.0;

	// Partie 1

	// Exercice 1
	public static char symboliseLuciole(double niveauEnergie) {
		if (niveauEnergie > SEUIL) {
			return '*';
		}
		return ',';
	}

	public static void afficheLuciole(double niveauEnergie, boolean verbeux) {
		System.out.print(symboliseLuciole(niveauEnergie) + " ");
		if (verbeux == true) {
			System.out.print(niveauEnergie);
		}
		System.out.println();
	}

	// Exercice 2

	public static double incrementeLuciole(double niveauEnergie, double deltaEnergie) {
		double niv2 = niveauEnergie;
		niv2 = niv2 + deltaEnergie;
		return niv2;
	}
	
	// Exercice 3
	public static void simuleLucioleNbPas(int n) {
		double lucioleEnergie = RandomGen.rGen.nextInt(100);
		for (int i = 0; i < n; i++) {
			lucioleEnergie = incrementeLuciole(lucioleEnergie, RandomGen.rGen.nextDouble());
			afficheLuciole(lucioleEnergie, true);
			if (lucioleEnergie > SEUIL) {
				lucioleEnergie = 0;
			}
		}
	}
	
	public static void simuleLucioleNbFlashs(int n) {
		double lucioleEnergie = RandomGen.rGen.nextInt(100);
		int compteur = 0;
		for(int i=0;i<n;i++) {
			while (compteur < 4) {
				lucioleEnergie = incrementeLuciole(lucioleEnergie, RandomGen.rGen.nextDouble());
				if (lucioleEnergie > SEUIL) {
					compteur++;
					afficheLuciole(lucioleEnergie, true);
					lucioleEnergie=0;
				}
				afficheLuciole(lucioleEnergie, true);
			}
			lucioleEnergie = incrementeLuciole(lucioleEnergie, RandomGen.rGen.nextDouble());
			afficheLuciole(lucioleEnergie, false);
		}
	}

	public static void main(String[] args) {
		// TODO À compléter
		double lucioleEnergie = RandomGen.rGen.nextInt(100);
		// System.out.println(lucioleEnergie);
		// System.out.println(symboliseLuciole(101.1));
		// afficheLuciole(101,false);
		// afficheLuciole(101,true);
		// afficheLuciole(99,false);
		// afficheLuciole(99,true);
		double lucioleDeltaEnergie = RandomGen.rGen.nextDouble();
//		System.out.println(incrementeLuciole(lucioleEnergie, lucioleDeltaEnergie));
//		simuleLucioleNbPas(100);
		simuleLucioleNbFlashs(200);

	}

}
