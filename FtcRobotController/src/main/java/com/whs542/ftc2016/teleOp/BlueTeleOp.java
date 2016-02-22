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
        //Slide Telemetry
        //telemetry.addData("Shift", bot.slides.getShiftState());
        //telemetry.addData("Lock", bot.slides.getLockState());
        //telemetry.addData("Angle", bot.slides.getAngle());
        //telemetry.addData("Slide Length", "");
        telemetry.addData("Intake", bot.intake.getIntakeState());

        //Drive Telemetry
        telemetry.addData("Hook", bot.drive.getHookState());
        telemetry.addData("Orientation", bot.drive.getOrientation());

        //Box Telemetry
        telemetry.addData("Door", bot.box.getDoorState());

        //Sensor Telemetry
        //telemetry.addData("Mag", bot.box.getExtensionValue());
        //telemetry.addData("Mag1", bot.slides.getZeroDetectorValue());

        //drive
        bot.drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
        bot.drive.setOrientation(gamepad1.a);
        bot.drive.setSwitcher(gamepad1.right_bumper);
        bot.drive.setHook(gamepad1.right_trigger == 1.0);

        //Intake
        bot.intake.setRun(gamepad1.left_bumper, gamepad1.left_trigger == 1.0);

        //Slides
        bot.slides.setAngle(gamepad2.dpad_up, gamepad2.dpad_down);
        bot.slides.setTransmissionPower(gamepad2.left_trigger == 1.0, gamepad2.left_bumper);
        bot.slides.setConveyorMotor(gamepad2.right_trigger == 1.0, gamepad2.right_bumper);

        //Box
        bot.box.setDoor(gamepad2.right_bumper);
    }

    public void stop()
    {

    }
}
