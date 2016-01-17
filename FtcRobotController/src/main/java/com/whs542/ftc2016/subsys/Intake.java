package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.whs542.lib.Toggler;

//
// Intake Subsystem Class
//

public class Intake
{
	public int INTAKE_EXTENSION_STATE = 0;
	public int INTAKE_RUNNING_STATE = 0;
	// ----------------------------------
	// Intake Variables
	// ----------------------------------
	// -Hardware object reference variables for motors and servos
	// -Double variables for servo positions

	private DcMotor intakeMotor;
	private Servo dropDownServo;

    private Toggler runSwitch = new Toggler(2);
    private Toggler dropSwitch = new Toggler(2);

	// ----------------------------------
	// Intake Constructor
	// ----------------------------------
	// -Initializes the hardware references

	public Intake(HardwareMap intakeMap)
	{
		dropDownServo = intakeMap.servo.get("intake_dds");
		intakeMotor = intakeMap.dcMotor.get("intake_motor");



		//Should output be too coarse, uncomment this, and add an encoder
		//intakeMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
	}

	// ----------------------------------
	// Intake Methods
	// ----------------------------------

    public void runIntake(boolean in, boolean out)
    {
        if(dropSwitch.currentState() == 1) {
            if (in) {
                intakeMotor.setPower(1.0);
            } else if (out) {
                intakeMotor.setPower(-1.0);
            }
            else
            {
                intakeMotor.setPower(0.0);
            }
        }
        else
        {
            intakeMotor.setPower(0.0);
        }
    }

    public void setRun(boolean trigger, boolean reverse)
    {
        runSwitch.changeState(trigger);
        switch(runSwitch.currentState())
        {
            case 0:
                //Intake Off
                intakeMotor.setPower(reverse ? -1.0 :0.0);
            break;

            case 1:
                //Intake Running
                intakeMotor.setPower(reverse ? -1.0: 1.0);
            break;
        }
    }

    public void setDrop(boolean trigger)
    {
        dropSwitch.changeState(trigger);
        switch(dropSwitch.currentState())
        {
            //Undropped
            case 0:
                dropDownServo.setPosition(1.0);
                break;

            //Dropped
            case 1:
                dropDownServo.setPosition(0.0);
            break;
        }
    }

    public void dropIntake()
    {
        dropDownServo.setPosition(0.0);
    }
}