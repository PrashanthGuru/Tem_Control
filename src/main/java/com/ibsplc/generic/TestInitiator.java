package com.ibsplc.generic;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

/**
 * 
 * @author SHALINI/Sharath on 29-03-2019 Description To create Dynamic suite
 *         based on module
 **/
public class TestInitiator {

	public static void main(String[] args) throws Exception {
		TestNG runner = new TestNG();
		List<String> suitefiles1 = new ArrayList<String>();
		suitefiles1.add("TestSuite/TemperatureControl_test.xml");
		runner.setTestSuites(suitefiles1);
		runner.run();
	}

}
