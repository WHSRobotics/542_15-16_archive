package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//
// Intake Subsystem Class
//

//TODO: Add current sensor support to the intake motor

public class Intake
{
	// ----------------------------------
	// Intake Variables
	// ----------------------------------
	// -Hardware object reference variables for motors and servos
	// -Double variables for servo positions

	public enum IntakeState
	{

	}

	private DcMotor intakeMotor;
	private Servo dropDownServo;

	private double intakeClosePosition;
	private double intakeOpenPosition;

	// ----------------------------------
	// Intake Constructor
	// ----------------------------------
	// -Initializes the hardware references

	public Intake(HardwareMap intakeMap)
	{
		dropDownServo = intakeMap.servo.get("intake_dds");
		intakeMotor = intakeMap.dcMotor.get("intake_motor");
	}

	// ----------------------------------
	// Intake Methods
	// ----------------------------------

	public void closeIntake()
	{
		dropDownServo.setPosition(intakeClosePosition);
	}
	
	public void openIntake()
	{
		dropDownServo.setPosition(intakeOpenPosition);
	}

	public void setIntakePower(double power)
	{
		intakeMotor.setPower(power);
	}
}