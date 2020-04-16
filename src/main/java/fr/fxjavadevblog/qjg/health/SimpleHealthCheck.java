package fr.fxjavadevblog.qjg.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/**
 * Simple Health Check.
 * 
 * @author François-Xavier Robin
 *
 */

@Liveness
@ApplicationScoped
public class SimpleHealthCheck implements HealthCheck
{
    @Override
    public HealthCheckResponse call()
    {
       return HealthCheckResponse.up("Application");
    }
}
