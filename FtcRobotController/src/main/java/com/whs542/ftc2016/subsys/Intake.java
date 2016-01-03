package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//
// Intake Subsystem Class
//

public class Intake
{
	public int INTAKE_EXTENSION_STATE = 0;
	public int INTAKE_RUNNING_STATE = 0;
	// ----------------------------------
	// Intake Variables
	// ----------------------------------
	// -Hardware object reference variables for motors and servos
	// -Double variables for servo positions

	private DcMotor intakeMotor;
	private Servo dropDownServo;

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

	public void update()
	{
		switch(INTAKE_EXTENSION_STATE)
		{
			case 1:
				dropDownServo.setPosition(1.0);
			break;

			case 0:
				dropDownServo.setPosition(0.0);
			break;
		}

		switch(INTAKE_RUNNING_STATE)
		{
			case 1:
				intakeMotor.setPower(1.0);
			break;

			case 0:
				intakeMotor.setPower(0.0);
			break;
		}
	}
}