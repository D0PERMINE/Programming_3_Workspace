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

/**
 * stellt ein allgemeines Konto dar
 */
public abstract class Konto implements Comparable<Konto>
{
	/** 
	 * der Kontoinhaber
	 */
	private Kunde inhaber;

	/**
	 * die Kontonummer
	 */
	private final long nummer;

	/**
	 * der aktuelle Kontostand
	 */
	private double kontostand;
	
	private Waehrung kontoWaehrung;
	
	protected void setKontoWaehrung(Waehrung kontoWaehrung) {
		this.kontoWaehrung = kontoWaehrung;
	}
	
	protected Waehrung getKontoWaehrung() {
		return kontoWaehrung;
	}

	/**
	 * setzt den aktuellen Kontostand
	 * @param kontostand neuer Kontostand
	 */
	protected void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	/**
	 * Wenn das Konto gesperrt ist (gesperrt = true), können keine Aktionen daran mehr vorgenommen werden,
	 * die zum Schaden des Kontoinhabers wären (abheben, Inhaberwechsel)
	 */
	private boolean gesperrt;

	/**
	 * Setzt die beiden Eigenschaften kontoinhaber und kontonummer auf die angegebenen Werte,
	 * der anfängliche Kontostand wird auf 0 gesetzt.
	 *
	 * @param inhaber der Inhaber
	 * @param kontonummer die gewünschte Kontonummer
	 * @throws IllegalArgumentException wenn der Inhaber null
	 */
	public Konto(Kunde inhaber, long kontonummer) {
		if(inhaber == null)
			throw new IllegalArgumentException("Inhaber darf nicht null sein!");
		this.inhaber = inhaber;
		this.nummer = kontonummer;
		this.kontostand = 0;
		this.gesperrt = false;
		this.kontoWaehrung = Waehrung.EUR;
	}
	
	/**
	 * setzt alle Eigenschaften des Kontos auf Standardwerte
	 */
	public Konto() {
		this(Kunde.MUSTERMANN, 1234567);
	}

	/**
	 * liefert den Kontoinhaber zurück
	 * @return   der Inhaber
	 */
	public final Kunde getInhaber() {
		return this.inhaber;
	}
	
	/**
	 * setzt den Kontoinhaber
	 * @param kinh   neuer Kontoinhaber
	 * @throws GesperrtException wenn das Konto gesperrt ist
	 * @throws IllegalArgumentException wenn kinh null ist
	 */
	public final void setInhaber(Kunde kinh) throws GesperrtException{
		if (kinh == null)
			throw new IllegalArgumentException("Der Inhaber darf nicht null sein!");
		if(this.gesperrt)
			throw new GesperrtException(this.nummer);        
		this.inhaber = kinh;

	}
	
	/**
	 * liefert den aktuellen Kontostand
	 * @return   double
	 */
	public final double getKontostand() {
		return kontostand;
	}

	/**
	 * liefert die Kontonummer zurück
	 * @return   long
	 */
	public final long getKontonummer() {
		return nummer;
	}

	/**
	 * liefert zurück, ob das Konto gesperrt ist oder nicht
	 * @return true, wenn das Konto gesperrt ist
	 */
	public final boolean isGesperrt() {
		return gesperrt;
	}
	
	/**
	 * Erhöht den Kontostand um den eingezahlten Betrag.
	 *
	 * @param betrag double
	 * @throws IllegalArgumentException wenn der betrag negativ ist 
	 */
	public void einzahlen(double betrag) {
		if (betrag < 0 || Double.isNaN(betrag)) {
			throw new IllegalArgumentException("Falscher Betrag");
		}
		setKontostand(getKontostand() + betrag);
	}
	
	/**
	 * Gibt eine Zeichenkettendarstellung der Kontodaten zurück.
	 */
	@Override
	public String toString() {
		String ausgabe;
		ausgabe = "Kontonummer: " + this.getKontonummerFormatiert()
				+ System.getProperty("line.separator");
		ausgabe += "Inhaber: " + this.inhaber;
		ausgabe += "Aktueller Kontostand: " + getKontostandFormatiert() + " ";
		ausgabe += this.getGesperrtText() + System.getProperty("line.separator");
		return ausgabe;
	}
	
	/*
	public void ausgeben()
	{
		System.out.println(this.toString());
	}
	*/

	/**
	 * Mit dieser Methode wird der geforderte Betrag vom Konto abgehoben, wenn es nicht gesperrt ist.
	 *
	 * @param betrag double
	 * @throws GesperrtException wenn das Konto gesperrt ist
	 * @throws IllegalArgumentException wenn der betrag negativ ist 
	 * @return true, wenn die Abhebung geklappt hat, 
	 * 		   false, wenn sie abgelehnt wurde
	 */
	public abstract boolean abheben(double betrag) 
								throws GesperrtException;
	
	/**
	 * sperrt das Konto, Aktionen zum Schaden des Benutzers sind nicht mehr möglich.
	 */
	public final void sperren() {
		this.gesperrt = true;
	}

	/**
	 * entsperrt das Konto, alle Kontoaktionen sind wieder möglich.
	 */
	public final void entsperren() {
		this.gesperrt = false;
	}
	
	
	/**
	 * liefert eine String-Ausgabe, wenn das Konto gesperrt ist
	 * @return "GESPERRT", wenn das Konto gesperrt ist, ansonsten ""
	 */
	public final String getGesperrtText()
	{
		if (this.gesperrt)
		{
			return "GESPERRT";
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * liefert die ordentlich formatierte Kontonummer
	 * @return auf 10 Stellen formatierte Kontonummer
	 */
	public String getKontonummerFormatiert()
	{
		return String.format("%10d", this.nummer);
	}
	
	/**
	 * liefert den ordentlich formatierten Kontostand
	 * @return formatierter Kontostand mit 2 Nachkommastellen und dem jeweiligen "Währungssymbol"
	 */
	public String getKontostandFormatiert()
	{
		return String.format("%10.2f %s" , this.getKontostand(), getAktuelleWaehrung());
	}
	
	/**
	 * Vergleich von this mit other; Zwei Konten gelten als gleich,
	 * wen sie die gleiche Kontonummer haben
	 * @param other das Vergleichskonto
	 * @return true, wenn beide Konten die gleiche Nummer haben
	 */
	@Override
	public boolean equals(Object other)
	{
		if(this == other)
			return true;
		if(other == null)
			return false;
		if(this.getClass() != other.getClass())
			return false;
		if(this.nummer == ((Konto)other).nummer)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode()
	{
		return 31 + (int) (this.nummer ^ (this.nummer >>> 32));
	}

	@Override
	public int compareTo(Konto other)
	{
		if(other.getKontonummer() > this.getKontonummer())
			return -1;
		if(other.getKontonummer() < this.getKontonummer())
			return 1;
		return 0;
	}
	
	
	
	
	
	// ---------------------------------------------------------------------------- neue Methoden fuer Abgabe ----------------------------
	
	/**
	 * Hebt den gewünschten in der Währung w angegebenen Betrag ab.
	 * @param betrag Betrag, der abgehoben soll.
	 * @param w Die Waehrung, in der abgehoben werden soll.
	 * @return liefert true zurueck, wenn das konto nicht gesperrt ist, sonst false
	 * @throws GesperrtException Wenn Konto gesperrt ist.
	 */
	public boolean abheben(double betrag, Waehrung w) throws GesperrtException {
		if(!this.gesperrt) {
			
//			if(this.kontoWaehrung == Waehrung.EUR && w == Waehrung.EUR) {
//				this.setKontostand(this.getKontostand() - betrag);
//			} 
//			else if(this.kontoWaehrung == Waehrung.EUR && w != Waehrung.EUR) {
//				this.setKontostand(this.getKontostand() - w.waehrungInEuroUmrechnen(betrag));
//			} 
//			else if(this.kontoWaehrung != Waehrung.EUR && w == Waehrung.EUR) {
//				this.setKontostand(this.getKontostand() - this.kontoWaehrung.euroInWaehrungUmrechnen(betrag));
//			} 
//			else if(this.kontoWaehrung != Waehrung.EUR && w != Waehrung.EUR) {
//				double betragZwischenrechnung = w.waehrungInEuroUmrechnen(betrag);
//				this.setKontostand(this.getKontostand() - this.kontoWaehrung.euroInWaehrungUmrechnen(betragZwischenrechnung));
//			}
			
			if(this.kontoWaehrung == Waehrung.EUR && w == Waehrung.EUR) {
				return abheben(betrag);
			} 
			else if(this.kontoWaehrung == Waehrung.EUR && w != Waehrung.EUR) {
				return abheben(w.waehrungInEuroUmrechnen(betrag));
			} 
			else if(this.kontoWaehrung != Waehrung.EUR && w == Waehrung.EUR) {
				return abheben(this.kontoWaehrung.euroInWaehrungUmrechnen(betrag));
			} 
			else if(this.kontoWaehrung != Waehrung.EUR && w != Waehrung.EUR) {
				return abheben(w.waehrungZuWaehrung(betrag, w));
			}
			
			double umgerechnet = w.waehrungZuWaehrung(betrag, w);
			return abheben(umgerechnet);
			
		}
		else {
			throw new GesperrtException(this.nummer);
		}
//		return this.gesperrt;
	}
	
	/**
	 * Zahlt den in der Währung w angegebenen Betrag ein.
	 * @param betrag Betrag, der eingezahlt werden soll.
	 * @param w Waherung, in der eingezahlt werden soll.
	 */
	public void einzahlen(double betrag, Waehrung w) {
		
//		if(this.kontoWaehrung == Waehrung.EUR && w == Waehrung.EUR) {
//			this.setKontostand(this.getKontostand() + betrag);
//		} 
//		else if(this.kontoWaehrung == Waehrung.EUR && w != Waehrung.EUR) {
//			this.setKontostand(this.getKontostand() + w.waehrungInEuroUmrechnen(betrag));
//		} 
//		else if(this.kontoWaehrung != Waehrung.EUR && w == Waehrung.EUR) {
//			this.setKontostand(this.getKontostand() + this.kontoWaehrung.euroInWaehrungUmrechnen(betrag));
//		} 
//		else if(this.kontoWaehrung != Waehrung.EUR && w != Waehrung.EUR) {
//			double betragZwischenrechnung = w.waehrungInEuroUmrechnen(betrag);
//			this.setKontostand(this.getKontostand() + this.kontoWaehrung.euroInWaehrungUmrechnen(betragZwischenrechnung));
//		} 
		
		if(this.kontoWaehrung == Waehrung.EUR && w == Waehrung.EUR) {
			einzahlen(betrag);
		} 
		else if(this.kontoWaehrung == Waehrung.EUR && w != Waehrung.EUR) {
			einzahlen(w.waehrungInEuroUmrechnen(betrag));
		} 
		else if(this.kontoWaehrung != Waehrung.EUR && w == Waehrung.EUR) {
			einzahlen(this.kontoWaehrung.euroInWaehrungUmrechnen(betrag));
		} 
		else if(this.kontoWaehrung != Waehrung.EUR && w != Waehrung.EUR) {
			einzahlen(w.waehrungZuWaehrung(betrag, w));
		}
		
//		double umgerechnet = w.waehrungZuWaehrung(betrag, w);
//		einzahlen(umgerechnet);
	}
	
	/**
	 * Liefert die aktuelle Waehrung in der das Konto gefuehrt wjrd zurueck.
	 * @return Die akutelle Waehrung in der das Konto gefuehrt wird.
	 */
	public Waehrung getAktuelleWaehrung() {
		return this.kontoWaehrung;
	}

	/**
	 *  Wechselt die Waehrung vom Konto.
	 * @param neu Die Waehrung, in die gewechselt werden soll.
	 */
	public void waehrungswechsel(Waehrung neu) {
		
		if(this.kontoWaehrung == Waehrung.EUR && neu != Waehrung.EUR) {
			this.setKontostand(neu.euroInWaehrungUmrechnen(this.kontostand));
		} 
		else if(this.kontoWaehrung != Waehrung.EUR && neu == Waehrung.EUR) {
			this.setKontostand(neu.waehrungInEuroUmrechnen(this.kontostand));
		} 
		else if(this.kontoWaehrung != Waehrung.EUR && neu != Waehrung.EUR) {
			double betragZwischenrechnung = neu.waehrungInEuroUmrechnen(this.kontostand);
			this.setKontostand(neu.euroInWaehrungUmrechnen(betragZwischenrechnung));
		} 
		
		this.kontoWaehrung = neu;
	}

}
