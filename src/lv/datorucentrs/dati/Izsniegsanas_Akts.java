package lv.datorucentrs.dati;

public class Izsniegsanas_Akts {


		public int ID;
		public Persona izsniedzejs;
		public String sanemsanas_adrese;
		public String apmaksas_termins; 					
		public Piegade piegade;
		
		public Izsniegsanas_Akts() {}
		
		public Izsniegsanas_Akts(Persona izsniedzejs, String sanemsanas_adrese, String apmaksas_termins, Piegade piegade) {
			
		setIzsniedzejs(izsniedzejs);
		setSanemsanas_adrese(sanemsanas_adrese);
		setApmaksas_termins(apmaksas_termins);
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

		public String getSanemsanas_adrese() {
			return sanemsanas_adrese;
		}

		public void setSanemsanas_adrese(String sanemsanas_adrese) {
			this.sanemsanas_adrese = sanemsanas_adrese;
		}

		public String getApmaksas_termins() {
			return apmaksas_termins;
		}

		public void setApmaksas_termins(String apmaksas_termins) {
			this.apmaksas_termins = apmaksas_termins;
		}

		public Piegade getPiegade() {
			return piegade;
		}

		public void setPiegade(Piegade piegade) {
			this.piegade = piegade;
		}
	}

			
	


