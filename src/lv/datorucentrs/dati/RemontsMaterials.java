package lv.datorucentrs.dati;

public class RemontsMaterials {
	public int ID;
	public String materials_id;
	public String remonta_akts_id;
	public int daudzums;

	public RemontsMaterials() {

	}

	public RemontsMaterials(String materials_id, String remonta_akts_id, int daudzums) {
		setMaterials_id(materials_id);
		setRemonta_akts_id(remonta_akts_id);
		setDaudzums(daudzums);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaterials_id() {
		return materials_id;
	}

	public void setMaterials_id(String materials_id) {
		this.materials_id = materials_id;
	}

	public String getRemonta_akts_id() {
		return remonta_akts_id;
	}

	public void setRemonta_akts_id(String remonta_akts_id) {
		this.remonta_akts_id = remonta_akts_id;
	}

	public int getDaudzums() {
		return daudzums;
	}

	public void setDaudzums(int daudzums) {
		this.daudzums = daudzums;
	}

}
