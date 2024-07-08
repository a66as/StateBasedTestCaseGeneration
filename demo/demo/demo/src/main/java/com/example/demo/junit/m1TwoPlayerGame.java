package com.example.demo.junit;

public class m1TwoPlayerGame {
	private int p2_points;
	private int p1_points;
	public int server; // server variable for P1, P2 and P3 as 1, 2, and 3
	/* @instrumentation */
	public String state;
	public m1TwoPlayerGame()
	{
		/*Constructor*/
		/* @instrumentation */
		state="Game Started";
	}
	public void p1_Start()
	{
		/*P1 Serves first*/
		/* not implemented method simulateVolley() should be called here */
		server=1; // p1 is server
		/* @instrumentation */
		state="Player 1 Served";
	}
	public void p1_WinsVolley()
	{
		/*P1 ends the volley*/
		/* not implemented method simulateVolley() should be called here */
		server=1; // p1 is server
		// change{removed p1_AddPoint} which prevents to change state to Player 1 Won}
		if(!p1_IsWinner())
		{
			/* @instrumentation */
			state="Player 1 Served";
		}
		else
		{
			/* @instrumentation */
			state="Player 1 Won";
		}

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
			/* @instrumentation */
			state="Player 1 Won";
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
		/* @instrumentation */
		state="Player 2 Served";
	}
	public void p2_WinsVolley()
	{
		/*P2 ends the volley*/
		/* not implemented method simulateVolley() should be called here */
		server=2;
		p2_AddPoint();
		if(!p2_IsWinner())
		{
			/* @instrumentation */
			state="Player 2 Served";
		}
		else
		{
			/* @instrumentation */
			state="Player 2 Won";
		}

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
			/* @instrumentation */
			state="Player 2 Won";
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


	/*
	 * State Reporter
	 * Code instrumentation
	 * Not the part of SUT
	 * Code marked as @instrumentation is
	 * placed and was not part of the SUR
	 */
	/* @instrumentation */
	public String stateReporter()
	{
		return this.state;
	}
	/* @instrumentation */
	public void dtor() // as we don't have destructors in java
	{
		state="T";
	}
}
