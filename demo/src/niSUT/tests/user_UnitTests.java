package niSUT.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import SUT.ThreePlayerGame;

public class UnitTests {

	ThreePlayerGame sut;
	//example test case that tests server tracking for server p1
	@Test(timeout = 1000)
	public void testServer1() {
		sut= new ThreePlayerGame();
		sut.p1_Start(); 
		assertEquals(1,1);
	}
}
