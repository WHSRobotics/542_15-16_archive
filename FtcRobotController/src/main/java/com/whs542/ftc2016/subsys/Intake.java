package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//
// Intake Subsystem Class
//

public class Intake
{
	// ----------------------------------
	// Intake Variables
	// ----------------------------------
	// -Hardware object reference variables for motors and servos
	// -Double variables for servo positions

	private DcMotor intakeMotor;
	private Servo dropDownServo;

	private double intakeRetractedPosition;
	private double intakeExtendedPosition;

	// ----------------------------------
	// Intake Constructor
	// ----------------------------------
	// -Initializes the hardware references

	public Intake(HardwareMap intakeMap)
	{
		dropDownServo = intakeMap.servo.get("intake_dds");
		intakeMotor = intakeMap.dcMotor.get("intake_motor");

		//Should output be too coarse, uncomment this, and add an encoder
		//intakeMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
	}

	// ----------------------------------
	// Intake Methods
	// ----------------------------------

	public void retractIntake()
	{
		dropDownServo.setPosition(intakeRetractedPosition);
	}
	
	public void extendIntake()
	{
		dropDownServo.setPosition(intakeExtendedPosition);
	}

	public void intakePowerSet(double power)
	{
		intakeMotor.setPower(power);
	}
}