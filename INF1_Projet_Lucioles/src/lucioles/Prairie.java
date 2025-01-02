package lucioles;

import outils.*;

// Étapes 2 et 3 : Définition de prairies, et simulation sans interaction

public class Prairie {
	public static void afficheTab(double[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	public static void afficheTab2D(double[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void afficheTab2Dint(int[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Seuil au delà duquel une luciole émet un flash.
	public static final double SEUIL = 100.0;

	// Indices nommés pour accéder aux données d'une luciole
	public static final int ENERGIE = 0;
	public static final int DELTA = 1;

	public static double[] creerLuciole() {
		double[] tab = new double[2];
		tab[ENERGIE] = RandomGen.rGen.nextInt(100);
		tab[DELTA] = RandomGen.rGen.nextDouble();
		return tab;
	}

	public static double[] incrementeLuciole(double[] luciole) {
		luciole[ENERGIE] = luciole[ENERGIE] + luciole[DELTA];
		return luciole;
	}

	public static double[][] creerPopulation(int nbLucioles) {
		double[][] tab = new double[nbLucioles][2];
		for (int i = 0; i < tab.length; i++) {
			tab[i][ENERGIE] = RandomGen.rGen.nextInt(100);
			tab[i][DELTA] = RandomGen.rGen.nextDouble();
		}
		return tab;
	}

	public static int[][] prairieVide(int nbLignes, int nbColonnes) {
		int[][] tab = new int[nbLignes][nbColonnes];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = -1;
			}
		}
		return tab;
	}

	public static void affichePrairie(int[][] prairie, double[][] popLucioles) {
		for (int i = 0; i < prairie.length; i++) {
			for (int j = 0; j < prairie[0].length; j++) {
				if (i == 0 || i == prairie.length - 1) {
					System.out.print("#");
				} else if (j == 0 || j == prairie[0].length - 1) {
					System.out.print("#");
				} else if (prairie[i][j] != -1) {
					if (popLucioles[i][ENERGIE] > SEUIL) {
						System.out.print("*");
					} else {
						System.out.print(".");
					}
					// LucioleSeule.symboliseLuciole(popLucioles[i][j]);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	// QUESTION 18 //
	public static int[][] prairieLucioles(int nbLignes, int nbColonnes, double[][] popLucioles) {
		int[][] tab = prairieVide(nbLignes, nbColonnes); // on fait un tableau vide
		int k = 0;
		while (k < popLucioles.length) { // parcourt la population de lucioles
			int aleatoireL = RandomGen.rGen.nextInt(nbLignes); 
			int aleatoireC = RandomGen.rGen.nextInt(nbColonnes);
			
			if (k == -1) {
				tab[aleatoireL][aleatoireC] = k;
				k++;
			}
			
		}
		return tab;
		}
//		for (int k = 0; k < popLucioles.length; k++) { // parcourt la population de lucioles
//				int aleatoireL = RandomGen.rGen.nextInt(nbLignes);
//				int aleatoireC = RandomGen.rGen.nextInt(nbColonnes);
//				if (k != tab[aleatoireL][aleatoireC]) { // condition pour éviter d'avoir deux lucioles dans la même case
//					tab[aleatoireL][aleatoireC] = k; // on distribue la luciole k aléatoirement dans tab
//				
//			}
//
//		}
//
//		return tab;
//	}

	// QUESTION 19 //

	public static void simulationPrairie(int[][] prairie, double[][] popLucioles, int pas) {
		for (int i = 0; i < pas; i++) { // parcourt le nombre de pas
			for (int j = 0; j < prairie.length; j++) {
				if (popLucioles[j][ENERGIE] > SEUIL) {
					popLucioles[j][ENERGIE] = 0;
				}
				incrementeLuciole(popLucioles[j]);

			}
			affichePrairie(prairie, popLucioles);
		}
	}

	public static void simulationPrairieGIF(int[][] prairie, double[][] popLucioles, int pas) {
		for (int i = 0; i < prairie.length; i++) {
			String nom = "Luciole " + i;
			BitMap.bmpEcritureFichier(nom, prairie, popLucioles, SEUIL);
		}
	}

	public static void main(String[] args) {
		// TODO À compléter
		double[] luciole1 = creerLuciole();
		int[][] prairieDeLucioles = prairieLucioles(7, 7, creerPopulation(40));
		double[][] pop1 = creerPopulation(10);
		int nbPas = 1;

		// afficheTab(luciole1);
		// afficheTab(incrementeLuciole(luciole1));
		// afficheTab2D(creerPopulation(10));
		// afficheTab2Dint(prairieVide(10, 4));
		// int[][] prairieV = prairieVide(20, 10);

		// affichePrairie(prairieLucioles(10, 10, creerPopulation(60)), pop1);
		// afficheTab2Dint(prairieLucioles(4,2, creerPopulation(6)));
		simulationPrairie(prairieDeLucioles, pop1, 99);
		simulationPrairieGIF(prairieDeLucioles, pop1, nbPas);

	}

}
