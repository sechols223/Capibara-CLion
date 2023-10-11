package com.github.sechols223.capibara.core;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class DialogAction extends AnAction {

	private static final Logger Log = Logger.getInstance(DialogAction.class);


	@Override
	public void update(@NotNull AnActionEvent event) {
		// Using the event, evaluate the context,
		// and enable or disable the action.
	}

	@Override
	public void actionPerformed(@NotNull AnActionEvent event) {
		// Using the event, create and show a dialog
		Project currentProject = event.getProject();
		StringBuilder message =
				new StringBuilder(event.getPresentation().getText() + " Selected!");
		// If an element is selected in the editor, add info about it.
		Navigatable selectedElement = event.getData(CommonDataKeys.NAVIGATABLE);
		if (selectedElement != null) {
			message.append("\nSelected Element: ").append(selectedElement);
		}
		String title = event.getPresentation().getDescription();
		Log.info("Something happened YAAY");
		Messages.showMessageDialog(
				currentProject,
				message.toString(),
				title,
				Messages.getInformationIcon());

	}

}
