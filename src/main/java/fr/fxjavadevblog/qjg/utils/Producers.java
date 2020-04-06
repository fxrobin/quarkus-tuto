package fr.fxjavadevblog.qjg.utils;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Producers
{
    /**
     * produces randomly generated UUID for primary keys.
     *
     * @return UUID as a HEXA-STRING
     *
     */
    @Produces
    @InjectedUUID
    public String produceUUIDAsString()
    {
        return UUID.randomUUID().toString();
    }
}
