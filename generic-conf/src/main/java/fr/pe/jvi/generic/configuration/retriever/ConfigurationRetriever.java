package fr.pe.jvi.generic.configuration.retriever;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import fr.pe.jvi.generic.configuration.api.ConfigurationProperty;
import fr.pe.jvi.generic.configuration.api.Endpoint;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationRetriever {

	@Setter
	private Endpoint endpoint;

	private final TypeConverter typeConverter = new TypeConverter();

	public <T> Optional<T> retrieve(final ConfigurationProperty<T> configurationProperty) {

		Optional<T> result = Optional.ofNullable(configurationProperty.getDefaultValue());

		if (null != endpoint) {
			Optional<String> optionalResponse = endpoint.call(configurationProperty.getName());

			if (optionalResponse.isPresent()) {
				final String currentPropertyValue = optionalResponse.get();
				try {
					Class<T> clazz = getClassFromConfigurationProperty(configurationProperty);
					result = typeConverter.convert(clazz, currentPropertyValue);
				} catch (final Exception e) {
					log.warn("Current value [{}] for property [{}] is unparsable, default value [{}] is set",
							currentPropertyValue, configurationProperty.getName(),
							configurationProperty.getDefaultValue());
				}
			}
			log.debug("Property value for [{}] could not be found in configuration api",
					configurationProperty.getName());
		} else {
			log.warn("Missing Configuration endpoint. Use empty value for property [{}]",
					configurationProperty.getName());
		}

		return result;
	}

	@SuppressWarnings({ "unchecked" })
	private <T> Class<T> getClassFromConfigurationProperty(final ConfigurationProperty<T> configurationProperty) {
		return (Class<T>) ((ParameterizedType) configurationProperty.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
}
