package emergentech.iot.model;

public class LightBulb {
	
	private boolean isOnStatus;
	
	public LightBulb(boolean isOn) {
		this.isOnStatus = isOn;
	}
	
	public void setOnStatus(boolean isOn) {
		this.isOnStatus = isOn;
	}
	
	public boolean getOnStatus() {
		return isOnStatus;
	}

}
