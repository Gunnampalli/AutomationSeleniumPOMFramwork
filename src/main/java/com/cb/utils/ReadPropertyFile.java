package com.cb.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.cb.constants.FrameworkConstants;
import com.cb.enums.ConfigProperties;
import com.cb.exceptions.PropertyFileValueException;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	static Properties property = new Properties();
	static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());) {

			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {

				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key)  {
		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase())) {
			throw new PropertyFileValueException("Property name " + key + " not found.please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());

	}

	public static String getValue(String key)  {

		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new PropertyFileValueException("Property name " + key + " not found.please check config.properties");
		}

		return property.getProperty(key);
	}
}
