package display;


import javax.swing.JFrame;

public class AddNoteFrame extends JFrame  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Container frame for AddNote component.
	 */
	public AddNoteFrame(long claimId) {
		
		super("Add Note");
		
		setSize(250, 250); 
		
		getContentPane().add(new AddNote(claimId,this));
		
	}

}
