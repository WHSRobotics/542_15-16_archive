package com.whs542.ftc2016.subsys;

import com.whs542.lib.sensors.ProximityGP2Y0D810Z0F;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: Figure out subsystem actuators

public class ScoringBox
{
    private Servo doorServo;
    private Servo extendServo;

    private double doorOpen;
    private double doorClosed;

    private ProximityGP2Y0D810Z0F proximitySensor;

	public ScoringBox(HardwareMap boxMap)
	{
        doorServo = boxMap.servo.get("box_door");
        extendServo = boxMap.servo.get("box_extend");

        //proximitySensor = new ProximityGP2Y0D810Z0F(boxMap, 0);
	}

    public void openDoor()
    {
        doorServo.setPosition(doorOpen);
    }

    public void closeDoor()
    {
        doorServo.setPosition(doorClosed);
    }

    public void setExtensionSpeed(double input)
    {
        extendServo.setPosition(input);
    }
}
