

import org.junit.Test;
public class VultureBiteTest {

	@Test(expected = VultureBiteException.class)
	public void testVulture() throws VultureBiteException{
		Vulture t=new Vulture(20, 100);
		t.checked(18);
	}
}
