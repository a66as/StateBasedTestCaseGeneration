package niSUT.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import niSUT.niThreePlayerGame;

public class UnitTests {

	niThreePlayerGame sut;
	//example test case that tests server tracking for server p1
	@Test(timeout = 1000)
	public void unitTest0() {
		sut= new niThreePlayerGame();
		sut.p1_Start(); 
		assertEquals(1,1);
	}
}
