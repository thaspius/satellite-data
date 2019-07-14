package org.demo.satellite.models.csv;

import java.math.BigDecimal;

import org.demo.satellite.models.db.SatelliteMeasurementModel;
public class SeaSalinitySatelliteMeasurement extends BaseSatelliteMeasurement
{
    BigDecimal seaSalinity;

    @Override
    public void setSpecificMeasurement(String specificMeasurement)
    {
        this.seaSalinity = new BigDecimal(specificMeasurement);
    }

    @Override
    public SatelliteMeasurementModel addSpecificMeasurementToConvertedModel(SatelliteMeasurementModel model)
    {
        model.setSeaSalinity(this.seaSalinity);
        return model;
    }
    
}
