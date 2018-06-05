package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.ConnectDB;
import lv.datorucentrs.dati.Amats;
import lv.datorucentrs.dati.Datortehnika;

public class DatorTehnikaDB {

	public PreparedStatement ps;

	public boolean insertDatortehnika(String nosaukums) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO datortehnika(nosaukums) VALUES(?)";

		ps = ConnectDB.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	public boolean updateDatortehnika(String nosaukums, String jnosaukums) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE datortehnika set nosaukums = ?";
		ps = ConnectDB.connection.prepareStatement(sql);
		ps.setString(1, jnosaukums);
		ps.setString(2, nosaukums);
		ps.executeUpdate();
		updateOK = true;
		return updateOK;
	}

	public boolean deleteDatortehnika(String nosaukums) throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM datortehnika WHERE nosaukums = ?";
		ps = ConnectDB.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		deleteOK = true;
		return deleteOK;
	}

	public Datortehnika getDatortehnika(String nosaukums) throws SQLException {
		Datortehnika datortehnika = new Datortehnika();
		String sql = "SELECT nosaukums FROM datortehnika WHERE nosaukums = ?";
		ps = ConnectDB.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			datortehnika.setNosaukums(rs.getString(1));
		}

		return datortehnika;
	}

	public Amats getAmatsByID(int id) throws SQLException {
		Amats amats = new Amats();
		String sql = "SELECT id FROM amati WHERE id = ?";
		ps = ConnectDB.connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amats.setNosaukums(rs.getString(1));
		}

		return amats;
	}

	public int getAmatsID(String nosaukums) throws SQLException {
		int amatsID = -1;
		String sql = "SELECT id FROM amati WHERE nosaukums = ?";
		ps = ConnectDB.connection.prepareStatement(sql);
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
		String sql = "SELECT nosaukums FROM amati = ?";
		ps = ConnectDB.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amats = new Amats(rs.getString(1));
		}
		return amati;
	}
}
