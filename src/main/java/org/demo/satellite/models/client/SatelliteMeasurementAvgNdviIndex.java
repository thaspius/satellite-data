package org.demo.satellite.models.client;

import java.math.BigDecimal;

public class SatelliteMeasurementAvgNdviIndex extends SatelliteMeasurementBaseAvgMetric
{
    private BigDecimal avgNdviIndex;
    
    public SatelliteMeasurementAvgNdviIndex(String satelliteName, BigDecimal avgNdviIndex)
    {
        this.satelliteName = satelliteName;
        this.avgNdviIndex = avgNdviIndex;
    }

    @Override
    public BigDecimal getAvgMetric()
    {
        return this.avgNdviIndex;
    }
}
