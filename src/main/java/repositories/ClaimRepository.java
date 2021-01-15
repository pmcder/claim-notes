package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Claim;

public class ClaimRepository {
	
	private final String URL = "jdbc:postgresql://localhost/claim_notes_db";
	
	private final String findByIdString = "SELECT * FROM claims WHERE claim_id = ?";
	
	private PreparedStatement ps;
	
	private Connection conn;
	
	public ClaimRepository() {
		
	}
	
	public Claim findById(long claimId) {
		Claim claim = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findByIdString);
			ps.setLong(1, claimId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			claim = new Claim(rs.getLong(1), rs.getLong(2));
			conn.close();
		}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		return claim;
	}
	
}
