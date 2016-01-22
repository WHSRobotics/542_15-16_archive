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

    public double servoDoorValue;
    //public double servoExtensionValue;

    private int debrisCounter;

    boolean boxFlap = false; //Box flap, true = open, false = closed
    boolean boxExtended;//Inner box extension, true = open, false = retracted

    public static ProximityGP2Y0D810Z0F proximity0;
    public static ProximityGP2Y0D810Z0F proximity1;
    public static ProximityGP2Y0D810Z0F proximity2;
    public static ProximityGP2Y0D810Z0F proximity3;

    public ScoringBox(HardwareMap boxMap)
	{
        boxExtendServo = boxMap.servo.get("box_extend");    //Inner Box Extension
        boxExtendServo.setPosition(0.5);
        //boxFlapServo = boxMap.servo.get("box_flap");    //Box Flap Servo
        //boxFlapServo.setPosition(0.4);
        //proximity0 = new ProximityGP2Y0D810Z0F(boxMap, 0);
        //proximity1 = new ProximityGP2Y0D810Z0F(boxMap, 1);
        //proximity2 = new ProximityGP2Y0D810Z0F(boxMap, 2);
        //proximity3 = new ProximityGP2Y0D810Z0F(boxMap, 3);
    }

    public void boxFlapState(double doorFlapValue)
    {
        //Closed
                boxFlapServo.setPosition(doorFlapValue);     //Change the servo value for actual box position
                                                    //Left Scoring Box Servo Value 0.85
                                                    //Right Scoring Box Servo Value 0.15
                //Open
                // Change the servo value for actual box position
                                                    //Left Scoring Box Servo Value 0.6
                                                    //Right Scoring Box Servo Value 0.4
    }
    public void innerBoxExtension(double servoExtensionValue) //com.qualcomm.robotcore.hardware.Gamepad gamepad
    {
        boxExtendServo.setPosition(servoExtensionValue);
        /*
        //Extend
        if(boxExtended = false)
        {
            if(gamepad.x)
            {
                servoExtensionValue = 1.0;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = true;
            }
            else
            {
                servoExtensionValue = 0.5;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = false;
            }
        }
        //Retract
        else if(boxExtended = true)
        {
            if(gamepad.y)
            {
                servoExtensionValue = 0.0;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = false;
            }
            else
            {
                servoExtensionValue = 0.5;
                boxExtendServo.setPosition(servoExtensionValue);
                //boxExtended = true;
            }
        }
        else
        {
            boxExtended = false;
        }
        */
    }
}
