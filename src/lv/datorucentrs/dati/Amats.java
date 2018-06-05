package lv.datorucentrs.dati;

public class Amats {

	public int ID;
	public String nosaukums;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNosaukums() {
		return nosaukums;
	}

	public void setNosaukums(String nosaukums) {
		this.nosaukums = nosaukums;
	}
	
	public Amats() {}
	
	public Amats(String nosaukums) {	
		setNosaukums(nosaukums);
	}
}