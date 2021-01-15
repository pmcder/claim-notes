package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import entities.ClaimNote;
import repositories.CategoryRepository;
import services.ClaimNoteService;

public class AddNote extends JPanel implements ActionListener{
	
	JPanel headerPanel = new JPanel();
	
	JTextArea textArea =new JTextArea();
	
	JPanel footerPanel = new JPanel();
	
	JButton okButton = new JButton("OK");
	
	JButton cancelButton = new JButton("Cancel");
	
	JComboBox<String> categoryComboBox;
	
	ClaimNoteService claimNoteService = new ClaimNoteService();
	
	CategoryRepository categoryRepository = new CategoryRepository();
	
	JFrame jframe;
	
	Long claimId;
	
	Long categoryId;
	
	public AddNote(long claimId, JFrame jframe) {
		this.jframe = jframe;
		this.claimId = claimId;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		headerPanel.setSize(10, 10);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
		
		textArea.setSize(20, 20);
		textArea.setLineWrap(true);
		//category menu
		
		
		String [] categoryList =  new String[categoryRepository.findAll().size()];
				categoryRepository.findAll().toArray(categoryList);
		categoryComboBox = new JComboBox<String>(categoryList);
		headerPanel.add(categoryComboBox);
		
		footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.X_AXIS));
		footerPanel.setSize(10,10);
		footerPanel.add(okButton);
		footerPanel.add(cancelButton);
		
		add(headerPanel);
		add(textArea);
		add(footerPanel);
		
		setSize(250,250);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		categoryComboBox.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==okButton){
		ClaimNote claimNote = new ClaimNote(this.claimNoteService.getLastId(claimId) + 1, 1, 1, this.categoryRepository.findIdByCategoryName(categoryComboBox.getSelectedItem().toString()), LocalDateTime.now(), textArea.getText(), true);
		claimNoteService.save(claimNote);
		this.jframe.dispose();
		}
		if (e.getSource()==cancelButton) {
		this.jframe.dispose();
		
		}
	}
}
