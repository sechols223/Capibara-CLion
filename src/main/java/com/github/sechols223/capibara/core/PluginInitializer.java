package com.github.sechols223.capibara.core;

import com.github.sechols223.capibara.logging.CapiLogger;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PluginInitializer implements StartupActivity {

	private static final CapiLogger logger = new CapiLogger(PluginInitializer.class.getName());
	@Override
	public void runActivity(@NotNull Project project) {
		generateResources();
	}
	private void generateResources() {
		try {

			URL url = new URL("https://capibara.tools/capibara.json");
			URL resUrl = getClass().getClassLoader().getResource("resources");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setDoOutput(true);

			if (connection.getResponseCode() < 400) {

				Path resPath = Paths.get(resUrl.toURI());

				if (!Files.exists(resPath)) {
					Files.createDirectory(resPath);
				}

				Path path = Paths.get("resources/capibara.json");

				Files.deleteIfExists(path);
				Files.copy(connection.getInputStream(), path);

				connection.disconnect();

				logger.log("Capibara resources loaded!");
			} else {
				logger.logResourceError();
			}
		} catch (IOException exception) {
			logger.logResourceError(exception);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}


}
