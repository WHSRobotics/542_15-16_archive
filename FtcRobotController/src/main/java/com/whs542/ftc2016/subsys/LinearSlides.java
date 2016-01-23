package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.ftc2016.subsys.*;

//TODO: Figure out if we should set the speed shift and torque shift positions when instantiating or elsewhere.
//Should we set the shifter positions as a constructor parameter, the testing loop is easier
//Should we set the shifter position here permanently as a field, it's better information hiding

public class LinearSlides
{
    //
	private DcMotor leftTransmissionMotor;
	private DcMotor rightTransmissionMotor;

	private Servo shiftServo;
    private Servo lockServo;

    private double speedShiftPosition;
	private double torqueShiftPosition;

    public double shiftServoPosition;
    public double lockServoPosition;

    boolean linearSlideExtended;    // true means the linear slide is extended
                                    // false mean the linear slide is retracted

    int positionCounter;

    ScoringBox scoreBox;
    Intake intake;

	public LinearSlides(HardwareMap slideMap)
	{
        leftTransmissionMotor = slideMap.dcMotor.get("ls_l");
        rightTransmissionMotor = slideMap.dcMotor.get("ls_r");
        shiftServo = slideMap.servo.get("ls_ss");
        lockServo = slideMap.servo.get("ls_ls");
        lockServo.setPosition(0.65);
        linearSlideExtended = false;
        positionCounter = 0;
    }

    //Slide extension state (includes box extension state)
    //Slide angle state

    public void setTransmissionPower(double power)
    {
        leftTransmissionMotor.setPower(power);
        rightTransmissionMotor.setPower(power);
    }

    public void shiftTransmissionServo(double servoPosition) //int servoState
    {
        shiftServo.setPosition(servoPosition);
        /*
        if(gamepad.a)
        {
            shiftServo.setPosition(0.0);
        }
        else if(gamepad.b)
        {
            shiftServo.setPosition(0.5);
        }

        /*
        switch(servoState)
        {

            case 1:
                shiftServoPosition = 0.5;
                shiftServo.setPosition(shiftServoPosition);
            case 2:
                shiftServoPosition = 0.0;
                shiftServo.setPosition(shiftServoPosition);
        }
        */
    }
    public void lockTransmissionServo(double servoPosition) //int lockState
    {
        lockServo.setPosition(servoPosition);
        /*
        if(gamepad.x)
        {
            lockServo.setPosition(0.95);
        }
        else if(gamepad.y)
        {
            lockServo.setPosition(0.65);
        }
        /*
        switch(lockState)
        {
            case 1:
                lockServoPosition = 0.95;
                lockServo.setPosition(lockServoPosition);
            case 2:
                lockServoPosition = 0.65;
                lockServo.setPosition(lockServoPosition);
        }
        */
    }

    public void setLinearPosition(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(gamepad.right_bumper)
        {
            if(positionCounter == 0)
            {
                //Have the encoders set to 32 degrees
                //positionCounter++;
            }
            else
            {
                //Have the power be set to 0
                //positionCounter
            }
        }
        else if(gamepad.left_bumper)
        {
            if(positionCounter == 0)
            {
                //Have the encoders set to 64 degrees
                //positionCounter = 1;
            }
            else if(positionCounter == 1)
            {
                //Have the encoders set to 32 degrees
                //positionCounter++;
            }
            else
            {
                //Have the power be set to 0
                //positionCounter == 0;
            }
        }
        else if(positionCounter == 0)
        {
            //Have the power be set to 0
        }
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