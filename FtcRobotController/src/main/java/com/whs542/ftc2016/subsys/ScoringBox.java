package com.whs542.ftc2016.subsys;

import com.whs542.lib.sensors.*;
import com.whs542.lib.Toggler;

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

    private Servo doorServo;
    private Servo extendServo;

    private ProximityGP2Y0D810Z0F proximitySensor;

    private CurrentACS711EX boxExtensionDetector;

    private Toggler doorSwitch = new Toggler(2);
    private Toggler extensionSwitch = new Toggler(2);

    // ----------------------------------
    // Scoring Box Constructor
    // ----------------------------------

	public ScoringBox(HardwareMap boxMap)
	{
        doorServo = boxMap.servo.get("box_door");
        extendServo = boxMap.servo.get("box_extend");

        proximitySensor = new ProximityGP2Y0D810Z0F(boxMap, 0);
        boxExtensionDetector = new CurrentACS711EX(boxMap, 0);
	}

	// ----------------------------------
	// Scoring Box Methods
	// ----------------------------------

    public void setDoor(boolean trigger)
    {
        doorSwitch.stateInc(trigger);
        switch(doorSwitch.currentState())
        {
            case 0:
                //Close Door
                doorServo.setPosition(0.85);
                break;

            case 1:
                //Open Door
                doorServo.setPosition(0.6);
                break;
        }
    }

    public void setExtension(boolean trigger)
    {
        extensionSwitch.stateInc(trigger);
        switch(extensionSwitch.currentState())
        {
            case 1:
                //Box Extension
                setExtensionSpeed(boxFullyExtended()?0.5:1.0);
                break;

            case 0:
                //Box Retraction
                setExtensionSpeed(boxFullyRetracted()?0.5:0.0);
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

    public double getExtensionValue()
    {
        return boxExtensionDetector.getRawValue();
    }

    public void setExtensionSpeed(double input)
    {
        extendServo.setPosition(input);
    }

    public boolean boxFullyRetracted()
    {
        return (boxExtensionDetector.getRawValue() < 260);
    }

    public boolean boxFullyExtended()
    {
        return (boxExtensionDetector.getRawValue() > 610);
    }
}