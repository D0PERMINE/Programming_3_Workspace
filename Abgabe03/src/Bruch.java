/**
 * Die Klasse Bruch stellt einen mathematischen Bruch dar.
 */
public class Bruch implements Comparable<Bruch> {

    /**
     * Speichert den Zähler des Bruchs
     */
    private int zaehler;

    /**
     * Speichert den Nenner des Bruchs
     */
    private int nenner;
    
    /**
     * Standardkonstruktor zum expliziten Setzen von Zähler und Nenner
     */
    public Bruch()
    {
    }

    /**
	 * @param zaehler the zaehler to set
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	/**
	 * @param nenner the nenner to set
	 * @throws ArithmeticException, wenn der nenner 0 ist
	 */
	public void setNenner(int nenner) {
		prufeGueltigenNenner(nenner);
		this.nenner = nenner;
	}

    /**
     * Getter für zaehler
     * @return Wert von zaehler
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     * Getter für nenner
     * @return Wert von nenner
     */
    public int getNenner() {
        return nenner;
    }

	/**
     * Konstruktor der Klasse, bekommt den Nenner und ZÃ¤hler Ã¼begeben und bringt diese in
     * die Normalform bei der das negative Vorzeichen vor dem ZÃ¤hler steht bzw. negative Vorzeichen vor Nenner und ZÃ¤hler sich aufheben.
     * @param zaehler ZÃ¤hler der gesetzt werden soll
     * @param nenner Nenner der gesetzt werden soll, darf nicht 0 sein
     * @throws ArithmeticException, wenn der nenner 0 ist
     */
    public Bruch(int zaehler, int nenner){
        prufeGueltigenNenner(nenner);
        if((zaehler < 0 && nenner < 0) || (zaehler >=0 && nenner <0)){
            this.zaehler = zaehler * -1;
            this.nenner = nenner * -1;
        }else{
            this.zaehler = zaehler;
            this.nenner = nenner;
        }
    }
    
    public int berechnen()
    {
    	return ggt(this.zaehler, this.nenner);
    }

    /**
     * Multipliziert den Bruch this mit dem Ã¼bergebenen Bruch b und gibt das Ergebtnis als Bruch zurÃ¼ck.
     * @param b Bruch mit dem multipliziert werden soll
     * @return Ergebnis der Multiplikation als Bruch
     * @throws NullPointerException, wenn b == null
     */
    public Bruch multiplizieren(Bruch b){
        this.zaehler = this.zaehler * b.zaehler;
        this.nenner = this.nenner * b.nenner;
        return this;
    }

    /**
     * Berechnet den Gleitkommawert des Bruchs
     * @return Wert des Bruchs als Gleitkommazahl (double)
     */
    public double ausrechnen(){
        return (double) getZaehler() / getNenner();
    }

    /**
     * KÃ¼rzt den aufrufenden Bruch
     */
    public void kuerzen(){
        int ggt = ggt(this.zaehler, this.nenner);
        this.zaehler /= ggt;
        this.nenner /= ggt;
    }

    /**
     * Berechnet den Kehrwert des aufrufenden Bruchs und gibt diesen zurÃ¼ck
     * @return Kehrwert vom Typ Bruch
     * @throws ArithmeticException, wenn der Zähler von this 0 ist
     */
    public Bruch kehrwert(){
        int temp;
        temp = this.nenner;
        this.nenner = this.zaehler;
        this.zaehler = temp;
        return this;
    }

    /**
     * Dividiert den aufrufenden Bruch durch den Ã¼bergebenen Bruch b
     * @param b Bruch durch den dividiert werden soll
     * @return Ergebnis der Division als Bruch
     * @throws ArithmeticException, wenn b = 0 ist
     * @throws NullPointerException, wenn b == null ist
     */
    public Bruch dividieren(Bruch b){
        return multiplizieren(b.kehrwert());
    }

    @Override
    public String toString(){
        return zaehler + "/" + nenner;
    }

    @Override
    public int compareTo(Bruch b) {
        return Double.compare(this.ausrechnen(), b.ausrechnen());
    }

    /**
     * Ãœberpruft ob der Ã¼bergebene Wert gleich null ist und wirf falls ja eine Exception
     * @param nenner Wert der Ã¼berprÃ¼ft werden soll
     * @throws ArithmeticException, wenn der übergebene Nenner 0 ist
     */
    private static void prufeGueltigenNenner(int nenner){
        if (nenner == 0)
            throw new ArithmeticException("Nenner darf nicht 0 sein");
    }

    /**
     * Berechnet den grÃ¶ÃŸten gemeinsamen Teil von zwei Werten
     * @param zaehler 1.Wert
     * @param nenner 2.Wert
     * @return ggT als Integer
     * 	0, falls Zähler und Nenner = 0 sind, sollte aber beim Aufruf vermieden werden
     */
    private static int ggt(int zaehler, int nenner){
        int z = zaehler>0?zaehler:-zaehler;
        int n = nenner>0?nenner:-nenner;
        if(z == 0)
        	return n;
        while(n != 0)
        	if(z > n)
        		z = z - n;
        	else
        		n = n - z;
        return z;
    }
}
