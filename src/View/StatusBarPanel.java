/**
 * 
 */
package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * @author somme
 *
 */


public class StatusBarPanel extends JPanel {
	public enum POSITION { LEFT, 
							CENTER, 
							RIGHT
						  };
						  
	final static int itemHeight = 40;
	final static int innerItemHeight = 32;
	
	
	
	JLabel lblLeftStatus;
	JLabel lblCenterStatus;
	JLabel lblRightStatus;
		
	/**
	 * 
	 */
	public StatusBarPanel() {
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		
		Dimension dim = getPreferredSize();
		dim.height = itemHeight;
		setPreferredSize(dim);
		
		lblLeftStatus = new JLabel();
		
		lblCenterStatus = new JLabel();
		
		lblRightStatus = new JLabel();
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		gc.weightx = 5; // how much area the cell takes up
		gc.weighty = 1;
		gc.gridx = 2;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_END;
		add(lblRightStatus, gc);
		gc.weightx = 2; // how much area the cell takes up
		gc.gridx = 1;
		add(lblCenterStatus, gc);
		gc.weightx = 4; // how much area the cell takes up
		gc.gridx = 0;
		add(lblLeftStatus, gc);	
	}
	
	public void appendText(String text) {
		appendText(text, POSITION.CENTER);
	}
	
	public void appendText(String text, POSITION position) {
		if (position == POSITION.CENTER) {
			this.lblCenterStatus.setText(text);
		} else if (position == POSITION.LEFT) {
			this.lblLeftStatus.setText(text);
		} else if (position == POSITION.RIGHT) {
			this.lblRightStatus.setText(text);
		}
	}

	/**
	 * @param layout
	 */
	public StatusBarPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public StatusBarPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public StatusBarPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
