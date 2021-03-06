/*
 * Datum: 10.04.2022
 * Programmierung 3 - Uebung 01
 * Dozent: Dorothea Hubrich
 * 
 * Name: Timo Ji
 * Matrikel-Nummer: 575725
 * 
 * Anmerkungen: 
 * Ohne Partner gemacht.
 * 
 * Siehe *(1): Hier wird korrekt absteigend sortiert, aber mir ist unklar warum es aufsteigend nicht ganz korrekt sortiert(eine Zeile drueber).
 * 
 */


import java.util.*;

/**
 * Beschreibung: Die Klasse Playground testet mithilfe der main-Methode die geschriebenen Klassen und Methoden.
 * 
 * @author timoj
 *
 */
public class Playground {

	/**
	 * Beschreibung: Fuehrt Programm/Code aus.
	 * @param args Wird nicht benutzt.
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		// initializing Bruch
		Bruch bruch1 = new Bruch(4, 3);	
		Bruch bruch2 = new Bruch(2, 3);
		Bruch bruch3 = new Bruch(12, 27);
		Bruch bruch4 = new Bruch(5, 0);
		Bruch bruch5 = new Bruch(33, 5);
		
		// array initialized
		Bruch[] arrayBrueche = {bruch1, bruch2, bruch3, bruch4, bruch5};
		
		System.out.println("\nBrueche:\n");
		for(int i = 0; i < arrayBrueche.length; i++) {
			System.out.println(i + ". Bruch:" + arrayBrueche[i].toString());
		}
		
		// testing methods
		System.out.println(bruch1.toString());
		System.out.println(bruch1.toString().strip() + " * " + bruch2.toString());
		System.out.println(bruch1.multiplizieren(bruch2).toString());
		System.out.println(bruch1.toString());
		System.out.println(bruch1.ausrechnen() + "\n");
		bruch3.kuerzen();
		System.out.println(bruch3.toString());
		System.out.println(bruch3.kehrwert().toString());
		System.out.println(bruch3.dividieren(bruch2));
		System.out.println(bruch4.toString());
		System.out.println("break --------------------\n");
		
		System.out.println("BEFORE SORT:\n");
		for(int i = 0; i < arrayBrueche.length; i++) {
			System.out.println(i + ". Bruch:" + arrayBrueche[i].toString());
		}
		
//		aufsteigend nach dem Wert des Bruches
		Arrays.sort(arrayBrueche);
//		Arrays.sort(arrayBrueche, Collections.reverseOrder());	// *(1) <----------------------------------------

		System.out.println("AFTER SORT(value):\n");
		for(int i = 0; i < arrayBrueche.length; i++) {
			System.out.println(i + ". Bruch:" + arrayBrueche[i].toString());
		}
				 
//		absteigend nach der Differenz aus Z?hler und Nenner
		Arrays.sort(arrayBrueche, new BruchVergleicher());
		
		System.out.println("AFTER SORT(difference):\n");
		for(int i = 0; i < arrayBrueche.length; i++) {
			System.out.println(i + ". Bruch:" + arrayBrueche[i].toString());
		}
	}
}
