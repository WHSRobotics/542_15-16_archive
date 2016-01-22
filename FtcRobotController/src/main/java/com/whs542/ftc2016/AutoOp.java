package com.whs542.ftc2016;

/**
 * Created by DanielWang on 12/9/15.
 */

public class AutoOp extends RobotMain
{
    int state = 0;
    public void start()
    {
        //drive.zeroLeftEncoders();
        //drive.zeroRightEncoders();

        time = 0.0;
    }

    public void loop()
    {
        if(time < 2.0)
        //telemetry.addData("LF: %D", drive.encoderValues[drive.LF]);
        //telemetry.addData("RF: %D", drive.encoderValues[drive.RF]);
        telemetry.addData("state", state);

        //Note that if you make the power too big, it'll go way too fast and overshoot

            switch(state)
            {
                case 0:
                    drive.setLeftRightPower(0.1, 0.1);
                    if(drive.hasTargetHit(1.0))
                    {
                        state = 1;
                    }
                    break;

                case 1:
                    drive.setLeftRightPower(-0.1, -0.1);
                    if(drive.hasTargetHit(1.0))
                    {
                        state = 2;
                    }
                    break;

                case 2:
                    drive.setLeftRightPower(0.1, 0.1);
                    if(drive.hasTargetHit(1.0))
                    {
                        state = 3;
                    }
                    break;

                case 3:
                    drive.setLeftRightPower(-0.1, -0.1);
                    if(drive.hasTargetHit(1.0))
                    {
                        state = 4;
                    }
                break;

                case 4:
                    drive.setLeftRightPower(0.1, 0.1);
                    if(drive.hasTargetHit(1.0))
                    {
                        state = 5;
                    }
                    break;

                case 5:
                        drive.setLeftRightPower(0.0, 0.0);
                    break;
            }
            

        //Lucy's Code//
        /*
        control.speedUpMotor(drive.rightFrontMotor, 1.0);
        double power1 = drive.rightFrontMotor.getPower();
        //control.slowDownMotor(drive.rightFrontMotor);


        telemetry.addData("Motor power: ", power1);
        */
    }

}