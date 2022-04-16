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
 */


import java.util.Comparator;

/**
 * Enthaelt eine Implementation der Methode compare() aus dem Comparator Interface.
 * 
 * @author timoj
 *
 */
public class BruchVergleicher implements Comparator<Bruch>{

	/**
	 * Beschreibung: Vergleicht zwei Brueche nach der Differenz aus Zaehler und Nenner miteinander.
	 * @param bruch1 Ein Bruch zum Vergleichen.
	 * @param bruch2 Ein weiterer Bruch zum Vergleichen.
	 * @return Wenn die Differenz des ersten Bruchs(value1) kleiner ist als die Differenz des zweiten Bruchs(value2), dann wird ein positiver Wert ausgegeben. 
	 * 		   Bei value1 > value2, dann gibt es einen negativen Wert aus. Sonst(wenn value1 == value2) gib 0 zurück.
	 * @throws IllegalArgumentExcepetion Wenn eines der beiden oder beide Eingabeparameter NICHT vom Typ Bruch sind.
	 */
	@Override
	public int compare(Bruch bruch1, Bruch bruch2) {
		if(bruch1 instanceof Bruch && bruch2 instanceof Bruch) {
			float value1 = Math.abs(bruch1.getZaehler() - bruch1.getNenner());
			float value2 = Math.abs(bruch2.getZaehler() - bruch2.getNenner());
			if(value1 < value2) {
				return 1;
			} 
			else if(value1 > value2) {
				return -1;
			}
				return 0;
		} 
		else {
			throw new IllegalArgumentException();
		}
	}
}
