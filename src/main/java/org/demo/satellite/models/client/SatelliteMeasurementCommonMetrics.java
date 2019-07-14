package org.demo.satellite.models.client;

import java.math.BigDecimal;

public class SatelliteMeasurementCommonMetrics
{
    private Long minIonosphereIndex;
    private Long maxIonosphereIndex;
    private BigDecimal avgIonosphereIndex;
    
    private Long minNdviIndex;
    private Long maxNdviIndex;
    private BigDecimal avgNdviIndex;
    
    private BigDecimal minRadiationIndex;
    private BigDecimal maxRadiationIndex;
    private BigDecimal avgRadiationIndex;
    
    private String satelliteName;
    
    public SatelliteMeasurementCommonMetrics(Long minIonosphereIndex, Long maxIonosphereIndex,
            BigDecimal avgIonosphereIndex, Long minNdviIndex, Long maxNdviIndex, BigDecimal avgNdviIndex,
            BigDecimal minRadiationIndex, BigDecimal maxRadiationIndex, BigDecimal avgRadiationIndex,
            String satelliteName)
    {
        this.minIonosphereIndex = minIonosphereIndex;
        this.maxIonosphereIndex = maxIonosphereIndex;
        this.avgIonosphereIndex = avgIonosphereIndex;
        this.minNdviIndex = minNdviIndex;
        this.maxNdviIndex = maxNdviIndex;
        this.avgNdviIndex = avgNdviIndex;
        this.minRadiationIndex = minRadiationIndex;
        this.maxRadiationIndex = maxRadiationIndex;
        this.avgRadiationIndex = avgRadiationIndex;
        this.satelliteName = satelliteName;
    }
    
    public Long getMinIonosphereIndex()
    {
        return minIonosphereIndex;
    }
    
    public void setMinIonosphereIndex(Long minIonosphereIndex)
    {
        this.minIonosphereIndex = minIonosphereIndex;
    }
    
    public Long getMaxIonosphereIndex()
    {
        return maxIonosphereIndex;
    }
    
    public void setMaxIonosphereIndex(Long maxIonosphereIndex)
    {
        this.maxIonosphereIndex = maxIonosphereIndex;
    }
    
    public BigDecimal getAvgIonosphereIndex()
    {
        return avgIonosphereIndex;
    }
    
    public void setAvgIonosphereIndex(BigDecimal avgIonosphereIndex)
    {
        this.avgIonosphereIndex = avgIonosphereIndex;
    }
    
    public Long getMinNdviIndex()
    {
        return minNdviIndex;
    }
    
    public void setMinNdviIndex(Long minNdviIndex)
    {
        this.minNdviIndex = minNdviIndex;
    }
    
    public Long getMaxNdviIndex()
    {
        return maxNdviIndex;
    }
    
    public void setMaxNdviIndex(Long maxNdviIndex)
    {
        this.maxNdviIndex = maxNdviIndex;
    }
    
    public BigDecimal getAvgNdviIndex()
    {
        return avgNdviIndex;
    }
    
    public void setAvgNdviIndex(BigDecimal avgNdviIndex)
    {
        this.avgNdviIndex = avgNdviIndex;
    }
    
    public BigDecimal getMinRadiationIndex()
    {
        return minRadiationIndex;
    }
    
    public void setMinRadiationIndex(BigDecimal minRadiationIndex)
    {
        this.minRadiationIndex = minRadiationIndex;
    }
    
    public BigDecimal getMaxRadiationIndex()
    {
        return maxRadiationIndex;
    }
    
    public void setMaxRadiationIndex(BigDecimal maxRadiationIndex)
    {
        this.maxRadiationIndex = maxRadiationIndex;
    }
    
    public BigDecimal getAvgRadiationIndex()
    {
        return avgRadiationIndex;
    }
    
    public void setAvgRadiationIndex(BigDecimal avgRadiationIndex)
    {
        this.avgRadiationIndex = avgRadiationIndex;
    }
    
    public String getSatelliteName()
    {
        return satelliteName;
    }
    
    public void setSatelliteName(String satelliteName)
    {
        this.satelliteName = satelliteName;
    }
}
