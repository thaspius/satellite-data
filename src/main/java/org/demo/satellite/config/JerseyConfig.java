package org.demo.satellite.config;

import org.demo.satellite.resource.SatelliteMeasurementResource;
import org.demo.satellite.resource.SatelliteResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(SatelliteResource.class);
        register(SatelliteMeasurementResource.class);
    }
}
