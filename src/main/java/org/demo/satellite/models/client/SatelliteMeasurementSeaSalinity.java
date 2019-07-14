package org.demo.satellite.models.client;

import java.math.BigDecimal;
import java.util.Date;

public class SatelliteMeasurementSeaSalinity
{
    Date timestamp;
    String satelliteName;
    BigDecimal seaSalinity;
    
    public SatelliteMeasurementSeaSalinity(Date timestamp, String satelliteName, BigDecimal seaSalinity)
    {
        this.timestamp = timestamp;
        this.satelliteName = satelliteName;
        this.seaSalinity = seaSalinity;
    }
    
    public Date getTimestamp()
    {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public String getSatelliteName()
    {
        return satelliteName;
    }
    
    public void setSatelliteName(String satelliteName)
    {
        this.satelliteName = satelliteName;
    }
    
    public BigDecimal getSeaSalinity()
    {
        return seaSalinity;
    }
    
    public void setSeaSalinity(BigDecimal seaSalinity)
    {
        this.seaSalinity = seaSalinity;
    }
    
}
