package com.github.sechols223.capibara.logging;

import com.intellij.openapi.diagnostic.Logger;


public class CapiLogger {
	private final Logger Log;
	public CapiLogger(String className) {
		Log = Logger.getInstance(className);
	}

	public void logResourceError() {
		Log.error("Capibara resources could not be fetched from the server.");
	}
	public void logResourceError(Exception exception) {
		Log.error("Capibara resources could not be fetched from the server.", exception);
	}
	public void logError(String message) {
		Log.error(message);
	}
	public void logError(String message, Exception exception) {
		Log.error(message, exception);
	}
	public void log(String message) {
		Log.info(message);
	}
	public void logWarning(String message) {
		Log.warn(message);
	}
	public void logWarning(String message, Throwable throwable) {
		Log.warn(message, throwable);
	}
}
