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
        switch(state) {
            case 0:
                bot.drive.setLeftRightPower(1.0, 1.0);
                if (bot.drive.hasTargetHit(5.5)) {
                    state = 1;
                }
                break;

            case 1:
                bot.drive.setLeftRightPower(1.0, -1.0);
                if (bot.drive.hasTargetHit(1.0)) ;
            {
                state = 2;
            }
            break;

            case 2:
                bot.drive.setLeftRightPower(1.0, 1.0);
                if (bot.drive.hasTargetHit(1.0)) {
                    state = 4;
                }
                break;

            case 3:
                bot.drive.setLeftRightPower(1.0, -1.0);
                if (bot.drive.hasTargetHit(5.0)) {
                    state = 4;
                }
                break;

            case 4:
                bot.drive.setLeftRightPower(1.0, 1.0);
                if (bot.drive.hasTargetHit(3.0)) {
                    state = 5;
                }
                break;

            case 5:
                bot.drive.setLeftRightPower(0.0, 0.0);
                bot.drive.autoDump();
                state = 6;
            break;

            case 6:
                bot.slides.setTransmissionPower(true, false);
                if(bot.slides.fullyExtended(30.0))
                {
                    state = 7;
                }
            break;

            case 7:
                bot.slides.setTransmissionPower(false,false);
            break;
        }
    }
    public void stop()
    {

    }
}
