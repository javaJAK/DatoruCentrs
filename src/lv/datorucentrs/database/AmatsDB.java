package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Amats;

public class AmatsDB {

	public PreparedStatement ps;

	public boolean insertAmats(String nosaukums) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO amati(nosaukums) VALUES(?)";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		insertOK = true;
		
		return insertOK;
	}

	public boolean updateAmats(String nosaukums, String jNosaukums) throws SQLException {
		boolean updateOK = false;
		
		String sql = "UPDATE amati set nosaukums = ? WHERE nosaukums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jNosaukums);
		ps.setString(2, nosaukums);
		ps.executeUpdate();
		updateOK = true;
		
		return updateOK;
	}

	public boolean deleteAmats(String nosaukums) throws SQLException {
		boolean deleteOK = false;
		
		String sql = "DELETE FROM amati WHERE nosaukums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		deleteOK = true;
		
		return deleteOK;
	}

	public Amats getAmats(String nosaukums) throws SQLException {
		Amats amats = new Amats();
		
		String sql = "SELECT nosaukums FROM amati WHERE nosaukums = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amats.setNosaukums(rs.getString(1));
		}

		return amats;
	}

	public Amats getAmatsByID(int id) throws SQLException {
		Amats amats = new Amats();
		
		String sql = "SELECT id FROM amati WHERE id = ?;";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amats.setNosaukums(rs.getString(1));
		}

		return amats;
	}

	public int getAmatsID(String nosaukums) throws SQLException {
		int amatsID = -1;
		
		String sql = "SELECT id FROM amati WHERE nosaukums = ?;";
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
		
		String sql = "SELECT nosaukums FROM amati;";
		ps = Connect.connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			amats = new Amats(rs.getString(1));
			amati.add(amats);
		}
		
		return amati;
	}
}
