package lv.datorucentrs.dati;

public class IzsniegsanasAkts {


		public int ID;
		public Persona izsniedzejs;
		public String sanemsanasAdrese;
		public String apmaksasTermins; 					
		public Piegade piegade;
		
		public IzsniegsanasAkts() {}
		
		public IzsniegsanasAkts(Persona izsniedzejs, String sanemsanas_adrese, String apmaksas_termins, Piegade piegade) {
			
		setIzsniedzejs(izsniedzejs);
		setSanemsanasAdrese(sanemsanas_adrese);
		setApmaksasTermins(apmaksas_termins);
		setPiegade(piegade);
		
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public Persona getIzsniedzejs() {
			return izsniedzejs;
		}

		public void setIzsniedzejs(Persona izsniedzejs) {
			this.izsniedzejs = izsniedzejs;
		}

		public String getSanemsanasAdrese() {
			return sanemsanasAdrese;
		}

		public void setSanemsanasAdrese(String sanemsanasAdrese) {
			this.sanemsanasAdrese = sanemsanasAdrese;
		}

		public String getApmaksasTermins() {
			return apmaksasTermins;
		}

		public void setApmaksasTermins(String apmaksasTermins) {
			this.apmaksasTermins = apmaksasTermins;
		}

		public Piegade getPiegade() {
			return piegade;
		}

		public void setPiegade(Piegade piegade) {
			this.piegade = piegade;
		}
	}