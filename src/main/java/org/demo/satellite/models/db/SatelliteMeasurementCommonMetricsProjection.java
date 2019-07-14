package org.demo.satellite.models.db;

import java.math.BigDecimal;

public interface SatelliteMeasurementCommonMetricsProjection
{
    public Long getMinIonosphereIndex();
    public Long getMaxIonosphereIndex();
    public BigDecimal getAvgIonosphereIndex();
    
    public Long getMinNdviIndex();
    public Long getMaxNdviIndex();
    public BigDecimal getAvgNdviIndex();
    
    public BigDecimal getMinRadiationIndex();
    public BigDecimal getMaxRadiationIndex();
    public BigDecimal getAvgRadiationIndex();
    
    public Long getSatelliteId();
    public String getSatelliteName();
}
