package com.example.demo.junit;



public class niThreePlayerGame extends niTwoPlayerGame {
	private int p3_points;
	public niThreePlayerGame()
	{
		/*Constructor*/
	}
	public void p3_Start()
	{
		/*P3 Serves First*/
		/* not implemented method simulateVolley() should be called here */
		server=3; // p3 is server
	}
	public void p3_WinsVolley()
	{
		/*P3 ends the volley*/
		/* not implemented method simulateVolley() should be called here */
		server=3; // p3 is server
		p3_AddPoint();
	}
	private void p3_AddPoint()
	{
		/*Adds 1 to the P3's Score*/
		p3_points++;
	}
	public boolean p3_IsWinner()
	{
		/*True if P3's score is 21*/
		if(p3_points>19)
		{
			return true;
		}
		return false;
	}
	public boolean p3_IsServer()
	{
		/*True if P3 is Server*/
		if(server==3)
			return true;
		return false;
	}
	public int p3_Score()
	{
		/*Returns P3's Score*/
		return p3_points;
	}
}
