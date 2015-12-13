package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.Drive;

/**
 * Created by DanielWang on 12/9/15.
 */
public class AutoOp extends RobotMain
{
    Drive driveAuto;
    public AutoOp(Drive drive1)
    {
        driveAuto = drive1;
    }
    public void start()
    {
        time = 0.0;
    }
    public void loop()
    {
        telemetry.addData("Time: ", time);
        if(time < 2.0)
        {
            driveAuto.setLeftRightPower(1.0, 1.0);
        }
        else if(time < 4.0)
        {
            driveAuto.setLeftRightPower(-1.0, -1.0);
        }
        /*else if(time < 6.0)
        {

        }
        else if(time < 8.0)
        {

        }*/
        else
        {
            driveAuto.setLeftRightPower(0.0, 0.0);
        }
    }

}
