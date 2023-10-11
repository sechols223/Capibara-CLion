package com.github.sechols223.capibara.config;

import com.intellij.ide.util.PropertiesComponent;

public class Settings {

	private static final PropertiesComponent INSTANCE = PropertiesComponent.getInstance();

	public static void set(String key, String value) {
		INSTANCE.setValue(key, value);
	}

	public static String get(String key) {
		return INSTANCE.getValue(key);
	}
}
