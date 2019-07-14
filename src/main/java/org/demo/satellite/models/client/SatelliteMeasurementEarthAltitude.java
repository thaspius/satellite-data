package org.demo.satellite.models.client;

import java.math.BigDecimal;
import java.util.Date;

/**
 * View object specifically for Earth altitude satellite measurements
 * 
 * @author Jarrod Sears
 *
 */
public class SatelliteMeasurementEarthAltitude
{
    Date timestamp;
    String satelliteName;
    BigDecimal earthAltitude;
    
    public SatelliteMeasurementEarthAltitude(Date timestamp, String satelliteName, BigDecimal earthAltitude)
    {
        this.timestamp = timestamp;
        this.satelliteName = satelliteName;
        this.earthAltitude = earthAltitude;
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
    
    public BigDecimal getEarthAltitude()
    {
        return earthAltitude;
    }
    
    public void setEarthAltitude(BigDecimal earthAltitude)
    {
        this.earthAltitude = earthAltitude;
    }
}
