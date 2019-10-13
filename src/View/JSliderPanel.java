/**
 * 
 */
package View;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author rob
 *
 */
@SuppressWarnings("serial")
public class JSliderPanel extends JPanel {
	private String title;
	public JSliderPanel(String title, int orientation) {
		Dimension dim = getPreferredSize();
		if (orientation == JSlider.HORIZONTAL) {
			dim.width = 130;
			dim.height = 80;
		} else {
			dim.width = 80;
			dim.height = 200;}
		
		setPreferredSize(dim);
		
		Border insideBorder = BorderFactory.createTitledBorder(title);
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void setLables(ArrayList <Integer> values, ArrayList<JLabel> labels) throws Exception {
		Hashtable <Integer, JLabel> hashTable = new Hashtable <Integer, JLabel>();
		if (values.size() != labels.size()) {
			throw new Exception("Values List and Labels List aren't of equal length");
		}
		for (int i= 0; i < values.size(); i++) {
			hashTable.put(values.get(i), labels.get(i));
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
}
