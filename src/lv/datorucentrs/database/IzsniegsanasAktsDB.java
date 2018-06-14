package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.IzsniegsanasAkts;
import lv.datorucentrs.dati.Persona;

public class IzsniegsanasAktsDB {
	public PreparedStatement ps;
	//insert
	public boolean insertIzsniegsanasAkts(String iVards, String iUzvards, String sanemsanasAdrese, 
			String apmaksasTermins, String piegade) throws SQLException {
		boolean insertOK = false;
		
		int izsniedzejsID = -1, piegadeID = -1;
		
		PersonaDB personaDB = new PersonaDB();
		PiegadeDB piegadeDB = new PiegadeDB();
		
		izsniedzejsID = personaDB.getPersonaID(iVards, iUzvards);
		piegadeID = piegadeDB.getPiegadeID(piegade);

		if(izsniedzejsID != -1 && piegadeID != -1) {
			String sql = "INSERT INTO izsniegsanas_akti(izsniedzejs_id, sanemsanas_adrese, apmaksas_termins, piegade_id)"
					+ " VALUES(?, ?, ?, ?)";
			
			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, izsniedzejsID);
			ps.setString(2, sanemsanasAdrese);
			ps.setString(3, apmaksasTermins);
			ps.setInt(4, piegadeID);
			ps.executeUpdate();
			insertOK = true;
		}
		
		return insertOK;
	}
	//update
	public boolean updateIzsniegsanasAkts(String iVards, String iUzvards, String sanemsanasAdrese, 
			String apmaksasTermins, String piegade, String iVardsJauns, String iUzvardsJauns, 
			String sanemsanasAdreseJauns, String apmaksasTerminsJauns, String piegadeJauns) throws SQLException {
		boolean updateOK = false;

		int izsniedzejsID = -1, piegadeID = -1, jaunsIzsniedzejsID = -1, jaunaPiegadeID = -1;
		
		PersonaDB personaDB = new PersonaDB();
		PiegadeDB piegadeDB = new PiegadeDB();
		
		izsniedzejsID = personaDB.getPersonaID(iVards, iUzvards);
		piegadeID = piegadeDB.getPiegadeID(piegade);
		jaunsIzsniedzejsID = personaDB.getPersonaID(iVardsJauns, iUzvardsJauns);
		jaunaPiegadeID = piegadeDB.getPiegadeID(piegadeJauns);

		if(izsniedzejsID != -1 && piegadeID != -1 && jaunsIzsniedzejsID != -1 && jaunaPiegadeID != -1) {
			String sql = "UPDATE izsniegsanas_akti SET izsniedzejs_id = ?, "
					+ "sanemsanas_adrese = ?, apmaksas_termins = ?, piegade_id = ? "
					+ "WHERE izsniedzejs_id = ?, sanemsanas_adrese = ?, "
					+ "apmaksas_termins = ?, piegade_id = ?";
			
			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, izsniedzejsID);
			ps.setString(2, sanemsanasAdrese);
			ps.setString(3, apmaksasTermins);
			ps.setInt(4, piegadeID);
			ps.setInt(5, jaunsIzsniedzejsID);
			ps.setString(6, sanemsanasAdrese);
			ps.setString(7, apmaksasTermins);
			ps.setInt(8, jaunaPiegadeID);
			ps.executeUpdate();
			updateOK = true;
		}
		return updateOK;
	}
	//delete
	public boolean deleteRemontaAkts(String iVards, String iUzvards, String sanemsanasAdrese, 
			String apmaksasTermins, String piegade) throws SQLException {
		boolean deleteOK = false;
		int izsniedzejsID = -1, piegadeID = -1;
		
		PersonaDB personaDB = new PersonaDB();
		PiegadeDB piegadeDB = new PiegadeDB();
		
		izsniedzejsID = personaDB.getPersonaID(iVards, iUzvards);
		piegadeID = piegadeDB.getPiegadeID(piegade);

		if(izsniedzejsID != -1 && piegadeID != -1) {
			String sql = "DELETE FROM izsniegsanas_akti WHERE izsniedzejs_id = ? AND"
					+ " sanemsanasAdrese = ? AND apmaksasTermins = ? AND piegade_id = ?";
			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, izsniedzejsID);
			ps.setString(3, sanemsanasAdrese);
			ps.setString(4, apmaksasTermins);
			ps.setInt(5, piegadeID);
			ps.executeUpdate();
			deleteOK = true;
		}
		return deleteOK;
	}
	//select
	public IzsniegsanasAkts getIzsniegsanasAkts(String sanemsanasAdrese, String apmaksasTermins, 
			String veids, String iVards, String iUzvards) throws SQLException {
		int piegadeID = -1;
		int personaID = -1;
		
		IzsniegsanasAkts izsniegsanasAkts = new IzsniegsanasAkts();
		PersonaDB personaDB = new PersonaDB();
		PiegadeDB piegadeDB = new PiegadeDB();

		piegadeID = piegadeDB.getPiegadeID(veids);
		personaID = personaDB.getPersonaID(iVards, iUzvards);
		
		if (piegadeID != -1 && personaID != -1) {
			String sql = "SELECT sanemsanasAdrese, apmaksasTermins, piegades_veids_id, izsniedzejs_id "
					+ "FROM piegades "
					+ "WHERE piegade_id = ? AND izsniedzejs id = ? "
					+ "AND sanemsanasAdrese = ? AND apmaksasTermins = ?;";

			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, personaID);
			ps.setString(3, sanemsanasAdrese);
			ps.setString(4, apmaksasTermins);
			ps.setInt(5, piegadeID);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				izsniegsanasAkts.setIzsniedzejs(personaDB.getPersonaByID(rs.getInt(4)));
				izsniegsanasAkts.setSanemsanasAdrese(rs.getString(1));
				izsniegsanasAkts.setApmaksasTermins(rs.getString(2));
				izsniegsanasAkts.setPiegade(piegadeDB.getPiegadeByID(3));
			}
		}
		return izsniegsanasAkts;
	}
}
