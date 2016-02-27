package com.whs542.ftc2016.teleOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by DanielWang on 12/5/15.
 */

public class RedTeleOp extends OpMode
{
    WHSRobot bot;

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.RED);
    }

    public void loop() {
        //-----------------
        //Gamepad 1
        //-----------------
        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());

        //drive
        bot.drive.setLeftRightPower(gamepad1.left_stick_y * 0.8, gamepad1.right_stick_y * 0.8);
        bot.drive.setOrientation(gamepad1.a);
        bot.drive.setHook(gamepad1.right_trigger == 1.0);

        //Slides
        bot.slides.setRamp(gamepad1.right_bumper);
        bot.slides.setAngle(gamepad1.dpad_up, gamepad1.dpad_down);
        bot.slides.setIntake(gamepad1.left_trigger == 1.0 || gamepad2.left_trigger == 1.0, gamepad1.left_bumper || gamepad2.left_bumper);
        //bot.slides.setTransmissionPower(gamepad1.y, gamepad1.x);
        bot.slides.testLinearSlide(0.5, gamepad1.y, gamepad1.x);

        bot.drive.setAutoArm(gamepad1.b);

    }

    public void stop()
    {

    }
}
