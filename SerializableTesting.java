
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SerializableTesting {

	@Test
	public void testSerial() {
		try {
		Game g;
		g=new Game(100,"sunil_kumar");
		
		assertTrue(g.get_check("sunil_kumar")<(int)(0.25*100));
		}
		catch(Exception e) {
			System.out.println("all exception comes insed this parent exception");
		}
		
	}
}
