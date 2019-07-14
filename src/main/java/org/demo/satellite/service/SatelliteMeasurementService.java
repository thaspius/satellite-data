package org.demo.satellite.service;

import java.util.ArrayList;
import java.util.Collection;

import org.demo.satellite.models.client.SatelliteMeasurement;
import org.demo.satellite.models.client.SatelliteMeasurementTime;
import org.demo.satellite.models.db.SatelliteMeasurementModel;
import org.demo.satellite.models.db.SatelliteMeasurementTimeProjection;
import org.demo.satellite.repository.SatelliteMeasurementRepository;
import org.demo.satellite.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide Services related to Satellite Measurements
 * @author Jarrod Sears
 *
 */
@Service
@Transactional
public class SatelliteMeasurementService
{
    @Autowired
    SatelliteMeasurementRepository satelliteMeasurementRepository;
    
    @Autowired
    SatelliteRepository satelliteRepository;
    
    /**
     * Get all satellite measurement objects and return as display objects
     * @return
     */
    public Collection<SatelliteMeasurement> getAll()
    {
        return this.modelToClient(this.satelliteMeasurementRepository.findAll());
    }
    
    /**
     * Convert Satellite Measurement model to display object
     * @param model
     * @return
     */
    private SatelliteMeasurement modelToClient(SatelliteMeasurementModel model)
    {
        SatelliteMeasurement satelliteMeasurement = new SatelliteMeasurement();
        satelliteMeasurement.setId(model.getId());
        satelliteMeasurement.setTimestamp(model.getTimestamp());
        satelliteMeasurement.setIonosphereIndex(model.getIonosphereIndex());
        satelliteMeasurement.setNdviIndex(model.getNdviIndex());
        satelliteMeasurement.setRadiationIndex(model.getRadiationIndex());
        satelliteMeasurement.setSeaSalinity(model.getSeaSalinity());
        satelliteMeasurement.setEarthAltitude(model.getEarthAltitude());
        satelliteMeasurement.setVegetationClassification(model.getVegetationClassification());
        
        return satelliteMeasurement;
    }
    
    /**
     * Convert SatelliteMeasurement model to display objects
     * @param models
     * @return
     */
    private Collection<SatelliteMeasurement> modelToClient(Collection<SatelliteMeasurementModel> models)
    {
        Collection<SatelliteMeasurement> satelliteMeasurments = new ArrayList<SatelliteMeasurement>();
        
        models.forEach(model -> satelliteMeasurments.add(this.modelToClient(model)));
        
        return satelliteMeasurments;
    }
    
    /**
     * Create satellite measurement objects for display 
     * @return
     */
    public Collection<SatelliteMeasurementTime> getSatellitesTime()
    {
        Collection<SatelliteMeasurementTimeProjection> projections = this.satelliteMeasurementRepository.findSatelliteMeasurementTime();
        
        Collection<SatelliteMeasurementTime> result = new ArrayList<>();
        
        projections.forEach(projection -> result.add( new SatelliteMeasurementTime(projection.getSatelliteName(), projection.getTimeInMinutes()) ));
        
        return result;
    }
}
