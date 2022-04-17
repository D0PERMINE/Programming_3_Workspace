import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class okkk {

	/**
	 * In der Methoden werden 2 Zahlen vom Benutzen abgefragt und dividiert. Das Ergebnis wird auf der Konsole zurueckgegeben.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Git!");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers to divide them:");
		System.lineSeparator();
		System.out.println("First number: ");
		BigDecimal a = sc.nextBigDecimal();
		System.out.println("Second number: ");
		BigDecimal b = sc.nextBigDecimal();
//		int a;
//		int b;
		BigDecimal c;
		
//		a = 55;
//		b = 5;
		c = a.divide(b, 0, RoundingMode.HALF_UP);
		System.out.println("c = " + c);
		System.out.println("OMG it worked!!!");
		System.out.println("OMG it worked2!!!");
		System.out.println("HOLY MOLYYYYY LETS GOOOO3");
		int d = 12;
		System.out.println("LOL im: " + d);
	}

}
