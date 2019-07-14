package org.demo.satellite.models.csv;

import java.math.BigDecimal;
import java.util.Date;

import org.demo.satellite.models.db.SatelliteMeasurementModel;
import org.demo.satellite.models.db.SatelliteModel;

public interface SatelliteMeasurementCsv
{    
    public SatelliteMeasurementModel convertToModel();
    
    /**
     * Key to adding the specific measurement for the satellite to the output DB model
     * @param model
     * @return
     */
    public SatelliteMeasurementModel addSpecificMeasurementToConvertedModel(SatelliteMeasurementModel model);
    
    public void setSatellite(SatelliteModel satellite);
    public void setTimestamp(Date timestamp);
    public void setIonoIndex(Integer ionoIndex);
    public void setNdviIndex(Integer ndviIndex);
    public void setRadiationIndex(BigDecimal radiationIndex);
    
    /**
     * Key to adding the specific measurement for the satellite to the specific CSV Class
     * @param model
     * @return
     */
    public void setSpecificMeasurement(String specificMeasurement);
}
