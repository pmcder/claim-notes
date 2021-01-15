package display;

import javax.swing.SwingUtilities;

public class DisplayMain {
	
    private static final long serialVersionUID = 1L;  
    
    /**
     * 
     * The main method launches the application and creates a Claim Notes GUI.
     * @param args not used.
     */
    public static void main(String[] args) {
    	
    	
    	
    	SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	ClaimNotesFrame claimNotesFrame = new ClaimNotesFrame();
		    }});
    }
}
