import java.time.LocalDate;

public class Kind extends Person implements Frech{

	public boolean wachsen;
	protected boolean hatKuscheltier;
	public Kind() {
		super();
		wachsen = false;
		hatKuscheltier = false;
	}
	
	public Kind(LocalDate geburtstag, int alter, String name, boolean wachsen, boolean hatKuscheltier) {
		super();
		this.wachsen = wachsen;
		this.hatKuscheltier = hatKuscheltier;
	}

	@Override
	public boolean aergern(Person p) {
		return false;
	}

	@Override
	public void zungeRausstrecken() {
		
	}
}
