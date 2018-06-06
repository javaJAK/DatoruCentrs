package lv.datorucentrs.dati;

public class Piegade {
	
	public int ID;
	public String veids;
	
	public Piegade() {}

	public Piegade(String veids) {
		
		setVards(veids);
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getVeids() {
		return veids;
	}

	public void setVards(String veids) {
		this.veids = veids;
}
}
