/*
 * 
 * 
 * 
 */

/**
 * Beinhaltet Bankprojekt Methoden.
 * @author timoj
 *
 */

import java.text.*;
public class Playground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		DecimalFormat df = new DecimalFormat("#.##");
		double res = 234.123 / 32.1224;
		System.out.println((res * 100) / 100.00);
		double res2 = Double.parseDouble(df.format(res));
		System.out.println(res2);
	}

}
