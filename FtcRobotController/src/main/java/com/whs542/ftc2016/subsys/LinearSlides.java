package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.whs542.ftc2016.RobotMain;

//TODO: Figure out if we should set the speed shift and torque shift positions when instantiating or elsewhere.
//Should we set the shifter positions as a constructor parameter, the testing loop is easier
//Should we set the shifter position here permanently as a field, it's better information hiding

public class LinearSlides extends RobotMain
{
	private DcMotor leftTransmissionMotor;
	private DcMotor rightTransmissionMotor;
	private Servo shiftServo;

    private double speedShiftPosition;
	private double torqueShiftPosition;

    private int positionCounter;

	public LinearSlides(HardwareMap slideMap)
	{
        leftTransmissionMotor = slideMap.dcMotor.get("ls_l");
        rightTransmissionMotor = slideMap.dcMotor.get("ls_r");
        shiftServo = slideMap.servo.get("ls_ss");
        positionCounter = 0;
    }

    public void setTransmissionPower(double power)
    {
    	leftTransmissionMotor.setPower(power);
    	rightTransmissionMotor.setPower(power);
    }

    public void setLinearPosition()
    {
        if(gamepad1.a)
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
        else if(gamepad1.b)
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