package fr.pe.jvi.generic.configuration.retriever;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeConverterTest {

	private final TypeConverter instance = new TypeConverter();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void convertValues() {
		assertEquals(Optional.of(1.35f), instance.convert(Float.class, "1.35f"));
		assertEquals(Optional.of(35), instance.convert(Integer.class, "35"));
		assertEquals(Optional.of("myKey"), instance.convert(String.class, "myKey"));
		assertEquals(Optional.empty(), instance.convert(String.class, null));

	}
	
	

}
