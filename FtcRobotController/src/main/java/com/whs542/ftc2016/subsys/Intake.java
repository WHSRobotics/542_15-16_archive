package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake
{
	private DcMotor intakeMotor;
	private Servo dropDownServo;

	private double intakeRetractedPosition;
	private double intakeExtendedPosition;

	public Intake(HardwareMap intakeMap)
	{
		dropDownServo = intakeMap.servo.get("intake_dds");
		intakeMotor = intakeMap.dcMotor.get("intake_motor");

		//Should output be too coarse, uncomment this, and add an encoder
		//intakeMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
	}

	public void closeIntake()
	{
		dropDownServo.setPosition(intakeRetractedPosition);
	}
	
	public void openIntake()
	{
		dropDownServo.setPosition(intakeExtendedPosition);
	}

	public void setIntakePower(double power)
	{
		intakeMotor.setPower(power);
	}
}