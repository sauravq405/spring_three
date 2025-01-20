package com.pract.spring3.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.text.DecimalFormat;

public class CustomDoubleSerializer extends JsonSerializer<Double> {

    private static final DecimalFormat df = new DecimalFormat("#.00");

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeString(df.format(value));  // Format the salary as a string without scientific notation
        } else {
            gen.writeNull();
        }
    }
}
