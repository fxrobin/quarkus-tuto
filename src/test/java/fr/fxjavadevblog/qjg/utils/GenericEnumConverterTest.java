package fr.fxjavadevblog.qjg.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.ext.ParamConverter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.fxjavadevblog.qjg.global.TestingGroups;

@Tag(TestingGroups.UNIT_TESTING)
class GenericEnumConverterTest
{
    public enum DummyEnum
    {
        @JsonProperty("value-1")
        VALUE_1,

        @JsonProperty("value-2")
        VALUE_2,

        @JsonProperty("value-3")
        VALUE_3,

        @JsonProperty("value-4")
        VALUE_4,

        @JsonProperty("value-5")
        VALUE_5;
    }

    static private ParamConverter<DummyEnum> converter;
    
    @BeforeAll
    static void init()
    {
        converter = GenericEnumConverter.of(DummyEnum.class);
    }
    
    
    @Test
    @DisplayName("Enum to Json via GenericEnumConverter")
    void testEnumToJson()
    {
        assertEquals("value-1", converter.toString(DummyEnum.VALUE_1));
        assertEquals("value-2", converter.toString(DummyEnum.VALUE_2));
        assertEquals("value-3", converter.toString(DummyEnum.VALUE_3));
        assertEquals("value-4", converter.toString(DummyEnum.VALUE_4));
        assertEquals("value-5", converter.toString(DummyEnum.VALUE_5));
    }

    @Test
    @DisplayName("Json to Enum via GenericEnumConverter")
    void testJsonToEnum()
    {
        assertEquals(DummyEnum.VALUE_1, converter.fromString("value-1"));
        assertEquals(DummyEnum.VALUE_2, converter.fromString("value-2"));
        assertEquals(DummyEnum.VALUE_3, converter.fromString("value-3"));
        assertEquals(DummyEnum.VALUE_4, converter.fromString("value-4"));
        assertEquals(DummyEnum.VALUE_5, converter.fromString("value-5"));
    }

}
