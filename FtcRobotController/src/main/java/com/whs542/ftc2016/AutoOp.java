package com.whs542.ftc2016;

import com.whs542.ftc2016.subsys.Drive;

/**
 * Created by DanielWang on 12/9/15.
 */
public class AutoOp extends RobotMain
{
    public void start()
    {
        time = 0.0;
    }
    public void loop()
    {

        if(time < 2.0 || drive.encoderState == true)
        {
            drive.encodersReachTarget(2.0);
            drive.setLeftRightPower(1.0, 1.0);
        }
        else if(time < 4.0 || drive.encoderState == true)
        {
            drive.encodersReachTarget(1.0);
            drive.setLeftRightPower(-1.0, 1.0);
        }
        else if(time < 6.3 || drive.encoderState == true)
        {
            drive.encodersReachTarget(3.0);
            drive.setLeftRightPower(1.0, 1.0);
        }
        else if(time < 8.0 || drive.encoderState == true)
        {
            drive.encodersReachTarget(2.6);
            drive.setLeftRightPower(0.5, 0.5);
        }
        else
        {
            drive.setLeftRightPower(0.0, 0.0);
        }

        //Lucy's Code//
        /*
        control.speedUpMotor(drive.rightFrontMotor, 1.0);
        double power1 = drive.rightFrontMotor.getPower();
        //control.slowDownMotor(drive.rightFrontMotor);


        telemetry.addData("Motor power: ", power1);
        */
    }

}
