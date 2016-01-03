package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
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

    public static int slideState;

    private static DcMotor anglingMotor;

	private static DcMotor leftExtensionMotor;
	private static DcMotor rightExtensionMotor;
	private static Servo shiftServo;
    private static Servo lockServo;

    public static double fullLength;

    //Pulley Circumference = 3pi in/2 rot
    //Speed Gear In to Out = 15rot/7rot
    //Torque Gear In to Out = 15rot/28rot

    private static final double TORQUE_TICK_TO_IN = 9.0*Math.PI/12544.0;
    private static final double SPEED_TICK_TO_IN = 9.0*Math.PI/3136.0;

    private static boolean speedMode;

    // ----------------------------------
    // Intake Constructor
    // ----------------------------------
    // -Initializes the hardware references

    private double hookedAngle;
    private double unhookedAngle;

	public LinearSlides(HardwareMap slideMap)
	{
        anglingMotor = slideMap.dcMotor.get("ls_am");
        leftExtensionMotor = slideMap.dcMotor.get("ls_le");
        rightExtensionMotor = slideMap.dcMotor.get("ls_re");

        shiftServo = slideMap.servo.get("ls_ss");
        lockServo = slideMap.servo.get("ls_ls");

        anglingMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        leftExtensionMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightExtensionMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }

    // ----------------------------------
    // Linear Slide Methods
    // ----------------------------------

    public double getAngle()
    {
        return 0.0;
    }

    public void setTransmissionPower(double input)
    {
        switch(slideState)
        {
            case 0:
                leftExtensionMotor.setPower(0.0);
                rightExtensionMotor.setPower(0.0);
            break;

            case 1:
                leftExtensionMotor.setPower(input);
                rightExtensionMotor.setPower(input);
            break;

            case 2:
                leftExtensionMotor.setPower(-input);
                rightExtensionMotor.setPower(-input);
            break;
        }
    }

    public void setLockServo(double input)
    {
        lockServo.setPosition(Math.abs(input));
    }

    public double getExtensionLength()
    {
       return  SPEED_TICK_TO_IN * (leftExtensionMotor.getCurrentPosition() + rightExtensionMotor.getCurrentPosition())/2.0;
    }

    public double getExtensionLengthTorque()
    {
        //get last speed extension length
        return TORQUE_TICK_TO_IN * (leftExtensionMotor.getCurrentPosition() + rightExtensionMotor.getCurrentPosition())/2.0;
    }

    public void setShiftServoPosition(double input)
    {
        shiftServo.setPosition(Math.abs(input));
    }

    public void shiftToTorque()
    {
        fullLength = getExtensionLength();
    	shiftServo.setPosition(1.0);
    }

    public void shiftToSpeed()
    {
    	shiftServo.setPosition(0.4);
    }

    public void lock()
    {
        lockServo.setPosition(1.0);
    }

    public void unlock()
    {
        lockServo.setPosition(0.5);
    }
}