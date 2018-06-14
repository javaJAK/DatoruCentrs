package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.RemontsMaterials;

public class RemontsMaterialsDB {
	public PreparedStatement ps;

	// insert komanda
	public boolean insertRemontsMaterials(String materials_id, String remonta_akts_id) throws SQLException {
		boolean insertOK = false;
		String sql = "INSERT INTO remonti_materiali(materials_id, remonta_akts_id, daudzums) VALUES(?, ?, ?)";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, materials_id);
		ps.setString(2, remonta_akts_id);
		String daudzums = null;
		ps.setString(3, daudzums);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	// update komanda
	public boolean updateRemontsMaterials(String vMaterials_id, String jMaterials_id, String jRemonta_akts_id,
			String vRemonta_akts_id, String jDaudzums, String vDaudzums) throws SQLException {
		boolean updateOK = false; 
		String sql = "UPDATE remonti_materiali SET materials_id = ?, remonta_akts_id = ?, daudzumus = ?"
				+ " WHERE materials_id = ?, remonta_akts_id, daudzums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jMaterials_id);
		ps.setString(2, vMaterials_id);
		ps.setString(3, jRemonta_akts_id);
		ps.setString(4, vRemonta_akts_id);
		ps.setString(5, jDaudzums);
		ps.setString(6, vDaudzums);
		updateOK = true;
		return updateOK;
	}

	// delete komanda
	public boolean deleteRemontsMaterials(String materials_id, String remonta_akts_id, String daudzums)
			throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM remonti_materiali WHERE materials_id = ?, remonta_akts_id = ?, daudzums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, materials_id);
		ps.setString(2, remonta_akts_id);
		ps.setString(3, daudzums);
		deleteOK = true;
		return deleteOK;
	}

	// select komanda
	public RemontsMaterials getRemontsMaterials(String materials_id, String remonta_akts_id, String daudzums)
			throws SQLException {
		RemontsMaterials remontsmaterials = new RemontsMaterials();
		String sql = "SELECT materials_id, remonta_akts_id, daudzums "
					+ "FROM remonti_materiali rm, materiali m "
					+ "WHERE materials_id = ?, remonta_akts_id = ?, daudzums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, materials_id);
		ps.setString(2, remonta_akts_id);
		ps.setString(3, daudzums);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			remontsmaterials.setMaterials_id(rs.getString(1));
			remontsmaterials.setRemonta_akts_id(rs.getString(2));
			remontsmaterials.setDaudzums(rs.getInt(3));
		}
		return remontsmaterials;
	}
	// Tâlak es nemainîju. Nav ne jausmas, kas un kâ.

	// Atrast materialu pçc ID
	public RemontsMaterials getRemontsMaterialsByID(int id) throws SQLException {
		RemontsMaterials remontsmaterials = new RemontsMaterials();
		String sql = "SELECT materials_id FROM remonti_materiali WHERE materials_id = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			remontsmaterials.setMaterials_id(rs.getString(1));
		}
		return remontsmaterials;
	} 
	

	// Atrast materialu ID pçc NOSAUKUMa
	public int getMaterials_id_ID(String materials_id) throws SQLException {
		int materialsID = -1;
		String sql = "SELECT id FROM materiali WHERE nosaukums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, materials_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			materialsID = rs.getInt(1);
		}
		return materialsID;
	}
	// Atrast visus remontu_materialu ierakstus
	public List<RemontsMaterials> getAllRemontsMateriali() throws SQLException {
		RemontsMaterials remontsmaterials;
		List<RemontsMaterials> remontsmateriali = new ArrayList<>();
		String sql = "SELECT materials_id, remonta_akts_id, daudzums FROM remonti_materiali;";
		
				
		ps = Connect.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			remontsmaterials = new RemontsMaterials();
			remontsmateriali.add(remontsmaterials);
		}
		return remontsmateriali;
	}

}
