package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Rep;

public class RepRepository {
	
	private final String URL = "jdbc:postgresql://localhost/claim_notes_db";
	
	private final String findByIdString = "SELECT * FROM reps WHERE rep_id = ?";
	
	private PreparedStatement ps;
	
	private Connection conn;
	
	public RepRepository() {
		
	}
	
	/**
	 * Queries database for a Rep object by repId.
	 * @param repId to search by
	 * @return Rep object with repId passed
	 */
	public Rep findById(long repId) {
		Rep rep = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findByIdString);
			ps.setLong(1, repId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rep = new Rep(rs.getLong(1), rs.getString(2), rs.getString(3));
			conn.close();
		}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		return rep;
	}

}
