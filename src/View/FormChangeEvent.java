/**
 * 
 */
package View;

import java.util.EventObject;

/**
 * @author somme
 *
 */
public class FormChangeEvent extends EventObject {

	private String name;
	private String setting;
	private String command;
	private String lightingMode;
	
	/**
	 * @param source
	 */
	public FormChangeEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public FormChangeEvent(Object eventSource, String name, String setting, String command, String lightingMode) {
		super(eventSource);
		this.name = name;
		this.setting = setting;
		this.command = command;
		this.lightingMode = lightingMode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetting() {
		return setting;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getLightingMode() {
		return lightingMode;
	}

	public void setLightingMode(String lightingMode) {
		this.lightingMode = lightingMode;
	}

}
