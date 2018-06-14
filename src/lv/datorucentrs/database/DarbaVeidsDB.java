package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.DarbaVeids;

public class DarbaVeidsDB {
	public PreparedStatement ps;

	// insert komanda
	public boolean insertDarbaVeids(String nosaukums) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO darba_veidi(nosaukums) VALUES(?)";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		insertOK = true;

		return insertOK;
	}

	// update komanda
	public boolean updateDarbaVeids(String nosaukums, String jNosaukums) throws SQLException {
		boolean updateOK = false;

		String sql = "UPDATE darba_veidi SET nosaukums = ? WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, jNosaukums);
		ps.setString(2, nosaukums);
		ps.executeUpdate();
		updateOK = true;

		return updateOK;
	}

	// delete komanda
	public boolean updateDarbaVeids(String nosaukums) throws SQLException {
		boolean deleteOK = false;

		String sql = "DELETE FROM darba_veidi WHERE nosaukums = ?";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);
		ps.executeUpdate();
		deleteOK = true;

		return deleteOK;
	}

	// select komandas
	// Atrast DARBAVEIDU pçc NOSAUKUMA
	public DarbaVeids getDarbaVeids(String nosaukums) throws SQLException {
		DarbaVeids darbaVeids = new DarbaVeids();

		String sql = "SELECT nosaukums FROM darba_veids WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			darbaVeids.setNosaukums(rs.getString(1));
		}
		return darbaVeids;
	}

	// Atrast DARBAVEIDU pçc ID
	public DarbaVeids getDarbaVeidsByID(int id) throws SQLException {
		DarbaVeids darbaVeids = new DarbaVeids();

		String sql = "SELECT nosaukums FROM darba_veidi WHERE id = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			darbaVeids.setNosaukums(rs.getString(1));
		}
		return darbaVeids;
	}

	// Atrast DARBAVEIDU ID pçc NOSAUKUMA
	public int getDarbaVeidsID(String nosaukums) throws SQLException {
		int darbaVeidsID = -1;

		String sql = "SELECT id FROM darba_veidi WHERE nosaukums = ?";
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, nosaukums);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			darbaVeidsID = rs.getInt(1);
		}
		return darbaVeidsID;
	}
	
	// Atrast visus DARBAVEIDUS
	public List<DarbaVeids> getAllDarbaVeidi() throws SQLException{
		DarbaVeids darbaVeids;
		List<DarbaVeids> darbaVeidi = new ArrayList<DarbaVeids>();
		
		String sql = "SELECT nosaukums FROM darba_veidi;";
		ps = Connect.connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			darbaVeids = new DarbaVeids(rs.getString(1));
			darbaVeidi.add(darbaVeids);
		}
		return darbaVeidi;
	}
}
