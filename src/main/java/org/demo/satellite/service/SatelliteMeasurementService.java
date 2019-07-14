package org.demo.satellite.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.demo.satellite.models.client.SatelliteMeasurement;
import org.demo.satellite.models.client.SatelliteMeasurementAvgIonosphereIndex;
import org.demo.satellite.models.client.SatelliteMeasurementAvgNdviIndex;
import org.demo.satellite.models.client.SatelliteMeasurementAvgRadiationIndex;
import org.demo.satellite.models.client.SatelliteMeasurementBaseAvgMetric;
import org.demo.satellite.models.client.SatelliteMeasurementCommonMetrics;
import org.demo.satellite.models.client.SatelliteMeasurementEarthAltitude;
import org.demo.satellite.models.client.SatelliteMeasurementSeaSalinity;
import org.demo.satellite.models.client.SatelliteMeasurementTime;
import org.demo.satellite.models.client.SatelliteMeasurementVegetationClassification;
import org.demo.satellite.models.db.SatelliteMeasurementCommonMetricsProjection;
import org.demo.satellite.models.db.SatelliteMeasurementEarthAltitudeProjection;
import org.demo.satellite.models.db.SatelliteMeasurementModel;
import org.demo.satellite.models.db.SatelliteMeasurementSeaSalinityProjection;
import org.demo.satellite.models.db.SatelliteMeasurementTimeProjection;
import org.demo.satellite.models.db.SatelliteMeasurementVegetationClassificationProjection;
import org.demo.satellite.repository.SatelliteMeasurementRepository;
import org.demo.satellite.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide Services related to Satellite Measurements
 * 
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
     * 
     * @return
     */
    public Collection<SatelliteMeasurement> getAll()
    {
        return this.modelToClient(this.satelliteMeasurementRepository.findAll());
    }
    
    /**
     * Convert Satellite Measurement model to display object
     * 
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
     * 
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
     * 
     * @return
     */
    public Collection<SatelliteMeasurementTime> getSatellitesTime()
    {
        Collection<SatelliteMeasurementTimeProjection> projections = this.satelliteMeasurementRepository
                .findSatelliteMeasurementTime();
        
        Collection<SatelliteMeasurementTime> result = new ArrayList<>();
        
        projections.forEach(projection -> result
                .add(new SatelliteMeasurementTime(projection.getSatelliteName(), projection.getTimeInMinutes())));
        
        return result;
    }
    
    /**
     * Create satellite measurement avg/min/max values for measurements that are
     * common across all satellites and convert to display objects
     * 
     * @return
     */
    public Collection<SatelliteMeasurementCommonMetrics> getSatelliteMeasurementCommonMetrics()
    {
        Collection<SatelliteMeasurementCommonMetrics> result = new ArrayList<>();
        
        Collection<SatelliteMeasurementCommonMetricsProjection> projections = this.satelliteMeasurementRepository
                .findSatelliteMeasurementCommonMetrics();
        
        // loop over common metrics and generate display objects
        for (SatelliteMeasurementCommonMetricsProjection projection : projections)
        {
            SatelliteMeasurementCommonMetrics metric = new SatelliteMeasurementCommonMetrics(
                    projection.getMinIonosphereIndex(), projection.getMaxIonosphereIndex(),
                    projection.getAvgIonosphereIndex(), projection.getMinNdviIndex(), projection.getMaxNdviIndex(),
                    projection.getAvgNdviIndex(), projection.getMinRadiationIndex(), projection.getMaxRadiationIndex(),
                    projection.getAvgRadiationIndex(), projection.getSatelliteName());
            result.add(metric);
        }
        
        return result;
    }
    
    /**
     * Create Satellite Measurement objects for displaying Earth altitude graph
     * over time.
     * 
     * @return
     */
    public Collection<SatelliteMeasurementEarthAltitude> getSatelliteMeasurementEarthAltitude()
    {
        Collection<SatelliteMeasurementEarthAltitude> result = new ArrayList<>();
        
        Collection<SatelliteMeasurementEarthAltitudeProjection> projections = this.satelliteMeasurementRepository
                .findSatelliteMeasurementEarthAltitude();
        
        for (SatelliteMeasurementEarthAltitudeProjection projection : projections)
        {
            SatelliteMeasurementEarthAltitude metric = new SatelliteMeasurementEarthAltitude(projection.getTimestamp(),
                    projection.getSatelliteName(), projection.getEarthAltitude());
            result.add(metric);
        }
        
        return result;
    }
    
    /**
     * Create Satellite Measurement objects for displaying Earth altitude graph
     * over time.
     * 
     * @return
     */
    public Collection<SatelliteMeasurementSeaSalinity> getSatelliteMeasurementSeaSalinity()
    {
        Collection<SatelliteMeasurementSeaSalinity> result = new ArrayList<>();
        
        Collection<SatelliteMeasurementSeaSalinityProjection> projections = this.satelliteMeasurementRepository
                .findSatelliteMeasurementSeaSalinity();
        
        for (SatelliteMeasurementSeaSalinityProjection projection : projections)
        {
            SatelliteMeasurementSeaSalinity metric = new SatelliteMeasurementSeaSalinity(projection.getTimestamp(),
                    projection.getSatelliteName(), projection.getSeaSalinity());
            result.add(metric);
        }
        
        return result;
    }
    
    /**
     * Create Satellite Measurement objects for displaying percent vegetation
     * classification per classification while satellite recorded measurements
     * in the target zone
     * 
     * @return
     */
    public Collection<SatelliteMeasurementVegetationClassification> getSatelliteMeasurementVegetationClassification()
    {
        Collection<SatelliteMeasurementVegetationClassification> result = new ArrayList<>();
        
        Collection<SatelliteMeasurementVegetationClassificationProjection> projections = this.satelliteMeasurementRepository
                .findSatelliteMeasurementVegetationClassification();
        
        for (SatelliteMeasurementVegetationClassificationProjection projection : projections)
        {
            SatelliteMeasurementVegetationClassification metric = new SatelliteMeasurementVegetationClassification(
                    projection.getSatelliteName(), projection.getVegetationClassification(),
                    projection.getClassificationPercent());
            result.add(metric);
        }
        
        return result;
    }
    
    /**
     * Create satellite measurement Averages per satellite and convert to
     * display format
     * 
     * @return
     */
    public Map<String, Collection<SatelliteMeasurementBaseAvgMetric>> getSatelliteMeasurementAvgMetricsSorted()
    {
        Map<String, Collection<SatelliteMeasurementBaseAvgMetric>> result = new HashMap<>();
        
        Collection<SatelliteMeasurementCommonMetrics> commonMetrics = this.getSatelliteMeasurementCommonMetrics();
        
        List<SatelliteMeasurementBaseAvgMetric> avgIonosphereIndices = new ArrayList<>();
        List<SatelliteMeasurementBaseAvgMetric> avgNdviIndices = new ArrayList<>();
        List<SatelliteMeasurementBaseAvgMetric> avgRadiationIndices = new ArrayList<>();
        
        // loop over common metrics and generate display objects for just AVG
        // metrics
        for (SatelliteMeasurementCommonMetrics commonMetric : commonMetrics)
        {
            SatelliteMeasurementAvgIonosphereIndex avgIonosphereIndex = new SatelliteMeasurementAvgIonosphereIndex(
                    commonMetric.getSatelliteName(), commonMetric.getAvgIonosphereIndex());
            avgIonosphereIndices.add(avgIonosphereIndex);
            
            SatelliteMeasurementAvgNdviIndex avgNdviIndex = new SatelliteMeasurementAvgNdviIndex(
                    commonMetric.getSatelliteName(), commonMetric.getAvgNdviIndex());
            avgNdviIndices.add(avgNdviIndex);
            
            SatelliteMeasurementAvgRadiationIndex avgRadiationIndex = new SatelliteMeasurementAvgRadiationIndex(
                    commonMetric.getSatelliteName(), commonMetric.getAvgRadiationIndex());
            avgRadiationIndices.add(avgRadiationIndex);
        }
        
        // Sort each of the indices Arrays
        Collections.sort(avgIonosphereIndices, Collections.reverseOrder());
        Collections.sort(avgNdviIndices, Collections.reverseOrder());
        Collections.sort(avgRadiationIndices, Collections.reverseOrder());
        
        result.put("Average Ionosphere Index", avgIonosphereIndices);
        result.put("Average NDVI Index", avgNdviIndices);
        result.put("Average Radiation Index", avgRadiationIndices);
        
        return result;
    }
}
