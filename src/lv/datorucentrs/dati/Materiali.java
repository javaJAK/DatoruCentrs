package lv.datorucentrs.dati;

public class Materiali {
	public int id;
	public int cena;
	public String nosaukums;
	public int daudzums;
	
	public Materiali() {
		
	}
	public Materiali(String nosaukums) {
		setNosaukums(nosaukums);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNosaukums() {
		return nosaukums;
	}
	public void setNosaukums(String nosaukums) {
		this.nosaukums = nosaukums;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getDaudzums() {
		return daudzums;
	}
	public void setDaudzums(int daudzums) {
		this.daudzums = daudzums;
	}
	
}
