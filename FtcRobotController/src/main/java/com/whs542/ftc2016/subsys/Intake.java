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

    boolean intakePostition = false; //false is closed, true is open

	public Intake(HardwareMap intakeMap)
	{
		dropDownServo = intakeMap.servo.get("intake_dds");
		intakeMotor = intakeMap.dcMotor.get("intake_motor");

		//Should output be too coarse, uncomment this, and add an encoder
		//intakeMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
	}
    public void setIntakePosition(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        //Intake Down
        if(gamepad.right_bumper)
        {
            dropDownServo.setPosition(0.99);
        }
        //Intake Up
        else if(gamepad.right_trigger == 1.0)
        {
            dropDownServo.setPosition(0.85);
        }
    }
    /*
	public void closeIntake(double intakeClosePosition, com.qualcomm.robotcore.hardware.Gamepad gamepad)
	{
        if(gamepad.left_trigger == 1.0)
        {
            dropDownServo.setPosition(intakeClosePosition);
            intakePostition = false;
        }
        else
        {

        }
		dropDownServo.setPosition(intakeRetractedPosition);
	}
	public void openIntake(double intakeOpenPosition ,com.qualcomm.robotcore.hardware.Gamepad gamepad)
	{
        if(gamepad.right_trigger == 1.0)
        {
            dropDownServo.setPosition(intakeOpenPosition);
            intakePostition = true;
        }
        else
        {
        }
		dropDownServo.setPosition(intakeExtendedPosition);
	}
    */
	public void setIntakePower(double power)
	{
        if(intakePostition = true)
        {
            intakeMotor.setPower(power);
        }
        else
        {
            intakeMotor.setPower(0.0);
        }

	}
}