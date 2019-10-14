/**
 * 
 */
package View;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author rob
 *
 */
@SuppressWarnings("serial")
public class JRadioPanel extends JPanel {
	public JRadioPanel(String title) {
		Dimension dim = getPreferredSize();
		dim.width = 200;
		dim.height = 130;
		setPreferredSize(dim);
		
		Border insideBorder = BorderFactory.createTitledBorder(title);
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
