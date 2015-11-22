package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: Figure out if we should set the speed shift and torque shift positions when instantiating or elsewhere.
//Should we set the shifter positions as a constructor parameter, the testing loop is easier
//Should we set the shifter position here permanently as a field, it's better information hiding

public class LinearSlides
{
	private DcMotor leftTransmissionMotor;
	private DcMotor rightTransmissionMotor;
	private Servo shiftServo;

    private double speedShiftPosition = 0.5;
	private double torqueShiftPosition = 1.0;

	public LinearSlides(HardwareMap slideMap)
	{
        leftTransmissionMotor = slideMap.dcMotor.get("ls_l");
        rightTransmissionMotor = slideMap.dcMotor.get("ls_r");
        shiftServo = slideMap.servo.get("ls_ss");
    }

    public void setTransmissionPower(double power)
    {
    	leftTransmissionMotor.setPower(power);
    	rightTransmissionMotor.setPower(power);
    }

    public void setShiftServoPosition(double input)
    {
        shiftServo.setPosition(Math.abs(input));
    }

    public void shiftToTorque()
    {
    	shiftServo.setPosition(torqueShiftPosition);
    }

    public void shiftToSpeed()
    {
    	shiftServo.setPosition(speedShiftPosition);
    }
}