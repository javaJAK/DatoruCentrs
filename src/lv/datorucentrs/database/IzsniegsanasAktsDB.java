package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Persona;

public class IzsniegsanasAktsDB {
	public PreparedStatement ps;
	//insert
	public boolean insertIzsniegsanasAkts(String izsniedzejs, String remontaAkts, 
			String sanemsanasAdrese, String apmaksasTermins, String piegade) throws SQLException {
		boolean insertOK = false;
		
		String sql = "INSERT INTO izsniegsanasAkti(izsniedzejs, remontaAkts, sanemsanasAdrese, apmaksasTermins, piegade)"
				+ " VALUES(?, ?, ?, ?, ?)";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniedzejs);
		ps.setString(2, remontaAkts);
		ps.setString(3, sanemsanasAdrese);
		ps.setString(4, apmaksasTermins);
		ps.setString(5, piegade);
		ps.executeUpdate();
		return insertOK = true;
	}
	//update
	public boolean updateIzsniegsanasAkts(String izsniedzejs, String remontaAkts, 
			String sanemsanasAdrese, String apmaksasTermins, String piegade) throws SQLException {
		boolean updateOK = false;
		
		String sql = "UPDATE izsniegsanasAkti SET izsniedzejs = ?, remontaAkts = ?, "
				+ "sanemsanasAdrese = ?, apmaksasTermins = ?, piegade = ? "
				+ "WHERE izsniedzejs = ?, remontaAkts = ?, "
				+ "sanemsanasAdrese = ?, apmaksasTermins = ?, piegade = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniedzejs);
		ps.setString(2, remontaAkts);
		ps.setString(3, sanemsanasAdrese);
		ps.setString(4, apmaksasTermins);
		ps.setString(5, piegade);
		ps.executeUpdate();
		return updateOK = true;
	}
	//delete
	public boolean deleteRemontaAkts(String izsniedzejs, String remontaAkts, 
		 String sanemsanasAdrese, String apmaksasTermins, String piegade) throws SQLException {
		boolean deleteOK = false;

		String sql = "DELETE FROM izsniegsanasAkti WHERE izsniedzejs = ?, remontaAkts = ?,"
				+ " sanemsanasAdrese = ?, apmaksasTermins = ?, piegade = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniedzejs);
		ps.setString(2, remontaAkts);
		ps.setString(3, sanemsanasAdrese);
		ps.setString(4, apmaksasTermins);
		ps.setString(5, piegade);
		ps.executeUpdate();
		deleteOK = true;

		return deleteOK;
	}
	//select
	public IzsniegsanasAktsDB getIzsniegsanasAkts(String sanemsanasAdrese, String apmaksasTermins, String veids, String remontaAkts, String izsniedzejs) throws SQLException {
		int piegadeID = -1;
		int personaID = -1;
		int remontaAktsID = -1;
		
		IzsniegsanasAktsDB izsniegsanasAkts = new IzsniegsanasAktsDB();
		PersonaDB personaDB = new PersonaDB();
		PiegadeDB piegadeDB = new PiegadeDB();
		RemontaAktsDB remontaAktsDB = new RemontaAktsDB();

		piegadeID = piegadeID.getPiegadeID(veids);
		personaID = personaID.getPersonaID(izsniedzejs);
		remontaAktsID = remontaAktsID.getRemontaAktsID(remontaAkts);
		if (piegadeID != -1 && personaID != -1 && remontaAktsID != -1) {
			String sql = "SELECT i.sanemsanasAdrese, i.apmaksasTermins, pi.veids, r.remontaAkts, p.vards, p.uzvards"
					+ "FROM personas p, piegades pi, remontaAkti r, izsniegsanasAkti i"
					+ "WHERE i.piegade id = pi.id, i.izsniedzejs id = p.id, i.remontaAkts id = r.id "
					+ "AND i.piegade id = ? AND i.izsniedzejs id = ? AND i.remontaAkts id = ? "
					+ "AND i.sanemsanasAdrese = ? AND i.apmaksasTermins = ?;";

			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, personaID);
			ps.setInt(2, remontaAktsID);
			ps.setString(3, sanemsanasAdrese);
			ps.setString(4, apmaksasTermins);
			ps.setInt(5, piegadeID);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				izsniegsanasAkts.setPersonaID(personaDB.getPersonaByID(1));
				izsniegsanasAkts.setRemontaAktsID(remontaAktsDB.getRemontaAktsByID(2));
				izsniegsanasAkts.setSanemsanasAdrese(rs.getString(3));
				izsniegsanasAkts.setApmaksasTermins(rs.getString(4));
				izsniegsanasAkts.setPiegadeID(piegadeDB.getPiegadeByID(5));

			}
		}
		return izsniegsanasAkts;
	}
}
