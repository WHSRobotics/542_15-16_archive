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
        bot = new WHSRobot(hardwareMap, Alliance.BLUE);
    }

    public void start()
    {

    }

    public void loop()
    {
    //drive
        //driving
            bot.drive.setLeftRightPower(gamepad1.left_stick_y * 7.0/9.0, gamepad1.right_stick_y * 7.0/9.0);
        //Switcher
            bot.drive.setSwitcher(gamepad1.x);
        //Hook
            bot.drive.setHook(gamepad1.y);

    //Slides
            bot.slides.setShifter(gamepad2.b);
            bot.slides.setAngle(1.0, gamepad2.dpad_up, gamepad2.dpad_down);
            bot.slides.setTransmissionPower(1.0, gamepad2.left_bumper, gamepad2.left_trigger == 1.0);

        //Box
        //Door
            //bot.box.setDoor(gamepad1.b);
        //Extension
            //bot.box.setExtension(gamepad1.a);

        //Intake
            bot.intake.setRun(gamepad1.left_bumper,gamepad1.left_trigger == 1.0);
            //bot.intake.setDrop(gamepad1.x);
    }

    public void stop()
    {

    }
}
