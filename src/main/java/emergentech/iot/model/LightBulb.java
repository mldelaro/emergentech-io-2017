package emergentech.iot.model;

public class LightBulb {
	
	private Boolean isOnStatus;
	private Integer id;
	
	public LightBulb(Integer id, Boolean isOn) {
		this.id = id;
		isOnStatus = isOn;
	}
	
	public LightBulb() {
		this.id = 0;
		isOnStatus = false;
	}
	
	public void setOnStatus(Boolean isOn) {
		this.isOnStatus = isOn;
	}
	
	public Boolean getOnStatus() {
		return isOnStatus;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

}
