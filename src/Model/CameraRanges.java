/**
 * 
 */
package Model;

/**
 * @author somme
 *
 */
public abstract class CameraRanges {
	private double maxPanRight;
	private double maxPanLeft;
	private double maxTiltUp;
	private double maxTiltDown;
	private double maxZoomIn;
	private double maxZoomOut;
	
	/**
	 * 
	 */
	public CameraRanges() {
		// TODO Auto-generated constructor stub
	}
	
	public CameraRanges(String jsonSpecification) {
		
	}

	public double getMaxPanRight() {
		return maxPanRight;
	}

	public void setMaxPanRight(double maxPanRight) {
		this.maxPanRight = maxPanRight;
	}

	public double getMaxPanLeft() {
		return maxPanLeft;
	}

	public void setMaxPanLeft(double maxPanLeft) {
		this.maxPanLeft = maxPanLeft;
	}

	public double getMaxTiltUp() {
		return maxTiltUp;
	}

	public void setMaxTiltUp(double maxTiltUp) {
		this.maxTiltUp = maxTiltUp;
	}

	public double getMaxTiltDown() {
		return maxTiltDown;
	}

	public void setMaxTiltDown(double maxTiltDown) {
		this.maxTiltDown = maxTiltDown;
	}

	public double getMaxZoomIn() {
		return maxZoomIn;
	}

	public void setMaxZoomIn(double maxZoomIn) {
		this.maxZoomIn = maxZoomIn;
	}

	public double getMaxZoomOut() {
		return maxZoomOut;
	}

	public void setMaxZoomOut(double maxZoomOut) {
		this.maxZoomOut = maxZoomOut;
	}

}
