package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class servoTest extends OpMode
{
    Servo testServo;

    @Override
    public void init()
    {
        testServo = hardwareMap.servo.get("servo");
    }

    @Override
    public void loop()
    {
        testServo.setPosition(gamepad1.left_stick_y);
    }
}