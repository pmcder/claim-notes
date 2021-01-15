package repositories;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import entities.ClaimNote;

class ClaimNoteRepositoryTest {

	@Test
	void test() {
		
		ClaimNoteRepository claimNoteRepository = new ClaimNoteRepository();
		
		ClaimNote testClaimNote = new ClaimNote(1, 1, 1, 4, LocalDateTime.now(), "reviewed p/r. iv had green light", true);
		
		//claimNoteRepository.save(testClaimNote);
		
		assertEquals(testClaimNote.getNoteId(), claimNoteRepository.findById(testClaimNote.getNoteId()).getNoteId());
		
	}
	
	@Test
	void findAllByClaimIdTest() {
		
		ClaimNoteRepository claimNoteRepository = new ClaimNoteRepository();
		
		ClaimNote testClaimNote = new ClaimNote(5, 1, 1, 2, LocalDateTime.now(), "called ruby. told her I love how sexy her voice is", true);
		claimNoteRepository.save(testClaimNote);
		
		assertEquals(5, claimNoteRepository.findAllByClaimId(1).size());
		
	}

}
