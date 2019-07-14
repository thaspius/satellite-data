package org.demo.satellite.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.satellite.models.client.Satellite;
import org.demo.satellite.service.SatelliteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Resource routing for satellite API methods
 * 
 * @author Jarrod Sears
 *
 */
@Path("/satellites")
@Component
public class SatelliteResource
{
    Logger logger = LoggerFactory.getLogger(SatelliteResource.class);
    
    @Autowired
    SatelliteService satelliteService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Satellite> getAll()
    {
        return this.satelliteService.getAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Satellite get(@PathParam("id") Long id)
    {
        logger.debug("Request for Satellite with ID: " + id);
        return this.satelliteService.get(id);
    }
}
