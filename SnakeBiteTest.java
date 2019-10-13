

import org.junit.Test;
public class SnakeBiteTest {

	@Test(expected = SnakeBiteException.class)
	public void testSnake()throws SnakeBiteException {
		Snake t=new Snake(10, 100);
		t.checked(9);
		
		
	}
}
