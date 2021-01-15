package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import entities.ClaimNote;


public class ClaimNoteRepository {
	
	private final String URL = "jdbc:postgresql://localhost/claim_notes_db";
	
	private final String findByIdString = "SELECT * FROM claim_notes WHERE note_id = ?";
	
	private final String saveString = "INSERT INTO claim_notes (note_id, rep_id, claim_id, category_id,created_at,content, is_editable) "
			+ "values (?,?,?,?,?,?,?)";
	
	private final String findAllByIdString = "SELECT * FROM claim_notes where claim_id = ? order by created_at DESC";
	
	private final String updateString = "update claim_notes set category_id = ?, content = ?, is_editable = ? where note_id = ?";
	
	private PreparedStatement ps;
	
	private Connection conn;
	
	public ClaimNoteRepository() {
		
	}
	
	public ClaimNote findById(long claimNoteId) {
		ClaimNote claimNote = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findByIdString);
			ps.setLong(1, claimNoteId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			claimNote = new ClaimNote(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4)
					,LocalDateTime.parse(rs.getString(5)), rs.getString(6), rs.getBoolean(7));
			conn.close();
		}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		return claimNote;
	}
	
	public void save(ClaimNote claimNote) {
		System.out.println();
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(saveString);
			ps.setLong(1, claimNote.getNoteId());
			ps.setLong(2, claimNote.getClaimId());
			ps.setLong(3, claimNote.getRepId());
			ps.setLong(4, claimNote.getCategoryId());
			ps.setString(5,String.valueOf(claimNote.getCreatedAt()));
			ps.setString(6, claimNote.getContent());
			ps.setBoolean(7, claimNote.isEditable());
			ps.executeUpdate();
			conn.close();
		}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
	}
	
	public List<ClaimNote> findAllByClaimId(long claimId) {
		List<ClaimNote> claimNoteList = new ArrayList<ClaimNote>();
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findAllByIdString);
			ps.setLong(1, claimId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			ClaimNote claimNote = new ClaimNote(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4)
					,LocalDateTime.parse(rs.getString(5)), rs.getString(6), rs.getBoolean(7));
			claimNoteList.add(claimNote);
			}
			conn.close();
		}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		return claimNoteList;
	}
	
	/**
	 * Updates a claim note. Can only update category_id, content, and is_editable.
	 * other rows cannot be updated.
	 * @param claimNote to be updated.
	 */
	public void update(ClaimNote claimNote) {
		System.out.println();
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(updateString);
			ps.setLong(1, claimNote.getCategoryId());
			ps.setString(2, claimNote.getContent());
			ps.setBoolean(3,claimNote.isEditable());
			ps.setLong(4, claimNote.getClaimId());
			ps.executeUpdate();
			conn.close();
		}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
	}
}
