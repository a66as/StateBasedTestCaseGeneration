package niSUT.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import niSUT.niThreePlayerGame;

public class UnitTests {
	//Pasqua and Samaneh
	niThreePlayerGame sut;
	//example test case that tests server tracking for server p1
	@Test
	public void testServer1() {
		sut= new niThreePlayerGame();
		sut.p1_Start(); 
		assertEquals(1,sut.server); 
	}
	@Test
	public void tc1() {
		//Not possible
	}
	@Test
	public void tc2() {
		sut= new niThreePlayerGame();
		sut.p3_Start();
		for(int i=1;i<23;i++)
			sut.p3_WinsVolley();
		assertTrue(sut.p3_IsWinner()); // Assertion unclear
	}
	@Test
	public void tc3() {
		sut= new niThreePlayerGame();
		sut.p3_Start();
		for(int i=1;i<20;i++)
			sut.p3_WinsVolley();
		assertFalse(sut.p3_IsServer()); 
	}
	@Test
	public void tc4() {
		//Not possible 
	}
}
