package com.whs542.ftc2016.teleOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by DanielWang on 12/5/15.
 */

public class BlueTeleOp extends OpMode
{
    WHSRobot bot;

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.BLUE);
    }

    public void start()
    {

    }

    public void loop() {

        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());
        telemetry.addData("Joy", gamepad1.left_stick_y/2.0 + " " + gamepad1.right_stick_y/2.0);

        //drive
        bot.drive.setLeftRightPower(gamepad1.left_stick_y/2.0, gamepad1.right_stick_y/2.0);
        bot.drive.setOrientation(gamepad1.a);
        bot.drive.setHook(gamepad1.right_trigger == 1.0);

        //Slides
        bot.slides.setRamp(gamepad1.right_bumper);
        bot.slides.setAngle(gamepad2.dpad_up, gamepad2.dpad_down);
        bot.slides.setIntake(gamepad1.left_trigger == 1.0, gamepad1.left_bumper);
        bot.slides.setTransmissionPower(gamepad2.left_trigger == 1.0, gamepad2.left_bumper);
    }

    public void stop()
    {

    }
}
