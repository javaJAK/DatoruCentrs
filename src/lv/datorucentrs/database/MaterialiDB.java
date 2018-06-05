package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Amats;

public class MaterialiDB {


	public PreparedStatement ps;

	public boolean insertMateriali(String nosaukums, String cena, String daudzums) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO materiali(nosaukums) VALUES(?)";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.setInt(2, cena);
		ps.setInt(3, daudzums);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	public boolean updateMateriali(String nosaukums,String jnosaukums, String cena, String jcena, String daudzums, String jdaudzums) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE materiali set nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jnosaukums);
		ps.setString(2, nosaukums);
		ps.setInt(3, cena);
		ps.setInt(4, jcena);
		ps.setInt(5, daudzums);
		ps.setInt(6, jdaudzums);
		ps.executeUpdate();
		updateOK = true;
		return updateOK;
	}

	public boolean deleteMateriali(String nosaukums, String cena, String daudzums) throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM materiali WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.setInt(2, cena);
		ps.setInt(3, daudzums);
		ps.executeUpdate();
		deleteOK = true;
		return deleteOK;
	}

	public Materiali getMateriali(String nosaukums) throws SQLException {
		Materiali materiali = new materiali();
		String sql = "SELECT nosaukums FROM materiali WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.setInt(2, cena);
		ps.setInt(3, daudzums);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			materiali.setNosaukums(rs.getString(1));
		}

		return materiali;
	}

	public Materiali getMaterialiByID(int id) throws SQLException {
		Materiali materiali = new Materiali();
		String sql = "SELECT id FROM materiali WHERE id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			materiali.setNosaukums(rs.getString(1));
		}

		return materiali;
	}

	public int getAmatsID(String nosaukums) throws SQLException {
		int amatsID = -1;
		String sql = "SELECT id FROM materiali WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amatsID = rs.getInt(1);
		}
		return amatsID;

	}

	public List<Amats> getAllAmati() throws SQLException {
		Amats amats;
		List<Amats> amati = new ArrayList<Amats>();
		String sql = "SELECT nosaukums FROM materiali = ?";
		ps = Connect.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amats = new Amats(rs.getString(1));
		}
		return amati;
	}
}
