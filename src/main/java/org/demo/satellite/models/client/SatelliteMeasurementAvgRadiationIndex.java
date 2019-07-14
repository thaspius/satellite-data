package org.demo.satellite.models.client;

import java.math.BigDecimal;

public class SatelliteMeasurementAvgRadiationIndex extends SatelliteMeasurementBaseAvgMetric
{
    private BigDecimal avgRadiationIndex;
    
    public SatelliteMeasurementAvgRadiationIndex(String satelliteName, BigDecimal avgRadiationIndex)
    {
        this.satelliteName = satelliteName;
        this.avgRadiationIndex = avgRadiationIndex;
    }
    
    @Override
    public BigDecimal getAvgMetric()
    {
        return this.avgRadiationIndex;
    }
}
