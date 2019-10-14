package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private JRadioButton rdoInfraRed;
	private JRadioButton rdoNaturalLight;
	private JRadioButton rdoNightVision;
	private ButtonGroup lightingGroup;
	
	private JCheckBox chkAudioOn;
	private JLabel lblAudioOn;


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
						String lightingMode = lightingGroup.getSelection().getActionCommand();
						FormChangeEvent ev = new FormChangeEvent(obj, name, setting, command, lightingMode);
						

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
		
		zoomPanel.add(lblZoom);
		zoomPanel.add(zoom, 20, 10);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		Insets no_inset = new Insets(0, 0, 0, 0); 
		
		// radio buttons
		rdoInfraRed = new JRadioButton("Infra-Red");
		rdoInfraRed.setActionCommand("INFRARED");
		rdoNaturalLight = new JRadioButton("Natural");
		rdoNaturalLight.setActionCommand("NATURAL");
		rdoNightVision = new JRadioButton("Night Vision");
		rdoNightVision.setActionCommand("NIGHT_VISION");
		lightingGroup = new ButtonGroup();

		lightingGroup.add(rdoNaturalLight);
		lightingGroup.add(rdoInfraRed);
		lightingGroup.add(rdoNightVision);
		
		rdoNaturalLight.setSelected(true);
		
		JRadioPanel pnlLighting = new JRadioPanel("Lighting");
		
		pnlLighting.add(rdoNaturalLight);
		pnlLighting.add(rdoInfraRed);
		pnlLighting.add(rdoNightVision);
		
		chkAudioOn = new JCheckBox("Audio");
		chkAudioOn.setSelected(false); // this should actually get the status from the camera
		lblAudioOn = new JLabel("OFF");
		chkAudioOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
			}
		});
		
		chkAudioOn.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				// TODO Auto-generated method stub
				lblAudioOn.setText(String.format("%s", (ie.getStateChange() == ItemEvent.SELECTED)?"ON":"OFF"));
			}
			
		});

		///////////////////// FIRST ROW/3rd Column ///////////////////////
		gc.weightx = 1; // how much area the cell takes up
		gc.weighty = .2;
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(3, 3, 3, 3);
		add(panPanel, gc);
		
		gc.weightx = .2; // how much area the cell takes up
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 3;
		gc.fill = GridBagConstraints.VERTICAL;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(tiltPanel, gc);
		
		gc.weightx = .2; // how much area the cell takes up
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 3;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(zoomPanel, gc);
		
		gc.weightx = .2; // how much area the cell takes up
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(pnlLighting, gc);
		
		JPanel audioControlPanel = new JPanel();
		audioControlPanel.setLayout(new FlowLayout());
		audioControlPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		audioControlPanel.add(chkAudioOn);
		audioControlPanel.add(lblAudioOn);
		
		
		gc.weightx = .2; // how much area the cell takes up
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.gridx = 2;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(audioControlPanel, gc);
		
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
