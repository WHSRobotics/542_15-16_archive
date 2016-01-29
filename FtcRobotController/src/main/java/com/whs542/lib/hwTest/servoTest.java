package com.whs542.lib.hwTest;

import com.qualcomm.hardware.ModernRoboticsUsbServoController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class servoTest extends OpMode
{
    Integer [] servoNum = new Integer[6];
    Servo [] servos = new Servo[6];

    @Override
    public void init()
    {
        for(int i = 1; i<7; i++)
        {
            servoNum[i-1] = new Integer(i);
            servos[i-1] = hardwareMap.servo.get(servoNum[i-1].toString());
        }
    }

    @Override
    public void loop()
    {
        for(int i  = 1; i<7; i++)
        {
            servos[i-1].setPosition(Math.abs(gamepad1.left_stick_y));
        }
    }
}