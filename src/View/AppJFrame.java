/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author somme
 *
 */
public class AppJFrame extends JFrame {
	private TextJPanel textPanel;
	private ActionButtonsPanel actionButtonsPanel;
	private StatusBarPanel statusBarPanel;
	private CameraControlPanel cameraControl;
	private FormPanel formPanel;

	/**
	 * @throws HeadlessException
	 */
	public AppJFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param gc
	 */
	public AppJFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public AppJFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setSize(1000, 400);
		setMinimumSize(new Dimension(1000, 400));
		textPanel = new TextJPanel();
		actionButtonsPanel = new ActionButtonsPanel();
		statusBarPanel = new StatusBarPanel();
		//cameraController = new CameraControl();
		formPanel = new FormPanel();
		actionButtonsPanel.setStringListener(new StringListener() {
			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				statusBarPanel.appendText(text, StatusBarPanel.POSITION.CENTER);
			}			
		});
		
		setJMenuBar(this.createMenuBar());
		
		
		CameraControlPanel cameraControl = new CameraControlPanel("Primary Camera Controller");
		FormChangeListener formChangeListener = new FormChangeListener() {
			@Override
			public void formEventOccurred(FormChangeEvent ev) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String name = ev.getName();
				String setting = ev.getSetting();
				String command = ev.getCommand();
				String lighting = ev.getLightingMode();
				textPanel.appendText(name + ": " + setting + ": " + command + ":" + lighting + "\n");
			}

			@Override
			public void formEventOccurred(FormEvent ev) {
				// TODO Auto-generated method stub				
			}
		};
		
		
		add(actionButtonsPanel, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(statusBarPanel, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);
		add(cameraControl, BorderLayout.EAST);
		
		FormListener formListener = new FormListener() {
			public void formEventOccurred(FormEvent ev) {
				String name = ev.getName();
				String setting = ev.getSetting();
				String ageCategory = ev.getAgeCategory();
				textPanel.appendText(name + ": " + setting + " " + ageCategory + "\n");
			}
		};
		
		formPanel.setFormListener(formListener);
		cameraControl.setFormListener(formChangeListener);
		/*
		 * formPanel.setFormListener(new FormListener() { public void
		 * formEventOccurred(FormEvent ev) { String name = ev.getName(); String setting
		 * = ev.getSetting(); String ageCategory = ev.getAgeCategory();
		 * textPanel.appendText(name + ": " + setting + " " + ageCategory + "\n"); } });
		 */
		
		// what action is taken when the "x" is clicked on the window frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * @param title
	 * @param gc
	 */
	public AppJFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");
		
		
		// By declaring this as a final variable, it can be referenced inside the action  listener.
		final JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		fileMenu.add(exitItem);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		return menuBar;
	}

}
