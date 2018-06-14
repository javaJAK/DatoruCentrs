package lv.datorucentrs.dati;

public class RemontaAkts {
	public int ID;
	public String problema;
	public String serialaisNumurs;
	public String piezime;
	public double transports;
	public double darbaIlgums;
	public String darbaApraksts;
	public String datums;
	public Datortehnika datortehnika;
	public DarbaVeids darbaVeids;
	public Persona klients, tehnikis;
	public IzsniegsanasAkts izsniegsanasAkts;
	public double samaksa;

	public RemontaAkts() {

	}

	public RemontaAkts(String problema, String serialaisNumurs, String piezime, double transports, double darbaIlgums,
			String darbaApraksts, String datums, Datortehnika datortehnika, DarbaVeids darbaVeids, Persona klients,
			Persona tehnikis, IzsniegsanasAkts akts, double samaksa) {
		setProblema(problema);
		setSerialaisNumurs(serialaisNumurs);
		setPiezimes(piezime);
		setTransports(transports);
		setDarbaIlgums(darbaIlgums);
		setDarbaApraksts(darbaApraksts);
		setDatums(datums);
		setDatortehnika(datortehnika);
		setDarbaVeids(darbaVeids);
		setKlients(klients);
		setTehnikis(tehnikis);
		setIzsniegsanasAkts(akts);
		setSamaksa(samaksa);
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

	public double getTransports() {
		return transports;
	}

	public void setTransports(double transports) {
		this.transports = transports;
	}

	public double getDarbaIlgums() {
		return darbaIlgums;
	}

	public void setDarbaIlgums(double darbaIlgums) {
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

	public DarbaVeids getDarbaVeids() {
		return darbaVeids;
	}

	public void setDarbaVeids(DarbaVeids darbaveids) {
		this.darbaVeids = darbaveids;
	}

	public void setPiezime(String piezime) {
		this.piezime = piezime;
	}

	public IzsniegsanasAkts getIzsniegsanasAkts() {
		return izsniegsanasAkts;
	}

	public void setIzsniegsanasAkts(IzsniegsanasAkts izsniegsanasAkts) {
		this.izsniegsanasAkts = izsniegsanasAkts;
	}

	public double getSamaksa() {
		return samaksa;
	}

	public void setSamaksa(double samaksa) {
		this.samaksa = samaksa;
	}
}