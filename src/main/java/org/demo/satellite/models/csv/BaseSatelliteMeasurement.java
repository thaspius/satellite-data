package org.demo.satellite.models.csv;

import java.math.BigDecimal;
import java.util.Date;

import org.demo.satellite.models.db.SatelliteMeasurementModel;
import org.demo.satellite.models.db.SatelliteModel;

public abstract class BaseSatelliteMeasurement implements SatelliteMeasurementCsv
{   
    protected Date timestamp;
    protected Integer ionosphereIndex;
    protected Integer ndviIndex;
    protected BigDecimal radiationIndex;
    protected SatelliteModel satellite;
    
    @Override
    public SatelliteMeasurementModel convertToModel()
    {
        SatelliteMeasurementModel result = new SatelliteMeasurementModel();
        result.setTimestamp(this.timestamp);
        result.setIonosphereIndex(this.ionosphereIndex);
        result.setNdviIndex(this.ndviIndex);
        result.setRadiationIndex(this.radiationIndex);
        result.setSatellite(this.satellite);
        
        result = this.addSpecificMeasurementToConvertedModel(result);
        
        return result;
    }
    
    @Override
    public void setSatellite(SatelliteModel satellite)
    {
        this.satellite = satellite;
    }

    @Override
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public void setIonoIndex(Integer ionoIndex)
    {
        this.ionosphereIndex = ionoIndex;
    }

    @Override
    public void setNdviIndex(Integer ndviIndex)
    {
        this.ndviIndex = ndviIndex;
    }

    @Override
    public void setRadiationIndex(BigDecimal radiationIndex)
    {
        this.radiationIndex = radiationIndex;
    }
}
