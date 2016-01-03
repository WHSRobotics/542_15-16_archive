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
	private DcMotor leftTransmissionMotor;
	private DcMotor rightTransmissionMotor;
	private Servo shiftServo;

    private double speedShiftPosition;
	private double torqueShiftPosition;

    private double hookedAngle;
    private double unhookedAngle;

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
        linearSlideExtended = false;
        positionCounter = 0;
    }

    //Slide extension state (includes box extension state)
    //Slide angle state

    public void setTransmissionPower(double power, com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(gamepad.dpad_up && scoreBox.boxFlap == true && scoreBox.boxExtended == false)
        {
            leftTransmissionMotor.setPower(power * (7.0/9.0));
            rightTransmissionMotor.setPower(power * (7.0/9.0));
            linearSlideExtended = true;
        }
        else if(gamepad.dpad_down && scoreBox.boxFlap == false && scoreBox.boxExtended == false)
        {
            leftTransmissionMotor.setPower(-power * (7.0/9.0));
            rightTransmissionMotor.setPower(-power * (7.0/9.0));
            linearSlideExtended = false;
        }
        else if(gamepad.left_bumper)
        {
            shiftServo.setPosition(0.7);
        }
        else if(gamepad.right_bumper)
        {
            shiftServo.setPosition(0.3);
        }
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