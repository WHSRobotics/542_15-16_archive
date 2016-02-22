package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.RobotLog;
import com.whs542.lib.Alliance;
import com.whs542.lib.sensors.PIDController;

/**
 * Created by DanielWang on 2/12/16.
 */
public class PIDTest extends OpMode{
    public DcMotor testMot;
    public DcMotor testMot2;
    PIDController pidControl;

    public void init()
    {
        //PID Testing//
        testMot = hardwareMap.dcMotor.get("motor");
        testMot2 = hardwareMap.dcMotor.get("motor2");
        testMot.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        testMot2.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        pidControl = new PIDController(0.0000001, 0.001, 0.0055, 0.0001);
    }
    public void loop()
    {
        pidControl.update(testMot.getCurrentPosition(), testMot2.getCurrentPosition());
        if((Math.abs(testMot.getCurrentPosition() * (1.0/1120.0)) > 10.0) ||
        (Math.abs(testMot2.getCurrentPosition() * (1.0/1120.0)) > 10.0))
        {
            testMot.setPower(0.0);
            testMot2.setPower(0.0);
        }
        else
        {
            testMot.setPower(0.5 + pidControl.update(testMot.getCurrentPosition(), testMot2.getCurrentPosition()));
            testMot2.setPower(0.5 - pidControl.update(testMot.getCurrentPosition(), testMot2.getCurrentPosition()));
        }

        telemetry.addData("testmot", testMot.getCurrentPosition() * (1.0/1120.0));
        telemetry.addData("testmot2", testMot2.getCurrentPosition() * (1.0/1120.0));
        RobotLog.i(getRuntime() + " TestMot: " + testMot.getCurrentPosition() + " TestMot2: " + testMot2.getCurrentPosition() + " Update: " + (pidControl.update(testMot2.getCurrentPosition(), testMot.getCurrentPosition()) * 100) + " " + pidControl.lastError);
    }
}
