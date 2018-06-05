package lv.datorucentrs.dati;

public class Persona {

	public int ID;
	public String vards;
	public String uzvards;
	public String talrunis;
	public Amats amats;
	
	public Persona() {}
	
	public Persona(String vards, String uzvards, String talrunis, Amats amats) {
		
		setVards(vards);
		setUzvards(uzvards);
		setTalrunis(talrunis);
		setAmats(amats);
		
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getVards() {
		return vards;
	}

	public void setVards(String vards) {
		this.vards = vards;
	}

	public String getUzvards() {
		return uzvards;
	}

	public void setUzvards(String uzvards) {
		this.uzvards = uzvards;
	}

	public String getTalrunis() {
		return talrunis;
	}

	public void setTalrunis(String talrunis) {
		this.talrunis = talrunis;
	}

	public Amats getAmats() {
		return amats;
	}

	public void setAmats(Amats amats) {
		this.amats = amats;
	}
	
	// RemontaAktsDB

	
	
	
	

}
