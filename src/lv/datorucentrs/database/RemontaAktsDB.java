package lv.datorucentrs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lv.datorucentrs.database.savienojums.Connect;
import lv.datorucentrs.dati.Amats;
import lv.datorucentrs.dati.DarbaVeids;
import lv.datorucentrs.dati.Datortehnika;
import lv.datorucentrs.dati.Persona;
import lv.datorucentrs.dati.RemontaAkts;

public class RemontaAktsDB {
	public PreparedStatement ps;

	// insert komanda
	public boolean insertRemontaAkts(String problema, String serialaisNumurs, String piezime, String transports,
			String darbaIlgums, String darbaApraksts, String datums, String datortehnika, String darbaveids,
			String klients, String tehnikis) throws SQLException {
		boolean insertOK = false;

		String sql = "INSERT INTO RemontaAkti(problema, serialaisNumurs, piezime, "
				+ "transports, darbaIlgums, darbaApraksts, datums, " + "datortehnika, darbaveids, klients, tehnikis)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, problema);
		ps.setString(2, serialaisNumurs);
		ps.setString(3, piezime);
		ps.setString(4, transports);
		ps.setString(5, darbaIlgums);
		ps.setString(6, darbaApraksts);
		ps.setString(7, datums);
		ps.setString(8, datortehnika);
		ps.setString(9, darbaveids);
		ps.setString(10, klients);
		ps.setString(11, tehnikis);
		ps.executeUpdate();
		insertOK = true;

		return insertOK;
	}

	// update komanda
	public boolean updateRemontaAkts(String problema, String serialaisNumurs, String piezime, String transports,
			String darbaIlgums, String darbaApraksts, String datums, String datortehnika, String darbaveids,
			String klients, String tehnikis) throws SQLException {
		boolean updateOK = false;

		String sql = "UPDATE remontaAkti SET problema = ?, serialaisNumurs = ?, piezime = ?, " // UPDATE
				+ "transports = ?, darbaIlgums = ?, darbaApraksts = ?, datums = ?, "
				+ "datortehnika = ?, darbaveids = ?, klients = ?, tehnikis = ?"
				+ " WHERE problema = ?, serialaisNumurs = ?, piezime = ?, " // WHERE
				+ "transports = ?, darbaIlgums = ?, darbaApraksts = ?, datums = ?, "
				+ "datortehnika = ?, darbaveids = ?, klients = ?, tehnikis = ?";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, problema);
		ps.setString(2, serialaisNumurs);
		ps.setString(3, piezime);
		ps.setString(4, transports);
		ps.setString(5, darbaIlgums);
		ps.setString(6, darbaApraksts);
		ps.setString(7, datums);
		ps.setString(8, datortehnika);
		ps.setString(9, darbaveids);
		ps.setString(10, klients);
		ps.setString(11, tehnikis);
		ps.executeUpdate();
		updateOK = true;

		return updateOK;
	}

	// delete komanda
	public boolean deleteRemontaAkts(String problema, String serialaisNumurs, String piezime, String transports,
			String darbaIlgums, String darbaApraksts, String datums, String datortehnika, String darbaveids,
			String klients, String tehnikis) throws SQLException {
		boolean deleteOK = false;

		String sql = "DELETE FROM remontaAkti WHERE problema = ?, serialaisNumurs = ?, piezime = ?, "
				+ "transports = ?, darbaIlgums = ?, darbaApraksts = ?, datums = ?, "
				+ "datortehnika = ?, darbaveids = ?, klients = ?, tehnikis = ?";

		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, problema);
		ps.setString(2, serialaisNumurs);
		ps.setString(3, piezime);
		ps.setString(4, transports);
		ps.setString(5, darbaIlgums);
		ps.setString(6, darbaApraksts);
		ps.setString(7, datums);
		ps.setString(8, datortehnika);
		ps.setString(9, darbaveids);
		ps.setString(10, klients);
		ps.setString(11, tehnikis);
		ps.executeUpdate();
		deleteOK = true;

		return deleteOK;
	}

	// select komanda
	// Atrast REMONATAAKTU pçc visa
	public RemontaAkts getRemontaAkts(String klients, String tehnikis, String darbaveids, String problema,
			Datortehnika datortehnika, String serialaisNumurs, String piezime, String transports, String darbaIlgums,
			String darbaApraksts, String datums) throws SQLException {
		PersonaDB persona = new PersonaDB();
		DatortehnikaDB datortehnika = new DatortehnikaDB();
		DarbaVeidsDB darbaveids = new DarbaVeidsDB();
		RemontaAkts remontaAkts = new RemontaAkts();
		String sql = "SELECT klientsID FROM remontaAkti WHERE klients = ?"; // ????
		ps = Connect.connection.prepareStatement(sql);
		ps.setString(1, problema);
		ps.setString(2, serialaisNumurs);
		ps.setString(3, piezime);
		ps.setString(4, transports);
		ps.setString(5, darbaIlgums);
		ps.setString(6, darbaApraksts);
		ps.setString(7, datums);
		ps.setString(8, datortehnika);
		ps.setString(9, darbaveids);
		ps.setString(10, klients);
		ps.setString(11, tehnikis);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			remontaAkts.setProblema(rs.getString(1));
			remontaAkts.setSerialaisNumurs(rs.getString(2));
			remontaAkts.setPiezime(rs.getString(3));
			remontaAkts.setTransports(rs.getString(4));
			remontaAkts.setDarbaIlgums(rs.getString(5));
			remontaAkts.setDarbaApraksts(rs.getString(6));
			remontaAkts.setDatums(rs.getString(7));
			remontaAkts.setDatortehnika(DatortehnikaDB.getDatortehnikabyID(8));
			remontaAkts.setDarbaVeids(DarbaVeidsDB.getDarbaveidsByID(9));
			remontaAkts.setKlients(rs.getString(10));
			remontaAkts.setTehnikis(rs.getString(11));
		}
		return remontaAkts;
	}
}
