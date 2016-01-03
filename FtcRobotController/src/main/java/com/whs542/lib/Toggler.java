package com.whs542.lib;

//TODO: Perhaps change this to include a subsystem state enum that's passed in

public class Toggler
{
	private boolean pressedDec = false;
	private boolean pressedInc = false;
	private boolean limited = false;
	private int state = 0;
	private int numberOfStates = 0;

	/*
	//What does it control?
	public Toggler(int state)
	{

	}

	//What does it control/flip?
	public Toggler(boolean state)
	{

	}
	*/

	public Toggler(int stateNum, int initState)
	{
		numberOfStates = stateNum;
		limited = true;
		state = (initState < stateNum) && (initState > -1) ? initState: 0;
	}

	public Toggler(int stateNum)
	{
		numberOfStates = stateNum;
	}

	public int currentState()
	{
		return state;
	}

	public int TotalStates()
	{
		return numberOfStates;
	}
	
	//This boolean trigger can have an expression with && or || for further functionality
	public void stateInc(boolean inc)
	{
		if(inc)
		{
			if(!pressedInc)
			{
				if(limited)
				{
					state = ((state + 1) != numberOfStates)
							? (state + 1) % numberOfStates
							:state;
				}
				else {
					state = (state + 1) % numberOfStates;
				}
			}
			pressedInc = true;
		}
		else
		{
			pressedInc = false;
		}
	}

	public void stateDec(boolean dec)
	{
		if(dec)
		{
			if(!pressedDec)
			{
				if(limited)
				{
					state = ((state - 1) != -1)
							? ((state - 1) % numberOfStates+numberOfStates)%numberOfStates
							:state;
				}
				else {
					state = ((state - 1) % numberOfStates+numberOfStates)%numberOfStates;
				}
			}
			pressedDec = true;
		}
		else
		{
			pressedDec = false;
		}
	}
}