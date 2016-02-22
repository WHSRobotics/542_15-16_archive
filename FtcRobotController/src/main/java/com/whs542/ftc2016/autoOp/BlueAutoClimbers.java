package com.whs542.ftc2016.autoOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class BlueAutoClimbers extends OpMode{
    WHSRobot bot;

    int state = 0;
    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.BLUE);
    }
    public void loop()
    {
        switch(state)
        {
            case 0:
                if(bot.drive.hasTargetHit(5.5))
                {
                    state = 1;
                }
                break;

            case 1:
                bot.drive.servoArmDump();
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
