package lv.datorucentrs.dati;

public class RemontaAkts {
	public int ID;
	public String problema;
	public String serialaisNumurs;
	public String piezime;
	public String transports;
	public String darbaIlgums;
	public String darbaApraksts;
	public String datums;
	public Datortehnika datortehnika;
	public DarbaVeids darbaveids;
	public Persona klients, tehnikis;

	public RemontaAkts() {

	}

	public RemontaAkts(String problema, String serialaisNumurs, String piezime, String transports, String darbaIlgums,
			String darbaApraksts, String datums, Datortehnika datortehnika, DarbaVeids darbaveids, Persona klients,
			Persona tehnikis) {
		setProblema(problema);
		setSerialaisNumurs(serialaisNumurs);
		setPiezimes(piezime);
		setTransports(transports);
		setDarbaIlgums(darbaIlgums);
		setDarbaApraksts(darbaApraksts);
		setDatums(datums);
		setDatortehnika(datortehnika);
		setDarbaveids(darbaveids);
		setKlients(klients);
		setTehnikis(tehnikis);
	}

	public Persona getKlients() {
		return klients;
	}

	public void setKlients(Persona klients) {
		this.klients = klients;
	}

	public Persona getTehnikis() {
		return tehnikis;
	}

	public void setTehnikis(Persona tehnikis) {
		this.tehnikis = tehnikis;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getSerialaisNumurs() {
		return serialaisNumurs;
	}

	public void setSerialaisNumurs(String serialaisNumurs) {
		this.serialaisNumurs = serialaisNumurs;
	}

	public String getPiezime() {
		return piezime;
	}

	public void setPiezimes(String piezime) {
		this.piezime = piezime;
	}

	public String getTransports() {
		return transports;
	}

	public void setTransports(String transports) {
		this.transports = transports;
	}

	public String getDarbaIlgums() {
		return darbaIlgums;
	}

	public void setDarbaIlgums(String darbaIlgums) {
		this.darbaIlgums = darbaIlgums;
	}

	public String getDarbaApraksts() {
		return darbaApraksts;
	}

	public void setDarbaApraksts(String darbaApraksts) {
		this.darbaApraksts = darbaApraksts;
	}

	public String getDatums() {
		return datums;
	}

	public void setDatums(String datums) {
		this.datums = datums;
	}

	public Datortehnika getDatortehnika() {
		return datortehnika;
	}

	public void setDatortehnika(Datortehnika datortehnika) {
		this.datortehnika = datortehnika;
	}

	public DarbaVeids getDarbaveids() {
		return darbaveids;
	}

	public void setDarbaveids(DarbaVeids darbaveids) {
		this.darbaveids = darbaveids;
	}
}
