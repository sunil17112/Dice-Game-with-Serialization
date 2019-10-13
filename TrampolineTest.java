
import org.junit.Test;
public class TrampolineTest {

	@Test(expected = TrampolineBiteException.class)
	public void testTrampoline() throws TrampolineBiteException{
			Trampoline t=new Trampoline(10, 100);
		//Game g=new Game(100,"snil");
			t.checked(9);
		
	}
}
