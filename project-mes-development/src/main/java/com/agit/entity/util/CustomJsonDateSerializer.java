/**
 * 
 */
package com.agit.entity.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.agit.util.Constantas;
/**
*
* @author Ridwan
*/
public class CustomJsonDateSerializer extends JsonSerializer<Date>
{

    /**
     *
     * @param date
     * @param jgen
     * @param sp
     * @throws IOException
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    @Override
    public void serialize(Date date, JsonGenerator jgen, SerializerProvider sp) throws IOException, JsonProcessingException {
    	
        jgen.writeString(Constantas.fdate.format(date).toUpperCase());
    }

	
}
