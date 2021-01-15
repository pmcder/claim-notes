package services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoteRepServiceTest {

	@Test
	void test() {
		
		NoteRepService noteRepService = new NoteRepService();
		
		assertEquals("Patrick Ramirez", noteRepService.getAuthorByNoteId(1));
	}

}
