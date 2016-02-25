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
        bot.drive.zeroLeftEncoders();
        bot.drive.zeroRightEncoders();
    }
    public void loop()
    {
        telemetry.addData("state", state);
        switch(state) {
            case 0:
                bot.drive.setLeftRightPower(1.0, 1.0);
                bot.drive.autoNeutral();
                //2.25 feet
                if (bot.drive.hasTargetHit(2.25)) {
                    bot.drive.setLeftRightPower(0.0, 0.0);
                    state = 1;
                }
                break;

            case 1:
                bot.drive.setLeftRightPower(1.0, -1.0);
                if (bot.drive.hasTargetHit(0.75))
                {
                    bot.drive.setLeftRightPower(0.0,0.0);
                    state = 2;
                }
            break;

            case 2:
                bot.drive.autoDump();
                bot.drive.setLeftRightPower(0.0, 0.0);
                if (bot.drive.hasTargetHit(5.6568)) {
                    state = 3;
                }
                break;

            case 3:
                bot.drive.setLeftRightPower(1.0, -1.0);
                if (bot.drive.hasTargetHit(5.0)) {
                    //state = 4;
                }
                break;

            /*case 4:

                bot.drive.setLeftRightPower(1.0, 1.0);
                if (bot.drive.hasTargetHit(2.25)) {
                    state = 5;
                }
                break;

            case 5:
                bot.drive.setLeftRightPower(0.0, 0.0);
                bot.drive.autoDump();
                state = 6;
            break;

            case 6:
                //bot.slides.setTransmissionPower(true, false);
                if(bot.slides.fullyExtended(30.0))
                {
                    state = 7;
                }
            break;

            case 7:
                //bot.slides.setTransmissionPower(false,false);
            break;*/
        }
    }
    public void stop()
    {

    }
}
