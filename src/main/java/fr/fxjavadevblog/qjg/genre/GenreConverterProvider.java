package fr.fxjavadevblog.qjg.genre;

import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

/**
 * JAW-RS provider for Genre convertion. 
 * 
 * <p>Examples :</p> 
 * 
 * <pre>
 * "ARCADE" <-> "arcade"
 * "SHOOT_THEM_UP" <-> "shoot-them.up"
 * </pre>
 * 
 * @author robin
 *
 */

@Provider
public class GenreConverterProvider implements ParamConverterProvider
{
    private final Logger log = LoggerFactory.getLogger(GenreConverterProvider.class);
    private final GenreConverter converter = new GenreConverter();
    
    public class GenreConverter implements ParamConverter<Genre>
    {
        private final Logger log = LoggerFactory.getLogger(GenreConverter.class);

        @Override
        public Genre fromString(String value)
        {
            log.debug("Converting String {} to Genre", value);
            value = value.toUpperCase().replace('-', '_');
            return Genre.valueOf(value);
        }

        @Override
        public String toString(Genre value)
        {
            log.debug("Converting Genre {} to String", value);
            return value.toString().toLowerCase().replace('_', '-');
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations)
    {
       log.debug("Registering GenreConverter"); 
       return (Genre.class.equals(rawType)) ? (ParamConverter<T>) converter : null;
    }
}
