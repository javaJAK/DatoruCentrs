package lv.datorucentrs.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.AktsMaterials;
import lv.datorucentrs.dati.IzsniegsanasAkts;
import lv.datorucentrs.dati.RemontsMaterials;

public class AktsMaterialsDB {
	public PreparedStatement ps;

	// insert komanda
	public boolean insertAktsMaterials(String nosaukums, String kVards, String kUzvards, String tVards, String tUzvards, String datortehnika, Date datums )
			throws SQLException {
		boolean insertOK = false;
		String sql = "INSERT INTO akti_materials(materials_id, remonts_materials_id, izsniegsanas_akts_id) VALUES(?, ?, ?);";
		
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniegsanas_akts_id);
		ps.setString(2, remonts_materials_id);
		ps.setString(3, daudzums_id);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	// update komanda
	public boolean updateAmats(String vIzsniegsanas_akts_id, String jIzsniegsanas_akts_id,
			String vRemonts_materials_id, String jRemonts_materials_id,
			String vDaudzums_id, String jDaudzums_id) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE amati SET nosaukums = ? WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jIzsniegsanas_akts_id);
		ps.setString(2, vIzsniegsanas_akts_id);
		ps.setString(3, jRemonts_materials_id);
		ps.setString(4, vRemonts_materials_id);
		ps.setString(5, jDaudzums_id);
		ps.setString(2, vDaudzums_id);
		updateOK = true;
		return updateOK;
	}
	// delete komanda
	public boolean deleteAktsMaterials(String izsniegsanas_akts_id, String remonts_materials_id, String daudzums_id)
			throws SQLException {
			boolean deleteOK = false;
			String sql = "DELETE FROM aktsmateriali WHERE izsniegsanas_akts_id = ?"
					+"DELETE FROM aktsmateriali WHERE remonts_materials_id = ?"+
					"DELETE FROM aktsmateriali WHERE daudzums_id = ?";
			ps = Connect.connection.prepareStatement(sql);
			ps.setString(1, izsniegsanas_akts_id);
			ps.setString(2, remonts_materials_id);
			ps.setString(3, daudzums_id);
			deleteOK = true;
			return deleteOK;
	}
	// select komandas
		public AktsMaterials getAktsMaterials(String materials, String kVards, String kUzvards, String tVards, String tUzvards, String datortehnika, Date datums) throws SQLException {
			AktsMaterials aktsMaterials = new AktsMaterials();
			
			IzsniegsanasAktsDB izsniegsanasAktsDB = new IzsniegsanasAktsDB();
			RemontsMaterialsDB remontsMaterialsDB = new RemontsMaterialsDB();
			
			
			
			String sql = "SELECT izsniegsanas_akts_id, remonts_materials_id, daudzums FROM aktsmateriali WHERE izsniegsanas_akts_id = ? AND remonts_materials_id = ?";			
			ps = Connect.connection.prepareStatement(sql);
			ps.setString(1, izsniegsanas_akts_id);
			ps.setString(2, remonts_materials_id);
			ps.setString(3, daudzums_id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				aktsMaterials.setIzsniegsanasAkts(izsniegsanasAktsDB.getIzsniegsanasAktsByID(rs.getInt(1)));
				aktsMaterials.setRemontsMaterials(remontsMaterialsDB.getRemontsMaterialsByID(rs.getInt(2)));
				aktsMaterials.setDaudzums(rs.getInt(3));
			}
			return aktsMaterials;	
		}
		//atrast pec id
	
				public AktsMaterials getAktsMaterialsByID(int id) throws SQLException {
					RemontsMaterials remontsmaterials = new RemontsMaterials();
					String sql = "SELECT daudzums_id FROM aktsmaterials WHERE daudzums_id = ?";
					ps = Connect.connection.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					AktsMaterials aktsmaterials;
					while (rs.next()) {
						aktsmaterials.setDaudzums_id(rs.getString(1));
					}
					return aktsmaterials;
				
			
			
		}
				public AktsMaterials getAllAktsMateriali() throws SQLException {
					AktsMaterials aktsmaterials;
					List<RemontsMaterials> remontsmateriali = new ArrayList<>();
					String sql = "SELECT materials_id, remonta_akts_id, daudzums FROM Remontsmaterials;";
					
							
					ps = Connect.connection.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						aktsmaterials = new AktsMaterials();
						aktsmaterials.add(aktsmaterials);
					}
					return aktsmaterials;
				}

}