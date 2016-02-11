package com.whs542.ftc2016.autoOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.whs542.ftc2016.subsys.WHSRobot;
import com.whs542.lib.Alliance;

public class ForwardAuto extends OpMode
{
    WHSRobot bot;

    int state = 0;

    public void init()
    {
        bot = new WHSRobot(hardwareMap, Alliance.BLUE);
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
                bot.intake.dropIntake();
                bot.drive.setLeftRightPower(0.5, 0.5);
                if(bot.drive.hasTargetHit(1.0)) //value to be determined
                {
                    time = 0.0;
                    state = 1;
                }
            break;

            case 1:
                //Turn left towards beacon
                bot.drive.setLeftRightPower(0.0, 0.0);
                bot.intake.setRun(true, false);
                if(time > 3.0)
                {
                    bot.intake.setRun(false, false);
                }
                //bot.drive.updateEncoderValues;
            break;
        }
    }
}