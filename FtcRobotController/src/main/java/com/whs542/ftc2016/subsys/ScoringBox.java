package com.whs542.ftc2016.subsys;

import com.whs542.lib.sensors.*;

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

    private int boxRetractionThreshold;
    private int boxExtensionThreshold;

    private ProximityGP2Y0D810Z0F proximitySensor;

    private CurrentACS711EX boxRetractDetector;
    private CurrentACS711EX boxExtendDetector;

    // ----------------------------------
    // Scoring Box Constructor
    // ----------------------------------

	public ScoringBox(HardwareMap boxMap)
	{
        doorServo = boxMap.servo.get("box_door");
        extendServo = boxMap.servo.get("box_extend");

        proximitySensor = new ProximityGP2Y0D810Z0F(boxMap, 0);
        boxRetractDetector = new CurrentACS711EX(boxMap, 0);
        boxExtendDetector = new CurrentACS711EX(boxMap, 1);
	}

	// ----------------------------------
	// Scoring Box Methods
	// ----------------------------------

    public void openDoor()
    {
        doorServo.setPosition(0.5);
    }

    public void closeDoor()
    {
        doorServo.setPosition(1.0);
    }

    public void setExtensionSpeed(double input)
    {
        extendServo.setPosition(input);
    }

    public boolean boxFullyRetracted()
    {
        return (boxRetractDetector.getRawValue() > boxRetractionThreshold);
    }

    public boolean boxFullyExtended()
    {
        return (boxExtendDetector.getRawValue() > boxExtensionThreshold);
    }
}