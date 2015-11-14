package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: Figure out if we should set the speed shift and torque shift positions when instantiating or elsewhere.

public class LinearSlides
{
	private DcMotor leftTransmissionMotor;
	private DcMotor rightTransmissionMotor;
	private Servo shiftServo;

    private double speedShiftPosition;
	private double torqueShiftPosition;

	public LinearSlides(HardwareMap slideMap)
	{
        leftTransmissionMotor = slideMap.dcMotor.get("ls_l");
        rightTransmissionMotor = slideMap.dcMotor.get("ls_r");
        shiftServo = slideMap.servo.get("ls_ss");
    }

    void setTransmissionPower(double power)
    {
    	leftTransmissionMotor.setPower(power);
    	rightTransmissionMotor.setPower(power);
    }

    void shiftToTorque()
    {
    	shiftServo.setPosition(torqueShiftPosition);
    }

    void shiftToSpeed()
    {
    	shiftServo.setPosition(speedShiftPosition);
    }
}