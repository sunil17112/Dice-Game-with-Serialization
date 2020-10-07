

import java.io.IOException;

import org.junit.Test;
public class GameWinnerTest {

	@Test(expected = GameWinnerException.class)
	public void testGameWin()throws IOException ,ClassNotFoundException,NoExtraTiles,GameWinnerException{
			Tile[] arr=new Tile[100];
			Player p;
			p = new Player(100, "sunil_kumar", arr);
			p.setTile(100);
			p.play();
			
		}
}
