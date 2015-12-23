package com.whs542.ftc2016;

import com.whs542.lib.Toggler;

/**
 * Created by DanielWang on 12/5/15.
 */

public class TeleOp extends RobotMain {

    Toggler boxScore = new Toggler(2);
    Toggler slideExtender = new Toggler(4);

    boolean boxFull = false;
    boolean boxRetracted = false;

    public void loop()
    {
        slideExtender.toggleCycle();
        switch(slideExtender.currentState())
        {
            //Intake Position
            case 0:
                scoringBox.closeDoor();
                if(boxRetracted)
                {
                    scoringBox.setExtensionSpeed(0.5);
                    linearSlides.setExtensionPosition(0.0);
                }
                else
                {
                    scoringBox.setExtensionSpeed(0.0);
                }
                if(boxFull)
                {
                    intake.setIntakePower(0.0);
                }
                else
                {
                    intake.setIntakePower(1.0);
                }
            break;

            //Second Box
            case 1:
                linearSlides.setExtensionPosition(20.0);
            break;

            //Third Box
            case 2:
                linearSlides.setExtensionPosition(30.0);
            break;

            //Hanging
            case 3:
                linearSlides.setExtensionPosition(40.0);
            break;
        }


        boxScore.toggleCycle();
        switch(boxScore.currentState())
        {
            case 0:
                scoringBox.setExtensionSpeed(0.5);
            break;

            case 1:
                    if(!boxRetracted)
                    {
                        scoringBox.setExtensionSpeed(0.5);
                        scoringBox.openDoor();
                    }
                    else
                    {
                        scoringBox.setExtensionSpeed(0.0)
                    }
            break;
        }
        
        drive.setLeftRightPower(gamepad1.left_stick_y * 7.0/9.0, gamepad1.right_stick_y * 7.0/9.0);
    }
}
