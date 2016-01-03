package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
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

	private static DcMotor rightFrontMotor;
	private static DcMotor rightBackMotor;
	private static DcMotor leftFrontMotor;
	private static DcMotor leftBackMotor;

    public double [] encoderZeroes;
    public double [] encoderValues;

    public static int RF = 0;
    public static int RB = 1;
    public static int LF = 2;
    public static int LB = 3;

	public Drive(HardwareMap driveMap)
	{
		rightFrontMotor = driveMap.dcMotor.get("drive_rf");
        //rightBackMotor = driveMap.dcMotor.get("drive_rb");
        //leftFrontMotor = driveMap.dcMotor.get("drive_lf");
        //leftBackMotor = driveMap.dcMotor.get("drive_lb");
        //leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        //leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

        rightFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        //rightBackMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        //leftFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        //rightBackMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        encoderZeroes = new double[4];
        encoderValues = new double[4];
    }

    public static void setLeftRightPower(double leftPower, double rightPower)
    {
        rightFrontMotor.setPower(rightPower);
        //rightBackMotor.setPower(rightPower);
        //leftFrontMotor.setPower(leftPower);
        //leftBackMotor.setPower(leftPower);
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
        encoderValues[RF] = rightFrontMotor.getCurrentPosition()-encoderZeroes[RF];
        encoderValues[RB] = rightBackMotor.getCurrentPosition()-encoderZeroes[RB];
        encoderValues[LF] = leftFrontMotor.getCurrentPosition()-encoderZeroes[LF];
        encoderValues[LB] = leftBackMotor.getCurrentPosition()-encoderZeroes[LB];
    }

    public void zeroLeftEncoders()
    {
        encoderZeroes[LF] = leftFrontMotor.getCurrentPosition();
        encoderZeroes[LB] = leftBackMotor.getCurrentPosition();
    }

    public void zeroRightEncoders()
    {
        encoderZeroes[RF] = rightFrontMotor.getCurrentPosition();
        encoderZeroes[RB] = rightBackMotor.getCurrentPosition();
    }
}