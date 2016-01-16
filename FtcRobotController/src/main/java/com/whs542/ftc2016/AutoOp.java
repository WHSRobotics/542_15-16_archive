package com.whs542.ftc2016;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by DanielWang on 12/9/15.
 */

public class AutoOp extends RobotMain
{
    int state = 0;
    public void start()
    {
        drive.zeroLeftEncoders();
        drive.zeroRightEncoders();

        time = 0.0;
    }

    public void loop()
    {
        telemetry.addData("LF: %D", drive.encoderValues[drive.LF]);
        telemetry.addData("RF: %D", drive.encoderValues[drive.RF]);
        telemetry.addData("state", state);

        //Note that if you make the power too big, it'll go way too fast and overshoot
/*
        switch(state)
        {
            case 0:
                drive.setLeftRightPower(0.1, 0.1);
                if(drive.hasTargetHit(1.0)) //value to be determined
                {
                    state = 1;
                }
                break;

            case 1:
                //Turn left towards beacon
                drive.setLeftRightPower(0.0, 0.1);
                drive.updateEncoderValues;
                if(drive.hasTargetHit(1.0))
                {
                    state = 2;
                }
                break;

            case 2:
                //Drive forward towards beacon
                drive.setLeftRightPower(0.1, 0.1);
                if(drive.hasTargetHit(0.5))
                {
                    state = 3;
                }
                break;

            case 3:
                //Stop drive and switch beacon
                drive.setLeftRightPower(0.0, 0.0);
                if(//beacon has been switched)
            {
                state = 4;
            }
            break;

            case 4:
                //Back up from beacon and angle to drop climbers in shelter
                drive.setLeftRightPower(-0.05, -0.1);
                if(drive.hasTargetHit(1.0))
                {
                    drive.setLeftRightPower(0.1, 0.1); //maybe just make this a separate case itself
                    {
                        if(drive.hasTargetHit(0.5))
                        {
                            state = 5;
                        }
                    }
                }
                break;

            case 5:
                //Drop climbers into shelter
                drive.setLeftRightPower(0.0, 0.0);
                linearSlides.setExtension(true);
                //Current sensors check how far it has gone
                //Color sensing code
                if(//beacon is switched)
            {
                state = 6;
            }

            case 6:
                //Back up from beacon and angle towards mountain
                drive.setLeftRightPower(-0.1, 0.0);
                if(drive.hasTargetHit(0.75))
                {
                    state = 7;
                }
                break;

            case 7:
                //Move towards mountain and climb onto midzone
                drive.setLeftRightPower(0.1, 0.1);
                if(drive.hasTargetHit(1.0)))
            {
                state = 8;
            }
            break;

            case 8:
                //Stop robot
                drive.setLeftRightPower(0.0, 0.0);
                break;

        }
*/
        //Lucy's Code//
        HardwareMap driveMap = new HardwareMap();
        DcMotor rightFrontMotor = driveMap.dcMotor.get("drive_rf");
        rightFrontMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        control.speedUpMotor(rightFrontMotor, 1.0);
        double power1 = rightFrontMotor.getPower();
        //control.slowDownMotor(drive.rightFrontMotor);


        telemetry.addData("Motor power: ", power1);

    }

}