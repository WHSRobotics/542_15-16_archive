package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
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
    private static final double JOY_THRESHOLD = 0.2;

    private Servo leftChurroHook;
    private Servo rightChurroHook;
    private Servo blueSwitcher;
    private Servo redSwitcher;

    private Toggler switcherSwitch = new Toggler(2);
    private Toggler hookSwitch = new Toggler(2);
    private Toggler orientationSwitch = new Toggler(2);

	private DcMotor rightFrontMotor;
	private DcMotor rightBackMotor;
	private DcMotor leftFrontMotor;
	private DcMotor leftBackMotor;

    public double [] encoderZeroes;
    public double [] encoderValues;

    public int RF = 0;
    public int RB = 1;
    public int LF = 2;
    public int LB = 3;

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

        /*rightFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightBackMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        leftFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightBackMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);*/

        encoderZeroes = new double[4];
        encoderValues = new double[4];
        color = side;
    }

    //Distribute Alliance color to necessary classes
    public void setSwitcher(boolean trigger)
    {
        switcherSwitch.changeState(trigger);
        switch(switcherSwitch.currentState())
        {
            case 0:
                //closed
                switcherUp();
            break;

            case 1:
                //open
                switcherDown();
            break;
        }
    }

    public void switcherUp()
    {
        redSwitcher.setPosition(0.9);
        blueSwitcher.setPosition(0.0);
    }

    public void switcherDown()
    {
        switch(color)
        {
            case RED:
                redSwitcher.setPosition(0.15);
                blueSwitcher.setPosition(0.0);
            break;

            case BLUE:
                blueSwitcher.setPosition(0.7);
                redSwitcher.setPosition(0.9);
            break;
        }
    }

    public void setHook(boolean trigger)
    {
        hookSwitch.changeState(trigger);
        switch(hookSwitch.currentState())
        {
            case 0:
                unhook();
                break;

            case 1:
                hook90();
        }
    }

    public String getHookState()
    {
        String state = "null";
        switch(hookSwitch.currentState())
        {
            case 0:
                state = "Unhooked";
            break;

            case 1:
                state = "Hooked";
            break;
        }
        return state;
    }

    public void unhook()
    {
        leftChurroHook.setPosition(0.0);
        rightChurroHook.setPosition(1.0);
    }

    public void hook()
    {
        leftChurroHook.setPosition(1.0);
        rightChurroHook.setPosition(0.0);
    }

    public void hook90()
    {
        leftChurroHook.setPosition(0.45);
        rightChurroHook.setPosition(0.4);
    }

    // ----------------------------------
    // Drive Methods
    // ----------------------------------

    public void setLeftRightPower(double leftPower, double rightPower)
    {
        rightFrontMotor.setPower(7.0/9.0 * rightPower);
        rightBackMotor.setPower(7.0/9.0 * rightPower);
        leftFrontMotor.setPower(7.0/9.0 * leftPower);
        leftBackMotor.setPower(7.0/9.0 * leftPower);
    }

    public void setDrive(double leftPower, double rightPower)
    {
        rightPower = Math.abs(rightPower) > JOY_THRESHOLD ? rightPower * 7.0/9.0 : 0.0;
        leftPower = Math.abs(leftPower) > JOY_THRESHOLD ? leftPower * 7.0/9.0 : 0.0;
        switch(orientationSwitch.currentState())
        {
            case 0:
                rightFrontMotor.setPower(rightPower);
                rightBackMotor.setPower(rightPower);
                leftFrontMotor.setPower(leftPower);
                leftBackMotor.setPower(leftPower);
            break;

            case 1:
                rightFrontMotor.setPower(-leftPower);
                rightBackMotor.setPower(-leftPower);
                leftFrontMotor.setPower(-rightPower);
                leftBackMotor.setPower(-rightPower);
            break;
        }
    }

    public void setOrientation(boolean trigger)
    {
        orientationSwitch.changeState(trigger);
    }

    public String getOrientation()
    {
        String o = "null";
        switch(orientationSwitch.currentState())
        {
            case 0:
                o = "Normal";
                        break;

            case 1:
                o = "Reverse";
                break;
        }
        return o;
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