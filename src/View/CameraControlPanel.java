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
		
		Hashtable <Integer, JLabel>panLabelTable = new <Integer, JLabel>Hashtable();
		panLabelTable.put(0, new JLabel("-180°"));
		panLabelTable.put(90, new JLabel(" -90°"));
		panLabelTable.put(180, new JLabel("   0°"));
		panLabelTable.put(270, new JLabel("  90°"));
		panLabelTable.put(360, new JLabel(" 180°"));
		pan = new JSlider(JSlider.HORIZONTAL,0, 360, 180);
		pan.setLabelTable(panLabelTable);
		tilt = new JSlider(JSlider.VERTICAL, 0, 180, 90);
		Hashtable <Integer, JLabel>tiltLabelTable = new <Integer, JLabel>Hashtable();
		tiltLabelTable.put(0, new JLabel("-90\u00B0"));
		tiltLabelTable.put(45, new JLabel("-45\u00B0"));
		tiltLabelTable.put(90, new JLabel("  0\u00B0"));
		tiltLabelTable.put(135, new JLabel(" 45\u00B0"));
		tiltLabelTable.put(180, new JLabel(" 90\u00B0"));
		tilt.setLabelTable(tiltLabelTable);
		//labelTable.clear();
		Hashtable <Integer, JLabel>zoomLabelTable = new <Integer, JLabel>Hashtable();
		zoomLabelTable.put(0, new JLabel(" 0x"));
		zoomLabelTable.put(5, new JLabel(" 5x"));
		zoomLabelTable.put(10, new JLabel("10x"));
		zoomLabelTable.put(15, new JLabel("15x"));
		zoomLabelTable.put(20, new JLabel("20x"));
		zoom = new JSlider(JSlider.VERTICAL,0, 20, 0);
		zoom.setLabelTable(zoomLabelTable);
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
		panPanel.add(pan, 20, 10);
		
		tiltPanel.add(lblTilt);
		tiltPanel.add(tilt, 20, 10);
		
		zoomPanel.add(zoom, 20, 10);
		zoomPanel.add(lblZoom);

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
