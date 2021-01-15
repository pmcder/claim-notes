package claimNoteSystem;

import display.NotePanelFactory;
import entities.Claim;
import repositories.ClaimRepository;

public class ClaimNoteSystem {
	
	private Claim claim;
	
	private NotePanelFactory notePanelFactory = new NotePanelFactory();
	
	
	public ClaimNoteSystem() {
		
	}
	
	public Claim getClaim() {
		return claim;
	}
	
	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public NotePanelFactory getNotePanelFactory() {
		return notePanelFactory;
	}

	public void setNotePanelFactory(NotePanelFactory notePanelFactory) {
		this.notePanelFactory = notePanelFactory;
	}
	
	
}
