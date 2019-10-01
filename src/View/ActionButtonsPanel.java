/**
 * 
 */
package View;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * @author somme
 *
 */
public class ActionButtonsPanel extends JPanel implements ActionListener{
	private JButton loginButton;
	private JButton statusButton;
	// this could be a listener that outputs information to the status bar
	private StringListener textListener;
	private LogInEventListener loginEventListener;
	private GetStatusListener getStatusListener;

	/**
	 * 
	 */
	public ActionButtonsPanel() {
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		loginButton = new JButton("&Login");
		statusButton = new JButton("&Get Status");
		
		loginButton.addActionListener(this);
		statusButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(loginButton);
		add(statusButton);
	}

	/**
	 * @param arg0
	 */
	public ActionButtonsPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ActionButtonsPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ActionButtonsPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
	 */
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}
	
	public void setLoginEventListener(LogInEventListener loginEventListener) {
		this.loginEventListener = loginEventListener;
		
	}
	
	public void setGetStatusListener(GetStatusListener getStatusListener) {
		
	}
	
	@Override
	/*
	 * This is a main concept of decoupling communications in Swing where the events are loosely coupled with the receivers of those
	 * events. The action button panel knows that events are routed to listeners, but not necessarily what is done when those listeners 
	 * are called. All listener events are routed back to the AppJFrame, there they are then routed to the correct receiver.
	 */
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) event.getSource();
		if (clicked == loginButton) {
			if (textListener != null) {
				//really, this should be changed to a listener for a login event
				textListener.textEmitted("Log In Event Sent ... waiting ...");
			}
		} else if (clicked == statusButton) {
			if (textListener != null) {
				//really, this should be changed to a listener for a get status event
				textListener.textEmitted("Get Status Event Sent ... waiting ...");
				
			}
		}
		
	}

}
