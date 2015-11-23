package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: Define Subsys class
//TODO: Define an interface?
//TODO: Implement left side/right side travel distance

public class Drive
{
	private static final double TICKS_TO_ROT = 1.0/1120.0;

	private DcMotor rightFrontMotor;
	private DcMotor rightBackMotor;
	private DcMotor leftFrontMotor;
	private DcMotor leftBackMotor;

	private Servo leftChurroHook;
	private Servo rightChurroHook;

	//TODO: Find and set these
	private double hookedPosition;
	private double unhookedPosition;

	private double RFencoderZero;
	private double RBencoderZero;
	private double LFencoderZero;
	private double LBencoderZero;

	public Drive(HardwareMap driveMap)
	{
		rightFrontMotor = driveMap.dcMotor.get("drive_rf");
        rightBackMotor = driveMap.dcMotor.get("drive_rb");
        leftFrontMotor = driveMap.dcMotor.get("drive_lf");
        leftBackMotor = driveMap.dcMotor.get("drive_lb");
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

        leftChurroHook = driveMap.servo.get("drive_lh");
        rightChurroHook = driveMap.servo.get("drive_rh");
	}

	public void setLeftRightPower(double leftPower, double rightPower)
	{
	    rightFrontMotor.setPower(rightPower);
	    rightBackMotor.setPower(rightPower);
	    leftFrontMotor.setPower(leftPower);
	    leftBackMotor.setPower(leftPower);
  	}

  	public void hookChurro()
  	{
  		leftChurroHook.setPosition(hookedPosition);
  		rightChurroHook.setPosition(hookedPosition);
  	}

  	public void unhookChurro()
  	{
  		leftChurroHook.setPosition(unhookedPosition);
  		rightChurroHook.setPosition(unhookedPosition);
  	}

  	public void setChurroHookPosition(double input)
  	{
  		leftChurroHook.setPosition(Math.abs(input));
  		rightChurroHook.setPosition(Math.abs(input));
  	}

	public double getRightFrontEncoder()
	{
		return rightFrontMotor.getCurrentPosition()*TICKS_TO_ROT - RFencoderZero;
	}

	public double getRightBackEncoder()
	{
		 return rightBackMotor.getCurrentPosition()*TICKS_TO_ROT - RBencoderZero;
	}

	public double getLeftFrontEncoder()
	{
		return leftFrontMotor.getCurrentPosition()*TICKS_TO_ROT - LFencoderZero;
	}

	public double getLeftBackEncoder()
	{
		return leftBackMotor.getCurrentPosition()*TICKS_TO_ROT - LBencoderZero;
	}

	public void zeroEncoders()
	{
		RFencoderZero = rightFrontMotor.getCurrentPosition()*TICKS_TO_ROT;
		RBencoderZero = rightBackMotor.getCurrentPosition()*TICKS_TO_ROT;
		LFencoderZero = leftFrontMotor.getCurrentPosition()*TICKS_TO_ROT;
		LBencoderZero = leftBackMotor.getCurrentPosition()*TICKS_TO_ROT;
	}
}