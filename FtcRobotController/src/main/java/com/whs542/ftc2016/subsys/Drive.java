package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.whs542.lib.*;

//
// Drive Subsystem Class
//

//TODO: Define Subsys class
//TODO: Define an interface?
//TODO: Implement left side/right side travel distance

public class Drive
{
    private Alliance color;
    private static final double WHEEL_DIAMETER = 15.24;
    private static final double TICKS_TO_ROT = 1.0/1120.0;
    private static final double TICKS_TO_RAD = 2.0*Math.PI/1120.0;
    private static final double TICKS_TO_DIST_CM = WHEEL_DIAMETER*Math.PI/1120.0;

    private static Servo leftChurroHook;
    private static Servo rightChurroHook;
    private static Servo blueSwitcher;
    private static Servo redSwitcher;

    private Toggler switcherSwitch = new Toggler(2);
    private Toggler hookSwitch = new Toggler(2);

	private static DcMotor rightFrontMotor;
	private static DcMotor rightBackMotor;
	private static DcMotor leftFrontMotor;
	private static DcMotor leftBackMotor;

    public static double [] encoderZeroes;
    public static double [] encoderValues;

    public static int RF = 0;
    public static int RB = 1;
    public static int LF = 2;
    public static int LB = 3;

	// ----------------------------------
	// Drive Constructor
	// ----------------------------------
	// -Initializes the hardware references

	public Drive(HardwareMap driveMap, Alliance side)
	{
        rightChurroHook = driveMap.servo.get("drive_rch");
        leftChurroHook = driveMap.servo.get("drive_lch");
        blueSwitcher = driveMap.servo.get("drive_bs");
        redSwitcher = driveMap.servo.get("drive_rs");

		rightFrontMotor = driveMap.dcMotor.get("drive_rf");
        rightBackMotor = driveMap.dcMotor.get("drive_rb");
        leftFrontMotor = driveMap.dcMotor.get("drive_lf");
        leftBackMotor = driveMap.dcMotor.get("drive_lb");
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

        rightFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightBackMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        leftFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightBackMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        encoderZeroes = new double[4];
        encoderValues = new double[4];
        color = side;
    }

    //Distribute Alliance color to necessary classes
    public void setSwitcher(boolean trigger)
    {
        switcherSwitch.changeState(trigger);
        switch(color)
        {
            case RED:
                //closed blue
                blueSwitcher.setPosition(0.0);
                switch(switcherSwitch.currentState())
                {
                    case 0:
                        //closed
                        redSwitcher.setPosition(0.9);
                        break;

                    case 1:
                        //open
                        redSwitcher.setPosition(0.15);
                        break;
                }
                break;

            case BLUE:
                //closed red
                redSwitcher.setPosition(0.9);
                switch(switcherSwitch.currentState())
                {
                    case 0:
                        //closed
                        blueSwitcher.setPosition(0.0);
                        break;

                    case 1:
                        //open
                        blueSwitcher.setPosition(0.7);
                        break;
                }
                break;
        }
    }

    public void setHook(boolean trigger)
    {
        hookSwitch.changeState(trigger);
        switch(hookSwitch.currentState())
        {
            case 0:
                //unhooked
                leftChurroHook.setPosition(0.0);
                rightChurroHook.setPosition(1.0);
                break;

            case 1:
                //hooked
                //90 degrees left - 0.45
                //90 degrees right 0.4
                leftChurroHook.setPosition(1.0);
                rightChurroHook.setPosition(0.0);
        }
    }

    // ----------------------------------
    // Drive Methods
    // ----------------------------------

    public static void setLeftRightPower(double leftPower, double rightPower)
    {
        rightFrontMotor.setPower(rightPower);
        rightBackMotor.setPower(rightPower);
        leftFrontMotor.setPower(leftPower);
        leftBackMotor.setPower(leftPower);
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