package fr.pe.jvi.generic.configuration.api;

public class ConfigurationProperty<T> {
	private final String name;

	private final T defaultValue;

	public ConfigurationProperty(final String name) {
		this(name, null);
	}

	public ConfigurationProperty(final String name, final T defaultValue) {
		this.name = name;
		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public T getDefaultValue() {
		return defaultValue;
	}

}
