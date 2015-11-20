package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Assign5TestSuite extends TestSuite{
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All JUnit Tests");
		
		suite.addTestSuite(Assign5TestLevel1.class);
		suite.addTestSuite(Assign5TestLevel2.class);
		suite.addTestSuite(Assign5TestLevel3.class);
		suite.addTestSuite(Assign5TestLevel4.class);
		suite.addTestSuite(Assign5TestLevel5.class);

		return suite;	
	}
}
