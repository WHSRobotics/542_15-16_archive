package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class servoTest extends OpMode
{
    Servo ts1;
    Servo ts2;
    Servo ts3;
    Servo ts4;

    @Override
    public void init()
    {

        ts1 = hardwareMap.servo.get("ts1");
        ts2 = hardwareMap.servo.get("ts2");
        ts3 = hardwareMap.servo.get("ts3");
        ts4 = hardwareMap.servo.get("ts4");

    }

    @Override
    public void loop() {
        ts1.setPosition(Math.abs(gamepad1.left_stick_y));
        ts2.setPosition(Math.abs(gamepad1.right_stick_y));
        ts3.setPosition(Math.abs(gamepad2.left_stick_y));
        ts4.setPosition(Math.abs(gamepad2.right_stick_y));

    }
}