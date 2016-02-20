package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.whs542.ftc2016.subsys.WHSRobot;

public class servoTest extends OpMode
{
    Servo ts1;
    public Servo ts2;
    Servo ts3;
    Servo ts4;
    WHSRobot bot;

    @Override
    public void init()
    {

        //ts1 = hardwareMap.servo.get("1");
        ts2 = hardwareMap.servo.get("2");
        //ts2.setPosition(1.0);
        //ts3 = hardwareMap.servo.get("ts3");
        //ts4 = hardwareMap.servo.get("ts4");

    }

    @Override
    public void loop()
    {
        double position = 1.0;
        while(position > 0.0) {
            ts2.setPosition(position);
            position -= 0.2;
        }
    }

    public void sto()
    {

    }
}