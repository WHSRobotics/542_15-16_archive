package com.whs542.ftc2016;

import com.whs542.lib.sensors.*;
import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;
import com.whs542.ftc2016.threads.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by DanielWang on 12/5/15.
 */

public class TeleOp extends OpMode
{
    WHSRobot bot;

    public void init()
    {
        bot = new WHSRobot(hardwareMap);

    }

    public void start()
    {

    }

    public void loop()
    {
        bot.slides.setLock(gamepad1.a);
        bot.slides.setShifter(gamepad1.b);
        //bot.intake.update();
        bot.slides.setTransmissionPower(1.0, gamepad1.dpad_up, gamepad1.dpad_down);
        bot.drive.setLeftRightPower(gamepad1.left_stick_y * 7.0/9.0, gamepad1.right_stick_y * 7.0/9.0);

        //telemetry.addData("slideState");
        telemetry.addData("left" , gamepad1.left_stick_y);
        telemetry.addData("lock shift", bot.slides.lockSwitch.currentState() + " " + bot.slides.shiftSwitch.currentState());
    }

    public void stop()
    {

    }
}
