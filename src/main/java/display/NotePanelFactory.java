package display;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import entities.ClaimNote;
import services.ClaimNoteService;
import utils.TimeUtils;

public class NotePanelFactory {
	
	ClaimNoteService claimNoteService;
	
	public NotePanelFactory() {
		this.claimNoteService = new ClaimNoteService();
	}
	
	/**
	 * Creates a claimNotePanel object populated 
	 * with NotePanes of the claim_notes for the claimId passed as an argument.
	 * Each claimNote is checked to see if over 24 hours old and if so the pane will
	 * not have a check box to select for editing.
	 * @param claimId the claimId for the claim to get notes for.
	 * @return a JPanel of notePanes with a vertical BoxLayout.
	 */
	public JPanel getClaimNotePanel(long claimId) {
		JPanel claimNotePanel = new JPanel();
		claimNotePanel.setLayout(new BoxLayout(claimNotePanel, BoxLayout.Y_AXIS));
		List<ClaimNote> claimNotesList = this.claimNoteService.getNotesByClaimId(claimId);
		claimNotesList.forEach(c -> {
			if(TimeUtils.isOver24Hours(c.getCreatedAt())) {
				c.setEditable(false); 
				this.claimNoteService.updateClaimNote(c);
			}
			claimNotePanel.add(new NotePane(c));
		});
		return claimNotePanel;
	}
}
