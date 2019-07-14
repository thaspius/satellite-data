package org.demo.satellite.models.csv;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.demo.satellite.models.db.IngestDetailModel;
import org.demo.satellite.models.db.SatelliteMeasurementModel;
import org.demo.satellite.models.db.SatelliteModel;
import org.demo.satellite.repository.SatelliteMeasurementRepository;
import org.demo.satellite.repository.SatelliteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SatelliteMeasurementCsvFactory
{
    private Logger logger = LoggerFactory.getLogger(SatelliteMeasurementCsvFactory.class);
    
    @Autowired
    SatelliteRepository satelliteRepository;
    
    @Autowired
    SatelliteMeasurementRepository satelliteMeasurementRepository;
    
    public SatelliteMeasurementModel createFromSatelliteMeasurementCsv(String[] inputStrings, IngestDetailModel ingestDetail)
    {
        SatelliteMeasurementModel result = null;
        
        String satNumber = inputStrings[0];
        String timestampString = inputStrings[1];
        String ionoIndexString = inputStrings[2];
        String ndviIndexString = inputStrings[3];
        String radiationIndexString = inputStrings[4];
        String specificMeasurementString = inputStrings[5];
        
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date timestamp = null;
        try
        {
            timestamp = format.parse(timestampString);
        }
        catch (ParseException e)
        {
            logger.error("Error while parsing timestamp: " + timestampString, e);
            return null;
        }
        
        SatelliteModel satellite = this.satelliteRepository.findSatelliteBySatNumber(satNumber);
        
        if (satellite != null)
        {
            SatelliteMeasurementCsv measurementCsv = null;
            if (satellite.getSpecificMeasurement().equals(SatelliteModel.TYPE_EARTH_ALTITUDE))
            {
                measurementCsv = new EarthAltitudeSatelliteMeasurement();
            }
            else if (satellite.getSpecificMeasurement().equals(SatelliteModel.TYPE_SEA_SALINITY))
            {
                measurementCsv = new SeaSalinitySatelliteMeasurement();
            }
            else if (satellite.getSpecificMeasurement().equals(SatelliteModel.TYPE_VEGETATION_CLASSIFICATION))
            {
                measurementCsv = new VegetationClassificationSatelliteMeasurement();
            }
            else
            {
                logger.error("Unknown Satellite Measurement Type: " + satellite.getSpecificMeasurement());
                return null;
            }
            
            measurementCsv.setSatellite(satellite);
            measurementCsv.setTimestamp(timestamp);
            measurementCsv.setIonoIndex(Integer.parseInt(ionoIndexString));
            measurementCsv.setNdviIndex(Integer.parseInt(ndviIndexString));
            measurementCsv.setRadiationIndex(new BigDecimal(radiationIndexString));
            measurementCsv.setSpecificMeasurement(specificMeasurementString);
            
            result = measurementCsv.convertToModel();
            result.setIngestDetail(ingestDetail);
            
            try
            {
                this.satelliteMeasurementRepository.save(result);
                logger.info("Record saved for  sat " + satellite.getName() + " at time " + timestampString);
            }
            catch(BeanCreationException e)
            {
                logger.error("Error while saving record for sat " + satellite.getName() + " at time " + timestampString);
            }
        }
        
        return result;
    }
}
