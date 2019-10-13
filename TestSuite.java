
import org.junit.runner.RunWith;		
import org.junit.runners.Suite;		

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  SerializableTesting.class,
  SnakeBiteTest.class,
  VultureBiteTest.class,
  TrampolineTest.class,
  CricketBiteTest.class,
  GameWinnerTest.class
})


public class TestSuite { }
