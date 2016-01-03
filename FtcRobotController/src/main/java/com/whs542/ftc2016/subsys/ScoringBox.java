package com.whs542.ftc2016.subsys;

import com.whs542.lib.sensors.ProximityGP2Y0D810Z0F;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
//TODO: Figure out subsystem actuators

public class ScoringBox
{
    public static Servo boxExtendServo;
    public static Servo boxFlapServo;

    private Servo doorServo;
    private Servo extendServo;

    private double doorOpen;
    private double doorClosed;

    private ProximityGP2Y0D810Z0F proximitySensor;

    boolean boxFlap = false; //Box flap, true = open, false = closed
    boolean boxExtended;//Inner box extension, true = open, false = retracted

    LinearSlides linearSlide;
	public ScoringBox(HardwareMap boxMap)
	{
        boxExtendServo = boxMap.servo.get("box_extend");    //Inner Box Extension
        boxFlapServo = boxMap.servo.get("box_flap");    //Box Flap Servo
    }


    public void boxFlapState(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(linearSlide.linearSlideExtended == true)
        {
            if(gamepad.a)
            {
                boxFlapServo.setPosition(1.0);      //Change the servo value for actual box position
                boxFlap = true;
            }
            else if(gamepad.b)
            {
                boxFlapServo.setPosition(0.0);      //Change the servo value for actual box position
                boxFlap = false;
            }
        }
        else
        {

        }
    }
    public void innerBoxExtension(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(boxExtended = false && linearSlide.linearSlideExtended == true)
        {
            if(gamepad.x)
            {
                boxExtendServo.setPosition(1.0);
                boxExtended = true;
            }
            else
            {
                boxExtendServo.setPosition(0.5);
                boxExtended = false;
            }
        }
        else if(boxExtended = true && linearSlide.linearSlideExtended == true)
        {
            if(gamepad.y)
            {
                boxExtendServo.setPosition(0.0);
                boxExtended = false;
            }
            else
            {
                boxExtendServo.setPosition(0.5);
                boxExtended = true;
            }
        }
        else
        {
            boxExtended = false;
        }
    }


    //Use in Testing//
    public void simpleBox(com.qualcomm.robotcore.hardware.Gamepad gamepad)
    {
        if(gamepad.a)
        {
            boxFlapServo.setPosition(0.5);
        }
        else if(gamepad.b)
        {
            boxFlapServo.setPosition(0.0);
        }
        else if(gamepad.x)
        {
            boxExtendServo.setPosition(1.0);
        }
        else if(gamepad.y)
        {
            boxExtendServo.setPosition(0.0);
        }
        else
        {
            boxExtendServo.setPosition(0.5);
        }
    }
    //Use in Testing//
}
