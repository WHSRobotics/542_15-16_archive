package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: Add current sensor support to the intake motor

public class Intake
{
	private DcMotor intakeMotor;
	private Servo dropDownServo;

	private double intakeClosePosition;
	private double intakeOpenPosition;

	public Intake(HardwareMap intakeMap)
	{
		dropDownServo = intakeMap.servo.get("intake_dds");
		intakeMotor = intakeMap.dcMotor.get("intake_motor");
	}

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