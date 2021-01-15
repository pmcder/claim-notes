package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClaimNoteServiceTest {

	@Test
	void test() {
		
		ClaimNoteService claimNoteService = new ClaimNoteService();
		
		assertEquals(99, claimNoteService.getLastId(1));
	}

}
