package com.whs542.ftc2016;

/**
 * Created by DanielWang on 12/5/15.
 */
public class TeleOp extends RobotMain {

    public void loop()
    {

        if(gamepad1.a)
        {
            scoringBox.servo1.setPosition(1.0);
        }
        else if(gamepad1.b)
        {
            scoringBox.servo1.setPosition(0.0);
        }
        else if(gamepad1.y)
        {
            scoringBox.servo2.setPosition(1.0);
        }
        else
        {
            scoringBox.servo1.setPosition(0.5);
            scoringBox.servo2.setPosition(0.0);
        }

        drive.setLeftRightPower(gamepad1.left_stick_y, gamepad1.right_stick_y);

    }
}
