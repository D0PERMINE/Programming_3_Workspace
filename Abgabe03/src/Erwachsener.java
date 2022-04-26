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

import java.time.LocalDate;

public class Erwachsener extends Person {

	public static final String WUTSCHREI = "HEYYY!";
	private Kind[] kinder;
	
	public Erwachsener() {
		super();
		kinder = null;
	}
	
	public Erwachsener(LocalDate geburtstag, int alter, String name, Kind[] kinder) {
		super();
		this.kinder = kinder;
	}
}
