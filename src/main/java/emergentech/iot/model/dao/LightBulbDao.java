package emergentech.iot.model.dao;

import emergentech.iot.model.LightBulb;

public interface LightBulbDao {
	public LightBulb createLightBulb(boolean isOn);
	public LightBulb readLightBulb(int id);
	public LightBulb updateLightBulb(int id, boolean isOn);
	public void deleteLightBulb(int id);
}