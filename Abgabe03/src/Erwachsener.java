import java.time.LocalDate;

public class Erwachsener extends Person {

	public static final String WUTSCHREI = "HEYYY!";
	private boolean hatKind;
	public Erwachsener() {
		super();
		hatKind = false;
	}
	
	public Erwachsener(LocalDate geburtstag, int alter, String name, boolean hatKind) {
		super();
		this.hatKind = hatKind;
	}
}
