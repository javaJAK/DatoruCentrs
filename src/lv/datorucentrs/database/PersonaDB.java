package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Amats;
import lv.datorucentrs.dati.Persona;

public class PersonaDB {
	public PreparedStatement ps;

	// insert komanda

	// update komanda

	// delete komanda

	// select komanda
	// Atrast PERSONU pçc vârda, uzvârds un amata
	public Persona getPersona(String vards, String uzvards, String nosaukums) throws SQLException {
		int amatsID = -1;

		Persona persona = new Persona();
		AmatsDB amatsDB = new AmatsDB();

		amatsID = amatsDB.getAmatsID(nosaukums);
		if (amatsID != -1) {
			String sql = "SELECT p.vards, p.uzvards, p.talrunis, a.nosaukums" + "FROM persona p, amati a"
					+ "WHERE p.amats id = a.id AND p.vards = ? AND p.uzvards =  AND p.amats id = ?;";
			ps = Connect.connection.prepareStatement(sql);
			ps.setString(1, vards);
			ps.setString(2, uzvards);
			ps.setInt(3, amatsID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				persona.setVards(rs.getString(1));
				persona.setUzvards(rs.getString(2));
				persona.setTalrunis(rs.getString(3));
				persona.setAmats(amatsDB.getAmatsByID(4));
			}

		}

		return persona;
	}

	public boolean insertPersona(String vards, String uzvards, String amats) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO amati(nosaukums) VALUES(?)";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, vards);
		ps.setString(2, uzvards);
		ps.setString(3, amats);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	public boolean updatePersona(String vards, String uzvards, String amats) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE amati set nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, vards);
		ps.setString(2, uzvards);
		ps.setString(3, amats);
		ps.executeUpdate();
		updateOK = true;
		return updateOK;
	}

	public boolean deletePesrona(String vards, String uzvards, String amats) throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM amati WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, vards);
		ps.setString(2, uzvards);
		ps.setString(3, amats);
		ps.executeUpdate();
		deleteOK = true;
		return deleteOK;
	}

	
}
// PersonaDB, DatorTehnikaDB, MaterialiDB
