package com.whs542.ftc2016;

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
        if(time < 2.0)
        {
            driveAuto.setLeftRightPower(1.0, 1.0);
        }

    }

}
