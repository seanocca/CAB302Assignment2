package GUI;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DeliveryException;

public class StoreTest {

	private String storeName = "Mart";
	private double capital = 1000;
	private Store store;
	
	@Before
	public void setUp() throws Exception {
		store = new Store(storeName, capital);
	}

	@Test
	public void testStore() {
		Store initStore = store;
		assertEquals(initStore, store);
	}

	@Test
	public void testGetStoreName() {
		assertEquals(storeName, store.GetStoreName());
	}

	@Test
	public void testGetStoreCapital() {
		assertEquals(store.GetStoreCapital(), capital, 0.01);
	}

	@Test
	public void testGetCapitalString() {
		String output = "Store Capital: $" + NumberFormat.getNumberInstance(Locale.US).format(capital);
		assertEquals(store.GetCapitalString(), output);
	}

	@Test
	public void testPayWithCapital() throws DeliveryException {
		store.PayWithCapital(100);
	}

	@Test
	public void testSellItemsForCapital() {
		store.SellItemsForCapital(100);
	}

}
