package com.whs542.ftc2016.autoOp;

import com.whs542.ftc2016.subsys.*;
import com.whs542.lib.*;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class RedAutoOp extends OpMode
{
    WHSRobot bot;

    int state = 0;

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.RED);
    }

    public void start()
    {
        //bot.drive.zeroLeftEncoders();
        //bot.drive.zeroRightEncoders();

        time = 0.0;
    }

    public void loop()
    {
        //telemetry.addData("LF: %D", bot.drive.encoderValues[bot.drive.LF]);
        //telemetry.addData("RF: %D", bot.drive.encoderValues[bot.drive.RF]);
        telemetry.addData("state", state);

        //Note that if you make the power too big, it'll go way too fast and overshoot
        
        switch(state)
        {
            case 0:
                //bot.drive.setLeftRightPower(0.1, 0.1);
                //if(bot.drive.hasTargetHit(1.0)) //value to be determined
                {
                    state = 1;
                }
            break;

            case 1:
                //Turn left towards beacon
                //bot.drive.setLeftRightPower(0.0, 0.1);
                //bot.drive.updateEncoderValues;
                //if(bot.drive.hasTargetHit(1.0))
                {
                    state = 2;
                }
            break;

            case 2:
                //Drive forward towards beacon
                //bot.drive.setLeftRightPower(0.1, 0.1);
                //if(bot.drive.hasTargetHit(0.5))
                {
                    state = 3;
                }
            break;

            case 3:
                //Stop drive and switch beacon
                //bot.drive.setLeftRightPower(0.0, 0.0);
                if(1 == 1)//beacon has been switched
                {
                    state = 4;
                }
            break;

            case 4:
                //Back up from beacon and angle to drop climbers in shelter
                //bot.drive.setLeftRightPower(-0.05, -0.1);
                //if(bot.drive.hasTargetHit(1.0))
                {
                    state = 5;
                }
            break;

            case 5:
                //bot.drive.setLeftRightPower(0.1, 0.1); //maybe just make this a separate case itself
                //if(bot.drive.hasTargetHit(0.5))
                {
                    state = 6;
                }
            break;


            case 6:
                //Drop climbers into shelter
                //bot.drive.setLeftRightPower(0.0, 0.0);

                //Set Extension
                //bot.slides.setExtension(true);

                //Current sensors check how far it has gone
                //Color sensing code
                if(1 == 1)//beacon is switched)
                {
                     state = 7;
                }
            break;

            case 7:
                //Back up from beacon and angle towards mountain
                //bot.drive.setLeftRightPower(-0.1, 0.0);
                //if(bot.drive.hasTargetHit(0.75))
                {
                    state = 8;
                }
            break;

            case 8:
                //Move towards mountain and climb onto midzone
                //bot.drive.setLeftRightPower(0.1, 0.1);
                //if(bot.drive.hasTargetHit(1.0))
                {
                    state = 9;
                }
            break;

            case 9:
                //Stop robot
                //bot.drive.setLeftRightPower(0.0, 0.0);
            break;
        }
    }
}