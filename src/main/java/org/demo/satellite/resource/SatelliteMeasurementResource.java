package org.demo.satellite.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.satellite.models.client.SatelliteMeasurement;
import org.demo.satellite.models.db.SatelliteMeasurementTimeProjection;
import org.demo.satellite.service.SatelliteMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/satelliteMeasurements")
@Component
public class SatelliteMeasurementResource
{
    @Autowired
    SatelliteMeasurementService satelliteMeasurementService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SatelliteMeasurement> getAll()
    {
        return this.satelliteMeasurementService.getAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteTime")
    public Collection<SatelliteMeasurementTimeProjection> get()
    {
        return this.satelliteMeasurementService.getSatellitesTime();
    }
}
