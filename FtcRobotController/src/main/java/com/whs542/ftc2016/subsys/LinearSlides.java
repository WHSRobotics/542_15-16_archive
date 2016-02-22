package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.lib.Alliance;
import com.whs542.lib.Toggler;
import com.whs542.lib.sensors.CurrentACS711EX;
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

    public static Alliance color;

    public static Toggler coarseAngler = new Toggler(7,0);
    public static Toggler fineAngler = new Toggler(5,0);

    private static DcMotor anglingMotor;
    private static DcMotor intakeMotor;

	private static DcMotor leftExtensionMotor;
	private static DcMotor rightExtensionMotor;

    public static double fullLength;

    public static double highestMinimum;

    //Pulley Circumference = 3pi in/2 rot
    //Speed Gear In to Out = 15rot/7rot
    //Torque Gear In to Out = 15rot/28rot

    private static final double TORQUE_TICK_TO_IN = 9.0*Math.PI/12544.0;
    private static final double SPEED_TICK_TO_IN = 9.0*Math.PI/3136.0;

    // ----------------------------------
    // Intake Constructor
    // ----------------------------------
    // -Initializes the hardware references

    public double shiftServoPosition;
    public double lockServoPosition;

    boolean linearSlideExtended;    // true means the linear slide is extended
                                    // false mean the linear slide is retracted

    int positionCounter;

	public LinearSlides(HardwareMap slideMap, Alliance side)
	{
        anglingMotor = slideMap.dcMotor.get("ls_am");
        intakeMotor = slideMap.dcMotor.get("intake_motor");

        leftExtensionMotor = slideMap.dcMotor.get("ls_le");
        rightExtensionMotor = slideMap.dcMotor.get("ls_re");

        leftExtensionMotor.setDirection(DcMotor.Direction.REVERSE);

        //anglingMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        leftExtensionMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightExtensionMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        highestMinimum = anglingMotor.getCurrentPosition();

        color = side;
    }

    // ----------------------------------
    // Linear Slide Methods
    // ----------------------------------

    public double getAngle()
    {
        //Angle is a function of String length
        //For one rotation of the pulley, there is 4 rotation of the motor, which is a AM-NV20 with 560 pulses per rotation
        return Math.asin((Math.pow((Math.PI * anglingMotor.getCurrentPosition()/1120.0 - 0.01615593741),2.0) - 33.6177)/-31.8308393386)+0.577018458248;

    }

    //calibratory functions needed
    public void calibrateSlides()
    {

    }

    public void calibrateAngler()
    {

    }

    public void setAngler(boolean up, boolean down, boolean fine)
    {
        if(fine)
        {
            fineAngler.changeState(up,down);
        }
        else
        {
            coarseAngler.changeState(up,down);
        }
        //Add more conditions so that we can zero out automatically to allow easier control
        setAngle(29.0*coarseAngler.currentState()/3.0 + 5.0 - 29.0*fineAngler.currentState()/15.0);

    }

    //Takes in a degree value
    //need some kind of controller or target matched function
    public void setAngle(double angle)
    {
        if(angle != getAngle())
        {
            //FIX THIS
            //anglingMotor.setPower((angle - getAngle());
        }
        else
        {
            anglingMotor.setPower(0.0);
        }
    }

    public void setAngle(boolean up, boolean down)
    {
        if(up)
        {
            anglingMotor.setPower(7.0/9.0);
        }
        else if(down)
        {
            anglingMotor.setPower(-3.5/9.0);
        }
        else
        {
            anglingMotor.setPower(0.0);
        }
    }

    //Set extension speed
    public void setTransmissionPower(boolean up, boolean down)
    {
        if(up)
        {
            leftExtensionMotor.setPower(-1.0);
            rightExtensionMotor.setPower(-1.0);
        }
        else if(down)
        {
            leftExtensionMotor.setPower(1.0);
            rightExtensionMotor.setPower(1.0);
        }
        else
        {
            leftExtensionMotor.setPower(0.0);
            rightExtensionMotor.setPower(0.0);
        }
    }

    public double getExtensionLength()
    {
       return  SPEED_TICK_TO_IN * (leftExtensionMotor.getCurrentPosition() + rightExtensionMotor.getCurrentPosition())/2.0;
    }


}