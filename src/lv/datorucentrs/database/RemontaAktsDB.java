package lv.datorucentrs.database;

import java.sql.Date;
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
	public boolean deleteRemontaAkts(String problema, String serialaisNumurs, String piezime, double transports,
			double darbaIlgums, String darbaApraksts, Date datums, String datortehnika, String darbaveids,
			String kVards, String kUzvards, String tVards, String tUzvards) throws SQLException {
		boolean deleteOK = false;
		int klientsID = -1, tehnikisID = -1, darbaVeidsID = -1, datortehnikaID = -1;

		PersonaDB personaDB = new PersonaDB();
		DatortehnikaDB datortehnikaDB = new DatortehnikaDB();
		DarbaVeidsDB darbaVeidsDB = new DarbaVeidsDB();
		
		klientsID = personaDB.getPersonaID(kVards, kUzvards);
		tehnikisID = personaDB.getPersonaID(tVards, tUzvards);
		darbaVeidsID = darbaVeidsDB.getDarbaVeidsID(darbaveids);
		datortehnikaID = datortehnikaDB.getDatortehnikaID(datortehnika);
		
		if(klientsID != -1 && tehnikisID != -1 && darbaVeidsID != -1 && datortehnikaID != -1) {
			String sql = "DELETE FROM remonta_akti WHERE problema = ? AND serialaisNumurs = ? AND piezime = ? AND "
					+ "transports = ? AND darba_ilgums = ? AND darba_apraksts = ? AND datums = ? AND "
					+ "datortehnika_id = ? AND darba_veids_id = ? AND klients_id = ? AND tehnikis_id = ?;";

			ps = Connect.connection.prepareStatement(sql);
			ps.setString(1, problema);
			ps.setString(2, serialaisNumurs);
			ps.setString(3, piezime);
			ps.setDouble(4, transports);
			ps.setDouble(5, darbaIlgums);
			ps.setString(6, darbaApraksts);
			ps.setDate(7, datums);
			ps.setInt(8, datortehnikaID);
			ps.setInt(9, darbaVeidsID);
			ps.setInt(10, klientsID);
			ps.setInt(11, tehnikisID);
			ps.executeUpdate();
			deleteOK = true;
		}
		
		return deleteOK;
	}

	// select komanda
	// Atrast REMONATAAKTU pçc visa
	public RemontaAkts getRemontaAkts(String kVards, String kUzvards, 
			String tVards, String tUzvards, String datortehnika, 
			String serialaisNumurs, String datums) throws SQLException {
		int klientsID = -1, tehnikisID = -1, datortehnikaID = -1;
		
		PersonaDB personaDB = new PersonaDB();
		DatortehnikaDB datortehnikaDB = new DatortehnikaDB();
		DarbaVeidsDB darbaVeidsDB  = new DarbaVeidsDB();
		
		RemontaAkts remontaAkts = new RemontaAkts();
		
		tehnikisID = personaDB.getPersonaID(tVards, tUzvards);
		klientsID = personaDB.getPersonaID(kVards, kUzvards);
		datortehnikaID = datortehnikaDB.getDatortehnikaID(datortehnika);
		
		if(klientsID != -1 && tehnikisID != -1 && datortehnikaID != -1) {
			String sql = "SELECT ra.klients_id, ra.tehnikis_id, ra.darba_veids_id, ra.problema, "
					+ "ra.datortehnika_id, ra.serialais_numurs, ra.piezimes, ra.transports, "
					+ "ra.darba_ilgums, ra.darba_apraksts, ra.datums "
					+ "FROM remonta_akti ra, personas p, darba_veidi dv, datortehnika dt "
					+ "WHERE ra.klients_id = p.id AND ra.tehnikis_id = p.id "
					+ "AND ra.darba_veids_id = dv.id AND ra.datortehnika_id = dt.id AND ra.klients_id = ? "
					+ "AND ra.tehnikis_id = ? AND ra.datortehnika_id = ? AND ra.serialais_numurs = ? "
					+ "AND ra.datums = ?";
			
			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, klientsID);
			ps.setInt(2, tehnikisID);
			ps.setInt(3, datortehnikaID);
			ps.setString(4, serialaisNumurs);
			ps.setDate(5, Date.valueOf(datums));
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				remontaAkts.setProblema(rs.getString(4));
				remontaAkts.setSerialaisNumurs(rs.getString(6));
				remontaAkts.setPiezimes(rs.getString(7));
				remontaAkts.setTransports(rs.getDouble(8));
				remontaAkts.setDarbaIlgums(rs.getDouble(9));
				remontaAkts.setDarbaApraksts(rs.getString(6));
				remontaAkts.setDatums(rs.getString(7));
				remontaAkts.setDatortehnika(datortehnikaDB.getDatortehnikaByID(rs.getInt(4)));
				remontaAkts.setDarbaVeids(darbaVeidsDB.getDarbaVeidsByID(rs.getInt(3)));
				remontaAkts.setKlients(personaDB.getPersonaByID(rs.getInt(1)));
				remontaAkts.setTehnikis(personaDB.getPersonaByID(rs.getInt(2)));
			}
			return remontaAkts;
		}else {
			return null;
		}
	}
	
	public int getRemontaAktsID(String kVards, String kUzvards, String tVards, String tUzvards, 
			String datortehnika, Date datums) throws SQLException {
		int remontsAktsID = -1, klientsID = -1, tehnikisID = -1, datortehnikaID = -1;
		
		PersonaDB personaDB = new PersonaDB();
		DatortehnikaDB datortehnikaDB = new DatortehnikaDB();
		
		klientsID = personaDB.getPersonaID(kVards, kUzvards);
		tehnikisID = personaDB.getPersonaID(tVards, tUzvards);
		datortehnikaID = datortehnikaDB.getDatortehnikaID(datortehnika);
		
		if(klientsID != -1 && tehnikisID != -1 && datortehnikaID != -1) {
			String sql = "SELECT id FROM remonta_akti WHERE klients_id = ? AND tehnikis_id = ? "
					+ "AND datortehnika_id = ? AND datums = ?;";
			ps = Connect.connection.prepareStatement(sql);
			ps.setInt(1, klientsID);
			ps.setInt(2, tehnikisID);
			ps.setInt(3, datortehnikaID);
			ps.setDate(4, datums);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				remontsAktsID = rs.getInt(1);
			}
			
			return remontsAktsID;
		}else {
			return -1;
		}
	}
}