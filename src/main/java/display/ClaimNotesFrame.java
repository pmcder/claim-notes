package display;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ClaimNotesFrame extends JFrame {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel toolsPanel = new JPanel();
      
      private JComboBox<String> repMenu = new JComboBox();
      
      private NotePanelFactory notePanelFactory = new NotePanelFactory();
      
      private JButton addButton = new JButton("add");
      
      private JButton editButton = new JButton("edit");
      
      private JButton goButton = new JButton("go");
      
      private JPanel jpanel;
      
      private JScrollPane scrollableTextArea;
	
    public ClaimNotesFrame() {
	
        super("Claim Notes");  
                    
        setSize(500, 500);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            
    	//tools panel
		toolsPanel.setLayout(new GridLayout());
		toolsPanel.add(new JRadioButton("1 - Filter"));
		toolsPanel.add(new JRadioButton("2 - Find"));
		toolsPanel.add(repMenu);
		toolsPanel.add(goButton);
		toolsPanel.add(addButton);
		toolsPanel.add(editButton);
			
		jpanel = notePanelFactory.getClaimNotePanel(1);
        
        scrollableTextArea = new JScrollPane(jpanel); 
       
        //use flag here or use state pattern to prevent more than one add windown opening
        ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==addButton) {
				 AddNoteFrame addNoteFrame = new AddNoteFrame(1);
				 addNoteFrame.setVisible(true);
				return;
				}
				if (e.getSource()==goButton) {}
				refresh();
				//SwingUtilities.invokeLater(new Runnable() {
				//   public void run() {
				//      refresh();
				// }});
				
			}};
		addButton.addActionListener(actionListener);
	    goButton.addActionListener(actionListener);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        getContentPane().add(toolsPanel);
        getContentPane().add(scrollableTextArea);  
        pack();
    }
    
    public void refresh() {
    	scrollableTextArea.remove(jpanel);
    	JPanel jp = this.notePanelFactory.getClaimNotePanel(1);
    	scrollableTextArea.add(jp);
    	
    	SwingUtilities.invokeLater(new Runnable() {
    		
			   public void run() {
				   scrollableTextArea.revalidate();
				   revalidate();
			    	
			  }});
    	
    	
    }

}
