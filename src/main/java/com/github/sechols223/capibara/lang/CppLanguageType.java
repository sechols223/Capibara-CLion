package com.github.sechols223.capibara.lang;

import com.intellij.psi.PsiFile;
import com.jetbrains.cidr.lang.OCLanguageKind;
import com.jetbrains.cidr.lang.psi.impl.OCFileImpl;

public class CppLanguageType {
	public static boolean isCFamily(PsiFile file) {

		if(!(file instanceof OCFileImpl)) {
			return false;
		}
		OCLanguageKind languageKind = ((OCFileImpl) file).getKind();

		return languageKind.isCpp();
	}
}
