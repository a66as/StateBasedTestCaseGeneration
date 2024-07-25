package niSUT.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import niSUT.niThreePlayerGame;

public class UnitTests {

	niThreePlayerGame sut;
	//example test case that tests server tracking for server p1
	@Test
	public void testServer1() {
		sut= new niThreePlayerGame();
		sut.p1_Start(); 
		assertEquals(1,sut.server); 
	}
}
