import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankprojekt.verarbeitung.GesperrtException;
import bankprojekt.verarbeitung.Kunde;
import bankprojekt.verarbeitung.Sparbuch;
//import bankprojekt.verarbeitung.Waehrung;


class SparbuchTest {
	/*
	 * 1) Alle Methoden mal aufrufen
	 * 2) Rueckgabewert 
	 * 		+ Auswirkungen pruefen
	 * 3) mehrere Methodenaufrufe kombinieren
	 */
	
	Kunde kunde1 = new Kunde();
	Sparbuch sparbuch1 = new Sparbuch();
	@BeforeEach
	void setUp() throws Exception {
//		Sparbuch(Kunde inhaber, long kontonummer)
//		Kunde(String vorname, String nachname, String adresse, LocalDate gebdat)
		kunde1 = new Kunde("Timo", "Ji", "Storkower Strasse 219", LocalDate.of(1996, 07, 31));
		sparbuch1 = new Sparbuch(kunde1, 12345678);
	}

	@Test
	void abhebenPositivValueTest() throws GesperrtException {
		assertTrue(sparbuch1.abheben(22));

	}
	@Test
	void abhebenZeroValueTest() throws GesperrtException {
		assertTrue(sparbuch1.abheben(0));
	}
	@Test
	void abhebenNegativValueTest() {
		
	}

}
