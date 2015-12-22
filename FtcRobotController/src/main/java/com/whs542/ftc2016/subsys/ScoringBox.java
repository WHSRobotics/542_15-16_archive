package com.whs542.ftc2016.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


//TODO: Figure out subsystem actuators

public class ScoringBox
{
    //Box Testing//
    public static Servo servo1;
    public static Servo servo2;
    //Box Testing//

	public ScoringBox(HardwareMap boxMap)
	{
        //Box Testing//
        servo1 = boxMap.servo.get("servo1");
        servo2 = boxMap.servo.get("servo2");
        //Box Testing//
	}
}