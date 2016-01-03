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
    Toggler lock = new Toggler(2);
    Toggler shift = new Toggler(2);

    public void init()
    {
        bot = new WHSRobot(hardwareMap);

    }

    public void start()
    {

    }

    public void loop()
    {
        shift.stateInc(gamepad1.b);
        switch(shift.currentState())
        {
            case 0:
                bot.slides.shiftToSpeed();
                break;

            case 1:
                bot.slides.shiftToTorque();
                break;
        }

        lock.stateInc(gamepad1.a);
        switch(lock.currentState())
        {
            case 0:
                bot.slides.lock();
                break;

            case 1:
                bot.slides.unlock();
                break;
        }

        bot.slides.slideState = (gamepad1.dpad_up)
            ? 1
            : (gamepad1.dpad_down)
                ? 2
                : 0;
        //bot.intake.update();
        bot.slides.setTransmissionPower(1.0);
        bot.drive.setLeftRightPower(gamepad1.left_stick_y * 7.0/9.0, gamepad1.right_stick_y * 7.0/9.0);

        telemetry.addData("slideState" , bot.slides.slideState);
        telemetry.addData("left" , gamepad1.left_stick_y);
        telemetry.addData("lock shift", lock.currentState() + " " + shift.currentState());
    }

    public void stop()
    {

    }
}
