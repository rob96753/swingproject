/**
 * 
 */
package View;

import java.util.EventObject;

/**
 * @author somme
 *
 */
public class FormEvent extends EventObject {
	private String name;
	private String setting;
	private String ageCategory;
	private String command;

	/**
	 * @param arg0
	 */
	public FormEvent(Object eventSource) {
		super(eventSource);
		
	}
	
	public FormEvent(Object eventSource, String name, String setting, String ageCategory) {
		super(eventSource);
		this.name = name;
		this.setting = setting;
		this.ageCategory = ageCategory;
	}
	
	
	public FormEvent(Object eventSource, String name, String setting, String command, Object extraData) {
		super(eventSource);
		this.name = name;
		this.setting = setting;
		this.command = command;
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

	public String getAgeCategory() {
		// TODO Auto-generated method stub
		return this.ageCategory;
	}

}
