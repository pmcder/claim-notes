package repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class CategoryRepositoryTest {

	@Test
	void test() throws SQLException {
	
		CategoryRepository categoryRepository = new CategoryRepository();
		
		String categoryName = categoryRepository.findById(4).getCategoryName();
		
		assertEquals(4, categoryRepository.findIdByCategoryName(categoryName));
		
	}

}
