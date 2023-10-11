package com.github.sechols223.capibara.config;

import com.intellij.openapi.options.Configurable;
import com.intellij.ui.components.panels.VerticalLayout;
import com.intellij.workspaceModel.storage.cpp.CppLanguage;
import com.jetbrains.cidr.lang.parser.OCParser;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PluginOptions implements Configurable {
	private boolean isModified = false;
	private final String ENABLED_OPTION = "Enabled";
	private final String NAME = "Capibara";
	private final OptionModifiedListener LISTENER = new OptionModifiedListener(this);
	private JCheckBox checkboxOption;
	@Override
	public String getDisplayName() {
		return NAME;
	}
	@Override
	public String getHelpTopic() {

		return NAME;
	}
	@Override
	public @Nullable JComponent createComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new VerticalLayout(1, 2));

		checkboxOption = new JCheckBox(ENABLED_OPTION);
		checkboxOption.addActionListener(LISTENER);

		panel.add(checkboxOption);
		return panel;
	}

	@Override
	public boolean isModified() {
		return this.isModified;
	}

	@Override
	public void apply() {
		Settings.set(ENABLED_OPTION, String.valueOf(checkboxOption.isSelected()));
		this.isModified = false;
	}

	@Override
	public void reset() {
		String enabled = Settings.get("Enabled");
		boolean checked = enabled.equals(String.valueOf(true));

		checkboxOption.setText(ENABLED_OPTION);
		checkboxOption.setSelected(checked);

		this.isModified= false;
	}

	public void setModified(boolean modified) {
		this.isModified = modified;
	}


	private static class OptionModifiedListener implements ActionListener {
		private final PluginOptions options;

		public OptionModifiedListener(PluginOptions options) {
			this.options = options;
		}
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			options.setModified(true);
		}
	}

}
