package fr.fxjavadevblog.qjg.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.qjg.videogame.VideoGame;
import fr.fxjavadevblog.qjg.videogame.VideoGameFactory;
import io.quarkus.test.junit.QuarkusTest;

/**
 * vérification du comportement de CDI.
 * 
 * @author robin
 *
 */

@QuarkusTest
class CDITest
{
    private static final Pattern uuidPattern = Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})");

    
    // Testing @InjectedUUID
    @Inject
    @InjectedUUID
    String uuid;

    /**
     * test de l'injection de UUID
     */
    @Test
    void testUUID()
    {
        assertNotNull(uuid);
        assertTrue(uuidPattern.asPredicate().test(uuid));
    }
    
    // Testing VideoGame @Dependent
    @Inject
    VideoGame videoGame;
    
    @Test
    void testVideoGameInjection()
    {
        assertNotNull(videoGame);
    }
    

    @Test
    void testVideoGameFactory()
    {
        VideoGame vg = VideoGameFactory.newInstance();
        assertNotNull(vg);
    }

}
