/*
 * DateSerializer.java
 *
 * Created on 12-02-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados 
 *
 */

package com.proj.wsf.core.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Description the class  DateSerializer - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/02/2019
 */
public class DateSerializer implements JsonSerializer<Date> {

    public JsonElement serialize(Date date, Type typeOfSrc,
            JsonSerializationContext context) {
        return date == null ? null : new JsonPrimitive(date.getTime());
    }
}
