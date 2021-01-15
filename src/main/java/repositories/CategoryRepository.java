package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.NoteCategory;

public class CategoryRepository {

	private final String URL = "jdbc:postgresql://localhost/claim_notes_db";
	
	private final String findAllString = "SELECT category_name from note_categories";
	
	private final String findByIdString = "SELECT * FROM note_categories where category_id = ?";
	
	private final String findIdByCategoryName = "SELECT category_id FROM note_categories where category_name = ?";
	
	private PreparedStatement ps;
	
	private Connection conn;
	
	public CategoryRepository() {
		
	}
	
	public List<String> findAll() {
		List<String> categoryStringList = new ArrayList<String>();
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findAllString);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				categoryStringList.add(rs.getString(1));
				
			}
			conn.close();
			}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		
		return categoryStringList;
	}
	
	public NoteCategory findById(long categoryId) throws SQLException {
		
		NoteCategory noteCategory = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findByIdString);
			ps.setLong(1, categoryId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			noteCategory = new NoteCategory(rs.getLong(1), rs.getString(2));
			conn.close();
			}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		finally {
			conn.close();
		}
		return noteCategory;
	}
	
	public Long findIdByCategoryName(String categoryName) {
		
		Long categoryId = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL);
			ps = conn.prepareStatement(findIdByCategoryName);
			ps.setString(1, categoryName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			categoryId = (rs.getLong(1));
			conn.close();
			}
		catch (SQLException s ) {
			s.printStackTrace();
		}
		catch (ClassNotFoundException s) {
			s.printStackTrace();
		}
		return categoryId;
	}
}
