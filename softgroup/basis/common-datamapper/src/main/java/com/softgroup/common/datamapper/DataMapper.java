package com.softgroup.common.datamapper;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.Map;

/**
 * @author vlischyshyn
 */
public interface DataMapper {

	Map<String, Object> convertToMap(Object value);

	<T> T convert(Map<String, Object> map, Class<T> dataType);

	<T> T convert(Map<String, Object> map, TypeReference<?> dataType);

	<T> T mapData(String data, Class<T> dataType);

	<T> T mapData(String data, TypeReference<?> dataType);

	<T> T mapData(byte[] message, Class<T> dataType);

	<T> T readValue(InputStream src, Class<T> valueType);

	<T> String dataToString(T data);

	String objectToString(Object data);

}
