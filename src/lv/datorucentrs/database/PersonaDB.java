package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Amats;
import lv.datorucentrs.dati.Persona;

public class PersonaDB {
	public PreparedStatement ps;

	// insert komanda
	public boolean insertPersona(String vards, String uzvards, String talrunis, String amats) throws SQLException {
		boolean insertOK = false;
		int amatsID = -1;

		AmatsDB amatsDB = new AmatsDB();
		amatsID = amatsDB.getAmatsID(amats);
		
		if(amatsID != -1) {
			String sql = "INSERT INTO personas(vards, uzvards, talrunis, amatds_id) VALUES(?, ?, ?, ?)";
	
			ps = Connect.connection.prepareStatement(sql);
			ps.setString(1, vards);
			ps.setString(2, uzvards);
			ps.setString(3, talrunis);
			ps.setInt(4, amatsID);
			ps.executeUpdate();
			insertOK = true;
		}
		return insertOK;
	}
	
	// update komanda
	public boolean updatePersona(String vards, String uzvards, String jVards, String jUzvards, String jTalrunis, String jAmats) throws SQLException {
		boolean updateOK = false;
		int amatsID = -1;

		AmatsDB amatsDB = new AmatsDB();
		amatsID = amatsDB.getAmatsID(jAmats);
		
		if(amatsID != -1) {
			String sql = "UPDATE personas SET vards = ?, uzvards = ?, talrunis = ?, amats_id = ? "
						+ "WHERE vards = ?, uzvards = ?, talrunis = ?, amats_id = ?";
			ps = Connect.connection.prepareStatement(sql);
			ps.setString(1, jVards);
			ps.setString(2, jUzvards);
			ps.setString(3, jTalrunis);
			ps.setInt(4, amatsID);
			ps.setString(5, vards);
			ps.setString(6, uzvards);
			ps.executeUpdate();
			updateOK = true;
		}
		return updateOK;
	}
	
	// delete komanda
	public boolean deletePesrona(String vards, String uzvards, int talrunis, int amats_id) throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM personas WHERE vards = ?, uzvards = ?, talrunis = ?, amats_id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, vards);
		ps.setString(2, uzvards);
		ps.setInt(3, talrunis);
		ps.setInt(4, amats_id);
		ps.executeUpdate();
		deleteOK = true;
		return deleteOK;
	}

	// select komanda
	// Atrast PERSONU pçc vârda, uzvârds	
	public Persona getPersona(String vards, String uzvards) throws SQLException {
		int amatsID = -1;

		Persona persona = new Persona();
		AmatsDB amatsDB = new AmatsDB();
		
		if (amatsID != -1) {
			String sql = "SELECT vards, uzvards, "
					   + "FROM personas "
					   + "WHERE vards = ?, uzvards = ?;";
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

	public int getPersonaID(String vards, String uzvards) throws SQLException {
		int amatsID = -1;
		String sql = "SELECT id FROM personas WHERE vards = ? AND uzvards = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, vards);
		ps.setString(2, uzvards);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amatsID = rs.getInt(1);
		}
		return amatsID;
	}

	public Persona getPersonaByID(int id) throws SQLException {
		Persona persona = new Persona();
		AmatsDB amatsDB = new AmatsDB();
		
		String sql = "SELECT vards, uzvards, talrunis, amats_id FROM personas "
				   + "WHERE vards = ?, uzvards = ?, talrunis = ?, amats_id = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			persona.setVards(rs.getString(1));
			persona.setUzvards(rs.getString(2));
			persona.setTalrunis(rs.getString(3));
			persona.setAmats(amatsDB.getAmatsByID(rs.getInt(4)));
		}
		
		return persona;
	}
	
	public List<Persona> getAllPersonas() throws SQLException {
		Persona persona;
		AmatsDB amatsDB = new AmatsDB();
		List<Persona> personas = new ArrayList<Persona>();
		
		String sql = "SELECT vards, uzvards, talrunis, amats_id FROM personas";
		ps = Connect.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			persona = new Persona(rs.getString(1), rs.getString(2), rs.getString(3), amatsDB.getAmatsByID(rs.getInt(4)));
		}
		return personas;
	}
}