package com.jogadavelha.utils;

import java.math.BigDecimal;

public class FormatNull {

	public static String String(Object object) {
		if(object == null) 
			return null;
		if(object instanceof String || object instanceof Number)
			return object.toString().isEmpty() ? null : object.toString(); 
		return null;
	}
	
	public static Integer Integer(Object object) {
		if(object == null) 
			return null;
		if(object instanceof Number) 
			return ((Number) object).intValue();
		return null;
	}
	
	public static Short Short(Object object) {
		if(object == null) 
			return null;
		if(object instanceof Number) 
			return ((Number) object).shortValue();
		return null;
	}
	
	public static Double Double(Object object) {
		if(object == null) 
			return null;
		if(object instanceof Number) 
			return ((Number) object).doubleValue();
		return null;
	}
	
	public static BigDecimal BigDecimal(Object object) {
		if(object == null) 
			return null;
		if(object instanceof Number) 
			return ((BigDecimal) object);
		return null;
	}
	
	public static Boolean Boolean(Object object) {
		if(object == null)
			return null;
		if(object instanceof Number)
			return ((Number)object).intValue() == 1 ? true : false;
		return null;
	}
	
	public static String convertMoneyToString(Object object) {
		if(object == null) {
			return null;
		}
		double value = ((Number)object).doubleValue();
		if(value == 0.00 || value == 0.0){
			value = 0.01;
		}
		return String.valueOf(value);
	}
}
