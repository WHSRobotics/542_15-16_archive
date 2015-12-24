package com.whs542.lib;

//TODO: Perhaps change this to include a subsystem state enum that's passed in

public class Toggler
{
	private boolean pressed = false;
	private int state = 0;
	private int numberOfStates = 0;
	
	public Toggler(int inputNumber)
	{
		numberOfStates = inputNumber;
	}

	public int currentState()
	{
		return state;
	}

	public int TotalStates()
	{
		return numberOfStates;
	}
	
	//This boolean trigger can have an expression with && or ||
	public void toggleCycle(boolean trigger)
	{
		if(trigger)
		{
			if(!pressed)
			{
				state = (state + 1) % numberOfStates;
			}	
			pressed = true;
		}
		else
		{
			pressed = false;
		}
	}
}