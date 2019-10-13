package View;

import java.awt.BorderLayout;
import java.awt.Component;
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

@SuppressWarnings("serial")
public class CameraControlPanel extends JPanel {
	private JSlider pan;
	private JSlider tilt;
	private JSlider zoom;
	private JLabel lblPan;
	private JLabel lblTilt;
	private JLabel lblZoom;
	private FormChangeListener formListener;


	public CameraControlPanel(String title) {
		// TODO Auto-generated constructor stub
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		
		Border insideBorder = BorderFactory.createTitledBorder(title);
		Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		
		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("180"));
		labelTable.put(new Integer(90), new JLabel("90"));
		labelTable.put(new Integer(180), new JLabel("0"));
		labelTable.put(new Integer(-90), new JLabel("-90"));
		labelTable.put(new Integer(-180), new JLabel("-80"));

		pan = new JSlider(JSlider.HORIZONTAL,-180, 180, 15);
		pan.setLabelTable(labelTable);
		tilt = new JSlider(JSlider.VERTICAL,-180, 180, 15);
		tilt.setLabelTable(labelTable);
		zoom = new JSlider(JSlider.VERTICAL,0, 20, 15);
		zoom.setLabelTable(labelTable);
		lblPan = new JLabel("Pan Rotation (degrees)");
		lblTilt = new JLabel("Tilt Angle\n(degrees)");
		lblZoom = new JLabel("Zoom (power)"); 

		// call the main frame indirectly by event registration.		
		ChangeListener changeListener = new ChangeListener(){
					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
						Object obj = e.getSource();
						String name = (obj.equals(pan)) ? "pan": ((obj.equals(tilt))? "tilt": "zoom");
						String setting = String.valueOf(((JSlider) obj).getValue());
						String command = String.format("Change-%s",name);
						FormChangeEvent ev = new FormChangeEvent(obj, name, setting, command);

						if (formListener != null) {
							formListener.formEventOccurred((FormChangeEvent) ev);
						}
					}
				};

		pan.addChangeListener(changeListener);
		tilt.addChangeListener(changeListener);
		zoom.addChangeListener(changeListener);
		JSliderPanel panPanel = new JSliderPanel("Camera Pan", JSlider.HORIZONTAL); 
		JSliderPanel tiltPanel = new JSliderPanel("Camera Tilt", JSlider.VERTICAL);
		JSliderPanel zoomPanel = new JSliderPanel("Camera Zoom", JSlider.VERTICAL);
		panPanel.add(lblPan);
		panPanel.add(pan);
		
		tiltPanel.add(lblTilt);
		tiltPanel.add(tilt);
		
		zoomPanel.add(lblZoom);
		zoomPanel.add(zoom);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		Insets no_inset = new Insets(0, 0, 0, 0); 

		///////////////////// FIRST ROW/3rd Column ///////////////////////
		gc.weightx = 8; // how much area the cell takes up
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(panPanel, gc);
		
		gc.weightx = 2; // how much area the cell takes up
		gc.weighty = 4;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(tiltPanel, gc);
		
		gc.weightx = 2; // how much area the cell takes up
		gc.weighty = 4;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(zoomPanel, gc);
		
		
	}

	public CameraControlPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public CameraControlPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public CameraControlPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void setFormListener(FormChangeListener formListener) {
		this.formListener = formListener;
	}
}
