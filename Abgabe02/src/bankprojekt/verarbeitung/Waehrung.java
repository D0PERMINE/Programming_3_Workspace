package bankprojekt.verarbeitung;

import java.math.BigDecimal;
import java.math.RoundingMode;
/*
 * 
 * 
 * 
 */

/**
 * Behinhaltet verschiedene Waehrungen.
 * @author timoj
 *
 */
public enum Waehrung {
	
	
//	 Sie soll die Konstanten EUR, BGN (Bulgarische Leva), DKK (D�nische Kronen) und MKD
//	 (Mazedonischer Denar) haben - das sind alle die W�hrungen, die mit einem festen 
//	 Umrechnungskurs an den Euro gebunden sind.
	
	// Const
	EUR, BGN, DKK, MKD;
	
	private double zuEuroUmrechnungskurs;
	
	static {
		EUR.zuEuroUmrechnungskurs = 1;
		BGN.zuEuroUmrechnungskurs = 1.9558;
		DKK.zuEuroUmrechnungskurs = 7.4604;
		MKD.zuEuroUmrechnungskurs = 61.62;
	}
	
	/**
	 * Sie soll den in Euro angegebenen Betrag in die jeweilige W�hrung umrechnen.
	 * @param betrag
	 * @return
	 */
	public double euroInWaehrungUmrechnen(double betrag) {
		return betrag * this.zuEuroUmrechnungskurs;
	}
	
	/**
	 * Sie soll den in Euro angegebenen Betrag in die jeweilige W�hrung umrechnen.
	 * @param betrag
	 * @return
	 */
	public double waehrungInEuroUmrechnen(double betrag) {
//		BigDecimal bigDecimalBetrag = new BigDecimal(betrag);
//		BigDecimal bigDecimalZuEuroUmrechnungskurs = new BigDecimal(this.zuEuroUmrechnungskurs);
//		return bigDecimalBetrag.divide(bigDecimalZuEuroUmrechnungskurs, 5, RoundingMode.HALF_UP);
		return betrag / this.zuEuroUmrechnungskurs;
	}

}
