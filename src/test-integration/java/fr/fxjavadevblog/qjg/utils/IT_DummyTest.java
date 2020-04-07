package fr.fxjavadevblog.qjg.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import fr.fxjavadevblog.qjg.global.TestingGroups;

/**
 * Dummy test.
 * 
 * @author robin
 *
 */
@Tag("integration-testing")
@Tag(TestingGroups.INTEGRATION_TESTING)
class IT_DummyTest
{

    @Test
    void test()
    {
        assertTrue(true);
    }

}
