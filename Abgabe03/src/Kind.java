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

public class Kind extends Person implements Frech{

	public boolean wachsen;
	protected Kuscheltier[] kuscheltiere = new Kuscheltier[2];
	public Kind() {
		super();
		wachsen = false;
		kuscheltiere = null;
	}
	
	public Kind(LocalDate geburtstag, int alter, String name, boolean wachsen, Kuscheltier[] kuscheltiere) {
		super();
		this.wachsen = wachsen;
		this.kuscheltiere = kuscheltiere;
	}

	@Override
	public boolean aergern(Person p) {
		return false;
	}

	@Override
	public void zungeRausstrecken() {
		
	}
}
