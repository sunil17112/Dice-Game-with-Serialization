
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SerializableTesting {

	@Test
	public void testSerial() {
		try {
		Game g=new Game(100,"snil");
		
		assertTrue(g.get_check("snil")<(int)(0.25*100));
		}
		catch(Exception e) {
			System.out.println("some exception happens");
		}
		
	}
}
