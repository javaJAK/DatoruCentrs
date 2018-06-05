package lv.datorucentrs.dati;

public class DarbaVeids {
	public int ID;
	public String nosaukums;

	public DarbaVeids() {
	}

	public DarbaVeids(String nosaukums) {
		setNosaukums(nosaukums);
	}

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

}
