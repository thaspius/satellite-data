package org.demo.satellite.models.client;

import java.math.BigDecimal;

/**
 * 
 * @author thaspius
 *
 */
public class SatelliteMeasurementAvgIonosphereIndex extends SatelliteMeasurementBaseAvgMetric
{
    private BigDecimal avgIonosphereIndex;
    
    public SatelliteMeasurementAvgIonosphereIndex(String satelliteName, BigDecimal avgIonosphereIndex)
    {
        this.satelliteName = satelliteName;
        this.avgIonosphereIndex = avgIonosphereIndex;
    }
    
    @Override
    public BigDecimal getAvgMetric()
    {
        return this.avgIonosphereIndex;
    }
}
