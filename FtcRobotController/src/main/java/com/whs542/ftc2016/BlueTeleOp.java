package com.whs542.ftc2016;

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
        //drive
        //Slide Telemetry
        telemetry.addData("Shift", bot.slides.getShiftState());
        telemetry.addData("Lock", bot.slides.getLockState());

        bot.drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
        bot.drive.setOrientation(gamepad1.a);
        bot.drive.setSwitcher(gamepad1.right_bumper);
        bot.drive.setHook(gamepad1.right_trigger == 1.0);
        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());

        //Intake
        bot.intake.setRun(gamepad1.left_bumper, gamepad1.left_trigger == 1.0);
        //bot.intake.dropJoystick(gamepad2.left_stick_y);
        bot.intake.setDrop(gamepad1.b);

        //Slides
        bot.slides.setShifter(gamepad2.b);
        //bot.slides.setShiftServoPosition(gamepad2.left_stick_y);
        bot.slides.setLock(gamepad2.y);
        bot.slides.setAngle(gamepad2.dpad_up, gamepad2.dpad_down);
        bot.slides.setTransmissionPower(gamepad2.left_trigger == 1.0, gamepad2.left_bumper);

        //telemetry.addData("Angle", bot.slides.getAngle());
        //telemetry.addData("Slide Length", "");

        //Box
        bot.box.setDoorBlue(gamepad2.right_bumper);
        //bot.box.setExtension(gamepad2.right_trigger == 1.0);
        bot.box.setExtensionSpeed(gamepad2.dpad_right, gamepad2.dpad_left);
        //Box Telemetry
        telemetry.addData("Door", bot.box.getDoorState());

        //sensors
        //telemetry.addData("Mag", bot.box.getExtensionValue());
        //telemetry.addData("Deb1", bot.box.getDebrisValue1());
        //telemetry.addData("Deb2", bot.box.getDebrisValue2());
    }

    public void stop()
    {

    }
}
