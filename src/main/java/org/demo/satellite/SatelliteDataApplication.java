package org.demo.satellite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.demo.satellite.models.csv.SatelliteMeasurementCsvFactory;
import org.demo.satellite.models.db.IngestDetailModel;
import org.demo.satellite.repository.IngestDetailRepository;
import org.demo.satellite.repository.SatelliteMeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SatelliteDataApplication
{
    private Logger logger = LoggerFactory.getLogger(SatelliteDataApplication.class);
    
    private final String SEMICOLON_DELIMITER = ";";
    private final String HEADER_FIRST_ELEMENT = "idSat";

    @Value("${satellite.measurements.file:C/data.txt}")
    private String satelliteMeasurmentsFileName;
    
    @Autowired
    SatelliteMeasurementCsvFactory measureFactory;

    @Autowired
    SatelliteMeasurementRepository satelliteMeasurementRepository;
    
    @Autowired
    IngestDetailRepository ingestDetailRepository;
    
    public SatelliteDataApplication()
    {
        logger.info("Initializing Satellite Data Application...");
    }
    
    @PostConstruct 
    public void importSatelliteMeasurements()
    {
        logger.info("Emptying out existing satellite measurement records for new import.");
        this.satelliteMeasurementRepository.deleteAll();
        
        Date fileIngestStartedAt = new Date();
        
        IngestDetailModel ingestDetail = new IngestDetailModel();
        ingestDetail.setFileName(satelliteMeasurmentsFileName);
        ingestDetail.setStartedAt(fileIngestStartedAt);
        this.ingestDetailRepository.save(ingestDetail);
        
        logger.info("Reading from satellite measurements file: " + satelliteMeasurmentsFileName);
        try (BufferedReader br = new BufferedReader(new FileReader(satelliteMeasurmentsFileName)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(SEMICOLON_DELIMITER);
                
                // check if the line is the headers line and if it is, skip it
                if (values.length == 6)
                {
                    if (values[0].equals(HEADER_FIRST_ELEMENT))
                    {
                        continue;
                    }
                    measureFactory.createFromSatelliteMeasurementCsv(values, ingestDetail);
                }
                else
                {
                    logger.error("Line has an incorrect number of parameters: " + line);
                }
            }
        }
        catch (IOException ioe)
        {
            logger.error("IO Exception while reading file: " + satelliteMeasurmentsFileName, ioe);
        }
        
        Date fileIngestCompletedAt = new Date();
        ingestDetail.setCompletedAt(fileIngestCompletedAt);
        this.ingestDetailRepository.save(ingestDetail);
    }
    
    public static void main(String[] args)
    {
        SpringApplication.run(SatelliteDataApplication.class, args);
    }
    
}
