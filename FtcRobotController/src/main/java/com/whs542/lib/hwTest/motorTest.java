package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.RobotLog;
import com.whs542.lib.Toggler;

import java.lang.Override;

public class motorTest extends OpMode
{
    DcMotor testMot;
    Toggler changePower;
    Toggler activateMot;
    VoltageSensor voltSense;
    double power = 0.0;

    @Override
    public void init()
    {
        activateMot = new Toggler(2);
        changePower = new Toggler(21, 10);
        voltSense = hardwareMap.voltageSensor.get("motorc");
        testMot = hardwareMap.dcMotor.get("motor");
        testMot.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        RobotLog.i("StartLog");
    }

    @Override
    public void loop()
    {
        activateMot.changeState(gamepad1.a);
        changePower.changeState(gamepad1.dpad_up,gamepad1.dpad_down);

        power = activateMot.currentState() == 1
                ? (double)(changePower.currentState()-10) *0.1
                : 0.0;

        RobotLog.i(getRuntime() + " " + testMot.getCurrentPosition() + " " + (voltSense.getVoltage()*power) );
        testMot.setPower(power);

        telemetry.addData("","power: " + (changePower.currentState()-10) + "On: " + activateMot.currentState());


    }

    @Override
    public void stop()
    {
        RobotLog.i("EndLog");
    }
}