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
import lv.datorucentrs.dati.Materiali;
import lv.datorucentrs.dati.RemontsMaterials;

public class AktsMaterialsDB {
	public PreparedStatement ps;

	// insert komanda
	public boolean insertAktsMaterials(String nosaukums, String kVards, String kUzvards, String tVards, String tUzvards,
			String datortehnika, Date datums, String izsniegsanas_akts_id, String remontsMaterials, String daudzums_id)
			throws SQLException {
		boolean insertOK = false;
		String sql = "INSERT INTO akti_materials(materials_id, remonts_materials_id, izsniegsanas_akts_id) VALUES(?, ?, ?);";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniegsanas_akts_id);
		ps.setString(2, remontsMaterials);
		ps.setString(3, daudzums_id);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	// update komanda
	public boolean updateAmats(String vIzsniegsanas_akts_id, String jIzsniegsanas_akts_id, String VRemontsMaterials,
			String jRemontsMaterials, String vDaudzums_id, String jDaudzums_id) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE amati SET nosaukums = ? WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jIzsniegsanas_akts_id);
		ps.setString(2, vIzsniegsanas_akts_id);
		ps.setString(3, jRemontsMaterials);
		ps.setString(4, VRemontsMaterials);
		ps.setString(5, jDaudzums_id);
		ps.setString(2, vDaudzums_id);
		updateOK = true;
		return updateOK;
	}

	// delete komanda
	public boolean deleteAktsMaterials(String izsniegsanas_akts_id, String remontsMaterials, String daudzums_id)
			throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM aktsmateriali WHERE izsniegsanas_akts_id = ?"
				+ "DELETE FROM aktsmateriali WHERE remonts_materials_id = ?"
				+ "DELETE FROM aktsmateriali WHERE daudzums_id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniegsanas_akts_id);
		ps.setString(2, remontsMaterials);
		ps.setString(3, daudzums_id);
		deleteOK = true;
		return deleteOK;
	}

	// select komandas
	public AktsMaterials getAktsMaterials(String materials, String kVards, String kUzvards, String tVards,
			String tUzvards, String datortehnika, Date datums, String izsniegsanas_akts_id, String remontsMaterials,
			String daudzums_id) throws SQLException {
		AktsMaterials aktsMaterials = new AktsMaterials();

		IzsniegsanasAkts izsniegsanasAktsDB = new IzsniegsanasAkts();
		RemontsMaterialsDB remontsMaterialsDB = new RemontsMaterialsDB();

		String sql = "SELECT izsniegsanas_akts_id, remonts_materials_id, daudzums FROM aktsmateriali WHERE izsniegsanas_akts_id = ? AND remonts_materials_id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, izsniegsanas_akts_id);
		ps.setString(2, remontsMaterials);
		ps.setString(3, daudzums_id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			aktsMaterials.setRemontsMaterials(remontsMaterialsDB.getRemontsMaterialsByID(rs.getInt(1)));
			aktsMaterials.setDaudzums(rs.getInt(3));
		}
		return aktsMaterials;
	}
	// atrast pec id

	public AktsMaterials getAktsMaterialsByID(String remontsMaterials, 
						String materials, String izsniegsanasAkts) throws SQLException {
					int materialsID = -1;
					int remontsMaterialsID = -1;
					int izsniegsanasAktsID = -1;
					
					RemontsMaterialsDB remontsMaterialsDB = new RemontsMaterialsDB();
					IzsniegsanasAktsDB izsniegsanasAktsDB = new IzsniegsanasAktsDB();
					MaterialsDB materialsDB = new MaterialsDB();
					
					remontsMaterialsID = remontsMaterialsID.getRemontsMaterialsID(remontsMaterials);
					izsniegsanasAktsID = izsniegsanasAktsID.getIzsniegsanasAktsID(izsniegsanasAkts);
					materialsID = materialsID.getMaterialsID(materials);
					
					if (remontsMaterialsID != -1 && materialsID != -1 && izsniegsanasAktsID != -1) {
						String sql = "SELECT rm.remontsMaterials, ia.izsniegsanasAkts, m.materials"
								+ "FROM remontaMateriali rm, izsniegsanasAkti ia, materiali m, aktsMateriali am"
								+ "WHERE am.remontsMaterials id = rm.id, am.izsniegsanasAkts id = ia.id, am.materials id = m.id "
								+ "AND am.remontsMaterials = ? AND am.izsniegsanasAkts = ? AND am.materials = ?;";

						ps = Connect.connection.prepareStatement(sql);
						ps.setInt(1, remontsMaterialsID);
						ps.setInt(2, izsniegsanasAktsID);
						ps.setInt(3, materialsID);

						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							izsniegsanasAkts.setRemontsMaterialsID(remontsMaterialsDB.getRemontsMaterialsByID(1));
							izsniegsanasAkts.setIzsniegsanasAktsID(izsniegsanasAktsDB.getIzsniegsanasAktsByID(2));
							izsniegsanasAkts.setMaterialsID(materialsDB.getMaterialsByID(3));

						}
					
					}
					return aktsMaterials;
				
			
			
		}

	public AktsMaterials getAllAktsMateriali() throws SQLException {
		AktsMaterials aktsmaterials = null;
		List<RemontsMaterials> remontsMaterials = new ArrayList<>();
		String sql = "SELECT materials_id, remonta_akts_id, daudzums FROM Remontsmaterials;";

		ps = Connect.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			aktsmaterials = new AktsMaterials();
		}
		return aktsmaterials;

	}

}