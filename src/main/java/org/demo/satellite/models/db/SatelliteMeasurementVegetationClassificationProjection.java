package org.demo.satellite.models.db;

import java.math.BigDecimal;

/**
 * Projection used to get percent per vegetation classification that was
 * recorded by the satellite in the target zone
 * 
 * @author Jarrod Sears
 *
 */
public interface SatelliteMeasurementVegetationClassificationProjection
{
    String getSatelliteName();
    
    Long getSatelliteId();
    
    String getVegetationClassification();
    
    Long getTotalVegetation();
    
    Long getCountPerClassification();
    
    BigDecimal getClassificationPercent();
}
