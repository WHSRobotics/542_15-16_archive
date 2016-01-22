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
    private Servo extendServo;

    private ProximityGP2Y0D810Z0F debris1;
    private ProximityGP2Y0D810Z0F debris2;
    private ProximityGP2Y0D810Z0F debris3;

    private CurrentACS711EX boxExtensionDetector;

    private Toggler doorSwitch = new Toggler(2);
    private Toggler extensionSwitch = new Toggler(2);

    // ----------------------------------
    // Scoring Box Constructor
    // ----------------------------------

	public ScoringBox(HardwareMap boxMap, Alliance side)
	{
        doorServo = boxMap.servo.get("box_door");
        extendServo = boxMap.servo.get("box_extend");

        debris1 = new ProximityGP2Y0D810Z0F(boxMap, -1);
        debris2 = new ProximityGP2Y0D810Z0F(boxMap, -1);
        debris3 = new ProximityGP2Y0D810Z0F(boxMap, -1);

        boxExtensionDetector = new CurrentACS711EX(boxMap, 0);

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
                //closeDoor();
            break;

            case 1:
                openDoor();
            break;
        }
    }

    public void boxFlapState(double doorFlapValue)
    {
        switch(color)
        {
            case RED:
                doorServo.setPosition(0.8);
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
                doorServo.setPosition(0.6);
            break;

            case BLUE:
                doorServo.setPosition(0.3);
            break;
        }
    }

    //Alter to accommodate both boxes
    public void setExtension(boolean trigger)
    {
        extensionSwitch.changeState(trigger);
        switch(extensionSwitch.currentState())
        {
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

    public void setExtensionSpeed(boolean left, boolean right)
    {
        if(left)
        {
            extendServo.setPosition(0.0);
        }
        else if(right)
        {
            extendServo.setPosition(1.0);
        }
        else
        {
            extendServo.setPosition(0.5);
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

    public double getExtensionValue()
    {
        return boxExtensionDetector.getRawValue();
    }
    public void innerBoxExtension(double servoExtensionValue) //com.qualcomm.robotcore.hardware.Gamepad gamepad
    {
        //boxExtendServo.setPosition(servoExtensionValue);
        /*
        //Extend
        if(boxExtended = false)
        {
            if(gamepad.x)
            {
                servoExtensionValue = 1.0;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = true;
            }
            else
            {
                servoExtensionValue = 0.5;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = false;
            }
        }
        //Retract
        else if(boxExtended = true)
        {
            if(gamepad.y)
            {
                servoExtensionValue = 0.0;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = false;
            }
            else
            {
                servoExtensionValue = 0.5;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = true;
            }
        }
        else
        {
            boxExtended = false;
        }
        */
    }

    public void setDoorPosition(double input)
    {
        doorServo.setPosition(Math.abs(input));
    }

    public boolean boxFullyExtended() {
        boolean output = false;
        switch(color)
        {
            case RED:
                output = (boxExtensionDetector.getRawValue() < 260);
            break;

            case BLUE:
                output = (boxExtensionDetector.getRawValue() < -1);
            break;
        }
        return output;
    }

    public boolean boxFullyRetracted()
    {
        boolean output = false;
        switch(color)
        {
            case RED:
                output = (boxExtensionDetector.getRawValue() > 610);
            break;

            case BLUE:
                output = (boxExtensionDetector.getRawValue() > -1);
            break;
        }
        return output;
    }
}