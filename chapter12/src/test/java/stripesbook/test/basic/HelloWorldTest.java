package stripesbook.test.basic;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldTest {
	@Test
	public void testHello() {
		String expected = "HELLO" ;
		String result = "hello".toUpperCase();
		assertEquals(expected, result);
	}
}
