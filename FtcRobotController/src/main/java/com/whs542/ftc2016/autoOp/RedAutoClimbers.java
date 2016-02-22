package com.whs542.ftc2016.autoOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class RedAutoClimbers extends OpMode{
    WHSRobot bot;

    int state = 0;
    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.RED);
    }
    public void loop()
    {
        switch(state)
        {
            case 0:
                bot.drive.setLeftRightPower(1.0,1.0);
                if(bot.drive.hasTargetHit(6.0))
                {
                    state = 1;
                }
            break;

            case 1:
                bot.drive.setLeftRightPower(0.0,0.0);
                bot.drive.autoDump();
                state = 2;
            break;

            case 2:
                if(bot.drive.hasTargetHit(-1.0))
                {
                    state = 3;
                }
                break;
        }
    }
    public void stop()
    {

    }
}
