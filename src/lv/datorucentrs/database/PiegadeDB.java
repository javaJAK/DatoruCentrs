package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Piegade;

public class PiegadeDB {

	public PreparedStatement ps;

	public boolean insertPiegade(String veids) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO piegades(veids) VALUES(?)";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, veids);
		ps.executeUpdate();
		insertOK = true;
		return insertOK;
	}

	public boolean updatePiegade(String veids, String jveids) throws SQLException {
		boolean updateOK = false;
		String sql = "UPDATE piegades set veids = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jveids);
		ps.setString(2, veids);
		ps.executeUpdate();
		updateOK = true;
		return updateOK;
	}

	public boolean deletePiegade(String veids) throws SQLException {
		boolean deleteOK = false;
		String sql = "DELETE FROM piegades WHERE veids = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, veids);
		ps.executeUpdate();
		deleteOK = true;
		return deleteOK;
	}

	public Piegade getPiegade(String piegade) throws SQLException {
		String sql = "SELECT veids FROM  piegade WHERE veids = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, piegade);
		ResultSet rs = ps.executeQuery();
		Piegade piegade1 = null;
		while (rs.next()) {
			piegade1.getVeids();
		}

		return piegade1;
	}

	public Piegade getPiegadeByID(int id) throws SQLException {
		Piegade piegade = new Piegade();
		String sql = "SELECT id FROM piegades WHERE id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			piegade.getVeids();
		}

		return piegade;
	}

	public int getPiegadeID(String veids) throws SQLException {
		int amatsID = -1;
		String sql = "SELECT id FROM piegades WHERE veids = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, veids);
		ResultSet rs = ps.executeQuery();
		int piegadeID = 0;
		while (rs.next()) {
			piegadeID = rs.getInt(1);
		}
		return piegadeID;

	}

	public List<Piegade> getAllVeidi() throws SQLException {
		Piegade piegade;
		List<Piegade> piegades = new ArrayList<Piegade>();
		String sql = "SELECT veids FROM piegades;";
		ps = Connect.connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			piegades =  (List<Piegade>) new Piegade(rs.getString(1));
		}
		return piegades;
	}
}

