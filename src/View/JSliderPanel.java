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
	private JSlider slider;
	public JSliderPanel(String title, String label , JSlider slider, FormChangeListener formListener) {
		this.slider = slider;
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		
		Border insideBorder = BorderFactory.createTitledBorder(title);
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		this.slider.addChangeListener(this.setChangeListener(formListener, title));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel(label));
		this.add(this.slider);
		
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
	
	public ChangeListener setChangeListener(FormChangeListener formListener, String title) {
		return new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				String name = title;
				String setting = String.valueOf(((JSlider) obj).getValue());
				String command = String.format("Change-%s",name);
				FormChangeEvent ev = new FormChangeEvent(obj, name, setting, command);
				
				if (formListener != null) {
					formListener.formEventOccurred((FormChangeEvent) ev);
				}
			}
		};
	}
	
}
