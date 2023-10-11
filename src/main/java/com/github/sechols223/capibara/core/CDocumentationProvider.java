package com.github.sechols223.capibara.core;

import com.github.sechols223.capibara.logging.CapiLogger;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import com.jetbrains.cidr.lang.psi.impl.OCDirectiveImpl;
import com.jetbrains.cidr.lang.psi.impl.OCIncludeDirectiveImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CDocumentationProvider extends AbstractDocumentationProvider {

	@Override
	public @Nullable String generateDoc(@NotNull PsiElement element, @Nullable PsiElement originalElement) {

		CapiLogger logger = new CapiLogger(CDocumentationProvider.class.getName());
		StringBuilder documentation = new StringBuilder();

		if (element instanceof OCIncludeDirectiveImpl) {
			try (InputStream stream = getClass().getClassLoader().getResourceAsStream("capibara.json")) {
				if (stream != null) {
					InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
					JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
				}
			} catch (IOException ex) {
				logger.logResourceError(ex);
			}
		}

		return documentation.toString();
	}
}
