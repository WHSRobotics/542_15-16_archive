package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO: Define Subsys class
//TODO: Define an interface?
//TODO: Implement left side/right side travel distance

public class Drive
{

    private static final double WHEEL_DIAMETER = 15.24;
    private static final double TICKS_TO_ROT = 1.0/1120.0;
    private static final double TICKS_TO_RAD = 2.0*Math.PI/1120.0;
    private static final double TICKS_TO_DIST_CM = WHEEL_DIAMETER*Math.PI/1120.0;

	private static DcMotor driveRightFront;
	private static DcMotor driveRightBack;
	private static DcMotor driveLeftFront;
	private static DcMotor driveLeftBack;

    private static Servo hookLeft;
    private static Servo hookRight;
    private static Servo sideLeft;
    private static Servo sideRight;

    public double [] encoderZeroes;
    public double [] encoderValues;

    public static int RF = 0;
    public static int RB = 1;
    public static int LF = 2;
    public static int LB = 3;

    public static double hookLPosition;
    public static double hookRPosition;
    public static double sideLPosition;
    public static double sideRPosition;

	public Drive(HardwareMap driveMap)
	{
		driveRightFront = driveMap.dcMotor.get("drive_rf");
        driveRightBack = driveMap.dcMotor.get("drive_rb");
        driveLeftFront = driveMap.dcMotor.get("drive_lf");
        driveLeftBack = driveMap.dcMotor.get("drive_lb");
        driveLeftFront.setDirection(DcMotor.Direction.REVERSE);
        driveLeftBack.setDirection(DcMotor.Direction.REVERSE);

        driveRightFront.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        driveRightBack.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        driveLeftFront.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        driveLeftBack.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        hookLeft = driveMap.servo.get("drive_lch");
        hookRight = driveMap.servo.get("drive_rch");
        hookLeft.setPosition(0.9);
        hookRight.setPosition(0.15);

        sideLeft = driveMap.servo.get("drive_bs");
        sideRight = driveMap.servo.get("drive_rs");
        sideLeft.setPosition(0.95);
        sideRight.setPosition(0.0);

        encoderZeroes = new double[4];
        encoderValues = new double[4];
    }

    public static void setLeftRightPower(double leftPower, double rightPower)
    {
        driveRightFront.setPower(rightPower);
        driveRightBack.setPower(rightPower);
        driveLeftFront.setPower(leftPower);
        driveLeftBack.setPower(leftPower);
    }

    public boolean hasTargetHit(double target)
    {
        updateEncoderValues();
        boolean rightTargetHit = false;
        boolean leftTargetHit = false;

        if(Math.abs(encoderValues[RF])*TICKS_TO_ROT > target || Math.abs(encoderValues[RB])*TICKS_TO_ROT > target)
        {
            rightTargetHit = true;
        }

        if(Math.abs(encoderValues[LF])*TICKS_TO_ROT> target || Math.abs(encoderValues[LB])*TICKS_TO_ROT > target)
        {
            leftTargetHit = true;
        }

        if(leftTargetHit && rightTargetHit)
        {
            zeroLeftEncoders();
            zeroRightEncoders();
            return true;
        }
        else
        {
            return false;
        }
    }

    public void updateEncoderValues()
    {
        encoderValues[RF] = driveRightFront.getCurrentPosition()-encoderZeroes[RF];
        encoderValues[RB] = driveRightBack.getCurrentPosition()-encoderZeroes[RB];
        encoderValues[LF] = driveLeftFront.getCurrentPosition()-encoderZeroes[LF];
        encoderValues[LB] = driveLeftBack.getCurrentPosition()-encoderZeroes[LB];
    }

    public void zeroLeftEncoders()
    {
        encoderZeroes[LF] = driveLeftFront.getCurrentPosition();
        encoderZeroes[LB] = driveLeftBack.getCurrentPosition();
    }

    public void zeroRightEncoders()
    {
        encoderZeroes[RF] = driveRightFront.getCurrentPosition();
        encoderZeroes[RB] = driveRightBack.getCurrentPosition();
    }

    public void hook(double hookLPosition, double hookRPosition)
    {
        hookLeft.setPosition(hookLPosition);
        hookRight.setPosition(hookRPosition);
    }
    public void sideClimbers(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(gamepad.dpad_left)
        {
            sideLPosition = 0.95;
            sideRPosition = 0.0;
            sideLeft.setPosition(sideLPosition);
            sideRight.setPosition(sideRPosition);
        }
        else if(gamepad.dpad_right)
        {
            sideLPosition = 0.2;
            sideRPosition = 1.0;
            sideLeft.setPosition(sideLPosition);
            sideRight.setPosition(sideRPosition);
        }
    }
}