package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Amats;
import lv.datorucentrs.dati.Datortehnika;

public class DatortehnikaDB {

	public PreparedStatement ps;

	public boolean insertDatortehnika(String nosaukums) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO datortehnika(nosaukums) VALUES(?)";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	public boolean updateDatortehnika(String nosaukums, String jnosaukums) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE datortehnika SET nosaukums = ? WHERE nosaukums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jnosaukums);
		ps.setString(2, nosaukums);
		ps.executeUpdate();
		updateOK = true;
		return updateOK;
	}

	public boolean deleteDatortehnika(String nosaukums) throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM datortehnika WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		deleteOK = true;
		return deleteOK;
	}

	public Datortehnika getDatortehnika(String nosaukums) throws SQLException {
		Datortehnika datortehnika = new Datortehnika();
		
		String sql = "SELECT nosaukums FROM datortehnika WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			datortehnika.setNosaukums(rs.getString(1));
		}

		return datortehnika;
	}

	public Datortehnika getDatortehnikaByID(int id) throws SQLException {
		Datortehnika datortehnika = new Datortehnika();
		
		String sql = "SELECT nosaukums FROM datortehnika WHERE id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			datortehnika.setNosaukums(rs.getString(1));
		}

		return datortehnika;
	}

	public int getDatortehnikaID(String nosaukums) throws SQLException {
		int datortehnikaID = -1;
		
		String sql = "SELECT id FROM datortehnika WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			datortehnikaID = rs.getInt(1);
		}
		
		return datortehnikaID;
	}

	public List<Datortehnika> getAllDatortehnika() throws SQLException {
		Datortehnika datortehnika;
		List<Datortehnika> datortehnikas = new ArrayList<Datortehnika>();
		
		String sql = "SELECT nosaukums FROM datortehnika;";
		ps = Connect.connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			datortehnika = new Datortehnika(rs.getString(1));
			datortehnikas.add(datortehnika);
		}
		return datortehnikas;
	}
}
