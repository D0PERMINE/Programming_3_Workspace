/**
 * Stellt den Monat eines Jahres dar.
 * @author timoj
 *
 */
public enum Monate {
//	JANUAR(31), FEBRUAR(28), MAERZ(31), APRIL(30), MAI(31), JUNI(30), 
//    JULI(31), AUGUST(31),SEPTEMBER(30), OKTOBER(31), NOVEMBER(30), DEZEMBER(31);
//    
//    private int groessterErlaubterTag;
//    
//    Monat(int groesster)
//    {
//        this.groessterErlaubterTag = groesster;
//    }
    
	JANUAR, FEBRUAR, MAERZ, APRIL, MAI, JUNI, JULI, AUGUST, SEPTEMBER, OKTOBER, NOVEMBER, DEZEMBER;
	
	private int groessterErlaubterTag;
	
	/**
	 * statischer Block mit den groessten erlaubten Tag den einzelnen Monaten zugewiesen
	 */
	static {
		JANUAR.groessterErlaubterTag = 31;
		FEBRUAR.groessterErlaubterTag = 28;
		MAERZ.groessterErlaubterTag = 31;
		APRIL.groessterErlaubterTag = 30;
		MAI.groessterErlaubterTag = 31;
		JUNI.groessterErlaubterTag = 30;
		JULI.groessterErlaubterTag = 31;
		AUGUST.groessterErlaubterTag = 31;
		SEPTEMBER.groessterErlaubterTag = 30;
		OKTOBER.groessterErlaubterTag = 31;
		NOVEMBER.groessterErlaubterTag = 30;
		DEZEMBER.groessterErlaubterTag = 31;
	}
	
	/**
	 * Prueft ob ein Monat diesen Tag hat.
	 * @param tag
	 * @return Gibt true zurueck, falls es den Tag gibt, sonst false
	 */
	public boolean gibtEsDiesenTagImMonat(int tag) {
//		if(tag == 31) {
//			return true;
//		} 
//		else if(tag == 30) {
//			return true;
//		}
//		else if(tag == 28) {
//			return true;
//		}
		return 0 < tag && tag <= this.groessterErlaubterTag;
		
//		return 0 < tag && tag <= this.groessterErlaubterTag;
	}
}
