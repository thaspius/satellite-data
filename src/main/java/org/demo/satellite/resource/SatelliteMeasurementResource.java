package org.demo.satellite.resource;

import java.util.Collection;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.satellite.models.client.SatelliteMeasurement;
import org.demo.satellite.models.client.SatelliteMeasurementBaseAvgMetric;
import org.demo.satellite.models.client.SatelliteMeasurementCommonMetrics;
import org.demo.satellite.models.client.SatelliteMeasurementEarthAltitude;
import org.demo.satellite.models.client.SatelliteMeasurementSeaSalinity;
import org.demo.satellite.models.client.SatelliteMeasurementTime;
import org.demo.satellite.models.client.SatelliteMeasurementVegetationClassification;
import org.demo.satellite.service.SatelliteMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Resource routing for satellite measurement API methods
 * 
 * @author Jarrod Sears
 *
 */
@Path("/satelliteMeasurements")
@Component
public class SatelliteMeasurementResource
{
    @Autowired
    SatelliteMeasurementService satelliteMeasurementService;
    
    /**
     * Return all satellite measurement data
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SatelliteMeasurement> getAll()
    {
        return this.satelliteMeasurementService.getAll();
    }
    
    /**
     * REST API for getting satellite time over target area
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteTime")
    public Collection<SatelliteMeasurementTime> getSatelliteTime()
    {
        return this.satelliteMeasurementService.getSatellitesTime();
    }
    
    /**
     * REST API for getting satellite min/max/avg metrics that are measurements
     * in common for all satellites
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteCommonMetrics")
    public Collection<SatelliteMeasurementCommonMetrics> getSatelliteCommonMetrics()
    {
        return this.satelliteMeasurementService.getSatelliteMeasurementCommonMetrics();
    }
    
    /**
     * REST API for getting satellite measurements for Earth altitude
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteEarthAltitude")
    public Collection<SatelliteMeasurementEarthAltitude> getSatelliteEarthAltitude()
    {
        return this.satelliteMeasurementService.getSatelliteMeasurementEarthAltitude();
    }
    
    /**
     * REST API for getting satellite measurements for Sea Salinity
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteSeaSalinity")
    public Collection<SatelliteMeasurementSeaSalinity> getSatelliteSeaSalinity()
    {
        return this.satelliteMeasurementService.getSatelliteMeasurementSeaSalinity();
    }
    
    /**
     * REST API for getting percent vegetation classification of total records
     * of classification while satellite was recording in the target zone
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteVegetationClassificationPercentages")
    public Collection<SatelliteMeasurementVegetationClassification> getSatelliteVegetationClassificationPercentages()
    {
        return this.satelliteMeasurementService.getSatelliteMeasurementVegetationClassification();
    }
    
    /**
     * REST API for getting percent vegetation classification of total records
     * of classification while satellite was recording in the target zone
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/satelliteMeasurementAveragesSorted")
    public Map<String, Collection<SatelliteMeasurementBaseAvgMetric>> getSatelliteMeasurementAvgMetricsSorted()
    {
        return this.satelliteMeasurementService.getSatelliteMeasurementAvgMetricsSorted();
    }
}
