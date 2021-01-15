package services;

import java.util.List;
import entities.ClaimNote;
import repositories.ClaimNoteRepository;
import utils.TimeUtils;


public class ClaimNoteService {
	
	private ClaimNoteRepository claimNoteRepository;
	
	public ClaimNoteService() {
		this.claimNoteRepository = new ClaimNoteRepository();
	}
	
	public List<ClaimNote> getNotesByClaimId(long claimId) {
		List<ClaimNote> claimNoteList = this.claimNoteRepository.findAllByClaimId(claimId);
		claimNoteList.forEach(c ->{
			if(TimeUtils.isOver24Hours(c.getCreatedAt())) {
				c.setEditable(false);
				claimNoteRepository.update(c);;
			}
		});
		return claimNoteList;
	}
	
	public Long getLastId(long claimId) {
		return this.claimNoteRepository.findAllByClaimId(claimId).get(0).getNoteId();
	}
	
	public void updateClaimNote(ClaimNote claimNote) {
		this.claimNoteRepository.update(claimNote);
	}
	
	public void save(ClaimNote claimNote) {
		this.claimNoteRepository.save(claimNote);
	}
	
	

}
