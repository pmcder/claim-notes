package display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import entities.ClaimNote;
import repositories.CategoryRepository;
import services.NoteRepService;

/**
 * This class extends Jpanel and
 * is the component that contains 
 * all the display and data of each claim note.
 * @author patrickmcdermott
 *
 */
public class NotePane extends JPanel implements ActionListener{
	
	private final JTextArea headerTextArea = new JTextArea();
	
	ClaimNote claimNote;
	
	NoteRepService noteRepService;
	
	JCheckBox checkBox = new JCheckBox();
	
	JPanel headerFrame = new JPanel();
	
	CategoryRepository categoryRepository = new CategoryRepository();
	
	/**
	 * Displays a ClaimNote.
	 * @param claimNote to be displayed
	 */
	public NotePane(ClaimNote claimNote) {
		
		this.claimNote = claimNote;
		this.noteRepService = new NoteRepService();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		checkBox.setSize(5,10);
		checkBox.addActionListener(this);
		
		//header frame
		headerFrame.setSize(10, 10);
		headerFrame.setLayout(new BoxLayout(headerFrame, BoxLayout.X_AXIS));
		if (this.claimNote.isEditable()) {
			headerFrame.add(checkBox);
			}
		headerFrame.add(headerTextArea);
		//header text
		String headerText = null;
		try {
			headerText = String.format("%s %s%n%s%s", this.categoryRepository.findById(this.claimNote.getCategoryId()).getCategoryName(), this.claimNote
					.getCreatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),"Authored by: ",this.noteRepService
					.getAuthorByNoteId(this.claimNote.getNoteId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//header layout
		headerTextArea.setSize(10,10);
		headerTextArea.setBackground(Color.lightGray);
		headerTextArea.setEditable(false);
		headerTextArea.setText(headerText);
		
		//main text area
		JTextArea jta = new JTextArea(15,15);
		jta.setText(claimNote.getContent());
		jta.setLineWrap(true);
		jta.setEditable(false);
		
		add(headerFrame);
		add(jta);
		
	}

	public ClaimNote getClaimNote() {
		return claimNote;
	}

	public void setClaimNote(ClaimNote claimNote) {
		this.claimNote = claimNote;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
