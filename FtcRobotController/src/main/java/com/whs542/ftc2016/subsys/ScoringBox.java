package com.whs542.ftc2016.subsys;

import com.whs542.lib.sensors.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//
// Scoring Box Subsystem Class
//

public class ScoringBox
{
	// ----------------------------------
	// Scoring Box Variables
	// ----------------------------------

    private Alliance color;

    private Servo doorServo;

    private Toggler doorSwitch = new Toggler(2);
    private Toggler extensionSwitch = new Toggler(2);

    // ----------------------------------
    // Scoring Box Constructor
    // ----------------------------------

	public ScoringBox(HardwareMap boxMap, Alliance side)
	{
        //doorServo = boxMap.servo.get("box_door");
        //extendServo = boxMap.servo.get("box_extend");

        //boxExtensionDetector = new CurrentACS711EX(boxMap, 0);

        color = side;
	}

	// ----------------------------------
	// Scoring Box Methods
	// ----------------------------------

    public void setDoor(boolean trigger)
    {
        doorSwitch.changeState(trigger);
        switch(doorSwitch.currentState())
        {
            case 0:
                closeDoor();
            break;

            case 1:
                openDoor();
            break;
        }
    }

    public void setDoorRed(boolean trigger)
    {
        doorSwitch.changeState(trigger);
        switch(doorSwitch.currentState())
        {
            case 0:
                closeDoorRed();
            break;

            case 1:
                openDoorRed();
            break;
        }
    }

    public void setDoorBlue(boolean trigger)
    {
        doorSwitch.changeState(trigger);
        switch(doorSwitch.currentState())
        {
            case 0:
                closeDoorBlue();
                break;

            case 1:
                openDoorBlue();
                break;
        }
    }

    public void closeDoorRed()
    {
        doorServo.setPosition(0.8);
    }

    public void closeDoorBlue()
    {
        doorServo.setPosition(0.0);
    }

    public void openDoorRed()
    {
        doorServo.setPosition(0.5);
    }

    public void openDoorBlue()
    {
        doorServo.setPosition(0.3);
    }

    public void closeDoor()
    {
        switch(color)
        {
            case RED:
                doorServo.setPosition(0.6);
            break;

            case BLUE:
                doorServo.setPosition(0.0);
            break;
        }
    }

    public void openDoor()
    {
        switch(color)
        {
            case RED:
                doorServo.setPosition(0.28);
            break;

            case BLUE:
                doorServo.setPosition(0.25);
            break;
        }
    }


    //Alter to accommodate both boxes
    public void setExtension(boolean trigger)
    {
        extensionSwitch.changeState(trigger);
        switch(extensionSwitch.currentState()) {
            case 1:
                //Box Extension
                //setExtensionSpeed(boxFullyExtended()?0.5:1.0);
                break;

            case 0:
                //Box Retraction
                //setExtensionSpeed(boxFullyRetracted()?0.5:0.0);
                break;
        }
    }
    public String getDoorState()
    {
        String state = null;
        switch(doorSwitch.currentState())
        {
            case 0:
                state = "Closed";
            break;

            case 1:
                state = "Open";
            break;
        }
        return state;
    }
}