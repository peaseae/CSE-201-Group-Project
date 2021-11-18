import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class loginTest {

	@Test
	void testLogin() {
		login i = new login("1hiep", "cao");
	}
	
	@Test
	void testGetters() {
		login i = new login("1hiep", "cao");
		assertEquals(i.getUsername(), "1hiep");
		assertEquals(i.getPassword(), "cao");
	}
	
	@Test
	void testSetters() {
		login i = new login("1hiep", "cao");
		i.setUsername("hi");
		i.setPassword("abigail");
		assertEquals(i.getUsername(), "hi");
		assertEquals(i.getPassword(), "abigail");
	}
}
