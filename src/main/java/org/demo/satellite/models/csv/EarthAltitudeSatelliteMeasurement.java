package org.demo.satellite.models.csv;

import java.math.BigDecimal;

import org.demo.satellite.models.db.SatelliteMeasurementModel;

public class EarthAltitudeSatelliteMeasurement extends BaseSatelliteMeasurement
{
    private BigDecimal earthAltitude;

    @Override
    public void setSpecificMeasurement(String specificMeasurement)
    {
        this.earthAltitude = new BigDecimal(specificMeasurement);
    }

    @Override
    public SatelliteMeasurementModel addSpecificMeasurementToConvertedModel(SatelliteMeasurementModel model)
    {
        model.setEarthAltitude(this.earthAltitude);
        return model;
    }
    
}
