import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VL03Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Ignore
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void methodenNameTest() {
		assertEquals(1, 1);
	}

	@Test
	void methodenName2Test() {
		assertEquals(1, 2 - 1);
	}
}
