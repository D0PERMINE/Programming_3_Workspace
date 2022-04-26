/**
 * 
 * Datum: 26.04.2022
 * Programmierung 3 - Uebung 03
 * Dozent: Dorothea Hubrich
 * 
 * Name: Timo Ji
 * Matrikel-Nummer: 575725
 * 
 * Anmerkungen: 
 * Ohne Partner gemacht.
 * 
 */

package bankprojekt.verarbeitung;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Behinhaltet verschiedene Waehrungen und Methoden zur Umrechnung von Waehrungen.
 * @author timoj
 *
 */
public enum Waehrung {
	
	
//	 Sie soll die Konstanten EUR, BGN (Bulgarische Leva), DKK (D�nische Kronen) und MKD
//	 (Mazedonischer Denar) haben - das sind alle die W�hrungen, die mit einem festen 
//	 Umrechnungskurs an den Euro gebunden sind.
	
	/**
	 * Konstanten: Euro, Bulgarische Leva, Dänische Kronen, Mazedonischer Denar
	 */
	EUR, BGN, DKK, MKD;
	
	/**
	 * Zum Festlegen eines Umrechnungskurses zu Euro
	 */
	private double zuEuroUmrechnungskurs;
	
	static {
		EUR.zuEuroUmrechnungskurs = 1;
		BGN.zuEuroUmrechnungskurs = 1.9558;
		DKK.zuEuroUmrechnungskurs = 7.4604;
		MKD.zuEuroUmrechnungskurs = 61.62;
	}
	
	/**
	 * Sie soll den in Euro angegebenen Betrag in die jeweilige W�hrung umrechnen.
	 * @param betrag Der umzurechnende Euro Betrag
	 * @return Liefert den umgerechneten Betrag von Euro zu der jeweilige Waehrung zurueck
	 */
	public double euroInWaehrungUmrechnen(double betrag) {
		return betrag * this.zuEuroUmrechnungskurs;
	}
	
	/**
	 * Sie soll den in Euro angegebenen Betrag in die jeweilige W�hrung umrechnen.
	 * @param betrag Der Betrag der umzurechnender Wearhung 
	 * @return Liefert den umgerechneten Betrag von der jeweilige Waehrung in Euro zurueck
	 */
	public double waehrungInEuroUmrechnen(double betrag) {
//		BigDecimal bigDecimalBetrag = new BigDecimal(betrag);
//		BigDecimal bigDecimalZuEuroUmrechnungskurs = new BigDecimal(this.zuEuroUmrechnungskurs);
//		return bigDecimalBetrag.divide(bigDecimalZuEuroUmrechnungskurs, 5, RoundingMode.HALF_UP);
		return betrag / this.zuEuroUmrechnungskurs;
	}

	/**
	 * Soll eine den Betrag von einer Waerhung in eine andere Waehrung umrechenen
	 * @param betrag betrag zum umrechnen
	 * @param w waehrung in die umgerechnet werden soll
	 * @return umgerechneter Betrag mit neuer Waehrung
	 */
	public double waehrungZuWaehrung(double betrag, Waehrung w) {
		return this.euroInWaehrungUmrechnen(w.waehrungInEuroUmrechnen(betrag));
	}
}
