package com.agit.entity.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.agit.util.Constantas;
/**
*
* @author Ridwan
*/
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

    /**
     *
     * @param parser
     * @param ctx
     * @return
     * @throws IOException
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    @Override
	public Date deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
		try {
			return Constantas.fdate.parse(parser.getValueAsString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
