package Delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Stock.Stock;

public class ManifestTest {

	private Stock cargo = new Stock();
	private Manifest manifest;
	/**
	 * Setup Manifest for testing
	 * @throws Exception
	 * @author Sean O'Connell
	 */
	@Before
	public void setUp() throws Exception {
		manifest = new Manifest(cargo);
	}

	/**
	 * Test the manifest creation
	 * @author Sean O'Connell
	 */
	@Test
	public void testManifest() {
		Manifest newManifest = manifest;
		assertEquals(newManifest, manifest);
	}
}
