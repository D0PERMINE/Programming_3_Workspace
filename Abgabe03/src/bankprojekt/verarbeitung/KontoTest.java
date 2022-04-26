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

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testet einige Methoden aus Klasse Konto
 * @author timoji
 *
 */
class KontoTest {
	
	// Deklaration von Objekten
	Kunde kunde1;
	Sparbuch konto1;

	/**
	 * initialisiere Objekte, um sie zu testen
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		kunde1 = new Kunde("Timo", "Ji", "Storkower Strasse 219", LocalDate.of(1996, 7, 31));
		konto1 = new Sparbuch(kunde1, 12345678);
	}

	/**
	 * testet die Methode abheben() auf das "ueberziehen" eines Kontos
	 */
	@Test
	void abhebenTest() {
		konto1.einzahlen(25);
		try {
			konto1.abheben(35);
			fail("Should have thrown an Exception");
		} catch (GesperrtException e) {
//			e.printStackTrace();
			assertTrue(true);
		}
		
	}
	
	/**
	 * testet, ob abheben() mit einem normalen Wert funktioniert
	 * @throws GesperrtException wenn Konto gesperrt ist
	 */
	@Test
	void abhebenNormalValueTest() throws GesperrtException {
		konto1.einzahlen(25);
		assertEquals(true, konto1.abheben(13));
		assertEquals(12, konto1.getKontostand());
	}
	
	/**
	 * testet, ob abheben() mit einem negativen Wert funktioniert
	 * @throws GesperrtException
	 */
	@Test
	void abhebenNegativeValueTest() throws GesperrtException {
		konto1.einzahlen(25);
		assertFalse(konto1.abheben(-13));
	}
	
	/**
	 * testet, ob einzahlen() mit einem normalen Wert funktioniert
	 */
	@Test
	void einzahlenTest() {
		konto1.einzahlen(25);
		assertEquals(25, konto1.getKontostand());
//		assertTrue(konto1.einzahlen(25));
		
	}
	
	/**
	 * testet, ob die aktuelle Waehrung des Kontos stimmt
	 */
	@Test
	void getAktuelleWaehrungTest() {
		konto1.waehrungswechsel(Waehrung.MKD);
		assertEquals(Waehrung.MKD, konto1.getAktuelleWaehrung());
		konto1.waehrungswechsel(Waehrung.DKK);
		assertTrue(konto1.getAktuelleWaehrung() == Waehrung.DKK);
	}
	
	/**
	 * testet, ob ein waehrungswechsel funktioniert
	 */
	@Test
	void waehrungswechselTest() {
		assertEquals(Waehrung.EUR, konto1.getAktuelleWaehrung());
		konto1.waehrungswechsel(Waehrung.BGN);
		assertEquals(Waehrung.BGN, konto1.getAktuelleWaehrung());
	}
	

	
	/**
	 * public boolean abheben(double betrag, Waehrung w) throws GesperrtException
	 * public void einzahlen(double betrag, Waehrung w)
	 * public Waehrung getAktuelleWaehrung()
	 * public void waehrungswechsel(Waehrung neu)
	 */
}
