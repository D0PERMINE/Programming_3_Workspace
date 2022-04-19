import java.time.LocalDate;

/**
 * 
 * Datum: 19.04.2022
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

public class Person implements Cloneable{

	protected LocalDate geburtstag;
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
		return alter;
	}
	
	public void zahnfaelltaus() {
		System.out.println("Zahn faellt aus.");
	}
}
