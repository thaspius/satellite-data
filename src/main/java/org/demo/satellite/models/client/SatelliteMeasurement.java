package org.demo.satellite.models.client;

import java.math.BigDecimal;
import java.util.Date;

public class SatelliteMeasurement
{
    private Long id;
    private Date timestamp;
    private Integer ionosphereIndex;
    private Integer ndviIndex;
    private BigDecimal radiationIndex;
    private BigDecimal seaSalinity;
    private BigDecimal earthAltitude;
    private String vegetationClassification;
    
    public SatelliteMeasurement()
    {
        
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Date getTimestamp()
    {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public Integer getIonosphereIndex()
    {
        return ionosphereIndex;
    }
    
    public void setIonosphereIndex(Integer ionosphereIndex)
    {
        this.ionosphereIndex = ionosphereIndex;
    }
    
    public Integer getNdviIndex()
    {
        return ndviIndex;
    }
    
    public void setNdviIndex(Integer ndviIndex)
    {
        this.ndviIndex = ndviIndex;
    }
    
    public BigDecimal getRadiationIndex()
    {
        return radiationIndex;
    }
    
    public void setRadiationIndex(BigDecimal radiationIndex)
    {
        this.radiationIndex = radiationIndex;
    }
    
    public BigDecimal getSeaSalinity()
    {
        return seaSalinity;
    }
    
    public void setSeaSalinity(BigDecimal seaSalinity)
    {
        this.seaSalinity = seaSalinity;
    }
    
    public BigDecimal getEarthAltitude()
    {
        return earthAltitude;
    }
    
    public void setEarthAltitude(BigDecimal earthAltitude)
    {
        this.earthAltitude = earthAltitude;
    }
    
    public String getVegetationClassification()
    {
        return vegetationClassification;
    }
    
    public void setVegetationClassification(String vegetationClassification)
    {
        this.vegetationClassification = vegetationClassification;
    }
    
}
