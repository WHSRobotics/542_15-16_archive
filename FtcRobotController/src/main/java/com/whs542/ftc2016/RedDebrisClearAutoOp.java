package com.whs542.ftc2016;


import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class RedDebrisClearAutoOp extends OpMode
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
                bot.drive.setLeftRightPower(0.3, 0.3);
                if(bot.drive.hasTargetHit(3.0)) //value to be determined
                {
                    state = 1;
                }
            break;

            case 1:
                bot.drive.setLeftRightPower(0.0,0.0);
            break;
        }
    }
}