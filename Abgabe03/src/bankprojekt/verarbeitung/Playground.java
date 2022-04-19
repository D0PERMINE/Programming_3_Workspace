/**
 * 
 * Datum: 18.04.2022
 * Programmierung 3 - Uebung 02
 * Dozent: Dorothea Hubrich
 * 
 * Name: Timo Ji
 * Matrikel-Nummer: 575725
 * 
 * Anmerkungen: 
 * Ohne Partner gemacht.
 * 
 * Waehrungswechsel von nicht Euro zu Euro funktioniert nicht?!?! (siehe die letzten drei Zeilen und entsprechender 
 * Konsolen Output)
 * 
 */

package bankprojekt.verarbeitung;

import java.time.*;

/**
 * Testen von Bankprojekt Methoden.
 * @author timoj
 *
 */
public class Playground {

	public static void main(String[] args) throws GesperrtException {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
//		System.out.println(234.123 / 32.1224);
		
		Kunde kunde1 = new Kunde("Timo", "Ji", "Storkower Strasse 219", LocalDate.of(1996, 7, 31));
		System.out.println(kunde1.toString());
		
		Sparbuch konto1 = new Sparbuch(kunde1, 12345678, Waehrung.EUR);
		System.out.println(konto1.toString());
//		konto1.waehrungswechsel(Waehrung.BGN);
//		konto1.einzahlen(25000, Waehrung.BGN);
		konto1.einzahlen(61.62, Waehrung.MKD);
		System.out.println(konto1.toString());
//		System.out.println(konto1.getKontostandFormatiert());
		konto1.einzahlen(10, Waehrung.EUR);
		System.out.println(konto1.toString());
		konto1.abheben(61.62 * 3, Waehrung.MKD);
		System.out.println("Aktuelle Waehrung: " + konto1.getAktuelleWaehrung());
		System.out.println(konto1.toString());
		konto1.abheben(7.4604 * 2, Waehrung.DKK);
		System.out.println(konto1.toString());
		konto1.einzahlen(7.4604 * 4, Waehrung.DKK);
		System.out.println(konto1.toString());
		konto1.waehrungswechsel(Waehrung.DKK);	// BGN.zuEuroUmrechnungskurs = 1.9558;
		System.out.println(konto1.toString());
		System.out.println("Aktuelle Waehrung: " + konto1.getAktuelleWaehrung());
		
		konto1.waehrungswechsel(Waehrung.EUR);
		System.out.println(konto1.toString());
		System.out.println("Aktuelle Waehrung: " + konto1.getAktuelleWaehrung());
	}

}
