import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import View.AppJFrame;

/**
 * 
 */


/**
 * @author somme
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// make this runnable so it's thread-safe
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JFrame frame = new AppJFrame("Home PTZ Camera Controller");
					
					
				}
			}
		);
	}

}
