package emergentech.iot.api.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import emergentech.iot.model.LightBulb;

@Path("/deviceStatus")
public class RestfulDeviceStatus {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeviceStatus() {
		LightBulb sampleDevice = new LightBulb(false);
		return Response.status(200).entity(sampleDevice).build();
	}
}
