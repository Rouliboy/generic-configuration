package fr.pe.jvi.generic.configuration.retriever;

import org.junit.After;
import org.junit.Before;

import fr.pe.jvi.generic.configuration.api.Endpoint;

public class ConfigurationRetrieverTest {

	private ConfigurationRetriever instance;
	
	private Endpoint endpoint;
	
	@Before
	public void setUp() throws Exception {
		instance = new ConfigurationRetriever();
		instance.setEndpoint(endpoint);
	}

	@After
	public void tearDown() throws Exception {
	}

}
