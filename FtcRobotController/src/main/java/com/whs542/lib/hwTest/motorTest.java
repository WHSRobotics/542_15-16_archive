package com.whs542.lib.hwTest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.RobotLog;

import java.lang.Override;

public class motorTest extends OpMode
{
    DcMotor testMot;

    @Override
    public void init()
    {
        testMot = hardwareMap.dcMotor.get("motor");
        //RobotLog.i("StartLog - MR Controller")
        //RobotLog.i("StartLog - Power Supply");
    }

    @Override
    public void loop()
    {
        RobotLog.i("t: " + time + " enc: " + testMot.getCurrentPosition());
        //testMot.setPower(1.0);
    }

    @Override
    public void stop()
    {
        //RobotLog.i("EndLog - MR Controller")
        //RobotLog.i("EndLog - Power Supply");
    }
}