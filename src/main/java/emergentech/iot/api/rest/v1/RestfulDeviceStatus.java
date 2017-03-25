package emergentech.iot.api.rest.v1;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import emergentech.iot.model.LightBulb;
import emergentech.iot.model.dao.LightBulbDao;

@Path("/deviceStatus")
public class RestfulDeviceStatus {
	
	LightBulbDao lightBulbDao;

	
	public RestfulDeviceStatus() {
		lightBulbDao = (LightBulbDao)new emergentech.iot.model.dao.impl.mysql.LightBulbDaoImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeviceStatus() {
		LightBulb sampleDevice = new LightBulb();
		sampleDevice.setId(1);
		sampleDevice.setOnStatus(false);
		return Response.status(200).entity(sampleDevice).build();
	}
	
	@GET
	@Path("/{deviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeviceStatus(@PathParam("deviceId") Integer deviceId) {
		if(deviceId == null) {
			return Response.status(400).build();
		} else {
			LightBulb requestedDevice = lightBulbDao.readLightBulb(deviceId);
			if(requestedDevice == null) {
				return Response.status(404).build();
			}
			return Response.status(200).entity(requestedDevice).build();
		}
	}
	
	@POST
	@Path("/{deviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDeviceStatus(@PathParam("deviceId") Integer id, @FormParam("isOn") Boolean isOn) {
		if(id == null || isOn == null) {
			return Response.status(400).build();
		} else {
			LightBulb requestedDevice = lightBulbDao.updateLightBulb(id, isOn);
			return Response.status(200).entity(requestedDevice).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewDeviceStatus(@FormParam("isOn") Boolean isOn) {
		if(isOn == null) {
			return Response.status(400).build();
		} else {
			LightBulb requestedDevice = lightBulbDao.createLightBulb(isOn);
			return Response.status(200).entity(requestedDevice).build();
		}
	}
}
