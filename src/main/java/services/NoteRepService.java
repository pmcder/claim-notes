package services;

import entities.ClaimNote;
import entities.Rep;
import repositories.ClaimNoteRepository;
import repositories.RepRepository;

public class NoteRepService {
	
	private ClaimNoteRepository claimNoteRepository;
	
	private RepRepository repRepository;
	
	public NoteRepService() {
		this.claimNoteRepository = new ClaimNoteRepository();
		this.repRepository = new RepRepository();
	}
	
	/**
	 * Returns the reps name that authored the note.
	 * @param claimNoteId to search
	 * @return the rep's first and last name as a String
	 */
	public String getAuthorByNoteId(long claimNoteId) {
		StringBuilder authorName = new StringBuilder();
		ClaimNote claimNote = this.claimNoteRepository.findById(claimNoteId);
		Rep rep = this.repRepository.findById(claimNote.getRepId());
		authorName.append(rep.getFirstName()+" ");
		authorName.append(rep.getLastName());
		return authorName.toString();
	}
}
