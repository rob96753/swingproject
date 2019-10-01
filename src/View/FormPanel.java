/**
 * 
 */
package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author somme
 *
 */
public class FormPanel extends JPanel {
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JList ageCategories;

	/**
	 * 
	 */
	public FormPanel() {
		// preferred size communicates the preferred size to the contrainer manager
		Dimension dimension = getPreferredSize();
		dimension.width = 250;
		setPreferredSize(dimension);
		
		
		nameLabel = new JLabel("Name:");
		occupationLabel = new JLabel("Occupation:");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		okBtn = new JButton("OK");
		
		// call the main frame indirectly by event registration.
		okBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCategory = (AgeCategory) ageCategories.getSelectedValue();
				// getting the string that's displayed 
				FormEvent formEvent = new FormEvent(this, name, occupation, ageCategory.getCategory());
				
				if (formListener != null) {
					formListener.formEventOccurred(formEvent);
				}
			}
		});
		
		ageCategories = new JList();
		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<AgeCategory>();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "Over 65"));
		ageCategories.setPreferredSize(new Dimension(110, 66));
		ageCategories.setBorder(BorderFactory.createEtchedBorder());
		ageCategories.setModel(ageModel);
		ageCategories.setSelectedIndex(0);
		
		Border insideBorder = BorderFactory.createTitledBorder("Add Person");
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		Insets no_inset = new Insets(0, 0, 0, 0); 
		
		///////////////////// FIRST ROW ///////////////////////
		gc.weightx = 1; // how much area the cell takes up
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
				
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = no_inset;
		add(nameField);
		
		///////////////////// SECOND ROW ///////////////////////
		gc.weightx = 1; // how much area the cell takes up
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = no_inset;
		add(occupationField, gc);
			
		////////////////////// THIRD ROW ////////////////////////
		gc.weightx = 1; // how much area the cell takes up
		gc.weighty = 0.2;	
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = no_inset;
		add(ageCategories, gc);
		
		//////////////////////FORTH ROW ////////////////////////
		gc.weightx = 1; // how much area the cell takes up
		gc.weighty = 3.0;	
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = no_inset;
		add(okBtn, gc);
		
		
		
	}

	/**
	 * @param arg0
	 */
	public FormPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public FormPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public FormPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public void setFormListener(FormListener formListener) { 
		this.formListener = formListener;
	}

}

class AgeCategory {
	private int id;
	private String category;
	
	public AgeCategory(int id, String category) {
		this.id = id;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		return this.category;
	}
	
	
}
