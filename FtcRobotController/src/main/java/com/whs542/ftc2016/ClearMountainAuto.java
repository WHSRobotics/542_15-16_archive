package com.whs542.ftc2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

/**
 * Created by DanielWang on 1/29/16.
 */
public class ClearMountainAuto extends OpMode
{
    WHSRobot bot;

    int state = 0;

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.RED);
    }

    public void start()
    {
        bot.drive.zeroLeftEncoders();
        bot.drive.zeroRightEncoders();

        time = 0.0;
    }

    public void loop()
    {
        telemetry.addData("LF: %D", bot.drive.encoderValues[bot.drive.LF]);
        telemetry.addData("RF: %D", bot.drive.encoderValues[bot.drive.RF]);
        telemetry.addData("state", state);

        //Note that if you make the power too big, it'll go way too fast and overshoot

        switch(state)
        {
            case 0:
                bot.drive.setLeftRightPower(0.5, 0.5);
                if(bot.drive.hasTargetHit(3.82)) //value to be determined
                {
                    state = 1;
                }
                break;
        }
    }
}
