import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankprojekt.verarbeitung.GesperrtException;
import bankprojekt.verarbeitung.Kunde;
import bankprojekt.verarbeitung.Sparbuch;
//import bankprojekt.verarbeitung.Waehrung;


class SparbuchTest {

	@BeforeEach
	void setUp() throws Exception {
//		Sparbuch(Kunde inhaber, long kontonummer)
//		Kunde(String vorname, String nachname, String adresse, LocalDate gebdat)
//		System.out.println("Anlagen von Kunden: ");
//		Kunde kunde2 = new Kunde();
//		Kunde kunde3 = new Kunde();
//		System.out.println("Anlagen von Sparbeuchern: ");
//		Sparbuch sparbuch2 = new Sparbuch();
//		Sparbuch sparbuch3 = new Sparbuch();
	}

	@Test
	void testAbheben() throws GesperrtException {
		Kunde kunde1 = new Kunde("Timo", "Ji", "Storkower Strasse 219", LocalDate.of(1996, 07, 31));
		Sparbuch sparbuch1 = new Sparbuch(kunde1, 12345678);
		assertEquals(33.00, sparbuch1.abheben(33.00));
	}

}
