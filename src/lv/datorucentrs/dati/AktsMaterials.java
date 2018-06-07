package lv.datorucentrs.dati;

public class AktsMaterials {
	int ID;
	public IzsniegsanasAkts izsniegsanasAkts; // tabulâ: izsniegsanas_akts_id;
	public RemontsMaterials remontsMaterials; // tabulâ: menonts_materials_id;
	public int daudzums;

	public AktsMaterials() {}

	public AktsMaterials(IzsniegsanasAkts izsniegsanasAkts, RemontsMaterials remontsMaterials, int daudzums) {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public IzsniegsanasAkts getIzsniegsanasAkts() {
		return izsniegsanasAkts;
	}

	public void setIzsniegsanasAkts(IzsniegsanasAkts izsniegsanasAkts) {
		this.izsniegsanasAkts = izsniegsanasAkts;
	}

	public RemontsMaterials getRemontsMaterials() {
		return remontsMaterials;
	}

	public void setRemontsMaterials(RemontsMaterials remontsMaterials) {
		this.remontsMaterials = remontsMaterials;
	}

	public int getDaudzums() {
		return daudzums;
	}

	public void setDaudzums(int daudzums) {
		this.daudzums = daudzums;
	}
}
