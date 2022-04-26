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
import java.time.Period;

public class Person implements Cloneable{

	protected LocalDate geburtstag;
	/**
	 * Das Attribut ist abgeleitet,
		kann also aus anderen
		berechnet werden	
	 */
	public int alter;
	private String name;
	
	public Person() {
		geburtstag = null;
		alter = 0;
		name = "";
	}
	
	public Person(LocalDate geburtstag, int alter, String name) {
		this.geburtstag = geburtstag;
		this.alter = alter;
		this.name = name;
	}
	
	/**
	 * "Read only"
	 */
	public int getAlter() {
		return Period.between(geburtstag, LocalDate.now()).getYears();
	}
	
	public void zahnfaelltaus() {
		System.out.println("Zahn faellt aus.");
	}
}
