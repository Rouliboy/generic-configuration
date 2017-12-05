package fr.pe.jvi.generic.configuration.retriever;

import java.util.Optional;

public class TypeConverter {

	public <T> Optional<T> convert(final Class<T> clazz, final String value) {
		Object result = null;
		// String
		if (clazz.isAssignableFrom(String.class)) {
			result = value;
		}
		// Integer
		else if (clazz.isAssignableFrom(Integer.class)) {
			result = convertInteger(value);
		}
		// Float
		else if (clazz.isAssignableFrom(Float.class)) {
			result = convertFloat(value);
		}
		return Optional.ofNullable(clazz.cast(result));
	}

	/**
	 */
	private Integer convertInteger(final String value) {
		Integer result = null;

		if (null != value) {
			try {
				result = Integer.valueOf(value);
			} catch (final NumberFormatException e) {
				throw new IllegalArgumentException("Format error", e);
			}
		}

		return result;
	}

	private Float convertFloat(final String value) {
		Float result = null;

		if (null != value) {
			try {
				result = Float.valueOf(value);
			} catch (final NumberFormatException e) {
				throw new IllegalArgumentException("Format error", e);
			}
		}

		return result;
	}
}
