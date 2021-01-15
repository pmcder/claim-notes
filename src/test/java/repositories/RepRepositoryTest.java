package repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.Rep;

class RepRepositoryTest {

	@Test
	void test() {
		
		/*
		 * There is an rep in the db with 
		 * id 1, first name Patrick last name Ramirez
		 */
		RepRepository repRepository = new RepRepository();
		
		Rep testRep = repRepository.findById(1);
		
		assertEquals(1, testRep.getRepId());
		assertEquals("Patrick", testRep.getFirstName());
		assertEquals("Ramirez", testRep.getLastName());
	}

}
