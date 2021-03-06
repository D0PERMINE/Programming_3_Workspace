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


import java.math.BigInteger;

/**
 * Definiert die Klasse bruch mit den Eigenschaften zaehler und nenner. Beinhaltet einen Konstruktor, setter- und getter-Methoden, eine eine ueberladene toString() Methode, 
 * diverse Methoden fuer mathematische Berechnungen und eine Implementation der Vergleichsmethode compareTo().
 * @author timoj
 *
 */
public class Bruch implements Comparable<Bruch>{
	
	// attributes
	private int zaehler;
	private int nenner;
	
	// constructor
	/**
	 * Beschreibung: Konstruktor der Klasse Bruch.
	 * @param zaehler Legt den Zaehler fest.
	 * @param nenner Legt den Nenner fest.
	 * @throws ArithmeticException wenn durch das Aufrufen der setNenner() Methode, ein Nenner auf 0 gesetzt werden will. Gibt eine Warnungsnachricht auf der Konsole aus.
	 */
	public Bruch(int zaehler, int nenner) throws ArithmeticException{
		this.zaehler = zaehler;
		try {
			setNenner(nenner);	
		} 
		catch (ArithmeticException e) {
			System.out.println("Attention! " + e);
		}

	}

	/**
	 * Beschreibung: Getter-Methode fuer das Attribut zaehler.
	 * @return Gibt den Wert von zaehler zurueck.
	 */
	public int getZaehler() {
		return zaehler;
	}

	/**
	 * Beschreibung: Setter-Methode fuer das Attribut zaehler.
	 * @param zaehler Eine Zahl, um den Zaehler zu bestimmen.
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}
	
	/**
	 * Beschreibung: Getter-Methode fuer das Attribut nenner.
	 * @return Gibt den Wert von nenner zurueck.
	 */
	public int getNenner() {
		return nenner;
	}

	/**
	 * Beschreibung: Setter-Methode fuer das Attribut nenner.
	 * @param nenner Eine Zahl, um den nenner zu bestimmen.
	 * @throws ArithmeticException Wenn versucht wird den Nenner auf 0 zu setzen. Gibt eine Warnnachricht in der Konsole aus.
	 */
	public void setNenner(int nenner) throws ArithmeticException {
		if(nenner == 0) {
			this.nenner = 1;
			throw new ArithmeticException("Dividing through 0 is not allowed. The value got set to 1 instead.");
		}
		else {
			this.nenner = nenner;						
		}
	}
	
//	liefert eine String-Darstellung des Bruches
	/**
	 * Beschreibung: Laesst den Bruch schoen und strukturiert als String darstellen.
	 * @return Gibt den Bruch als String zurueck.
	 */
	public String toString() {
		return "Bruch: " + this.zaehler + "/" + this.nenner + "\n";
	}
	
//	rechnet this * b
	/**
	 * Beschreibung: Laesst einen ausgewaehlten Bruch mit einem im Parameter uebergebenden Bruch miteinander multiplizieren.
	 * @param b Einen Bruch mit dem multipliziert werden soll.
	 * @return Das Produkt der beiden Brueche wird zurueckgegeben.
	 */
	public Bruch multiplizieren(Bruch b) {
		Bruch bruch = new Bruch(this.zaehler * b.getZaehler(), this.nenner * b.getNenner());
		return bruch;
	}
	
	
//	rechnet den Bruch in eine Kommazahl um
	/**
	 * Beschreibung: Rechnet den Bruch in eine Kommazahl um
	 * @return Gibt die Kommazahl des Bruchs zurueck.
	 */
	public double ausrechnen() {
		return (double) this.getZaehler()/this.getNenner();
	}
	
//	 k?rzt this, d.h. Z?hler und Nenner werden durch deren gr??ten gemeinsamen Teiler 
//	 geteilt. (Es gibt in der Klasse BigInteger die Methode gcd() oder Sie benutzen 
//	 den euklidischen Algorithmus, um den gr??ten gemeinsamen Teiler zu bestimmen.)
	/**
	 * Beschreibung: Findet den groessten gemeinsamen Teiler von Zaehler und Nenner und kuerzt den Bruch.
	 */
	public void kuerzen() {
		BigInteger zaehler = BigInteger.valueOf(this.zaehler);
		BigInteger nenner = BigInteger.valueOf(this.nenner);
		BigInteger gcd = zaehler.gcd(nenner);
		this.zaehler = this.zaehler / gcd.intValue();
		this.nenner = this.nenner / gcd.intValue();
	}
	
//	 liefert den Kehrwert von this zur?ck
	/**
	 * Beschreibung: Bildet den Kehrwert des Bruchs.
	 * @return Gibt den Kehrwert zurueck.
	 */
	public Bruch kehrwert() {
		Bruch kehrwert = new Bruch(this.nenner, this.zaehler);
		return kehrwert;
	}
	
	
//	 teilt this durch b und gibt das Ergebnis zur?ck. Rufen Sie die bisher geschriebenen 
//	 Funktionen multiplizieren() und kehrwert() auf, denn Dividieren hei?t mathematisch multiplizieren mit dem Kehrwert.
	/**
	 * Beschreibung: Dividiert zwei Brueche miteinander.
	 * @param b Ein Bruch mit dem dividiert werden soll.
	 * @return Gibt den Quotienten der beiden Brueche aus.
	 */
	public Bruch dividieren(Bruch b) {
		return multiplizieren(b.kehrwert());
	}
	
	/**
	 * Beschreibung: Vergleicht zwei Brueche nach deren Wert.
	 * @param bruch Ein Bruch zum Vergleichen.
	 * @return Wenn der Wert des ersten Bruchs(value1) kleiner ist als der Wert des zweiten Bruchs(value2), dann wird ein negativer Wert ausgegeben. 
	 * 		   Bei value1 > value2, dann gibt es einen positiven Wert aus. Sonst(wenn value1 == value2) gib 0 zur?ck.
	 */
	@Override
	public int compareTo(Bruch bruch) {
		float value1 = this.zaehler / this.nenner;
		float value2 = bruch.zaehler / bruch.nenner;
		if(value1 < value2) {
			return -1;
		} 
		else if(value1 > value2) {
			return 1;
		}
		return 0;
	}
}


