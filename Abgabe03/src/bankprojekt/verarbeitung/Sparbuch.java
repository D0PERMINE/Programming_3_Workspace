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

import java.time.LocalDate;

/**
 * ein Sparbuch
 * @author Doro
 *
 */
public class Sparbuch extends Konto {
	/**
	 * Zinssatz, mit dem das Sparbuch verzinst wird. 0,03 entspricht 3%
	 */
	private double zinssatz;
	
	/**
	 * Monatlich erlaubter Gesamtbetrag für Abhebungen
	 */
	public static final double ABHEBESUMME = 2000;
	
	/**
	 * Betrag, der im aktuellen Monat bereits abgehoben wurde
	 */
	private double bereitsAbgehoben = 0;
	/**
	 * Monat und Jahr der letzten Abhebung
	 */
	private LocalDate zeitpunkt = LocalDate.now();
	
	/**
	* ein Standard-Sparbuch
	*/
	public Sparbuch() {
		zinssatz = 0.03;
	}

	/**
	* ein Standard-Sparbuch, das inhaber gehört und die angegebene Kontonummer hat
	* @param inhaber der Kontoinhaber
	* @param kontonummer die Wunsch-Kontonummer
	* @throws IllegalArgumentException wenn inhaber null ist
	*/
	public Sparbuch(Kunde inhaber, long kontonummer) {
		super(inhaber, kontonummer);
		zinssatz = 0.03;
	}
	
	@Override
	public String toString()
	{
    	String ausgabe = "-- SPARBUCH --" + System.lineSeparator() +
    	super.toString()
    	+ "Zinssatz: " + this.zinssatz * 100 +"%" + System.lineSeparator();
    	return ausgabe;
	}

	@Override
	public boolean abheben (double betrag) throws GesperrtException{
		if (betrag < 0 || Double.isNaN(betrag)) {
			throw new IllegalArgumentException("Betrag ungültig");
		}
		if(this.isGesperrt())
		{
			GesperrtException e = new GesperrtException(this.getKontonummer());
			throw e;
		}
		LocalDate heute = LocalDate.now();
		if(heute.getMonth() != zeitpunkt.getMonth() || heute.getYear() != zeitpunkt.getYear())
		{
			this.bereitsAbgehoben = 0;
		}
		if (getKontostand() - betrag >= 0.50 && 
				 bereitsAbgehoben + betrag <= Sparbuch.ABHEBESUMME)
		{
			if(this.getAktuelleWaehrung() == Waehrung.EUR) {
				setKontostand(getKontostand() - betrag);
				bereitsAbgehoben += betrag;			
			} 
			else {
				double betragInAktuellerWaehrung = this.getAktuelleWaehrung().euroInWaehrungUmrechnen(betrag);
				setKontostand(getKontostand() - betragInAktuellerWaehrung);
				bereitsAbgehoben += betragInAktuellerWaehrung;
			}
			this.zeitpunkt = LocalDate.now();
			return true;
		}
		else
			return false;
	}
	
//	/**
//	 *  Wechselt die Waehrung vom Konto.
//	 * @param neu Die Waehrung, in die gewechselt werden soll.
//	 */
//	public void waehrungswechsel(Waehrung neu) {
//		
//		if(this.getKontoWaehrung() == Waehrung.EUR && neu != Waehrung.EUR) {
//			this.setKontostand(neu.euroInWaehrungUmrechnen(this.getKontostand()));
//		} 
//		else if(this.getKontoWaehrung() != Waehrung.EUR && neu == Waehrung.EUR) {
//			this.setKontostand(neu.waehrungInEuroUmrechnen(this.getKontostand()));
//		} 
//		else if(this.getKontoWaehrung() != Waehrung.EUR && neu != Waehrung.EUR) {
//			double betragZwischenrechnung = neu.waehrungInEuroUmrechnen(this.getKontostand());
//			this.setKontostand(neu.euroInWaehrungUmrechnen(betragZwischenrechnung));
//		} 
//		
//		this.setKontoWaehrung(neu);
//	}

}
