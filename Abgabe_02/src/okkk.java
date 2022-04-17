import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class okkk {

	/**
	 * In der Methoden werden 2 Zahlen vom Benutzen abgefragt und dividiert. Das Ergebnis wird auf der Konsole zurueckgegeben.
	 * @param args
	 */
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		System.out.println("Hello Git!");
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter two numbers to divide them:");
//		System.lineSeparator();
//		System.out.println("First number: ");
//		BigDecimal a = sc.nextBigDecimal();
//		System.out.println("Second number: ");
//		BigDecimal b = sc.nextBigDecimal();
////		int a;
////		int b;
//		BigDecimal c;
//		
////		a = 55;
////		b = 5;
//		c = a.divide(b, 0, RoundingMode.HALF_UP);
//		System.out.println("c = " + c);
//		System.out.println("OMG it worked!!!");
//		System.out.println("OMG it worked2!!!");
//		System.out.println("HOLY MOLYYYYY LETS GOOOO3");
//		int d = 12;
//		System.out.println("LOL im: " + d);
		
		System.out.println("ENUMSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		
		System.out.println("Enter a day: ");
		int tag = sc.nextInt();
		System.out.println("Enter a month: ");
		int monat = sc.nextInt();
		if(monat < 0 || monat > 12) {
			System.out.println("Out of bounds!");
			throw new ArrayIndexOutOfBoundsException();
		}
		
//		Monate[] monatArr = Monate.values();
		
		System.out.println(Monate.values()[monat - 1].gibtEsDiesenTagImMonat(tag));
		
		
//		Nun ja, hier wird nicht geprüft, ob es den Monat auch gibt. Wenn man z.B. 13 eingibt, bricht das Programm mit einer ArrayIndexOutOfBoundsException ab. 
//		Aber das können Sie mit Sicherheit selber reparieren...
//
//		Mögliche Erweiterungen/Verbesserungen/Aufhübschungen:
//
//		Man könnte das Holen des Monat-Objektes zu einer Zahl in einer statischen Methode in Monat unterbringen:
//		public static Monat get(int monatAlsZahl)
//		
//		Man könnte die toString()-Methode überschreiben, damit sie die Monatsnamen nicht in Großbuchstaben, 
//		sondern nur mit großem Anfangsbuchstaben zurückliefert. Entweder gibt man jeder Konstante dazu ein weiteres Attribut String ausgabename 
//		mit der gleichen Technik wie eben oder man verwendet String-Methoden, um den Wert von name() umzuwandeln.
	}

}
