package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CameraControl extends JPanel {
	private FormChangeListener formListener;

	public CameraControl(String title) {
		// TODO Auto-generated constructor stub
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		
		Border insideBorder = BorderFactory.createTitledBorder(title);
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		
		

		ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(new Integer(0), new Integer(90), new Integer(0),
				new Integer(-90), new Integer(-180)));
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		labels.add(new JLabel("180"));
		labels.add(new JLabel("90"));
		labels.add(new JLabel("0"));
		labels.add(new JLabel("-90"));
		labels.add(new JLabel("-180"));
		
		JSliderPanel panPanel = new JSliderPanel("Pan", "Pan Rotation (degrees)", new JSlider(JSlider.HORIZONTAL,-180, 180, 15));
		JSliderPanel tiltPanel = new JSliderPanel("Tilt", "Tilt Angle\n(degrees)", new JSlider(JSlider.VERTICAL,-180, 180, 15));
		JSliderPanel zoomPanel = new JSliderPanel("Zoom", "Zoom (power)", new JSlider(JSlider.VERTICAL,0, 20, 4));
		try {
			panPanel.setLables(values, labels);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		Insets no_inset = new Insets(0, 0, 0, 0); 
		
		///////////////////// FIRST ROW/3rd Column ///////////////////////
		gc.weightx = 1; // how much area the cell takes up
		gc.weighty = 4;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 1;
		gc.gridy = 0;
		//add(lblPan, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(panPanel, gc);
		
		///////////////////// FIRST ROW/4TH COLUMN ///////////////////////
		gc.gridx = 2;
		gc.gridy = 0;
		//add(lblTilt, gc);
		gc.gridx = 2;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(tiltPanel, gc);
		
		
		///////////////////// SECOND ROW/3RD COLUMN ///////////////////////
		gc.gridx = 3;
		gc.gridy = 0;
		//add(lblZoom, gc);
		gc.gridx = 3;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(zoomPanel, gc);
		
		
	}

	public CameraControl(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public CameraControl(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public CameraControl(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public FormListener getFormListener() {
		return formListener;
	}

	public void setFormListener(FormChangeListener formListener) {
		this.formListener = formListener;
	}

}
