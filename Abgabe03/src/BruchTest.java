import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BruchTest {
	
	Bruch a;
	Bruch b;
	Bruch c;

	@Test
	void konstruktorUndGetMethodenTest() {
		a = new Bruch(1, 2);
		assertEquals(1, a.getZaehler());
		assertEquals(2, a.getNenner());
		assertEquals("1/2", a.toString());
	}
	
/*	@Test
	void berechnenTest() {
		a = new Bruch(1,2);
		int ergebnis;
		ergebnis = a.berechnen();
		
	}
*/
	
	@Test
	void ausrechnenTest() {
		a = new Bruch(1,2);
		double ergebnis;
		ergebnis = a.ausrechnen();
		assertEquals(0.5, ergebnis);
	}
	
	@Test
	void kuerzenTest()
	{
		a = new Bruch(2,4);
		a.kuerzen();
		assertEquals(1, a.getZaehler());
		assertEquals(2, a.getNenner());
		
		a = new Bruch(2,3);
		a.kuerzen();
		assertEquals(2, a.getZaehler());
		assertEquals(3, a.getNenner());
		
		a = new Bruch(2,-4);
		a.kuerzen();
		assertEquals(-1, a.getZaehler());
		assertEquals(2, a.getNenner());
	}
	
	@Test
	void multiplizierenTest()
	{
		a = new Bruch(1,2);
		b = new Bruch(3,4);
		c = a.multiplizieren(b);
		assertEquals(3, c.getZaehler());
		assertEquals(8, c.getNenner());
		
		c = c.multiplizieren(a);
		assertEquals(3, c.getZaehler());
		assertEquals(16, c.getNenner());
		
	}
	
	@Test
	void standardkonstruktorTest()
	{
		a = new Bruch();
		assertNotEquals(0, a.getNenner());
	}
	
	@Test
	void dividierenTest()
	{
		a = new Bruch(1,2);
		b = new Bruch(3,5);
		c = a.dividieren(b);
		assertEquals(5, c.getZaehler());
		assertEquals(6, a.getNenner());
	}
	

}
