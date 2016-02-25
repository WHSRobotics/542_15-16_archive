package com.whs542.ftc2016.teleOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.lib.sensors.PIDController;

/**
 * Created by DanielWang on 12/5/15.
 */

public class RedTeleOp extends OpMode
{
    WHSRobot bot;
    PIDController pidControl;
    private double correction;

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.RED);
        pidControl = new PIDController(0.00025, 0.0, 0.0, 0.6);
    }

    public void start()
    {

    }

    public void loop() {
        //-----------------
        //Gamepad 1
        //-----------------
        correction = pidControl.update(bot.slides.leftExtensionMotor.getCurrentPosition(), bot.slides.rightExtensionMotor.getCurrentPosition());
        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());
        telemetry.addData("Joy", gamepad1.left_stick_y / 2.0 + " " + gamepad1.right_stick_y / 2.0);

        //drive
        bot.drive.setLeftRightPower(gamepad1.left_stick_y / 2.0, gamepad1.right_stick_y / 2.0);
        bot.drive.setOrientation(gamepad1.a);
        bot.drive.setHook(gamepad1.right_trigger == 1.0);

        //Slides
        bot.slides.setRamp(gamepad1.right_bumper);
        bot.slides.setAngle(gamepad1.dpad_up, gamepad1.dpad_down);
        bot.slides.setIntake(gamepad1.left_trigger == 1.0, gamepad1.left_bumper);
        //bot.slides.setTransmissionPower(gamepad1.y, gamepad1.x);
        bot.slides.testLinearSlide(0.5, gamepad1.y, gamepad1.x);
        //-----------------
        //Gamepad 2
        //-----------------
        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());
        telemetry.addData("Joy", gamepad2.left_stick_y / 2.0 + " " + gamepad2.right_stick_y / 2.0);

        //Drive
        bot.drive.setLeftRightPower(gamepad2.left_stick_y / 2.0, gamepad2.right_stick_y / 2.0);
        bot.drive.setOrientation(gamepad2.a);
        bot.drive.setHook(gamepad2.right_trigger == 1.0);

        //Slides
        bot.slides.setRamp(gamepad2.right_bumper);
        bot.slides.setAngle(gamepad2.dpad_up, gamepad2.dpad_down);
        bot.slides.setIntake(gamepad2.left_trigger == 1.0, gamepad2.left_bumper);
        //bot.slides.setTransmissionPower(gamepad2.y, gamepad2.x);
        bot.slides.testLinearSlide(0.5, gamepad2.y, gamepad2.x);
    }
    public void stop()
    {

    }
}
