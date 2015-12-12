package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;
import com.whs542.ftc2016.RobotMain;

//TODO: Define Subsys class
//TODO: Define an interface?
//TODO: Implement left side/right side travel distance

public class Drive
{
	private static final double TICKS_TO_ROT = 1.0/1120.0;

	public static DcMotor rightFrontMotor;
	public static DcMotor rightBackMotor;
	public static DcMotor leftFrontMotor;
	public static DcMotor leftBackMotor;

	private Servo leftChurroHook;
	private Servo rightChurroHook;

	//TODO: Find and set these
	private double hookedPosition;
	private double unhookedPosition;

	private double RFencoderZero;
	private double RBencoderZero;
	private double LFencoderZero;
	private double LBencoderZero;
    public boolean encoderState;
    public boolean rightEncoderState;
    public boolean leftEncoderState;


	public Drive(HardwareMap driveMap)
	{
		rightFrontMotor = driveMap.dcMotor.get("drive_rf");
        rightBackMotor = driveMap.dcMotor.get("drive_rb");
        leftFrontMotor = driveMap.dcMotor.get("drive_lf");
        leftBackMotor = driveMap.dcMotor.get("drive_lb");
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

        //leftChurroHook = driveMap.servo.get("drive_lh");
        //rightChurroHook = driveMap.servo.get("drive_rh");
    }

    public static void setLeftRightPower(double leftPower, double rightPower)
	{
	    rightFrontMotor.setPower(rightPower);
	    rightBackMotor.setPower(rightPower);
	    leftFrontMotor.setPower(leftPower);
	    leftBackMotor.setPower(leftPower);
  	}

    //Churro Hook Control//
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

    //Encoders//
    boolean encodersReachTarget(double encoderCount)
    {
        encoderState = false;
        if(rightEncodersReachTarget(encoderCount) && leftEncodersReachTarget(encoderCount))
        {
            setLeftRightPower(0.0, 0.0);
            encoderState = true;
        }
        else
        {
            setLeftRightPower(1.0, 1.0);
            encoderState = false;
        }
        return encoderState;
    }

    boolean rightEncodersReachTarget(double rightEncoderCount)
    {
        rightEncoderState = false;
        if(Math.abs(rightFrontMotor.getCurrentPosition()) > rightEncoderCount && Math.abs(rightBackMotor.getCurrentPosition()) > rightEncoderCount)
        {
            zeroEncoders();
            rightEncoderState = true;
        }
        else
        {
            rightEncoderState = false;
        }
        return rightEncoderState;
    }
    boolean leftEncodersReachTarget(double leftEncoderCount)
    {
        leftEncoderState = false;
        if(Math.abs(leftFrontMotor.getCurrentPosition()) > leftEncoderCount && Math.abs(leftBackMotor.getCurrentPosition()) > leftEncoderCount)
        {
            zeroEncoders();
            leftEncoderState = true;
        }
        else
        {
            leftEncoderState = false;
        }
        return leftEncoderState;
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