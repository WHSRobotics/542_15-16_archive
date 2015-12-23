package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.ftc2016.RobotMain;

//
// Linear Slides Subsystem Class
//

//TODO: Implement Angling and Extension methods

public class LinearSlides
{
    // ----------------------------------
    // Linear Slide Variables
    // ----------------------------------
    // -Hardware object reference variables for motors and servos
    // -Double variables for servo positions

    private DcMotor leftAnglingMotor;
    private DcMotor rightAnglingMotor;

	private DcMotor leftExtensionMotor;
	private DcMotor rightExtensionMotor;
	private Servo shiftServo;

    private double speedShiftPosition = 0.5;
	private double torqueShiftPosition = 1.0;

    // ----------------------------------
    // Intake Constructor
    // ----------------------------------
    // -Initializes the hardware references

    private double hookedAngle;
    private double unhookedAngle;

	public LinearSlides(HardwareMap slideMap)
	{
        leftAnglingMotor = slideMap.dcMotor.get("ls_la");
        rightAnglingMotor = slideMap.dcMotor.get("ls_ra");

        leftExtensionMotor = slideMap.dcMotor.get("ls_le");
        rightExtensionMotor = slideMap.dcMotor.get("ls_re");
        shiftServo = slideMap.servo.get("ls_ss");
    }

    // ----------------------------------
    // Linear Slide Methods
    // ----------------------------------

    public void setAngle()
    {

    }

    public double getAngle()
    {
        //Based on encoder data
        return 0.0;
    }

    public void setExtensionLength()
    {

    }

    public double getExtensionLength()
    {
        //Based on encoder data
        return 0.0;
    }

    public void setExtensionPower(double power)
    {
    	leftExtensionMotor.setPower(power);
    	rightExtensionMotor.setPower(power);
    }

    public void setAnglePosition(double angle)
    {

    }

    public void setExtensionPosition(double length)
    {

    }

    public void setShiftServoPosition(double input)
    {
        shiftServo.setPosition(Math.abs(input));
    }

    public void shiftToTorque()
    {
    	shiftServo.setPosition(torqueShiftPosition);
    }

    public void shiftToSpeed()
    {
    	shiftServo.setPosition(speedShiftPosition);
    }
}