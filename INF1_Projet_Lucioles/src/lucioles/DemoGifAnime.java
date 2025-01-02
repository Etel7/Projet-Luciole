package lucioles;

import outils.*;

// Fourni : Exemple démontrant la construction d'un GIF animé

public class DemoGifAnime {

	public static void main(String[] args) {
		
		// Les images à afficher dans le GIF animé
		String[] images = { "img/33.bmp", "img/34.bmp",
				"img/35.bmp", "img/36.bmp", "img/37.bmp", "img/38.bmp" };
		
		// Création du fichier contenant le GIF animé
		GifCreator.construitGIF("simu/monGIFanime.gif", images);
	}

}
