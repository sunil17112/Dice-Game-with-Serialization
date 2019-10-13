import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class CricketBiteTest {

	@Test(expected = CricketBiteException.class)
	public void testCricket()throws CricketBiteException {
		
			Cricket t=new Cricket(10, 100);
			t.checked(8);
			
		
	}
}
