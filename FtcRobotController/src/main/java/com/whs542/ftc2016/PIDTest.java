package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.RobotLog;
import com.whs542.lib.Alliance;
import com.whs542.lib.sensors.PIDController;

/**
 * Created by DanielWang on 2/12/16.
 */
public class PIDTest extends OpMode{

    public com.whs542.ftc2016.subsys.Drive drive;
    PIDController pidControl;

    public void init()
    {
        drive = new com.whs542.ftc2016.subsys.Drive(hardwareMap, Alliance.BLUE);
        pidControl = new PIDController(0.01, 0.01, 0.0055, 0.01);
    }
    public void loop()
    {
        pidControl.update(drive.testMot.getCurrentPosition(), drive.testMot2.getCurrentPosition());
        if((Math.abs(drive.testMot.getCurrentPosition() * (1.0/1120.0)) > 10.0) ||
        (Math.abs(drive.testMot2.getCurrentPosition() * (1.0/1120.0)) > 10.0))
        {
            drive.setLeftRightPower(0.0, 0.0);
        }
        else
        {
            drive.setLeftRightPower(0.5  + pidControl.update(drive.testMot2.getCurrentPosition(), drive.testMot.getCurrentPosition()), 0.5 +  + pidControl.update(drive.testMot2.getCurrentPosition(), drive.testMot.getCurrentPosition()));
        }

        telemetry.addData("testmot", drive.testMot.getCurrentPosition() * (1.0/1120.0));
        telemetry.addData("testmot2", drive.testMot2.getCurrentPosition() * (1.0/1120.0));
        RobotLog.i(getRuntime() + " TestMot: " + drive.testMot.getCurrentPosition() + " TestMot2: " + drive.testMot2.getCurrentPosition() + " Update: " + (pidControl.update(drive.testMot2.getCurrentPosition(), drive.testMot.getCurrentPosition()) * 100) + " " + pidControl.lastError);
    }
}
