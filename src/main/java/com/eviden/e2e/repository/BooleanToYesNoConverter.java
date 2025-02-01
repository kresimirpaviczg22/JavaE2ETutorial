package com.eviden.e2e.repository;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanToYesNoConverter implements AttributeConverter<Boolean, String>{

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return (attribute != null && attribute) ? "Yes" : "No"; 
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return  "Yes".equalsIgnoreCase(dbData);
	}

}
