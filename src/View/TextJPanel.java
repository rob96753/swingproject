/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * @author somme
 *
 */
public class TextJPanel extends JPanel {
	private JTextArea textArea;
	/**
	 * 
	 */
	public TextJPanel() {
		// TODO Auto-generated constructor stub
		Border insideBorder = BorderFactory.createLineBorder(Color.GRAY);
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}

	/**
	 * @param arg0
	 */
	public TextJPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public TextJPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public TextJPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
