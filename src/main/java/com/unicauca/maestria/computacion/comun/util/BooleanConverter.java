package com.unicauca.maestria.computacion.comun.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Boolean b) {
        if (b == null) {
            return null;
        }
        if (b.booleanValue()) {
            return 1;
        }
        return 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer s) {
        if (s == null) {
            return null;
        }
        if (s.equals(1)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
