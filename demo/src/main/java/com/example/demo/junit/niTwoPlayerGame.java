package com.example.demo.junit;

public class niTwoPlayerGame {
	private int p2_points;
	private int p1_points;
	public int server; // server variable for P1, P2 and P3 as 1, 2, and 3

	public niTwoPlayerGame()
	{
		/*Constructor*/
		
	}
	public void p1_Start()
	{
		/*P1 Serves first*/
		/* not implemented method simulateVolley() should be called here */
		server=1; // p1 is server

	}
	public void p1_WinsVolley()
	{
		/*P1 ends the volley*/
		/* not implemented method simulateVolley() should be called here */
		server=1; // p1 is server
		p1_AddPoint();
		
	}
	private void p1_AddPoint()
	{
		/*Adds 1 to the P1's score*/
		p1_points++;
	}
	public boolean p1_IsWinner()
	{
		/*True if P1's score is 21*/
		if(p1_points>19)
		{
			return true;
		}
		return false;
	}
	public boolean p1_IsServer()
	{
		/*True if P1 is server*/
		if(server==1)
			return true;
		return false;
	}
	public int p1_Score()
	{
		/*Returns P1's Score*/
		return p1_points;
	}
	public void p2_Start()
	{
		/*P2 Serves First*/
		/* not implemented method simulateVolley() should be called here */
		server=2; // p2 is server
	}
	public void p2_WinsVolley()
	{
		/*P2 ends the volley*/
		/* not implemented method simulateVolley() should be called here */
		server=2;
		p2_AddPoint();
	}
	private void p2_AddPoint()
	{
		/*Adds 1 to P2's Score*/
		p2_points++;
	}
	public boolean p2_IsWinner()
	{
		/*True if P2's score is 21*/
		if(p2_points>19)
		{
			return true;
		}
		return false;
	}
	public boolean p2_IsServer()
	{
		/*True if P2 is server*/
		if(server==2)
			return true;
		return false;
	}
	public int p2_Score()
	{
		/*Returns P2's Score*/
		return p2_points;
	}
	
	public void simulateVolley()
	{
		System.out.println("simulateVolley() Called");
	}
}
